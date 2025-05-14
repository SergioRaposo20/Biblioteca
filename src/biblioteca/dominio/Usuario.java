package biblioteca.dominio;

import java.time.LocalDate;

public abstract class Usuario {
    private int id;
    private String senha;
    private String nome;
    private int quantidadeLivroEmprestado;
    protected final int quantidadeMaxEmprestimo=5;

    public abstract void reservarLivro(Livro livro, LocalDate dataReserva);
    public abstract void renovaEmprestimo(Livro livro);

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeLivroEmprestado() {
        return quantidadeLivroEmprestado;
    }

    public void setQuantidadeLivroEmprestado(int quantidadeLivroEmprestado) {
        this.quantidadeLivroEmprestado = quantidadeLivroEmprestado;
    }
}
