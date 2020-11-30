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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static project.DBconnect.connect;

/**
 * FXML Controller class
 *
 * @author Echo data
 */
public class UserCourseController implements Initializable {
    Connection con;
    ResultSet r;
    @FXML
    private Label s1;

    @FXML
    private Label s2;

    @FXML
    private Label d1;

    @FXML
    private Label m1;

    @FXML
    private Label c1;

    @FXML
    private Label d2;

    @FXML
    private Label m2;

    @FXML
    private Label c2;

    @FXML
    private Label d3;

    @FXML
    private Label m3;

    @FXML
    private Label c3;

    @FXML
    private Label d4;

    @FXML
    private Label m4;

    @FXML
    private Label c4;

    @FXML
    private Label d5;

    @FXML
    private Label m5;

    @FXML
    private Label c5;

    @FXML
    private Label d6;

    @FXML
    private Label m6;

    @FXML
    private Label c6;

    @FXML
    private Label d7;

    @FXML
    private Label m7;

    @FXML
    private Label c7;

    @FXML
    private Label d8;

    @FXML
    private Label m8;

    @FXML
    private Label c8;

    @FXML
    private Label d9;

    @FXML
    private Label m9;

    @FXML
    private Label c9;

    @FXML
    private Label d10;

    @FXML
    private Label m10;

    @FXML
    private Label c10;

    @FXML
    private Label d11;

    @FXML
    private Label m11;

    @FXML
    private Label c11;

    @FXML
    private Label d12;

    @FXML
    private Label m12;

    @FXML
    private Label c12;

    @FXML
    private Button close;

    @FXML
    void Close(ActionEvent event) throws IOException {
        Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
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
            Logger.getLogger(UserCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query1 = "select nom_t , nom_cours , c.credit from joined j , cours c , teacher t where j.id_s = ? and j.id_c = c.id_c and c.id_t = t.id_t";
        try {
            PreparedStatement pm1 = con.prepareStatement(query1);   
            pm1.setString(1, Project.id);
            r = pm1.executeQuery();
            r.next();
            
            d1.setText(r.getString("nom_t"));
            m1.setText(r.getString("nom_cours"));
            c1.setText(r.getString("credit"));
            r.next();
            
            d2.setText(r.getString("nom_t"));
            m2.setText(r.getString("nom_cours"));
            c2.setText(r.getString("credit"));
            r.next();
            
            d3.setText(r.getString("nom_t"));
            m3.setText(r.getString("nom_cours"));
            c3.setText(r.getString("credit"));
            
            r.next();
            
            d4.setText(r.getString("nom_t"));
            m4.setText(r.getString("nom_cours"));
            c4.setText(r.getString("credit"));
            r.next();
            
            d5.setText(r.getString("nom_t"));
            m5.setText(r.getString("nom_cours"));
            c5.setText(r.getString("credit"));
            r.next();
            
            d6.setText(r.getString("nom_t"));
            m6.setText(r.getString("nom_cours"));
            c6.setText(r.getString("credit"));
            r.next();
            
            d7.setText(r.getString("nom_t"));
            m7.setText(r.getString("nom_cours"));
            c7.setText(r.getString("credit"));
            r.next();
            
            d8.setText(r.getString("nom_t"));
            m8.setText(r.getString("nom_cours"));
            c8.setText(r.getString("credit"));
            r.next();
            
            d9.setText(r.getString("nom_t"));
            m9.setText(r.getString("nom_cours"));
            c9.setText(r.getString("credit"));
            r.next();
            
            d10.setText(r.getString("nom_t"));
            m10.setText(r.getString("nom_cours"));
            c10.setText(r.getString("credit"));
            r.next();
            
            d11.setText(r.getString("nom_t"));
            m11.setText(r.getString("nom_cours"));
            c11.setText(r.getString("credit"));
            r.next();
            
            d12.setText(r.getString("nom_t"));
            m12.setText(r.getString("nom_cours"));
            c12.setText(r.getString("credit"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
