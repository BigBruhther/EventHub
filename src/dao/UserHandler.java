/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
    
    public int addUser(String email, String password, int iD){
        String cmdTemplate = "insert into User(email, password, iD) values('%s', '%s', '%d')";
        String cmd = String.format(cmdTemplate, email, password, iD);
        return sqlUtil.execeuteUpdate(cmd);
    }
};
