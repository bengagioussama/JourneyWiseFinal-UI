module com.example.journeywisefinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.example.journeywisefinal to javafx.fxml;
    exports com.example.journeywisefinal;
    exports com.example.journeywisefinal.Controllers;
    opens com.example.journeywisefinal.Controllers to javafx.fxml;
    opens com.example.journeywisefinal.Entities to javafx.base;


}