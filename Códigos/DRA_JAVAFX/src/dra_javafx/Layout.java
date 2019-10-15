package dra_javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Layout extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public void closeApp() throws IOException{
        Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
