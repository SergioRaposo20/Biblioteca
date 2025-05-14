package biblioteca.infraestrutura;

import biblioteca.dominio.Livro;

import java.util.ArrayList;
import java.util.List;

public class DB_Livros {
    public static List<Livro> dados = new ArrayList<Livro>();
    public static int idAutoIncremento = 0;

    // CREATE
    public static void adicionar(Livro livro) {
        livro.setId(idAutoIncremento++);
        dados.add(livro);
    }

    // READ - listar todos
    public static List<Livro> listar() {
        return new ArrayList<>(dados); // retorna cópia para evitar alteração direta
    }

    // READ - buscar por ID
    public static Livro buscarPorId(int id) {
        for (Livro livro : dados) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public static List<Livro> buscarPorTitutloAutor(String texto) {
        List<Livro> livros = new ArrayList<Livro>();
        for (Livro livro : dados) {
            if (livro.getAutor().contains(texto) ||
                livro.getTitulo().contains(texto)) {
                livros.add(livro);
            }
        }
        return livros;
    }

    // UPDATE
    public static boolean atualizar(Livro livroAtualizado) {
        Livro registro = buscarPorId(livroAtualizado.getId());
        if (registro != null) {
            int index = dados.indexOf(registro);
            dados.set(index, livroAtualizado);
            return true;
        }
        return false;
    }

    // DELETE
    public static boolean remover(int id) {
        return dados.removeIf(livro -> livro.getId() == id);
    }
}
