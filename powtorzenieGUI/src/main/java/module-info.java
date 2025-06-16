module pl.umcs.oop.powtorzeniegui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens pl.umcs.oop.powtorzeniegui to javafx.fxml;
    exports pl.umcs.oop.powtorzeniegui;
}