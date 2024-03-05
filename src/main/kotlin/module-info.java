module p.itbactivitat10guijavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens p.itbactivitat10guijavafx to javafx.fxml;
    exports p.itbactivitat10guijavafx;
}