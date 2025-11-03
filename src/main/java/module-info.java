module uniquindio.edu.co {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens uniquindio.edu.co to javafx.fxml;
    exports uniquindio.edu.co;
    exports uniquindio.edu.co.Controller;
    opens uniquindio.edu.co.Controller to javafx.fxml;
}