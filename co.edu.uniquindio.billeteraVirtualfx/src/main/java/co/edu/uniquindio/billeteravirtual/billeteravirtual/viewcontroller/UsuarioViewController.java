package co.edu.uniquindio.billeteravirtual.billeteravirtual.viewcontroller;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.controller.UsuarioController;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Administrador;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.Usuario;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.ControllerUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class UsuarioViewController {
    private ControllerUtil controllerUtil = new ControllerUtil();
    private final UsuarioController usuarioController = new UsuarioController();
    private final ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private Usuario usuarioSeleccionado;

    // Obtener la instancia única del Administrador
    private final Administrador administrador = Administrador.getInstance();

    @FXML private TextField txtIdUsuario, txtNombre, txtEmail, txtCelular, txtPassword, txtSaldoTotal;
    @FXML private TableView<Usuario> tableUsuarios;
    @FXML private TableColumn<Usuario, String> colId, colNombre, colEmail, colCelular, colPassword;
    @FXML private TableColumn<Usuario, Double> colSaldoTotal;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getIdUsuario()));
        colNombre.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getNombre()));
        colEmail.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getEmail()));
        colCelular.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getCelular()));
        colPassword.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getPassword()));
        colSaldoTotal.setCellValueFactory(d -> new javafx.beans.property.SimpleDoubleProperty(d.getValue().getSaldoTotal()).asObject());

        tableUsuarios.setItems(listaUsuarios);
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, old, nuevo) -> {
            usuarioSeleccionado = nuevo;
            mostrarUsuario(nuevo);
        });

        // Cargar los usuarios desde el administrador
        if (administrador != null && administrador.getListaUsuarios() != null) {
            listaUsuarios.addAll(administrador.getListaUsuarios());
        }
    }

    private void mostrarUsuario(Usuario u) {
        if (u != null) {
            txtIdUsuario.setText(u.getIdUsuario());
            txtNombre.setText(u.getNombre());
            txtEmail.setText(u.getEmail());
            txtCelular.setText(u.getCelular());
            txtPassword.setText(u.getPassword());
            txtSaldoTotal.setText(String.valueOf(u.getSaldoTotal()));
        }
    }

    @FXML
    private void agregarUsuario() {
        Usuario u = new Usuario(
                txtIdUsuario.getText(),
                txtNombre.getText(),
                txtEmail.getText(),
                txtCelular.getText(),
                txtPassword.getText(),
                null // Puedes modificar esto si hay lógica para el administrador
        );
        if (usuarioController.agregarUsuario(u)) {
            listaUsuarios.add(u);
            limpiarCampos();
            mostrarMensaje("Usuario agregado correctamente.");
        }
    }

    @FXML
    private void actualizarUsuario() {
        if (usuarioSeleccionado != null) {
            usuarioSeleccionado.setNombre(txtNombre.getText());
            usuarioSeleccionado.setEmail(txtEmail.getText());
            usuarioSeleccionado.setCelular(txtCelular.getText());
            usuarioSeleccionado.setPassword(txtPassword.getText());
            tableUsuarios.refresh();
            mostrarMensaje("Usuario actualizado.");
        }
    }

    @FXML
    private void eliminarUsuario() {
        if (usuarioSeleccionado != null) {
            usuarioController.eliminarUsuario(usuarioSeleccionado.getIdUsuario());
            listaUsuarios.remove(usuarioSeleccionado);
            limpiarCampos();
            mostrarMensaje("Usuario eliminado.");
        }
    }
    
    @FXML
    private void volverInicio() {
        try {
            controllerUtil.navegarVentanas("/InicioView.fxml", "Banco", false);
        } catch (Exception e) {
            controllerUtil.crearAlerta("Error al volver al inicio: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    private void limpiarCampos() {
        txtIdUsuario.clear();
        txtNombre.clear();
        txtEmail.clear();
        txtCelular.clear();
        txtPassword.clear();
        txtSaldoTotal.clear();
        tableUsuarios.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String mensaje) {
        new Alert(Alert.AlertType.INFORMATION, mensaje).showAndWait();
    }
}
