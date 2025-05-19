module co.edu.uniquindio.billeteravirtual.video {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens co.edu.uniquindio.billeteravirtual.video to javafx.fxml;
    exports co.edu.uniquindio.billeteravirtual.video;
}