package co.edu.uniquindio.billeteravirtual.billeteravirtual.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CuentaController {

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
    private ComboBox<?> cbxTipoCuenta;

    @FXML
    private TableView<CuentaDto> tableCuenta;

    @FXML
    private TableColumn <CuentaDto, String>tcIdCuenta;

    @FXML
    private TableColumn <CuentaDto, String> tcNombreBanco;

    @FXML
    private TableColumn <CuentaDto, String>tcNumeroCuenta;

    @FXML
    private TableColumn <CuentaDto, String>tcTipoCuenta;

    @FXML
    private TextField txtIdCuenta;

    @FXML
    private TextField txtNombreBanco;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    private TextField txtTipoCuenta;

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
        listaCuentas.addAll(CuentaController.obtenerCuenta());
    }
    }

    private void initDataBinding() {
        tcIdCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idCuenta()));
        tcNombreBanco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreBanco()));
        tcNumeroCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numeroCuenta()));
        tcTipoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tipoCuenta()));
    }
    private void listenerSelection() {
        tableCuenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            cuentaSeleccionada = newSelection;
            mostrarInformacionCuenta(cuentaSeleccionada);
        });
    }

    private void mostrarInformacionCuenta(CuentaDto cuentaSeleccionada) {
        if(cuentaSeleccionada != null){
            txtIdCuenta.setText(cuentaSeleccionada.idCuenta());
            txtNombreBanco.setText(cuentaSeleccionada.nombreBanco());
            txtNumeroCuenta.setText(cuentaSeleccionada.numeroCuenta());
            txtTipoCuenta.setText(cuentaSeleccionada.tipoCuenta());

    }

}

