/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static project.DBconnect.connect;

/**
 *
 * @author Echo data
 */
public class FXMLDocumentController implements Initializable {
    ResultSet r;
    String d2;
    String d3;
    Connection con;
    @FXML
    private Label label;
    @FXML
    private Button button;


        
    @FXML
    private MenuItem time;

    @FXML
    private MenuItem date;

    @FXML
    void ShowDate(ActionEvent event) {
        JOptionPane.showMessageDialog(null, d3);
    }

    @FXML
    void ShowTime(ActionEvent event) {
        ImageIcon l = new ImageIcon("src\\project\\images\\Alarm_Clock_GIF_Animation.gif");
        JOptionPane.showMessageDialog(null, d2," ",JOptionPane.INFORMATION_MESSAGE ,l);
    }
    
    @FXML
    private TextField t2;

    @FXML
    private TextField t1;

    @FXML
    private ComboBox<String> combo;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        try{
        String access = combo.getValue();
        if(access.equals("Admin")){
            if(t1.getText().equals("admin") && t2.getText().equals("ul")){
                
                Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                JOptionPane.showMessageDialog(null,"Success");
                Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.centerOnScreen();
                s.show();
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Email or Password");
            }
        }
        else{
            if(access.equals("User")){
                String email,pass;
                email = t1.getText();
                pass = t2.getText();
                String query1 = "select id_s , first_name from student where email = ? and pass = ?";
                    PreparedStatement pm1 = con.prepareStatement(query1);
                    pm1.setString(1, email);
                    pm1.setString(2, pass);
                    r = pm1.executeQuery();
                    if(r.next()){
                        Project.id = r.getString("id_s");
                        Project.name = r.getString("first_name");
                        Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                        JOptionPane.showMessageDialog(null,"Success");
                        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
                        Scene scene = new Scene(root);
                        s.setScene(scene);
                        s.centerOnScreen();
                        s.show();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid Email or Password");
                    }
            }
        }
        }catch(Exception e){
            
        }
    }
    private Timer timer;
    private ActionListener timerAction;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            con = connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        combo.getItems().addAll(
            "Admin",
            "User"
        );
        
        this.timerAction = (java.awt.event.ActionEvent event) -> {
                timer.stop();
                Date d1=new Date();
                SimpleDateFormat d = new SimpleDateFormat("MM:mm:ss");
                d2=d.format(d1);
                timer.restart();
            };
        timer =new Timer(1000,timerAction);
        timer.start();
        
        Date d1=new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String d2=d.format(d1);
        if(d1.getDay()==0 && d1.getMonth()==0){
            d3=" sunday " + " januray " + " " + d2;
        }
         if(d1.getDay()==0 && d1.getMonth()==1){
            d3=" sunday " + " february " + " " + d2;
            
        } if(d1.getDay()==0 && d1.getMonth()==2){
            d3=" sunday " + " marsh " + " " + d2;
        }
         if(d1.getDay()==0 && d1.getMonth()==3){
            d3=" sunday " + " april " + " " + d2;
        }
          if(d1.getDay()==0 && d1.getMonth()==4){
            d3=" sunday " + " may " + " " + d2;
        }
           if(d1.getDay()==0 && d1.getMonth()==5){
            d3=" sunday " + " june " + " " + d2;
        }
            if(d1.getDay()==0 && d1.getMonth()==6){
            d3=" sunday " + " july " + " " + d2;
        }
             if(d1.getDay()==0 && d1.getMonth()==7){
            d3=" sunday " + " august " + " " + d2;
        }
              if(d1.getDay()==0 && d1.getMonth()==8){
            d3=" sunday " + " september " + " " + d2;
        }
               if(d1.getDay()==0 && d1.getMonth()==9){
            d3=" sunday " + " october " + " " + d2;
        }
                if(d1.getDay()==0 && d1.getMonth()==10){
            d3=" sunday " + " november " + " " + d2;
        }
                 if(d1.getDay()==0 && d1.getMonth()==11){
            d3=" sunday " + " december " + " " + d2;
        }
          if(d1.getDay()==1 && d1.getMonth()==0){
            d3=" sunday " + " januray " + " " + d2;
        }
         if(d1.getDay()==1 && d1.getMonth()==1){
            d3=" monday " + " february " + " " + d2;
            
        } if(d1.getDay()==1 && d1.getMonth()==2){
            d3=" monday " + " marsh " + " " + d2;
        }
         if(d1.getDay()==1 && d1.getMonth()==3){
            d3=" monday " + " april " + " " + d2;
        }
          if(d1.getDay()==1 && d1.getMonth()==4){
            d3=" monday " + " may " + " " + d2;
        }
           if(d1.getDay()==1 && d1.getMonth()==5){
            d3=" monday " + " june " + " " + d2;
        }
            if(d1.getDay()==1 && d1.getMonth()==6){
            d3=" monday " + " july " + " " + d2;
        }
             if(d1.getDay()==1 && d1.getMonth()==7){
            d3=" monday " + " august " + " " + d2;
        }
              if(d1.getDay()==1 && d1.getMonth()==8){
            d3=" monday " + " september " + " " + d2;
        }
               if(d1.getDay()==1 && d1.getMonth()==9){
            d3=" monday " + " october " + " " + d2;
        }
                if(d1.getDay()==1 && d1.getMonth()==10){
            d3=" monday " + " november " + " " + d2;
        }
                 if(d1.getDay()==1 && d1.getMonth()==11){
            d3=" monday " + " december " + " " + d2;
        }
                 if(d1.getDay()==2 && d1.getMonth()==0){
            d3=" tuesday " + " januray " + " " + d2;
        }
         if(d1.getDay()==2 && d1.getMonth()==1){
            d3=" tuesday " + " february " + " " + d2;
            
        } if(d1.getDay()==2 && d1.getMonth()==2){
            d3=" tuesday " + " marsh " + " " + d2;
        }
         if(d1.getDay()==2 && d1.getMonth()==3){
            d3=" tuesday " + " april " + " " + d2;
        }
          if(d1.getDay()==2 && d1.getMonth()==4){
            d3=" tuesday " + " may " + " " + d2;
        }
           if(d1.getDay()==2 && d1.getMonth()==5){
            d3=" tuesday " + " june " + " " + d2;
        }
            if(d1.getDay()==2 && d1.getMonth()==6){
            d3=" tuesday " + " july " + " " + d2;
        }
             if(d1.getDay()==2 && d1.getMonth()==7){
            d3=" tuesday " + " august " + " " + d2;
        }
              if(d1.getDay()==2 && d1.getMonth()==8){
            d3=" tuesday " + " september " + " " + d2;
        }
               if(d1.getDay()==2 && d1.getMonth()==9){
            d3=" tuesday " + " october " + " " + d2;
        }
                if(d1.getDay()==2 && d1.getMonth()==10){
            d3=" tuesday " + " november " + " " + d2;
        }
                 if(d1.getDay()==2 && d1.getMonth()==11){
            d3=" tuesday " + " december " + " " + d2;
        }
                 if(d1.getDay()==3 && d1.getMonth()==0){
            d3=" wednesday " + " januray " + " " + d2;
        }
         if(d1.getDay()==3 && d1.getMonth()==1){
            d3=" wednesday " + " february " + " " + d2;
            
        } if(d1.getDay()==3 && d1.getMonth()==2){
            d3=" wednesday " + " marsh " + " " + d2;
        }
         if(d1.getDay()==3 && d1.getMonth()==3){
            d3=" wednesday " + " april " + " " + d2;
        }
          if(d1.getDay()==3 && d1.getMonth()==4){
            d3=" wednesday " + " may " + " " + d2;
        }
           if(d1.getDay()==3 && d1.getMonth()==5){
            d3=" wednesday " + " june " + " " + d2;
        }
            if(d1.getDay()==3 && d1.getMonth()==6){
            d3=" wednesday " + " july " + " " + d2;
        }
             if(d1.getDay()==3 && d1.getMonth()==7){
            d3=" wednesday " + " august " + " " + d2;
        }
              if(d1.getDay()==3 && d1.getMonth()==8){
            d3=" wednesday " + " september " + " " + d2;
        }
               if(d1.getDay()==3 && d1.getMonth()==9){
            d3=" wednesday " + " october " + " " + d2;
        }
                if(d1.getDay()==3 && d1.getMonth()==10){
            d3=" wednesday " + " november " + " " + d2;
        }
                 if(d1.getDay()==3 && d1.getMonth()==11){
            d3=" wednesday " + " december " + " " + d2;
        }
                 
                 if(d1.getDay()==4 && d1.getMonth()==0){
            d3=" tuesday " + " januray " + " " + d2;
        }
         if(d1.getDay()==4 && d1.getMonth()==1){
            d3=" tuesday " + " february " + " " + d2;
            
        } if(d1.getDay()==4 && d1.getMonth()==2){
            d3=" tuesday " + " marsh " + " " + d2;
        }
         if(d1.getDay()==4 && d1.getMonth()==3){
            d3=" tuesday " + " april " + " " + d2;
        }
          if(d1.getDay()==4 && d1.getMonth()==4){
            d3=" tuesday " + " may " + " " + d2;
        }
           if(d1.getDay()==4 && d1.getMonth()==5){
            d3=" tuesday " + " june " + " " + d2;
        }
            if(d1.getDay()==4 && d1.getMonth()==6){
            d3=" tuesday " + " july " + " " + d2;
        }
             if(d1.getDay()==4 && d1.getMonth()==7){
            d3=" tuesday " + " august " + " " + d2;
        }
              if(d1.getDay()==4 && d1.getMonth()==8){
            d3=" tuesday " + " september " + " " + d2;
        }
               if(d1.getDay()==4 && d1.getMonth()==9){
            d3=" tuesday " + " october " + " " + d2;
        }
                if(d1.getDay()==4 && d1.getMonth()==10){
            d3=" tuesday " + " november " + " " + d2;
        }
                 if(d1.getDay()==4 && d1.getMonth()==11){
            d3=" tuesday " + " december " + " " + d2;
        }
                 if(d1.getDay()==5 && d1.getMonth()==0){
            d3=" friday " + " januray " + " " + d2;
        }
         if(d1.getDay()==5 && d1.getMonth()==1){
            d3=" friday " + " february " + " " + d2;
            
        } if(d1.getDay()==5 && d1.getMonth()==2){
            d3=" friday " + " marsh " + " " + d2;
        }
         if(d1.getDay()==5 && d1.getMonth()==3){
            d3=" friday " + " april " + " " + d2;
        }
          if(d1.getDay()==5 && d1.getMonth()==4){
            d3=" friday " + " may " + " " + d2;
        }
           if(d1.getDay()==5 && d1.getMonth()==5){
            d3=" friday " + " june " + " " + d2;
        }
            if(d1.getDay()==5 && d1.getMonth()==6){
            d3=" friday " + " july " + " " + d2;
        }
             if(d1.getDay()==5 && d1.getMonth()==7){
            d3=" friday " + " august " + " " + d2;
        }
              if(d1.getDay()==5 && d1.getMonth()==8){
            d3=" friday " + " september " + " " + d2;
        }
               if(d1.getDay()==5 && d1.getMonth()==9){
            d3=" friday " + " october " + " " + d2;
        }
                if(d1.getDay()==5 && d1.getMonth()==10){
            d3=" friday " + " november " + " " + d2;
        }
                 if(d1.getDay()==5 && d1.getMonth()==11){
            d3=" friday " + " december " + " " + d2;
        }
                 if(d1.getDay()==6 && d1.getMonth()==0){
            d3=" saturday " + " januray " + " " + d2;
        }
         if(d1.getDay()==6 && d1.getMonth()==1){
            d3=" saturday " + " february " + " " + d2;
            
        } if(d1.getDay()==6 && d1.getMonth()==2){
            d3=" saturday " + " marsh " + " " + d2;
        }
         if(d1.getDay()==6 && d1.getMonth()==3){
            d3=" saturday " + " april " + " " + d2;
        }
          if(d1.getDay()==6 && d1.getMonth()==4){
            d3=" saturday " + " may " + " " + d2;
        }
           if(d1.getDay()==6 && d1.getMonth()==5){
            d3=" saturday " + " june " + " " + d2;
        }
            if(d1.getDay()==6 && d1.getMonth()==6){
            d3=" saturday " + " july " + " " + d2;
        }
             if(d1.getDay()==6 && d1.getMonth()==7){
            d3=" saturday " + " august " + " " + d2;
        }
              if(d1.getDay()==6 && d1.getMonth()==8){
            d3=" saturday " + " september " + " " + d2;
        }
               if(d1.getDay()==6 && d1.getMonth()==9){
            d3=" saturday " + " october " + " " + d2;
        }
                if(d1.getDay()==6 && d1.getMonth()==10){
            d3=" saturday " + " november " + " " + d2;
        }
                 if(d1.getDay()==6 && d1.getMonth()==11){
            d3=" saturday " + " december " + " " + d2;
        }
    }
}
