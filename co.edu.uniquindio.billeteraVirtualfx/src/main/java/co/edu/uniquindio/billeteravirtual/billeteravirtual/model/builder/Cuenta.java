package co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder;

public class Cuenta {

    public String idCuenta;
    public String nombreBanco;
    public String numeroCuenta;
    private TipoCuenta tipoCuenta;

    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    public static CuentaBuilder builder(){
        return new CuentaBuilder();
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
}
