package biblioteca.dominio;

import java.time.LocalDate;

public class Livro_Usuario_Emprestimo {
    private int id;
    private int idLivro;
    private int idUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataReserva;
    private LocalDate dataDevolucao;

    public Livro_Usuario_Emprestimo(int idLivro, int idUsuario, LocalDate dataEmprestimo, LocalDate dataReserva, LocalDate dataDevolucao){
        setIdLivro(idLivro);
        setIdUsuario(idUsuario);
        setDataEmprestimo(dataEmprestimo);
        setDataReserva(dataReserva);
        setDataDevolucao(dataDevolucao);
    }

    public int getIdLivro() {
        return idLivro;
    }

    private void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    private void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    private void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    private void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    private void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
