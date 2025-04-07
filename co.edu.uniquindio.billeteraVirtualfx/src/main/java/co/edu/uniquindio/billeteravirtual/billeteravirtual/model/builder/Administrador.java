package co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    public String idAdmistrador;
    public String nombre;
    public String email;
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Presupuesto> listaPresupuestos = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();

    public Administrador(String idAdmistrador, String nombre, String email) {
        this.idAdmistrador = idAdmistrador;
        this.nombre = nombre;
        this.email = email;
    }

    public String getIdAdmistrador() {
        return idAdmistrador;
    }

    public void setIdAdmistrador(String idAdmistrador) {
        this.idAdmistrador = idAdmistrador;
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

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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

}