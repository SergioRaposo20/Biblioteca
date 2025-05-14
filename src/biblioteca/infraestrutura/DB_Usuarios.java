package biblioteca.infraestrutura;

import biblioteca.dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DB_Usuarios {
    public static List<Usuario> dados = new ArrayList<>();
    public static int idAutoIncremento = 0;

    public static void adicionar(Usuario usuario) {
        usuario.setId(idAutoIncremento++);
        dados.add(usuario);
    }

    public static List<Usuario> listar() {
        return new ArrayList<>(dados);
    }

    public static Usuario buscarPorId(int id) {
        for (Usuario usuario : dados) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public static boolean atualizar(Usuario usuarioAtualizado) {
        Usuario existente = buscarPorId(usuarioAtualizado.getId());
        if (existente != null) {
            int index = dados.indexOf(existente);
            dados.set(index, usuarioAtualizado);
            return true;
        }
        return false;
    }

    public static boolean remover(int id) {
        return dados.removeIf(usuario -> usuario.getId() == id);
    }
}
