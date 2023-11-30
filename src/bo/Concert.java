/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.security.Timestamp;
import java.util.Vector;

/**
 *
 * @author Kohner Smith
 */
public class Concert {
    private String name;
    private String date;
    private Float price;
    private int vId;
    private int artistId;

    public Concert(String name, String date, Float price, int vId, int artistId) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.vId = vId;
        this.artistId = artistId;
    }
    
    public Vector getRow(){
        Vector vec = new Vector();
        vec.add(this.name);
        vec.add(this.date);
        vec.add(this.price);
        vec.add(this.vId);
        vec.add(this.artistId);
        return vec;
    }
    
    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
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
    
    
}
