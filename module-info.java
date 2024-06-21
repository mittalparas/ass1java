module data.management.lab2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens data.management.lab2 to javafx.fxml;
    exports data.management.lab2;
}