/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Kohner Smith
 */
public class Venue {
    private int vId;
    private String address;
    private String vName;

    public Venue(int vId, String address, String vName) {
        this.vId = vId;
        this.address = address;
        this.vName = vName;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public int getvId() {
        return vId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    @Override
    public String toString() {
        return Integer.toString(getvId()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
