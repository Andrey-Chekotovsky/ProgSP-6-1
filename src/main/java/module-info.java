module com.example.javafxtry {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxtry to javafx.fxml;
    exports com.example.javafxtry;
    exports com.example.javafxtry.Controllers;
    opens com.example.javafxtry.Controllers to javafx.fxml;
}