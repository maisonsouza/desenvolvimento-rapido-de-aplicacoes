/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra_javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jhoyce
 */
public class LayoutController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    public void openLayoutCRUD() throws IOException{
        Stage stage = new Stage();   
        Parent root = FXMLLoader.load(getClass()
                                      .getResource("/crud/LayoutCRUD.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL );
        stage.show();        
    }
    
    public void closeApp() throws IOException{
        Platform.exit();
    }
}
