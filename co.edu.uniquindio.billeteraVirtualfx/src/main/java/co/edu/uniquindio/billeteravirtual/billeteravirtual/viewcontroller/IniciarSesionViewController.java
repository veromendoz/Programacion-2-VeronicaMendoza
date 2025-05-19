package co.edu.uniquindio.billeteravirtual.billeteravirtual.viewcontroller;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Administrador;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Sesion;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Usuario;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class IniciarSesionViewController {

    @FXML
    private GridPane gridPaneFormularioIniciarSesion;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private PasswordField passFieldContrasenaInicioSesion;

    @FXML
    private TextField txtNumeroIdentificacionInicioSesion;

    // Creamos una instancia que automáticamente obtiene el Stage desde la aplicación
    private final ControllerUtil controllerUtil = new ControllerUtil();

    // Obtener la instancia única del Administrador
    private final Administrador administrador = Administrador.getInstance();

    /**
     * Método controlador para el botón de iniciar sesión
     * @param event
     * @throws Exception
     */
    public void iniciarSesion(ActionEvent event) throws Exception {
        try {
            String idUsuario = txtNumeroIdentificacionInicioSesion.getText();
            String password = passFieldContrasenaInicioSesion.getText();

            // Verificar credenciales vacías
            if (idUsuario.isEmpty() || password.isEmpty()) {
                controllerUtil.crearAlerta("Debe ingresar identificación y contraseña", Alert.AlertType.WARNING);
                return;
            }

            // Verificar si es un administrador
            Administrador adminLogin = Administrador.buscarAdministrador(idUsuario, password);
            if (adminLogin != null) {
                controllerUtil.crearAlerta("Bienvenido Administrador " + adminLogin.getNombre(), Alert.AlertType.INFORMATION);
                // TODO: Navegar a la vista del panel de administrador cuando esté disponible
                controllerUtil.navegarVentanas("/BilleteraVirtualApp.fxml", "Administración", false);
                return;
            }

            // Llamada al método buscarUsuario de la instancia de Administrador
            Usuario usuario = administrador.buscarUsuario(idUsuario, password);

            if (usuario != null) {
                // Crear la sesión del usuario
                Sesion sesion = Sesion.getInstance();
                sesion.setUsuario(usuario);

                // Mostrar mensaje de bienvenida
                controllerUtil.crearAlerta("Bienvenido " + usuario.getNombre(), Alert.AlertType.INFORMATION);

                // Navegar a la vista del panel principal del Usuario
                controllerUtil.navegarVentanas("/VentanaUsuarioApp.fxml", "Banco-Panel Principal", true);
            }else{
                controllerUtil.crearAlerta("No se encontro el usuario", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            controllerUtil.crearAlerta("Error: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
    /**
     * Método controlador para el botón volver al inicio
     * @param event
     * @throws Exception
     */
    public void volverAInicio(ActionEvent event) throws Exception {
        try {
            controllerUtil.navegarVentanas("/InicioView.fxml", "Banco", false);
        } catch (Exception e) {
            controllerUtil.crearAlerta("Error al volver al inicio: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
