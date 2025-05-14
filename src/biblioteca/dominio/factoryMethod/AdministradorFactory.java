package biblioteca.dominio.factoryMethod;

import biblioteca.dominio.Usuario;
import biblioteca.dominio.Administrador;

public class AdministradorFactory implements IFactoryUsuario {
    @Override
    public Usuario createUsuario() {
        return new Administrador();
    }
}
