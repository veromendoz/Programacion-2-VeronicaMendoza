package co.edu.uniquindio.billeteravirtual.billeteravirtual.service;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Usuario;

import java.util.List;

public interface IModelFactoryService {
    List<CuentaDto> obtenerCuenta();

    boolean agregarCuenta(CuentaDto cuentaDto);
    boolean actualizarCuenta(CuentaDto cuentaDto);
    boolean eliminarCuenta(String idCuenta);

    // Métodos para Usuario sin DTO

    List<Usuario> obtenerUsuarios();
    boolean agregarUsuario(Usuario usuario);
    boolean actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(String idUsuario);

}
