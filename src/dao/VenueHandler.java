/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Venue;
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
public class VenueHandler {
    private SQLUtil sqlUtil;

    public VenueHandler() {
        sqlUtil = new SQLUtil();
    }
   
    public List<Venue> getVenues(){
        List<Venue> results = new ArrayList<> ();
        String cmd = "select vId, address, vName from Venue;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                int vId = rs.getInt("vId");
                String address = rs.getString("address");
                String vName = rs.getString("vName");
                Venue c = new Venue(vId, address, vName);
                results.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VenueHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    public int addVenue(int vId, String address,String vName){
        String cmdTemplate = "insert into Venue(vId, address, vName) values (%d ,'%s', '%s')";
        String cmd = String.format(cmdTemplate,vId, address, vName);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int getID(String vName) {
                int vId = 0;
		String cmdTemplate = "select vId from Venue where vName = '%s'";
		String cmd = String.format(cmdTemplate, vName);
		ResultSet rs = sqlUtil.executeQuery(cmd);
		try {
                    while(rs.next()){
			vId = rs.getInt("vId");}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(VenueHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return vId;
	}
    
	public boolean searchForVenue(int vId) {

		String cmdTemplate = "select vId from Venue where vId = %d";
		String cmd = String.format(cmdTemplate, vId);
		ResultSet rs = sqlUtil.executeQuery(cmd);

		try {
			return rs.next();
		} catch (SQLException e) {
			System.err.println("Warning: rs is null");
			return false;
		}

	}
}


