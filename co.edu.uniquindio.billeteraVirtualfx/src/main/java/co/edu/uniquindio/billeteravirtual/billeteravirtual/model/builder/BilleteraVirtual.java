package co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder;

import java.util.ArrayList;
import java.util.List;

public class BilleteraVirtual {
    private String nombre;
    private List<Cuenta> listaCuentas;

    public BilleteraVirtual() {
        this.listaCuentas = new ArrayList<>();
    }

    public boolean crearCuenta(String idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta) {
        Cuenta cuentaEncontrada = obtenerCuenta(idCuenta);
        if (cuentaEncontrada == null) {
            Cuenta cuenta = getBuildCuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
            getListaCuentas().add(cuenta);
            return true;
        } else {
            return false;
        }
    }

    public boolean crearCuenta(Cuenta nuevoCuenta) {
        Cuenta cuentaEncontrada = obtenerCuenta(nuevoCuenta.getIdCuenta());
        if (cuentaEncontrada == null) {
            getListaCuentas().add(nuevoCuenta);
            return true;
        } else {
            return false;
        }
    }

    private Cuenta getBuildCuenta(String idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta) {
        // Convierte el String a TipoCuenta (enum)
        TipoCuenta tipoEnum = TipoCuenta.valueOf(tipoCuenta.toUpperCase()); // Asegúrate que coincida con los nombres del enum

        return Cuenta.builder()
                .idCuenta(idCuenta)
                .nombreBanco(nombreBanco)
                .numeroCuenta(numeroCuenta)
                .tipoCuenta(tipoEnum)
                .build();
    }

    private Cuenta obtenerCuenta(String idCuenta) {
        for (Cuenta cuenta : getListaCuentas()) {
            if (cuenta.getIdCuenta().equalsIgnoreCase(idCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
