package co.edu.uniquindio.billeteravirtual.billeteravirtual.viewcontroller;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Administrador;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RegistroViewController {
    @FXML
    private GridPane gridPaneFormularioRegistro;
    @FXML
    private PasswordField passFieldContrasena;
    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumeroIdentificacion;

    @FXML
    private TextField txtResidencia;

    // Creamos una instancia que automáticamente obtiene el Stage desde la aplicación
    private final ControllerUtil controllerUtil = new ControllerUtil();

    // Obtener la instancia única del Administrador
    private final Administrador administrador = Administrador.getInstance();

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

    /**
     * Método controlador para el botón de registrarse
     * @param event
     * @throws Exception
     */
    public void registrarCuenta(ActionEvent event) throws Exception {
        try {
            administrador.registrarUsuario(
                    txtNumeroIdentificacion.getText(),
                    txtNombre.getText(),
                    txtResidencia.getText(),
                    txtCorreoElectronico.getText(),
                    passFieldContrasena.getText()
            );
            controllerUtil.crearAlerta("Registro exitoso", Alert.AlertType.INFORMATION);
            controllerUtil.navegarVentanas("/InicioView.fxml", "Banco", false);
        } catch (Exception e) {
            controllerUtil.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
