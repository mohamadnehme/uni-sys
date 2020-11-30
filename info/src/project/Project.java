/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static project.DBconnect.connect;

/**
 *
 * 
 * @author Echo data
 */

public class Project extends Application {
    
    public static String id;
    public static String name;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        
        connect();
        /*MakeConnection m = MakeConnection.getconnection();
        MakeConnection m1 = MakeConnection.getconnection();
        if(m == m1){
            System.out.println("c1 and c2 are same instance");
        }*/
        launch(args);
        
    }
}
