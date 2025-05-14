package biblioteca.dominio.factoryMethod;

import biblioteca.dominio.Usuario;
import biblioteca.dominio.AlunoProfessor;

public class AlunoProfessorFactory implements IFactoryUsuario {
    @Override
    public Usuario createUsuario() {
        return new AlunoProfessor();
    }
}
