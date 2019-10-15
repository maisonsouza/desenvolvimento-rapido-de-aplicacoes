package dra_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyHelloWorldJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {        
        //Definindo nó raiz
        Label label = new Label("Hello World FavaFX!!");
        //Adicionando nó à cena
        Scene cena = new Scene(label, 200, 200);
        //Adicionando cena ao palco
        primaryStage.setScene(cena);
        //Tornando palco visível
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
