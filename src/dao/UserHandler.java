/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bo.Concert2;
import bo.User;
import utils.SQLUtil;

/**
 *
 * @author Kohner Smith, Logan Alpha
 */
public class UserHandler {
	private SQLUtil sqlUtil;

	public UserHandler() {
		this.sqlUtil = new SQLUtil();
	}

	public int addUser(String name, String email, String password) throws ClassNotFoundException {
		String cmdTemplate = "insert into User(userName, userEmail, userPassword) values('%s', '%s', '%s')";
		String cmd = String.format(cmdTemplate, name, email, password);
		return sqlUtil.executeUpdate(cmd);
	}

	/**
	 * Returns true if the user is in the database
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean searchForUser(String email, String password) {

		String cmdTemplate = "select userEmail, userPassword from User where userEmail = '%s' and userPassword = '%s'";
		String cmd = String.format(cmdTemplate, email, password);
		ResultSet rs = sqlUtil.executeQuery(cmd);

		try {
			return rs.next();
		} catch (SQLException e) {
			System.err.println("Warning: rs is null");
			return false;
		}

	}

	public int getID(String email) {
		String cmdTemplate = "select userId from User where userEmail = '%s'";
		String cmd = String.format(cmdTemplate, email);
		ResultSet rs = sqlUtil.executeQuery(cmd);

		try {
			return rs.getInt("userId");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	public boolean searchForUser(String email) {

		String cmdTemplate = "select userEmail, userPassword from User where userEmail = '%s'";
		String cmd = String.format(cmdTemplate, email);
		ResultSet rs = sqlUtil.executeQuery(cmd);

		try {
			return rs.next();
		} catch (SQLException e) {
			System.err.println("Warning: rs is null");
			return false;
		}

	}

	public int getID2(String email) {
		int userId = 0;
		String cmdTemplate = "select userId from User where userEmail = '%s'";
		String cmd = String.format(cmdTemplate, email);
		ResultSet rs = sqlUtil.executeQuery(cmd);
		try {
			while (rs.next()) {
				userId = rs.getInt("userId");
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(VenueHandler.class.getName()).log(Level.SEVERE, null, ex);
		}

		return userId;
	}
	
	public String getName(String email) {
		String name = "<NULL NAME>";
		String cmdTemplate = "select userName from User where userEmail = '%s'";
		String cmd = String.format(cmdTemplate, email);
		ResultSet rs = sqlUtil.executeQuery(cmd);
		try {
			while (rs.next()) {
				name = rs.getString("username");
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(VenueHandler.class.getName()).log(Level.SEVERE, null, ex);
		}

		return name;
	}

}
