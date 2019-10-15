package crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LayoutCRUD extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    
        Parent root = FXMLLoader.load(getClass().getResource("LayoutCRUD.fxml"));

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Sistema de Controle de Senhas");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
