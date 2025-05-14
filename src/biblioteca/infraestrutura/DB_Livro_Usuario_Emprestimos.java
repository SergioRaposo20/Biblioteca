package biblioteca.infraestrutura;

import biblioteca.dominio.Livro_Usuario_Emprestimo;
import biblioteca.util.Status;

import java.util.ArrayList;
import java.util.List;

public class DB_Livro_Usuario_Emprestimos {
    public static int idAutoIncremento = 0;
    public static List<Livro_Usuario_Emprestimo> dados = new ArrayList<>();

    public static void adicionar(Livro_Usuario_Emprestimo emprestimo) {
        emprestimo.setId(idAutoIncremento++);
        dados.add(emprestimo);
    }

    public static List<Livro_Usuario_Emprestimo> listar() {
        return new ArrayList<>(dados); // evita retornar referência direta
    }

    public static Livro_Usuario_Emprestimo buscarPorId(int id) {
        for (Livro_Usuario_Emprestimo e : dados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static Livro_Usuario_Emprestimo buscarPorLivroEmprestado(int idLivro) {
        var livro = DB_Livros.buscarPorId(idLivro);
        if (livro.getStatus().equals(Status.EMPRESTADO)) {

            for (Livro_Usuario_Emprestimo e : dados) {
                if (e.getIdLivro() == idLivro) {

                    return e;
                }
            }
        }
        return null;
    }

    public static boolean atualizar(Livro_Usuario_Emprestimo emprestimoAtualizado) {
        Livro_Usuario_Emprestimo registroLivroUsuario = buscarPorId(emprestimoAtualizado.getId());

        if (registroLivroUsuario != null) {
            int index = dados.indexOf(registroLivroUsuario);
            dados.set(index, emprestimoAtualizado);
            return true;
        }
        return false;
    }

    public static boolean remover(int id) {
        return dados.removeIf(e -> e.getId() == id);
    }
}