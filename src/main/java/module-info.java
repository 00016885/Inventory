module com.example.inventory {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.inventory to javafx.fxml;
    exports com.example.inventory;
    opens com.example.inventory.controller to javafx.fxml;
    exports com.example.inventory.controller;
    opens com.example.inventory.model to javafx.base;
}