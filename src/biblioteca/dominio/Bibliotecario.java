package biblioteca.dominio;

import biblioteca.infraestrutura.DB_Livro_Usuario_Emprestimos;
import biblioteca.infraestrutura.DB_Livros;
import biblioteca.util.Status;

import java.time.LocalDate;


public class Bibliotecario extends Usuario {
    @Override
    public void reservarLivro(Livro livro, LocalDate dataReserva) {

    }

    @Override
    public void renovaEmprestimo(Livro livro) {

    }


    public void aprovarEmprestimoLivro(Livro_Usuario_Emprestimo livroUsuarioEmprestimo) {
        var livro = DB_Livros.buscarPorId(livroUsuarioEmprestimo.getIdLivro());

        if (livro != null) {
            livro.setStatus(Status.EMPRESTADO);

            DB_Livros.atualizar(livro);
            DB_Livro_Usuario_Emprestimos.atualizar(livroUsuarioEmprestimo);
            System.out.print("Emprestimo efetivado!");

        }
    }
}
