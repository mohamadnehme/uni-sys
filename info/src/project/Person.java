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
    public class Person {
        public  SimpleStringProperty firstName;
        public SimpleStringProperty lastName;
        public  SimpleStringProperty email;
        public SimpleStringProperty pass;
        public  SimpleStringProperty id;
        public SimpleStringProperty date;
        public  SimpleStringProperty gendre;
        public SimpleStringProperty phone;
        public Person(String id, String fName,String lName, String date,String gendre, String phone,String email, String pass) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.id = new SimpleStringProperty(id);
            this.email = new SimpleStringProperty(email);
            this.date = new SimpleStringProperty(date);
            this.pass = new SimpleStringProperty(pass);
            this.phone = new SimpleStringProperty(phone);
            this.gendre = new SimpleStringProperty(gendre);
        }
        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String s) {
            firstName.set(s);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String s) {
            lastName.set(s);
        }
        public String getId() {
            return id.get();
        }

        public void setId(String s) {
            id.set(s);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String s) {
            email.set(s);
        }public String getPass() {
            return pass.get();
        }

        public void setPass(String s) {
            pass.set(s);
        }

        public String getPhone() {
            return phone.get();
        }

        public void setPhone(String s) {
            phone.set(s);
        }public String getDate() {
            return date.get();
        }

        public void setDate(String s) {
            date.set(s);
        }

        public String getGendre() {
            return gendre.get();
        }

        public void setGendre(String s) {
            gendre.set(s);
        }
}
