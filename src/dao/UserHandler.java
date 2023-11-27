/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.User;
import java.sql.ResultSet;
import utils.PasswordEncryptor;
import utils.SQLUtil;

/**
 *
 * @author Joshua Cruz
 */
public class UserHandler {
    private SQLUtil sqlUtil;
    public UserHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public User login(String email, String password){
        User usr = null;
        //encrypt
        //password = PasswordEncryptor.encrypt(password); Commented out due to login not working for now...
        String stm = String.format("select userID, name from User where email='%s' and password='%s'", email, password);
        ResultSet rsUser = sqlUtil.executeQuery(stm);
        try {
            if (rsUser != null && rsUser.next()){
                int userID = rsUser.getInt("userID");
                String userName = rsUser.getString("name");
                usr = new User(userID, userName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usr;
    }
    
    public int addUser(String name, String email, String password){
        String cmdTemplate = "insert into User(name, email, password) values('%s', '%s', '%s')";
        String cmd = String.format(cmdTemplate, name, email, password);
        return sqlUtil.execeuteUpdate(cmd);
    }
};
