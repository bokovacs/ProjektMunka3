module org.example.projektmunka {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.projektmunka to javafx.fxml;
    exports org.example.projektmunka;
}