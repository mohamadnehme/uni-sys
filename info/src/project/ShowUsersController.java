/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static project.DBconnect.connect;

/**
 * FXML Controller class
 *
 * @author Echo data
 */

public class ShowUsersController implements Initializable {

    ResultSet r;
    Connection con;

    private final ObservableList<Person> obs = FXCollections.observableArrayList();
     @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> col1;

    @FXML
    private TableColumn<Person, String> col2;
    
    @FXML
    private TableColumn<Person, String> col3;
    
    @FXML
    private TableColumn<Person, String> col4;
    @FXML
    private TableColumn<Person, String> col5;
    @FXML
    private TableColumn<Person, String> col6;
    @FXML
    private TableColumn<Person, String> col7;
    @FXML
    private TableColumn<Person, String> col8;
    @FXML
    private Button btn;

    @FXML
    private ImageView cl;

    @FXML
    void close(ActionEvent event) throws IOException {
                Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
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
        try {
            con = connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col1.setCellValueFactory(
                    new PropertyValueFactory<Person,String>("id")
                    );

        col2.setCellValueFactory(
            new PropertyValueFactory<Person,String>("FirstName")
            ); 
        col3.setCellValueFactory(
            new PropertyValueFactory<Person,String>("lastName")
            ); 
        col4.setCellValueFactory(
            new PropertyValueFactory<Person,String>("date")
            ); 
        col5.setCellValueFactory(
            new PropertyValueFactory<Person,String>("gendre")
            ); 
        col6.setCellValueFactory(
            new PropertyValueFactory<Person,String>("phone")
            ); 
        col7.setCellValueFactory(
            new PropertyValueFactory<Person,String>("email")
            ); 
        col8.setCellValueFactory(
            new PropertyValueFactory<Person,String>("pass")
            ); 
        String query1 = "select * from student ";
                    PreparedStatement pm1;
        try {
            pm1 = con.prepareStatement(query1);
        
                    r = pm1.executeQuery();
                    
                    while(r.next())
                        obs.add(new Person(r.getString("id_s"),r.getString("first_name"),r.getString("last_name"),r.getString("dob"),r.getString("gendre"),r.getString("phone"),r.getString("email"),r.getString("pass")));
                    
                     
                    table.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(ShowUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
