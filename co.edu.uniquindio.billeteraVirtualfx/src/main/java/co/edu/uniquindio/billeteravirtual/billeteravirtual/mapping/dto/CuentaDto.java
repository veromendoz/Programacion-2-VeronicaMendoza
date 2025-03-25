package co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto;


public record CuentaDto(
        int idCuenta,
        String nombreBanco,
        String numeroCuenta,
        String tipoCuenta
) {
}