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
    //requires javafx.base;


    opens uniquindio.edu.co to javafx.fxml;
    opens uniquindio.edu.co.viewController to javafx.fxml;
    exports uniquindio.edu.co;
    exports uniquindio.edu.co.Controller;
    exports uniquindio.edu.co.viewController;
    exports uniquindio.edu.co.model;
    exports uniquindio.edu.co.model.enums;
    exports uniquindio.edu.co.model.staffs;
}