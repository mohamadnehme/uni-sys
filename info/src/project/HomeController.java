/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Echo data
 */
public class HomeController implements Initializable {
        
     @FXML
    private Button b;
     
    @FXML
    private ImageView lo;

    @FXML
    private MenuItem users;

    @FXML
    private MenuBar mymenubar;
    
    @FXML
    private Button creer;

    @FXML
    private Button logout;

    @FXML
    private ImageView log;

    @FXML
    private Button sh;
    
    @FXML
    void Creer(ActionEvent event) throws IOException {
        Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();

                Parent root = FXMLLoader.load(getClass().getResource("Create.fxml"));
                
                Scene scene = new Scene(root);
                
                s.setScene(scene);
                s.centerOnScreen();
                s.show();
    }
    
    @FXML
    void ShowUsers(ActionEvent event) throws IOException {
        Stage s = (Stage) ((Node) mymenubar).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ShowUsers.fxml"));
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.centerOnScreen();
        s.show();
    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
        Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.centerOnScreen();
        s.show();
    }
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
