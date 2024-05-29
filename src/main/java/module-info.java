// 'mvcapp': Your module name
// 'com.example': Your package name
module mvcapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hildan.fxgson;    
    opens com.example to javafx.graphics, javafx.fxml, com.google.gson;
}
