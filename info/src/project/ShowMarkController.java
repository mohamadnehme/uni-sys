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
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import static project.DBconnect.connect;

/**
 * FXML Controller class
 *
 * @author Echo data
 */
public class ShowMarkController implements Initializable {

    Connection con;
    ResultSet r;
    @FXML
    private Label m1;

    @FXML
    private Label c1;

    @FXML
    private Label max1;

    @FXML
    private Label g1;

    @FXML
    private Label m2;

    @FXML
    private Label c2;

    @FXML
    private Label max2;

    @FXML
    private Label g2;

    @FXML
    private Label m3;

    @FXML
    private Label c3;

    @FXML
    private Label max3;

    @FXML
    private Label g3;

    @FXML
    private Label m4;

    @FXML
    private Label c4;

    @FXML
    private Label max4;

    @FXML
    private Label g4;

    @FXML
    private Label m5;

    @FXML
    private Label c5;

    @FXML
    private Label max5;

    @FXML
    private Label g5;

    @FXML
    private Label m6;

    @FXML
    private Label c6;

    @FXML
    private Label max6;

    @FXML
    private Label g6;

    @FXML
    private Label m7;

    @FXML
    private Label c7;

    @FXML
    private Label max7;

    @FXML
    private Label g7;

    @FXML
    private Label m8;

    @FXML
    private Label c8;

    @FXML
    private Label max8;

    @FXML
    private Label g8;

    @FXML
    private Label m9;

    @FXML
    private Label c9;

    @FXML
    private Label max9;

    @FXML
    private Label g9;

    @FXML
    private Label m10;

    @FXML
    private Label c10;

    @FXML
    private Label max10;

    @FXML
    private Label g10;

    @FXML
    private Label m11;

    @FXML
    private Label c11;

    @FXML
    private Label max11;

    @FXML
    private Label g11;

    @FXML
    private Label m12;

    @FXML
    private Label c12;

    @FXML
    private Label max12;

     @FXML
    private Label g12;

    @FXML
    private Button cls;

    @FXML
    private ImageView close;

    @FXML
    private Label matiere;

    @FXML
    private Label credit;

    @FXML
    private Label notesur;

    @FXML
    private Label note;

    @FXML
    private Label matiere1;

    @FXML
    private Label credit1;

    @FXML
    private Label notesur1;

    @FXML
    private Label note1;

    @FXML
    private Label totalsur;

    @FXML
    private Label total;

    @FXML
    private Label totalsur1;

    @FXML
    private Label totalp;

    @FXML
    private Label result;

    @FXML
    private Label name;

    @FXML
    private Label tl;
    
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
        name.setText(Project.id);
        try {
            con = connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowMarkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query1 = "select c.nom_cours , c.credit , j.note from joined j , cours c where j.id_s = ? and j.id_c = c.id_c";
          
        try {
            double total1=0,total2=0;
            PreparedStatement pm1 = con.prepareStatement(query1);
            pm1.setString(1, Project.id);
            r = pm1.executeQuery();
            r.next();
            m1.setText(r.getString("nom_cours"));
            c1.setText(r.getString("credit"));
            max1.setText("100");
            g1.setText(r.getString("note"));
            total1 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m2.setText(r.getString("nom_cours"));
            c2.setText(r.getString("credit"));
            max2.setText("100");
            g2.setText(r.getString("note"));
            total1 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m3.setText(r.getString("nom_cours"));
            c3.setText(r.getString("credit"));
            max3.setText("100");
            g3.setText(r.getString("note"));
            total1 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m4.setText(r.getString("nom_cours"));
            c4.setText(r.getString("credit"));
            max4.setText("100");
            g4.setText(r.getString("note"));
            total1 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m5.setText(r.getString("nom_cours"));
            c5.setText(r.getString("credit"));
            max5.setText("100");
            g5.setText(r.getString("note"));
            total1 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m6.setText(r.getString("nom_cours"));
            c6.setText(r.getString("credit"));
            max6.setText("100");
            g6.setText(r.getString("note"));
            total1 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m7.setText(r.getString("nom_cours"));
            c7.setText(r.getString("credit"));
            max7.setText("100");
            g7.setText(r.getString("note"));
            total2 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m8.setText(r.getString("nom_cours"));
            c8.setText(r.getString("credit"));
            max8.setText("100");
            g8.setText(r.getString("note"));
            total2 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m9.setText(r.getString("nom_cours"));
            c9.setText(r.getString("credit"));
            max9.setText("100");
            g9.setText(r.getString("note"));
            total2 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m10.setText(r.getString("nom_cours"));
            c10.setText(r.getString("credit"));
            max10.setText("100");
            g10.setText(r.getString("note"));
            total2 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m11.setText(r.getString("nom_cours"));
            c11.setText(r.getString("credit"));
            max11.setText("100");
            g11.setText(r.getString("note"));
            total2 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            r.next();
            m12.setText(r.getString("nom_cours"));
            c12.setText(r.getString("credit"));
            max12.setText("100");
            g12.setText(r.getString("note"));
            total2 += Double.parseDouble(r.getString("note")) * Double.parseDouble(r.getString("credit"));
            total1/=30;
            total2/=30;
            double to = (total1 + total2)/2;
            if(to<48){
                result.setStyle("-fx-text-fill: red; -fx-font-size: 28px;");
                result.setText("Failure");
            }
            else{
                result.setStyle("-fx-text-fill: green; -fx-font-size: 28px;");
                result.setText("Success");
            }
            total.setText(total1+"");
            totalp.setText(total2+"");
            tl.setText(to+"");
        } catch (SQLException ex) {
            Logger.getLogger(ShowMarkController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
