/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static project.DBconnect.connect;

/**
 * FXML Controller class
 *
 * @author Echo data
 */
public class CreateController implements Initializable {
    Connection con = null;
    ResultSet r;
    ImageIcon i1;
    ImageIcon done;
    ImageIcon error;
    String d2;
    String d3;
    private Timer timer;
    private ActionListener timerAction;
    ImageIcon l2;

    @FXML
    private MenuBar id1;

    @FXML
    private MenuItem attachimage;

    @FXML
    private MenuItem date1;

    @FXML
    private MenuItem time1;

    @FXML
    private AnchorPane barsearch;

    @FXML
    private TextField search_t;

    @FXML
    private Button se;

    @FXML
    private ImageView se1;

    @FXML
    private TextField tid;

    @FXML
    private TextField tfn;

    @FXML
    private TextField tln;

    @FXML
    private TextField tdob;

    @FXML
    private RadioButton rm;

    @FXML
    private RadioButton rf;

    @FXML
    private TextField tp;

    @FXML
    private TextField temail;

    @FXML
    private TextField tpass;

    @FXML
    private ImageView image;

    String filename;
    
    @FXML
    private Button upd;
    
    @FXML
    private Button adds;
        
    @FXML
    void AddStd(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(tfn.getText().isEmpty() || tln.getText().isEmpty() || tdob.getText().isEmpty() || (!rm.isSelected() && !rf.isSelected()) || tp.getText().isEmpty() || temail.getText().isEmpty() || tpass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The Informations","Attention",1,i1);
        }else{
            
            int p = JOptionPane.showConfirmDialog(null,"Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION,0,l2);
            
            if(p == 0){
                try{    
                    String query = "insert into student (id_s,first_name,last_name,dob,gendre,phone,email,pass,image) values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pm = con.prepareStatement(query);
                    pm.setString(1, null);
                    pm.setString(2, tfn.getText());
                    pm.setString(3, tln.getText());
                    pm.setString(4, tdob.getText());
                    if(rm.isSelected()){
                        pm.setString(5, "m");
                    }
                    else{
                        pm.setString(5, "f");
                    }
                    pm.setInt(6,Integer.parseInt(tp.getText()));
                    pm.setString(7, temail.getText());
                    pm.setString(8, tpass.getText());
                    pm.setString(9, filename);
                    pm.execute();
                    String query1 = "select id_s from student where email = ?";
                    PreparedStatement pm1 = con.prepareStatement(query1);
                    pm1.setString(1, temail.getText());
                    r = pm1.executeQuery();
                    if(r.next())
                        tid.setText(r.getString("id_s"));
                    JOptionPane.showMessageDialog(null,"Record Added","Done",1,done);
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",1,error);
                }
            }
        }
    }
    
    @FXML
    void AttachImage(ActionEvent event) {
        try{
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        //Image i1 = new Image(f.toURI().toString());
        //Image im = new Image(getClass().getResource(filename).toExternalForm());
        //image.setImage(i1);
        try {
                BufferedImage bufferedImage = ImageIO.read(f);
                Image im = SwingFXUtils.toFXImage(bufferedImage, null);
                image.setImage(im);
            } catch (IOException ex) {
                
            }
        }catch(Exception e){
            
        }
    }

    @FXML
    void UpdStd(ActionEvent event) throws SQLException {

        if(tid.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Choose Student","Attention",1,i1);
        }
        else{
            int p = JOptionPane.showConfirmDialog(null,"Are you sure you want to update record?","Update Record",JOptionPane.YES_NO_OPTION,0,l2);
            if(p == 0){
                try{
                
                String query = "update student set first_name = ? , last_name = ? , dob = ? , gendre = ? , phone = ? , email = ? , pass = ? , image = ? where id_s = ? ";
                PreparedStatement pm = con.prepareStatement(query);
                pm.setString(1, tfn.getText());
                pm.setString(2, tln.getText());
                pm.setString(3, tdob.getText());
                if(rm.isSelected()){
                            pm.setString(4, "m");
                        }
                        else{
                            pm.setString(4, "f");
                        }
                pm.setString(5, tp.getText());
                pm.setString(6, temail.getText());
                pm.setString(7, tpass.getText());
                pm.setString(8, filename);
                pm.setString(9, tid.getText());
                pm.executeUpdate();
                JOptionPane.showMessageDialog(null,"Record Updated","Done",1,done);
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Error",1,error);
                }
            }
        }
    }
    
    @FXML
    private Button clr;
    
    @FXML
    void Clear(ActionEvent event) {
        search_t.setText("");
        tid.setText("");
        tfn.setText("");
        tln.setText("");
        tdob.setText("");
        rm.setSelected(false);
        rf.setSelected(false);
        tp.setText("");
        temail.setText("");
        tpass.setText("");
        image.setImage(null);
    }
    
    @FXML
    private Button dl;
    
    @FXML
    void DeleteStd(ActionEvent event) throws SQLException {
        if(tid.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Choose Student","Attention",1,i1);
        }
        else{
            int p = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete record?","Delete Record",JOptionPane.YES_NO_OPTION,0,l2);
            if(p == 0){
                String query = "delete from student where id_s = ?";
                PreparedStatement pm = con.prepareStatement(query);
                pm.setString(1, tid.getText());
                pm.execute();
                JOptionPane.showMessageDialog(null,"Record Deleted","Done",1,done);
                search_t.setText("");
                tid.setText("");
                tfn.setText("");
                tln.setText("");
                tdob.setText("");
                rm.setSelected(false);
                rf.setSelected(false);
                tp.setText("");
                temail.setText("");
                tpass.setText("");
                image.setImage(null);
            }
        }
    }
    
    @FXML
    private Button crs;
    
    @FXML
    private Button grd;
    
    @FXML
    void Grade(ActionEvent event) throws IOException, SQLException {
        if(tid.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Choose Student","Attention",1,i1);
        }
        else{
            String query1 = "select id_s from joined where id_s = ?";
            PreparedStatement pm1 = con.prepareStatement(query1);
            pm1.setString(1, tid.getText());
            r = pm1.executeQuery();
            if(r.next()){
                Project.id = tid.getText();
                Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Grade.fxml"));
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.centerOnScreen();
                s.show();
            }else{
                JOptionPane.showMessageDialog(null,"You should register the course","Attention",1,i1);
            }      
        }
    }
    @FXML
    void Course(ActionEvent event) throws IOException, SQLException {
        if(tid.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Choose Student","Attention",1,i1);
        }
        else{
                String query1 = "select id_s from joined where id_s = ?";
                    PreparedStatement pm1 = con.prepareStatement(query1);
                    pm1.setString(1, tid.getText());
                    r = pm1.executeQuery();
                    if(r.next()){
                        JOptionPane.showMessageDialog(null,"You have already register the courses","Attention",1,i1);
                    }else{
                        Project.id = tid.getText();
                        Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("Courses.fxml"));
                        Scene scene = new Scene(root);
                        s.setScene(scene);
                        s.centerOnScreen();
                        s.show();
                    }
        }
                
    }
    
