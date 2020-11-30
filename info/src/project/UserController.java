/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import static project.DBconnect.connect;

/**
 * FXML Controller class
 *
 * @author Echo data
 */
public class UserController implements Initializable {
    Connection con;
    ResultSet r;
    ImageIcon i1;
    private Timer timer;
    private ActionListener timerAction;
    String d2;
    String d3;
    @FXML
    private ImageView image;

    @FXML
    private MenuItem time;

    @FXML
    private MenuItem date;

    @FXML
    private Label name;

    @FXML
    private Button close;

    @FXML
    private ImageView cls;

    @FXML
    private Button card;

    @FXML
    private Button course;

    @FXML
    private Button mark;

    @FXML
    void Close(ActionEvent event) throws IOException {
        Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.centerOnScreen();
        s.show();
    }

    @FXML
    void MakeCard(ActionEvent event) throws FileNotFoundException, JRException, IOException, SQLException {
        String jr = "src\\project\\newReport.jasper";
        JasperPrint jp = null;
        FileInputStream jreport;
        HashMap param = new HashMap();
        String query1 = "select * from student where id_s = ?";
        PreparedStatement pm1 = con.prepareStatement(query1);
        pm1.setString(1, Project.id);
        r = pm1.executeQuery();
        r.next();
        param.put("id", r.getString("id_s"));
        param.put("fname",r.getString("first_name"));
        param.put("lname",r.getString("last_name"));
        param.put("dob",r.getString("dob"));
        param.put("email",r.getString("email"));
        String path;
        path = r.getString("image");
        if(path == null || "".equals(path)){
            path = "src\\project\\images\\noimage_1.jpg";
            param.put("image", path);
        }
        else{
            param.put("image", path);
        }
        jreport = new FileInputStream(jr);
        jp = JasperFillManager.fillReport(jreport, param,new JREmptyDataSource());
            if(jp!=null){
                JasperViewer jv = new JasperViewer(jp,false);
                jv.setVisible(true);
            }
    }

    @FXML
    void ShowCourse(ActionEvent event) throws IOException, SQLException {
        String query1 = "select id_s from joined where id_s = ?";
        PreparedStatement pm1 = con.prepareStatement(query1);
        pm1.setString(1, Project.id);
        r = pm1.executeQuery();
        if(r.next()){
            Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("UserCourse.fxml"));
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.centerOnScreen();
            s.show();
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Register in Course","Attention",1,i1);
        }
    }

    @FXML
    void ShowDate(ActionEvent event) {
        JOptionPane.showMessageDialog(null, d3);
    }

    @FXML
    void ShowMark(ActionEvent event) throws IOException, SQLException {
        String query1 = "select id_s , note from joined where id_s = ?";
        PreparedStatement pm1 = con.prepareStatement(query1);
        pm1.setString(1, Project.id);
        r = pm1.executeQuery();
        if(r.next()){
            String note = r.getString("note");
            if(note != null){
                Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("ShowMark.fxml"));
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.centerOnScreen();
                s.show();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Enter the Grades","Attention",1,i1);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Register in Course","Attention",1,i1);
        }
        
    }

    @FXML
    void ShowTime(ActionEvent event) {
        ImageIcon l = new ImageIcon("src\\project\\images\\Alarm_Clock_GIF_Animation.gif");
        JOptionPane.showMessageDialog(null, d2," ",JOptionPane.INFORMATION_MESSAGE ,l);
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        i1 = new ImageIcon("src\\project\\images\\imageedit_2_6347544384.gif");
        try {
            con = connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        name.setText("Hello "+Project.name);
        
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
