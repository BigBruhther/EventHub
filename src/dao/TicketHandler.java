/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Ticket;
import java.util.ArrayList;
import java.util.List;
import utils.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kohner Smith
 */
public class TicketHandler {
    private SQLUtil sqlUtil;
    
    public TicketHandler(){
        sqlUtil = new SQLUtil();
    }
    public int addTicket(int userId, String name, int sectionNo, int seatNo, int vId, float tPrice, String cardNo){
    	
    	String cmdTemplate = "insert into Ticket(userId, name, sectionNo, seatNo, vId, tPrice, cardNo) values (%d ,'%s', %d, %d, %d, %f, '%s')";
        String cmd = String.format(cmdTemplate,userId, name, sectionNo, seatNo, vId, tPrice, cardNo);
        return sqlUtil.executeUpdate(cmd);
    }
    
	public boolean exists(String cName, int sectionNo, int seatNo) {

		String cmdTemplate = "select * from Ticket where name = '%s' and sectionNo = %d and seatNo = %d";
		String cmd = String.format(cmdTemplate, cName, sectionNo, seatNo);
		ResultSet rs = sqlUtil.executeQuery(cmd);

		try {
			return rs.next();
		} catch (SQLException e) {
			System.err.println("Warning: rs is null");
			return false;
		}

	}
}
