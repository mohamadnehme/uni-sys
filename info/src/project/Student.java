/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Echo data
 */
public class Student {
    
    private SimpleStringProperty fname , lname , id;

    public Student(String id , String fname , String lname){
        this.fname=new SimpleStringProperty(fname);
        this.lname=new SimpleStringProperty(lname);
        this.id=new SimpleStringProperty(id);
    }
    public String getid(){
        return this.id.get();
    }
    public void setid(String Id){
        this.id.set(Id);
    }
        public String getfname(){
        return this.fname.get();
    }
    public void setfname(String fname){
        this.fname.set(fname);
    }
        public String getlname(){
        return this.lname.get();
    }
    public void setlname(String lname){
        this.lname.set(lname);
    }
}
