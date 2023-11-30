/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Kohner Smith
 */
public class Section2 {
    private int sectionNo;
    
    public Section2(int sectionNo){
        this.sectionNo = sectionNo;
    }

    public int getSectionNo2() {
        return sectionNo;
    }

    public void setSectionNo2(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    @Override
    public String toString() {
        return Integer.toString(getSectionNo2());
    }
    
}
