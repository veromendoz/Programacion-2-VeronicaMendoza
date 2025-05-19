package co.edu.uniquindio.billeteravirtual.billeteravirtual.controller;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.factory.ModelFactory;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Usuario;

import java.util.List;

public class UsuarioController {

    private ModelFactory modelFactory;

    public UsuarioController() {
        modelFactory = ModelFactory.getInstancia();
    }

    public List<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public boolean agregarUsuario(Usuario usuario) {
        return modelFactory.agregarUsuario(usuario);
    }

    public boolean actualizarUsuario(Usuario usuarioActualizado) {
        return modelFactory.actualizarUsuario(usuarioActualizado);
    }

    public boolean eliminarUsuario(String idUsuario) {
        return modelFactory.eliminarUsuario(idUsuario);
    }

    public Usuario obtenerUsuario(String idUsuario) {
        return modelFactory.obtenerUsuario(idUsuario);
    }
}
