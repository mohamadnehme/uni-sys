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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static project.DBconnect.connect;

/**
 * FXML Controller class
 *
 * @author Echo data
 */
public class CoursesController implements Initializable {

    ResultSet r;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,id1;
    Connection con = null;
    ImageIcon error;
    ImageIcon l1,l2;
    
    @FXML
    private VBox cr;

    @FXML
    private Label c1;

    @FXML
    private Label c2;

    @FXML
    private Label c3;

    @FXML
    private Label c4;

    @FXML
    private Label c5;

    @FXML
    private Label c6;

    @FXML
    private VBox cr1;

    @FXML
    private Label c7;

    @FXML
    private Label c8;

    @FXML
    private Label c9;

    @FXML
    private Label c10;

    @FXML
    private Label c11;

    @FXML
    private Label c12;
    
    @FXML
    private ImageView imagex;
    
    @FXML
    private ImageView image;
    
    @FXML
    private Label pre;

    @FXML
    private VBox vboxd1;

    @FXML
    private Label d1;

    @FXML
    private Label d2;

    @FXML
    private Label d3;

    @FXML
    private Label d4;

    @FXML
    private Label d5;

    @FXML
    private Label d6;

    @FXML
    private VBox vboxm1;

    @FXML
    private CheckBox m1;

    @FXML
    private CheckBox m2;

    @FXML
    private CheckBox m3;

    @FXML
    private CheckBox m4;

    @FXML
    private CheckBox m5;

    @FXML
    private CheckBox m6;

    @FXML
    private Label deus;

    @FXML
    private VBox vboxd2;

    @FXML
    private Label d7;

    @FXML
    private Label d8;

    @FXML
    private Label d9;

    @FXML
    private Label d10;

    @FXML
    private Label d11;

    @FXML
    private Label d12;

    @FXML
    private VBox vboxm2;

    @FXML
    private CheckBox m7;

    @FXML
    private CheckBox m8;

    @FXML
    private CheckBox m9;

    @FXML
    private CheckBox m10;

    @FXML
    private CheckBox m11;

    @FXML
    private CheckBox m12;

    @FXML
    private Button add;
    
    @FXML
    private Label id;

    @FXML
    void AddCourse(ActionEvent event) throws IOException, SQLException {
        if(!m1.isSelected() || !m2.isSelected() || !m3.isSelected() || !m4.isSelected() || !m5.isSelected() || !m6.isSelected() || !m7.isSelected() || !m8.isSelected() || !m9.isSelected() || !m10.isSelected() || !m11.isSelected() || !m12.isSelected()){
            JOptionPane.showMessageDialog(null,"Choose The Courses","Attention",1,l1);
        }
        else{
            int p = JOptionPane.showConfirmDialog(null,"Are you sure you want to add This Courses?","Add Course",JOptionPane.YES_NO_OPTION,0,l2);
            if(p == 0){
                try{
                id1 = id.getText();
                String query = "select id_c from cours where nom_cours = ?";
                PreparedStatement pm = con.prepareStatement(query);
                String query1 = "insert into joined (id_c,id_s) values(?,?)";
                PreparedStatement pm1 = con.prepareStatement(query1);
                
                pm.setString(1, m1.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                
                    pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m2.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m3.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m4.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m5.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m6.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m7.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m8.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m9.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m10.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m11.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                pm.setString(1, m12.getText());
                r = pm.executeQuery();
                r.next();
                s1 = r.getString("id_c");
                pm1.setString(1, s1);
                    pm1.setString(2, id1);
                    pm1.execute();
                
                Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Create.fxml"));
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.centerOnScreen();
                s.show();
                }catch(IOException | SQLException e){
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Error",1,error);
                }
            }
        }
    }
    
    @FXML
    void Close(ActionEvent event) throws IOException {
        
                Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Create.fxml"));
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
        id.setText(Project.id);
        error = new ImageIcon("src\\project\\images\\imageedit_1_2272947787.png");
        
        try {
            con = connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CoursesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String query = "SELECT t.nom_t , c.nom_cours , c.credit FROM teacher t , cours c where c.id_t = t.id_t";
        
        try {
            
            PreparedStatement pm1 = con.prepareStatement(query);
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
            Logger.getLogger(CoursesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        l1 = new ImageIcon("src\\project\\images\\imageedit_2_6347544384.gif");
        l2 = new ImageIcon("src\\project\\images\\rr.gif");
    }
}
