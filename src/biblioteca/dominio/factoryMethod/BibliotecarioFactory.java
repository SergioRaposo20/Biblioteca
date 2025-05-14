package biblioteca.dominio.factoryMethod;

import biblioteca.dominio.Usuario;
import biblioteca.dominio.Bibliotecario;

public class BibliotecarioFactory implements IFactoryUsuario {
    @Override
    public Usuario createUsuario() {
        return new Bibliotecario();
    }
}
