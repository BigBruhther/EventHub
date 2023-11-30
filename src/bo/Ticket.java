/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Kohner Smith
 */
public class Ticket {
    private int userId;
    private String name;
    private int seatNo;
    private int sectionNo;
    private int vId;
    private float tPrice;

    public Ticket(int userId, String name, int seatNo, int sectionNo, int vId, float tPrice) {
        this.userId = userId;
        this.name = name;
        this.seatNo = seatNo;
        this.sectionNo = sectionNo;
        this.vId = vId;
        this.tPrice = tPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public float gettPrice() {
        return tPrice;
    }

    public void settPrice(float tPrice) {
        this.tPrice = tPrice;
    }

    
}
