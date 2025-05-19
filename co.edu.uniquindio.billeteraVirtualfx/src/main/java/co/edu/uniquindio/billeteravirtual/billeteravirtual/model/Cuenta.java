package co.edu.uniquindio.billeteravirtual.billeteravirtual.model;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.CuentaBuilder;

public class Cuenta {

    public String idCuenta;
    public String nombreBanco;
    public String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private double saldo;

    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta, double saldo) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public static CuentaBuilder builder() {
        return new CuentaBuilder();
    }

    // Constructor con saldo por defecto para compatibilidad hacia atrás
    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta) {
        this(idCuenta, nombreBanco, numeroCuenta, tipoCuenta, 0.0);
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
