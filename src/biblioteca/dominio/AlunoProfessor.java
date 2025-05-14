package biblioteca.dominio;
import biblioteca.infraestrutura.DB_Livro_Usuario_Emprestimos;
import biblioteca.infraestrutura.DB_Livros;
import biblioteca.util.Status;

import java.time.LocalDate;
import java.util.Date;

public class AlunoProfessor extends Usuario {
    private final int diasParaDevolucao = 3;

    private boolean isAtingiuLimiteLivros(){
        if (this.getQuantidadeLivroEmprestado() >= this.quantidadeMaxEmprestimo) {
            System.out.print("Atingiu limite de livros emprestado ("+this.quantidadeMaxEmprestimo+").");
            return true;
        }else{
            return false;
        }
    }


    private boolean SolicitaEmprestimo(Livro livro,LocalDate dataReserva){

        if (this.isAtingiuLimiteLivros()){
            return false;
        }

        if (!livro.getStatus().equals(Status.DISPONIVEL)){
            System.out.print("Livro indisponivel");
            return false;
        }

        LocalDate dataEmprestimo = null;
        LocalDate dataDevolucao = null;

        if (dataReserva==null) {
            dataEmprestimo = LocalDate.now();
            dataDevolucao = LocalDate.now().plusDays(this.diasParaDevolucao);
        }else{
            dataEmprestimo = dataReserva;
            dataDevolucao = dataReserva.plusDays(this.diasParaDevolucao);
        }

        var livroUsuarioSolicitaEmprestimo = new Livro_Usuario_Emprestimo(livro.getId(),this.getId(),dataEmprestimo,dataReserva,dataDevolucao);
        livro.setStatus(Status.AGUARDANDOAPROVACAO);

        DB_Livros.atualizar(livro);
        DB_Livro_Usuario_Emprestimos.adicionar(livroUsuarioSolicitaEmprestimo);

        System.out.print("Aguarde a aprovação!");
        return true;
    }

    @Override
    public void reservarLivro(Livro livro,LocalDate dataReserva) {
        SolicitaEmprestimo(livro,dataReserva);
    }

    @Override
    public void renovaEmprestimo(Livro livro) {
        SolicitaEmprestimo(livro, null);
    }




}
