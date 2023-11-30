/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kohner Smith
 */
import bo.Concert;
import bo.Concert2;
import bo.User;
import utils.SQLUtil;

/**
 *
 * @author Kohner Smith
 */
public class ConcertHandler {
	private SQLUtil sqlUtil;

	public ConcertHandler() {
		sqlUtil = new SQLUtil();
	}

	public int addConcert(String name, String date, float price, int vId, int artistId) {
		String cmdTemplate = "insert into Concert (name, date, price, vId, artistId) values ('%s', '%s', %f, %d, %d)";
		String cmd = String.format(cmdTemplate, name, date, price, vId, artistId);
		return sqlUtil.executeUpdate(cmd);
	}

	public List<Concert> getConcerts() {
		List<Concert> concerts = new ArrayList<>();
		String cmdTemplate = "select name,date,price,vId,artistId from Concert";
		String cmd = String.format(cmdTemplate);
		ResultSet rs = sqlUtil.executeQuery(cmd);
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				String date = rs.getString("date");
				float price = rs.getFloat("price");
				int vId = rs.getInt("vId");
				int artistId = rs.getInt("artistId");
				Concert c = new Concert(name, date, price, vId, artistId);
				concerts.add(c);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ConcertHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
		return concerts;
	}

	public List<Concert2> getConcerts2(String keyword) {
		List<Concert2> concerts = new ArrayList<>();
		String cmdTemplate = "select Concert.name, Concert.date, Concert.price, Venue.vName, User.userName from Concert join Venue on Concert.vId = Venue.vId join Artist on Concert.artistId = Artist.artistId join User on Artist.artistId = User.userId where Concert.name like '%s'";
		String cmd = String.format(cmdTemplate, "%" + keyword + "%");
		ResultSet rs = sqlUtil.executeQuery(cmd);
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				String date = rs.getString("date");
				float price = rs.getFloat("price");
				String vName = rs.getString("vName");
				String userName = rs.getString("userName");
				Concert2 c = new Concert2(name, date, price, vName, userName);
				concerts.add(c);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ConcertHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
		return concerts;
	}
	
	public List<Concert2> getConcerts3(User u) {
		List<Concert2> concerts = new ArrayList<>();
		String cmdTemplate = "SELECT Concert.name, Concert.date, Ticket.ticketNo, Concert.vId FROM Concert NATURAL JOIN Ticket WHERE Ticket.userId = %d";
		String cmd = String.format(cmdTemplate, u.getUserId());
		ResultSet rs = sqlUtil.executeQuery(cmd);
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				String date = rs.getString("date");
				String id = "" + rs.getInt("vId");
				String vName = rs.getString("ticketNo");
				Concert2 c = new Concert2(name, date, id, vName);
				concerts.add(c);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ConcertHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
		return concerts;
	}
}
