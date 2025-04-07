package co.edu.uniquindio.billeteravirtual.billeteravirtual.service;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.Cuenta;

import java.util.List;

public interface IBilleteraVirtualMapping {
    List<CuentaDto> getCuentasDto(List<Cuenta> listaCuentas);
    CuentaDto cuentaToCuentaDto(Cuenta cliente);
    Cuenta cuentaDtoToCuenta(CuentaDto clienteDto);
}
