package co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder;

public class UsuarioBuilder {
    public String idUsuario;
    public String nombre;
    public String email;
    public String celular;
    public Double saldoTotal;

    public UsuarioBuilder idUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }
    public UsuarioBuilder celular(String celular) {
        this.celular = celular;
        return this;
    }
    public UsuarioBuilder saldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
        return this;
    }
    public Cuenta build() {
        return new Cuenta(idUsuario, nombre, email, celular);
    }
}
