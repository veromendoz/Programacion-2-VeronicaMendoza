package co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto;


import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.TipoCuenta;

public record CuentaDto(
        String idCuenta,
        String nombreBanco,
        String numeroCuenta,
        TipoCuenta tipoCuenta
) {
}


