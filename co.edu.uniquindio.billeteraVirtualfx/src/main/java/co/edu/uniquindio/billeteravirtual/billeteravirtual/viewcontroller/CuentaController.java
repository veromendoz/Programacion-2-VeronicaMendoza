package co.edu.uniquindio.billeteravirtual.billeteravirtual.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CuentaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<?> cbxTipoCuenta;

    @FXML
    private TableView<?> tableCuenta;

    @FXML
    private TextField txtIdCuenta;

    @FXML
    private TextField txtNombreBanco;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    void OnActualizarCuenta(ActionEvent event) {

    }

    @FXML
    void OnAgregarCuenta(ActionEvent event) {

    }

    @FXML
    void OnEliminarCuenta(ActionEvent event) {

    }

    @FXML
    void OnLimpiarCuenta(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert cbxTipoCuenta != null : "fx:id=\"cbxTipoCuenta\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tableCuenta != null : "fx:id=\"tableCuenta\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert txtIdCuenta != null : "fx:id=\"txtIdCuenta\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert txtNombreBanco != null : "fx:id=\"txtNombreBanco\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert txtNumeroCuenta != null : "fx:id=\"txtNumeroCuenta\" was not injected: check your FXML file 'Cuenta.fxml'.";

    }

}
