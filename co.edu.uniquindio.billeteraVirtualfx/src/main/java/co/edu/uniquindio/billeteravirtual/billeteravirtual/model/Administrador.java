package co.edu.uniquindio.billeteravirtual.billeteravirtual.model;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Validacion.ValidacionCorreo;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private String idAdministrador;
    private String nombre;
    private String email;
    private String password; // Agregamos password para los administradores
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Presupuesto> listaPresupuestos = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();

    // Lista de todos los administradores del sistema
    private static List<Administrador> listaAdministradores = new ArrayList<>();

    // Instancia única del Administrador principal (patrón Singleton)
    private static Administrador instanciaPrincipal;

    /**
     * Constructor que permite crear administradores
     */
    public Administrador(String idAdministrador, String nombre, String email, String password) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        listaAdministradores.add(this);
    }

    /**
     * Método para obtener la instancia principal del Administrador
     * @return instancia principal del Administrador
     */
    public static Administrador getInstance() {
        if (instanciaPrincipal == null) {
            instanciaPrincipal = new Administrador("admin001", "Administrador Principal", "admin@billeteravirtual.com", "admin123");
        }
        return instanciaPrincipal;
    }

    /**
     * Busca un administrador por su ID y contraseña
     * @param idAdmin ID del administrador
     * @param password Contraseña del administrador
     * @return El administrador si las credenciales son correctas, null en caso contrario
     */
    public static Administrador buscarAdministrador(String idAdmin, String password) {
        return listaAdministradores.stream()
                .filter(admin -> admin.getIdAdministrador().equals(idAdmin) && admin.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene la lista de todos los administradores
     * @return Lista de administradores
     */
    public static List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    /**
     * Permite registrar un usuario en el banco y crear su billetera
     * @param idUsuario identificación del usuario
     * @param nombre nombre del usuario
     * @param email email del usuario
     * @param celular número de celular del usuario
     * @param password contraseña del usuario
     * @throws Exception si algún campo es nulo/vacío o el usuario ya existe
     */
    public void registrarUsuario(String idUsuario, String nombre, String email, String celular, String password) throws Exception {
        if(idUsuario == null || idUsuario.isEmpty()) {
            throw new Exception("El ID de usuario es obligatorio");
        }
        if(nombre == null || nombre.isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        if(email == null || email.isEmpty() || !ValidacionCorreo.validarExpresionRegular(email)) {
            throw new Exception("No es una dirección de correo válida");
        }
        if(celular == null || celular.isEmpty()) {
            throw new Exception("El número de celular es obligatorio");
        }
        if(password == null || password.isEmpty()) {
            throw new Exception("La contraseña es obligatoria");
        }

        // Verificar si el usuario ya existe por ID
        if(buscarUsuarioPorId(idUsuario) != null) {
            throw new Exception("Ya existe un usuario con esa identificación");
        }

        Usuario usuario = new Usuario(idUsuario, nombre, email, celular, password, this);
        listaUsuarios.add(usuario);
    }

    /**
     * Busca un usuario por ID
     * @param idUsuario ID del usuario a buscar
     * @return Usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorId(String idUsuario) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getIdUsuario().equals(idUsuario))
                .findFirst()
                .orElse(null);
    }

    /**
     * Método que busca a un usuario según su id y contraseña
     * @param idUsuario id del usuario
     * @param password contraseña del usuario
     * @return usuario encontrado o null en caso contrario
     */
    public Usuario buscarUsuario(String idUsuario, String password){
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getIdUsuario().equals(idUsuario) && usuario.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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