module com.mycompany.coffeedelcio {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.mycompany.coffeedelcio to javafx.fxml;
    exports com.mycompany.coffeedelcio;
}