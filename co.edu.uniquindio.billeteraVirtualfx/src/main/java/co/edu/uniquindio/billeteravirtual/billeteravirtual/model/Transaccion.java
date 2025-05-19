package co.edu.uniquindio.billeteravirtual.billeteravirtual.model;

public class Transaccion {
    public String idTransaccion;
    public String fechaTransaccion;
    public String monto;
    public String descripcion;
    private TipoTransaccion tipoTransaccion;
    private Usuario usuario;
    private Cuenta cuenta;
    private Categoria categoria;
    private Administrador administrador;

    public Transaccion(String idTransaccion, String fechaTransaccion, String monto, String descripcion,
                       TipoTransaccion tipoTransaccion, Usuario usuario, Cuenta cuenta, Categoria categoria,
                       Administrador administrador) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.monto = monto;
        this.descripcion = descripcion;
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.cuenta = cuenta;
        this.categoria = categoria;
        this.administrador = administrador;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
