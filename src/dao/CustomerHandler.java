package dao;

import utils.SQLUtil;

public class CustomerHandler
{

	private SQLUtil sqlUtil;

	public CustomerHandler() {
		this.sqlUtil = new SQLUtil();
	}
	
	public int addUser(String name, String email, String password, String country, int zip) {
		
		try {
			UserHandler uh = new UserHandler();
			uh.addUser(name, email, password);
			int id = uh.getID2(email);
			
			String cmdTemplate = "insert into Customer(customerId, country, zip) values(%d, '%s', %d)";
			String cmd = String.format(cmdTemplate, id, country, zip);
			return sqlUtil.executeUpdate(cmd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
}
