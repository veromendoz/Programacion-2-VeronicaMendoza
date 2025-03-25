package co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder;

public class CuentaBuilder {
    public int idCuenta;
    public String nombreBanco;
    public String numeroCuenta;
    private TipoCuenta tipoCuenta;

    public CuentaBuilder idCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
        return this; // Devuelve la instancia actual de CuentaBuilder
    }
    public CuentaBuilder nombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        return this; // Devuelve la instancia actual de CuentaBuilder
    }
    public CuentaBuilder numeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        return this; // Devuelve la instancia actual de CuentaBuilder
    }
    public CuentaBuilder tipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
        return this; // Devuelve la instancia actual de CuentaBuilder
    }
    public Cuenta build() {
        return new Cuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
    }
}
