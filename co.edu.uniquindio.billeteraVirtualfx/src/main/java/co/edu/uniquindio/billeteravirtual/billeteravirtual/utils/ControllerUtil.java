package co.edu.uniquindio.billeteravirtual.billeteravirtual.utils;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.BilleteraVirtualApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ControllerUtil {

    private Stage primary;

    /**
     * Constructor por defecto que inicializa el Stage desde la aplicación principal
     */
    public ControllerUtil() {
        // Obtenemos el Stage directamente de la aplicación principal
        this.primary = BilleteraVirtualApplication.getPrimaryStage();
    }

    /**
     * Constructor que recibe el Stage principal
     * @param primary Stage principal que se usará para navegar entre ventanas
     */
    public ControllerUtil(Stage primary) {
        this.primary = primary;
    }

    /**
     * Establece el Stage principal después de la construcción
     * @param primary Stage principal que se usará para navegar entre ventanas
     */
    public void setPrimary(Stage primary) {
        this.primary = primary;
    }

    /**
     * Método que permite navegar entre ventanas
     * @param nombreArchivoFxml nombre del archivo de la ventana
     * @param tituloVentana titulo de la ventana
     * @param resize parametro para establecer si la ventana se puede o no agrandar
     * @throws Exception
     */
    public void navegarVentanas(String nombreArchivoFxml, String tituloVentana, Boolean resize) throws Exception {
        try {
            // Si el primary es null, intentamos obtenerlo nuevamente de la aplicación principal
            if (primary == null) {
                primary = BilleteraVirtualApplication.getPrimaryStage();
                if (primary == null) {
                    throw new IllegalStateException("El Stage (primary) no ha sido inicializado y no se puede recuperar desde la aplicación.");
                }
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            primary.resizableProperty().setValue(resize);
            primary.setTitle(tituloVentana);
            primary.setScene(scene);
            primary.show();
        } catch(Exception e) {
            e.printStackTrace();
            throw e; // Re-lanzamos la excepción para que se pueda manejar en un nivel superior si es necesario
        }
    }

    /**
     * Metodo que pemite crear y mostrar alertas en pantalla
     * @param mensaje mensaje que aparecera en la alerta
     * @param tipo tipo de alerta
     */
    public void crearAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
