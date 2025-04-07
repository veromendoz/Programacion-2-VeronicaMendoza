package co.edu.uniquindio.billeteravirtual.billeteravirtual.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.Constantes.*;

public class CuentaViewController {

    CuentaController cuentaController;
    ObservableList<CuentaDto> listaCuentas = FXCollections.observableArrayList();
    CuentaDto cuentaSeleccionada;

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
    private TableView<CuentaDto> tableCuenta;

    @FXML
    private TableColumn<CuentaDto, String> tcIdCuenta;

    @FXML
    private TableColumn<CuentaDto, String> tcNombreBanco;

    @FXML
    private TableColumn<CuentaDto, String> tcNumeroCuenta;

    @FXML
    private TableColumn<CuentaDto, String> tcTipoCuenta;

    @FXML
    private TextField txtIdCuenta;

    @FXML
    private TextField txtNombreBanco;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    void initialize() {
        cuentaController = new CuentaController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerCuenta();
        tableCuenta.getItems().clear();
        tableCuenta.setItems(listaCuentas);
        listenerSelection();
    }

    private void obtenerCuenta() {
        listaCuentas.addAll(cuentaController.obtenerCuenta());
    }

    private void initDataBinding() {
        tcIdCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idCuenta()));
        tcNombreBanco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreBanco()));
        tcNumeroCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numeroCuenta()));
    }

    private void listenerSelection() {
        tableCuenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            cuentaSeleccionada = newSelection;
            mostrarInformacionCuenta(cuentaSeleccionada);
        });
    }

    private void mostrarInformacionCuenta(CuentaDto cuentaSeleccionada) {
        if (cuentaSeleccionada != null) {
            txtIdCuenta.setText(cuentaSeleccionada.idCuenta());
            txtNombreBanco.setText(cuentaSeleccionada.nombreBanco());
            txtNumeroCuenta.setText(cuentaSeleccionada.numeroCuenta());
        }
    }

    @FXML
    void onActualizarCuenta(ActionEvent event) {
        actualizarCuenta();

    }
    private void actualizarCuenta() {
        CuentaDto cuentaDto = crearCuentaDto();
        if (datosValidos(cuentaDto)) {
            if (cuentaController.actualizarCuenta(cuentaDto)) {
                for (int i = 0; i < listaCuentas.size(); i++) {
                    if (listaCuentas.get(i).idCuenta().equals(cuentaDto.idCuenta())) {
                        listaCuentas.set(i, cuentaDto);
                        break;
                    }
                }
                mostrarMensaje("Cuenta actualizada", "Éxito", "La cuenta fue actualizada correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "Actualización fallida", "No se encontró la cuenta para actualizar", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Campos incompletos", "Verificación", "Por favor llena todos los campos", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onAgregarCuenta(ActionEvent event) {
        agregarCuenta();
    }

    private void agregarCuenta() {
       CuentaDto cuentaDto = crearCuentaDto();
       if(datosValidos(cuentaDto)) {
           if (cuentaController.agregarCuenta(cuentaDto)) {
               listaCuentas.addAll(cuentaDto);
               mostrarMensaje(TITULO_CUENTA_NO_AGREGADA,HEADER, CUERPO_CUENTA_NO_AGREGADA, Alert.AlertType.INFORMATION);
           }else {
               mostrarMensaje(TITULO_CUENTA_NO_AGREGADA, HEADER, CUERPO_CUENTA_AGREGADA, Alert.AlertType.ERROR);
           }
       }else{
           mostrarMensaje(TITULO_INCOMPLETO, HEADER, CUERPO_INCOMPLETO, Alert.AlertType.WARNING);
       }
    }

    private CuentaDto crearCuentaDto() {
        return new CuentaDto(
                txtIdCuenta.getText(),
                txtNombreBanco.getText(),
                txtNumeroCuenta.getText()
        );
    }
    private boolean datosValidos(CuentaDto cuentaDto) {
        if(cuentaDto.idCuenta().isEmpty()||
                cuentaDto.nombreBanco().isEmpty()||
                cuentaDto.numeroCuenta().isEmpty()
        ){
            return false;
        }else{
            return true;
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


    @FXML
    void onEliminarCuenta(ActionEvent event) {
        eliminarCuenta();

    }
    private void eliminarCuenta() {
        CuentaDto cuentaDto = crearCuentaDto();
        if (cuentaDto != null && cuentaDto.idCuenta() != null && !cuentaDto.idCuenta().isEmpty()) {
            if (cuentaController.eliminarCuenta(cuentaDto.idCuenta())) {
                listaCuentas.removeIf(c -> c.idCuenta().equals(cuentaDto.idCuenta()));
                mostrarMensaje("Cuenta eliminada", "Éxito", "La cuenta fue eliminada correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "Eliminación fallida", "No se encontró la cuenta a eliminar", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("ID requerido", "Validación", "Debe ingresar un ID de cuenta para eliminar", Alert.AlertType.WARNING);
        }
    }


    @FXML
    void onLimpiarCuenta(ActionEvent event) {
        limpiarCampos();
    }
    private void limpiarCampos() {
        txtIdCuenta.clear();
        txtNombreBanco.clear();
        txtNumeroCuenta.clear();
    }


}
