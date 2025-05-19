package co.edu.uniquindio.billeteravirtual.billeteravirtual.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public String idUsuario;
    public String nombre;
    public String email;
    public String celular;
    public String password;
    private double saldoTotal;
    private Administrador administrador;
    private List<Presupuesto> listaPresupuestos = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private List<Cuenta> listacuentas = new ArrayList<>();

    public Usuario(String idUsuario, String nombre, String email, String celular, String password, Administrador administrador) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
        this.administrador = administrador;
        this.password = password;
        this.saldoTotal = 0.0;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public double getSaldoTotal() {
        return saldoTotal;
    }
    
    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
    
    /**
     * Calcula el saldo total sumando los saldos de todas las cuentas del usuario
     * @return El saldo total actualizado
     */
    public double calcularSaldoTotal() {
        double total = 0.0;
        if (listacuentas != null) {
            for (Cuenta cuenta : listacuentas) {
                // Asumiendo que la clase Cuenta tiene un método getSaldo()
                // Si no existe este método, tendrás que ajustar esta parte
                if (cuenta != null) {
                    total += cuenta.getSaldo();
                }
            }
        }
        this.saldoTotal = total;
        return total;
    }
}
