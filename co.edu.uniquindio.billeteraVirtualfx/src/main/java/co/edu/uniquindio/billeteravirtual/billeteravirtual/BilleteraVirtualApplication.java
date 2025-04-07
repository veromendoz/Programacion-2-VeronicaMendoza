package co.edu.uniquindio.billeteravirtual.billeteravirtual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BilleteraVirtualApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BilleteraVirtualApplication.class.getResource("/co/edu/uniquindio/billeteravirtual/billeteravirtual/BilleteraVirtualApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App billetera virtual!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}