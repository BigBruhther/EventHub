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
public class User {
    private int userID;
    private String name;

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }
    
    public Vector<Object> getRow(){
        Vector<Object> ret = new Vector();
        ret.add(this.userID);
        ret.add(this.name);
        return ret;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
