/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Seat2;
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
public class SeatHandler {
    private SQLUtil sqlUtil;

    public SeatHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public int addSeat(int seatNo,int sectionNo, int vId){
        String cmdTemplate = "insert into Seat (seatNo, sectionNo, vId) values (%d, %d, %d)";
        String cmd = String.format(cmdTemplate, seatNo, sectionNo, vId);
        return sqlUtil.executeUpdate(cmd);
    }
    public List<Seat2> getSeat(int sectionNo, String vName){
        List<Seat2> seats = new ArrayList<>();
        String cmdTemplate = "select s.seatNo from Seat s Join Section sec on s.sectionNo = sec.sectionNo and s.vId = sec.vId join Venue v on s.vId = v.vId where sec.sectionNo = %d and v.vName = '%s'";
        String cmd = String.format(cmdTemplate, sectionNo, vName);
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                int seatNo = rs.getInt("seatNo");
                Seat2 c = new Seat2(seatNo);
                seats.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcertHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seats;
    }
}
