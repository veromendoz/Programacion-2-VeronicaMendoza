package co.edu.uniquindio.billeteravirtual.billeteravirtual.viewcontroller;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class InicioViewController {
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private ImageView imgImagenInicio;

    // Creamos una instancia que automáticamente obtiene el Stage desde la aplicación
    private final ControllerUtil controllerUtil = new ControllerUtil();

    /**
     * Método controlador del botón iniciar sesión
     * @param event
     * @throws Exception
     */
    public void irAIniciarSesion(ActionEvent event) throws Exception {
        try {
            controllerUtil.navegarVentanas("/IniciarSesionView.fxml", "Banco-IniciarSesion", false);
        } catch (Exception e) {
            controllerUtil.crearAlerta("Error al navegar: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    /**
     * Método controlador del botón registrarse
     * @param event
     * @throws Exception
     */
    public void irARegistrarse(ActionEvent event) throws Exception {
        try {
            controllerUtil.navegarVentanas("/RegistroView.fxml", "Banco-Registrarse", false);
        } catch (Exception e) {
            controllerUtil.crearAlerta("Error al navegar: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
