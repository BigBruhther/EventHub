/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.Vector;

/**
 *
 * @author Kohner Smith
 */
public class Concert2 {
    private String name;
    private String date;
    private Float price;
    private String vName;
    private String userName;
    private String id;

    public Concert2(String name, String date, Float price, String vName, String userName) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.vName = vName;
        this.userName = userName;
    }
    
    public Concert2(String name, String date, String id, String vName) {
    	this.name = name;
    	this.date = date;
    	this.id = id;
    	this.vName = vName;
    }
    
    public Vector getRow(){
        Vector vec = new Vector();
        vec.add(this.name);
        vec.add(this.date);
        vec.add(this.price);
        vec.add(this.vName);
        vec.add(this.userName);
        return vec;
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public String getvName() {
            return vName;
        }

        public void setvName(String vName) {
            this.vName = vName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    
}
