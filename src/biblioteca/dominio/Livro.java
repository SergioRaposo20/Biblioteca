package biblioteca.dominio;
import biblioteca.infraestrutura.DB_Livro_Usuario_Emprestimos;
import biblioteca.infraestrutura.DB_Livros;
import biblioteca.util.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private int id;
    private String autor;
    private String titulo;
    private Status status;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Livro> buscaLivrosTituloAutor(String tituloAuto,int id) {
        List<Livro> livros = new ArrayList<Livro>();
        if (id>0){
            livros.add(DB_Livros.buscarPorId(id));
            return livros;
        }else{
            return DB_Livros.buscarPorTitutloAutor(tituloAuto);
        }
    }

    public void devolveLivro(Livro livro) {
        if (livro.getStatus().equals(Status.EMPRESTADO)){
            var livroEmprestado = DB_Livro_Usuario_Emprestimos.buscarPorLivroEmprestado(livro.getId());
            if (!livroEmprestado.getDataDevolucao().isAfter(LocalDate.now())) {
                livro.setStatus(Status.DISPONIVEL);
            }
        }
        DB_Livros.atualizar(livro);
    }

}
