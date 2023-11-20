/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Kohner Smith
 */
public class Section {
    private String sectionNo;
    private float pRate;
    private String vId;

    public Section(String sectionNo, float pRate, String vId) {
        this.sectionNo = sectionNo;
        this.pRate = pRate;
        this.vId = vId;
    }

    public String getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    public float getpRate() {
        return pRate;
    }

    public void setpRate(float pRate) {
        this.pRate = pRate;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }
    
    
}
