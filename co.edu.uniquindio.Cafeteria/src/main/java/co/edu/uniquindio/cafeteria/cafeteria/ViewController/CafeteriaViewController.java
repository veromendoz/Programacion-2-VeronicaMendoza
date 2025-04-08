package co.edu.uniquindio.cafeteria.cafeteria.ViewController;

import co.edu.uniquindio.cafeteria.cafeteria.AzucarDecorator;
import co.edu.uniquindio.cafeteria.cafeteria.CanelaDecorator;
import co.edu.uniquindio.cafeteria.cafeteria.LecheDecorator;
import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;
import co.edu.uniquindio.cafeteria.cafeteria.WhiskyDecorator;
import co.edu.uniquindio.cafeteria.cafeteria.model.CafeSimple;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CafeteriaViewController implements Initializable {

    @FXML private CheckBox ChAzucar, ChCanela, ChLeche, ChWhisky;
    @FXML private Button btnCalcular;
    @FXML private ComboBox<String> cbMetodoPreparacion;
    @FXML private Label lbCosto, lbIngredientes;
    @FXML private RadioButton rbEspecial, rbPasilla;

    @FXML private ToggleGroup grupoTipoCafe;

    @FXML
    void OnCalcular(ActionEvent event) {
        ICoffee cafe = new CafeSimple();

        String tipoCafe = "";
        if (rbEspecial.isSelected()) {
            tipoCafe = "Especial";
        } else if (rbPasilla.isSelected()) {
            tipoCafe = "Pasilla";
        }

        if (ChAzucar.isSelected()) {
            cafe = new AzucarDecorator(cafe);
        }
        if (ChCanela.isSelected()) {
            cafe = new CanelaDecorator(cafe);
        }
        if (ChLeche.isSelected()) {
            cafe = new LecheDecorator(cafe);
        }
        if (ChWhisky.isSelected()) {
            cafe = new WhiskyDecorator(cafe);
        }

        String metodo = cbMetodoPreparacion.getSelectionModel().getSelectedItem();

        lbIngredientes.setText("Tipo: " + tipoCafe + "\nMétodo: " + metodo + "\nIngredientes: " + cafe.getDescripcion());
        lbCosto.setText("Costo: $" + String.format("%.2f", cafe.getCosto()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbMetodoPreparacion.getItems().addAll(
                "Espreso", "Prensa Francesa", "V60", "Chemex", "AeroPress"
        );
        cbMetodoPreparacion.getSelectionModel().selectFirst();

        grupoTipoCafe = new ToggleGroup();
        rbEspecial.setToggleGroup(grupoTipoCafe);
        rbPasilla.setToggleGroup(grupoTipoCafe);
    }

    @FXML void OnChAzucar(ActionEvent event) {}
    @FXML void OnChCanela(ActionEvent event) {}
    @FXML void OnChLeche(ActionEvent event) {}
    @FXML void OnChWhiscy(ActionEvent event) {}
    @FXML void onCbMetodoPreparacion(ActionEvent event) {}
    @FXML void onEspecial(ActionEvent event) {}
    @FXML void onPasilla(ActionEvent event) {}

}
