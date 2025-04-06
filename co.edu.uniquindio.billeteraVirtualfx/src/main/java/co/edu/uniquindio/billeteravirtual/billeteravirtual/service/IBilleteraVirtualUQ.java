package co.edu.uniquindio.billeteravirtual.billeteravirtual.service;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.Cuenta;

import java.util.List;

public interface IBilleteraVirtualUQ {
    boolean crearCuenta(String idCuenta, String nombreBanco, String numeroCuenta, int tipoCuenta);
    void eliminarCuenta(String idCuenta);
    List<Cuenta> obtenerCuenta();
    Cuenta obtenerCuenta(String idCuenta);
    void mostrarInformacionCuenta();
    void buscarCuenta(String idCuenta);
    boolean actualizarCuenta(String idCuentaActual, String nombreBanco, String numeroCuenta, String tipoCuenta);

    boolean crearObjeto(String idObjeto, String descripcion);
    Objeto obtenerObjeto(String idObjeto);
    Empleado obtenerEmpleado(String cedulaEmpleado);
    boolean crearPrestamo(String numeroPrestamo,
                          Date fechaPrestamo,
                          Date fechaEntrega,
                          String descripcion,
                          String cedulaCliente,
                          String cedulaEmpleado,
                          String idObjeto);

    boolean eliminarPrestamo(String numeroPrestamo);

    boolean actualizarPrestamo(String numeroPrestamoActual, String numeroPrestamo, Date fechaPrestamo, Date fechaEntrega, String descripcion);

    Prestamo obtenerPrestamo(String numeroPrestamo);

}
