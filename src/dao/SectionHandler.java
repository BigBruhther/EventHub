/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Section;
import bo.Section2;
import java.util.ArrayList;
import java.util.List;
import utils.SQLUtil;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author Kohner Smith
 */
public class SectionHandler {
    private SQLUtil sqlUtil;

    public SectionHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public int addSection(int sectionNo, int vId){
        String cmdTemplate = "insert into Section(sectionNo, vId) values (%d, %d)";
        String cmd = String.format(cmdTemplate, sectionNo, vId);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<Section2> getSection2(String vName){
        List<Section2> sections = new ArrayList<>();
        String cmdTemplate = "select sectionNo from Venue natural join Section where vName = '%s'";
        String cmd = String.format(cmdTemplate, vName);
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                int sectionNo = rs.getInt("sectionNo");
                Section2 c = new Section2(sectionNo);
                sections.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcertHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sections;
    }
}
