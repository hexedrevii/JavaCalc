module xyz.itseve.javacalc {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.jetbrains.annotations;

    opens xyz.itseve.javacalc to javafx.fxml;
    exports xyz.itseve.javacalc;
}