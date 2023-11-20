/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Kohner Smith
 */
public class Seat {
    private String seatNo;
    private String sectionNo;
    private String vId;

    public Seat(String seatNo, String sectionNo, String vId) {
        this.seatNo = seatNo;
        this.sectionNo = sectionNo;
        this.vId = vId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }
    
    
}
