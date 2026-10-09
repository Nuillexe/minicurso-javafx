module com.example.interface_de_clientes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interface_de_clientes to javafx.fxml;
    exports com.example.interface_de_clientes;
    exports com.example.interface_de_clientes.Controllers;
    opens com.example.interface_de_clientes.Controllers to javafx.fxml;

}