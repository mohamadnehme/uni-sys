/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.HeadlessException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static project.DBconnect.connect;

/**
 * FXML Controller class
 *
 * @author Echo data
 */
public class GradeController implements Initializable {
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    int a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,id1;
    ImageIcon i1,l2;
    ResultSet r;
    Connection con;
    @FXML
    private Label tid;
    @FXML
    private ImageView image;

    @FXML
    private Button cls;

    @FXML
    private Label p;

    @FXML
    private Label d;

    @FXML
    private Label m1;

    @FXML
    private TextField t1;

    @FXML
    private Label m2;

    @FXML
    private TextField t2;

    @FXML
    private Label m3;

    @FXML
    private TextField t3;

    @FXML
    private Label m4;

    @FXML
    private TextField t4;

    @FXML
    private Label m5;

    @FXML
    private TextField t5;

    @FXML
    private Label m6;

    @FXML
    private TextField t6;

    @FXML
    private Label m7;

    @FXML
    private TextField t7;

    @FXML
    private Label m8;

    @FXML
    private TextField t8;

    @FXML
    private Label m9;

    @FXML
    private TextField t9;

    @FXML
    private Label m10;

    @FXML
    private TextField t10;

    @FXML
    private Label m11;

    @FXML
    private TextField t11;

    @FXML
    private Label m12;

    @FXML
    private TextField t12;

    @FXML
    private Button btn;

    @FXML
    @SuppressWarnings("IncompatibleEquals")
    void SetGrade(ActionEvent event) {
        if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || t6.getText().isEmpty() || t7.getText().isEmpty() || t8.getText().isEmpty() || t9.getText().isEmpty() || t10.getText().isEmpty() || t11.getText().isEmpty() || t12.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Fill The Grades","Attention",1,i1);
        }
        else{
          try{
            a1=Integer.parseInt(t1.getText().trim());
            a2=Integer.parseInt(t2.getText().trim());
            a3=Integer.parseInt(t3.getText().trim());
            a4=Integer.parseInt(t4.getText().trim());
            a5=Integer.parseInt(t5.getText().trim());
            a6=Integer.parseInt(t6.getText().trim());
            a7=Integer.parseInt(t7.getText().trim());
            a8=Integer.parseInt(t8.getText().trim());
            a9=Integer.parseInt(t9.getText().trim());
            a10=Integer.parseInt(t10.getText().trim());
            a11=Integer.parseInt(t11.getText().trim());
            a12=Integer.parseInt(t12.getText().trim());
            if(a1>100 || a2>100 ||a3>100 ||a4>100 ||a5>100 ||a6>100 ||a7>100 ||a8>100 ||a9>100 ||a10>100 ||a11>100 ||a12>100){
                JOptionPane.showMessageDialog(null,"The Grade Must Be Less Then 100","Attention",1,i1);
            }
            else{
                int p = JOptionPane.showConfirmDialog(null,"Are you sure you want to add grade?","Add Grade",JOptionPane.YES_NO_OPTION,0,l2);
                if(p == 0){
                    String query = "select id_c from cours where nom_cours = ?";
                    PreparedStatement pm = con.prepareStatement(query);
                    String query1 = "update joined set note = ? where id_c = ? and id_s = "+tid.getText()+"";
                    PreparedStatement pm1 = con.prepareStatement(query1);
                    pm.setString(1, m1.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t1.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m2.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t2.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m3.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t3.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m4.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t4.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m5.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t5.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m6.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t6.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m7.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t7.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m8.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t8.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m9.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t9.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m10.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t10.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m11.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t11.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    pm.setString(1, m12.getText());
                    r = pm.executeQuery();
                    r.next();
                    s1 = r.getString("id_c");
                    pm1.setString(1, t12.getText());
                    pm1.setString(2, s1);
                    pm1.executeUpdate();
                    
                    Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("Create.fxml"));
                    Scene scene = new Scene(root);
                    s.setScene(scene);
                    s.centerOnScreen();
                    s.show();
                }
            }
          }catch(HeadlessException | IOException | NumberFormatException | SQLException e){
              JOptionPane.showMessageDialog(null,"Inavlid Grade","Attention",1,i1);
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tid.setText(Project.id);
        try {
            con = connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GradeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        i1 = new ImageIcon("src\\project\\images\\imageedit_2_6347544384.gif");
        l2 = new ImageIcon("src\\project\\images\\rr.gif");
        String query1 = "select c.nom_cours from joined j , cours c where j.id_s = ? and j.id_c = c.id_c";
        PreparedStatement pm1;
        try {
            pm1 = con.prepareStatement(query1);
            pm1.setString(1, tid.getText());
            r = pm1.executeQuery();
            r.next();
            m1.setText(r.getString("nom_cours"));
            r.next();
            m2.setText(r.getString("nom_cours"));
            r.next();
            m3.setText(r.getString("nom_cours"));
            r.next();
            m4.setText(r.getString("nom_cours"));
            r.next();
            m5.setText(r.getString("nom_cours"));
            r.next();
            m6.setText(r.getString("nom_cours"));
            r.next();
            m7.setText(r.getString("nom_cours"));
            r.next();
            m8.setText(r.getString("nom_cours"));
            r.next();
            m9.setText(r.getString("nom_cours"));
            r.next();
            m10.setText(r.getString("nom_cours"));
            r.next();
            m11.setText(r.getString("nom_cours"));
            r.next();
            m12.setText(r.getString("nom_cours"));
            
        } catch (SQLException ex) {
            Logger.getLogger(GradeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
