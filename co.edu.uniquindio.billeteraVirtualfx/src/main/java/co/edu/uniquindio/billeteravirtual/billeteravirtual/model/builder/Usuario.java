package co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public String idUsuario;
    public String nombre;
    public String email;
    public String celular;
    public Double saldoTotal;
    private Administrador administrador;
    private List<Presupuesto> listaPresupuestos = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private List<Cuenta> listacuentas = new ArrayList<>();

    public Usuario(String idUsuario, String nombre, String email, String celular, Double saldoTotal, Administrador administrador) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
        this.saldoTotal = saldoTotal;
        this.administrador = administrador;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    public void setListaPresupuestos(List<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public List<Cuenta> getListacuentas() {
        return listacuentas;
    }

    public void setListacuentas(List<Cuenta> listacuentas) {
        this.listacuentas = listacuentas;
    }
}
