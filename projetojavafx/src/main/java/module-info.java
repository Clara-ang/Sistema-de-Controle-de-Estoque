module br.com.projeto {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.projeto to javafx.fxml;
    exports br.com.projeto;
}