    @FXML
    void Close(ActionEvent event) throws IOException {
                Stage s = (Stage)((Node)(event).getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.centerOnScreen();
                s.show();
    }
    
    @FXML
    private Button clo;

    @FXML
    private ImageView clos;
    
    @FXML
    void Search(ActionEvent event) throws SQLException, IOException {
        String g;
        String path;
        if(search_t.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Choose Student","Attention",1,i1);
        }
        else{
            String query1 = "select * from student where id_s = ?";
            PreparedStatement pm1 = con.prepareStatement(query1);
            pm1.setString(1, search_t.getText());
            r = pm1.executeQuery();
            if(r.next()){
                tid.setText(r.getString("id_s"));
                tfn.setText(r.getString("first_name"));
                tln.setText(r.getString("last_name"));
                tdob.setText(r.getDate("dob").toString());
                g = r.getString("gendre");
                if("m".equals(g)){
                    rm.setSelected(true);
                    rf.setSelected(false);
                }
                else{
                    rf.setSelected(true);
                    rm.setSelected(false);
                }
                tp.setText(r.getString("phone"));
                temail.setText(r.getString("email"));
                tpass.setText(r.getString("pass"));
                path = r.getString("image");
                try{
                if(path == null || path.equals("")){ 
                    File f = new File("src\\project\\images\\no-image-2zyki2umlg3f0ar25np1qi.png");
                    BufferedImage bufferedImage = ImageIO.read(f);
                    Image im = SwingFXUtils.toFXImage(bufferedImage, null);
                    image.setImage(im);
                }
                else{
                    File f = new File(path);
                    BufferedImage bufferedImage = ImageIO.read(f);
                    Image im = SwingFXUtils.toFXImage(bufferedImage, null);
                    image.setImage(im);
                }
                }catch(Exception e){
                    File f = new File("src\\project\\images\\no-image-2zyki2umlg3f0ar25np1qi.png");
                    BufferedImage bufferedImage = ImageIO.read(f);
                    Image im = SwingFXUtils.toFXImage(bufferedImage, null);
                    image.setImage(im);
                }
            }
            else
                JOptionPane.showMessageDialog(null,"Student Not Found","Attention",1,i1);
        }
    }

    @FXML
    void ShowDate1(ActionEvent event) {
        ImageIcon l = new ImageIcon("src\\project\\images\\Alarm_Clock_GIF_Animation.gif");
        JOptionPane.showMessageDialog(null, d2," ",JOptionPane.INFORMATION_MESSAGE ,l);
    }

    @FXML
    void ShowTime1(ActionEvent event) {
        JOptionPane.showMessageDialog(null, d3);
    }
    
    @FXML
    void fm(ActionEvent event) {
        rf.setSelected(false);
    }

    @FXML
    void fn(ActionEvent event) {
        rm.setSelected(false);
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
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        l2 = new ImageIcon("src\\project\\images\\rr.gif");
        i1 = new ImageIcon("src\\project\\images\\imageedit_2_6347544384.gif");
        done = new ImageIcon("src\\project\\images\\imageedit_2_8520218969.png");
        error = new ImageIcon("src\\project\\images\\imageedit_1_2272947787.png");

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
