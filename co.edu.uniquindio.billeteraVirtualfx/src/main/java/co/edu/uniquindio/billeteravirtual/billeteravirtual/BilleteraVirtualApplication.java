package co.edu.uniquindio.billeteravirtual.billeteravirtual;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.DataUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BilleteraVirtualApplication extends Application {
    // Stage principal de la aplicación (estático para acceder desde controladores)
    private static Stage primaryStage;

    /**
     * Devuelve el Stage principal de la aplicación
     * @return Stage principal
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Establece el Stage principal de la aplicación
     * @param stage El Stage a establecer como principal
     */
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Inicializar datos de prueba antes de mostrar la interfaz
        System.out.println("Inicializando datos de prueba...");
        DataUtil.inicializarDatos();

        // Guardamos referencia al stage principal
        primaryStage = stage;

        // Configuramos el Stage para que sea más robusto
        stage.setOnCloseRequest(event -> {
            // Limpieza al cerrar la aplicación si es necesario
        });

        // Cargamos la vista inicial
        cargarVistaInicial(stage);
    }

    /**
     * Carga la vista inicial de la aplicación
     * @param stage El Stage donde se mostrará la vista
     * @throws IOException Si hay problemas cargando el FXML
     */
    private void cargarVistaInicial(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BilleteraVirtualApplication.class.getResource("/InicioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App billetera virtual!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}