package co.edu.uniquindio.billeteravirtual.billeteravirtual.service;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;

import java.util.List;

public interface IModelFactoryService {
    List<CuentaDto> obtenerCuenta();

    boolean agregarCuenta(CuentaDto cuentaDto);
    boolean actualizarCuenta(CuentaDto cuentaDto);
    boolean eliminarCuenta(String idCuenta);
}
