package utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Java Class connects the Java code to the SQL backend
 *
 * @author  Joshua Cruz
 * @version 11.11.2023
 */
public class SQLUtil {
    private Connection con;
    private Statement stm;

    public SQLUtil() {
        String url = "jdbc:mysql//localhost:8889/ConcertDB"; // Change port as needed for your SQL setup
        String username = "root";
        String password = "root";

        try{
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection() {
        return con;
    }
    public Statement getStatement() {
        return stm;
    }
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
    @Override
    protected void finalize() throws Throwable {
        closeConnection();
        super.finalize();
    }
    public int executeUpdate(String cmd) {
        try {
            return this.stm.executeUpdate(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public ResultSet executeQuery(String cmd) {
        try {
            return this.stm.executeQuery(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}