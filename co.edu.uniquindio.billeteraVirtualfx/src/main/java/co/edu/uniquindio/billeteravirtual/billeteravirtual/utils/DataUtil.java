package co.edu.uniquindio.billeteravirtual.billeteravirtual.utils;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Administrador;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.BilleteraVirtual;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Cuenta;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.TipoCuenta;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Usuario;

/**
 * Clase de utilidad para inicializar datos de prueba en la aplicación
 */
public class DataUtil {

    /**
     * Inicializa los datos de prueba para la aplicación
     * Crea administradores, usuarios y cuentas predefinidas
     * @return BilleteraVirtual con datos inicializados
     */
    public static BilleteraVirtual inicializarDatos() {
        // Inicializar la billetera virtual con cuentas
        BilleteraVirtual billeteraVirtual = inicializarCuentas();

        // Inicializar administradores y usuarios
        inicializarAdministradores();
        inicializarUsuarios();

        System.out.println("Datos de prueba inicializados correctamente");
        return billeteraVirtual;
    }

    /**
     * Inicializa cuentas de ejemplo para la aplicación
     * @return BilleteraVirtual con cuentas inicializadas
     */
    private static BilleteraVirtual inicializarCuentas() {
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual();
        Cuenta cuenta1 = Cuenta.builder()
                .idCuenta("1")
                .nombreBanco("Bancolombia")
                .numeroCuenta("123")
                .tipoCuenta(TipoCuenta.AHORRO)
                .build();

        Cuenta cuenta2 = Cuenta.builder()
                .idCuenta("2")
                .nombreBanco("Bancolombia")
                .numeroCuenta("567")
                .tipoCuenta(TipoCuenta.CORRIENTE)
                .build();

        Cuenta cuenta3 = Cuenta.builder()
                .idCuenta("3")
                .nombreBanco("Bancolombia")
                .numeroCuenta("890")
                .tipoCuenta(TipoCuenta.AHORRO)
                .build();

        billeteraVirtual.getListaCuentas().add(cuenta1);
        billeteraVirtual.getListaCuentas().add(cuenta2);
        billeteraVirtual.getListaCuentas().add(cuenta3);

        return billeteraVirtual;
    }

    /**
     * Inicializa los administradores de prueba
     * Crea 2 administradores: el principal (singleton) y uno secundario
     */
    private static void inicializarAdministradores() {
        // Obtener el administrador principal (ya creado por el singleton)
        Administrador adminPrincipal = Administrador.getInstance();
        System.out.println("Administrador principal creado: " + adminPrincipal.getNombre());

        // Crear un segundo administrador
        Administrador admin2 = new Administrador(
                "002",
                "Administrador Secundario",
                "admin2@billeteravirtual.com",
                "admin456"
        );
        System.out.println("Administrador secundario creado: " + admin2.getNombre());
    }

    /**
     * Inicializa los usuarios de prueba
     * Crea 3 usuarios con datos realistas
     */
    private static void inicializarUsuarios() {
        Administrador admin = Administrador.getInstance();

        try {
            // Usuario 1
            admin.registrarUsuario(
                    "1094567890",
                    "Ana María Gómez",
                    "ana.gomez@email.com",
                    "3001234567",
                    "clave123"
            );

            // Usuario 2
            admin.registrarUsuario(
                    "1094904942",
                    "Veronica Mendoza",
                    "carlos.rodriguez@email.com",
                    "3109876543",
                    "456"
            );

            // Usuario 3
            admin.registrarUsuario(
                    "1087654321",
                    "Laura Martínez",
                    "laura.martinez@email.com",
                    "3205678901",
                    "clave789"
            );

            System.out.println("Usuarios de prueba creados exitosamente");

        } catch (Exception e) {
            System.err.println("Error al inicializar los usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Verifica las credenciales de los usuarios predefinidos (para pruebas)
     * @param idUsuario ID del usuario
     * @param password Contraseña del usuario
     * @return true si las credenciales son válidas
     */
    public static boolean verificarCredencialesPredefinidas(String idUsuario, String password) {
        return (idUsuario.equals("1094567890") && password.equals("clave123")) ||
               (idUsuario.equals("1098765432") && password.equals("clave456")) ||
               (idUsuario.equals("1087654321") && password.equals("clave789"));
    }
}
