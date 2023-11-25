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
public class VenueHandler {
    private SQLUtil sqlUtil;
    public VenueHandler() {
        sqlUtil = new SQLUtil();
    } 
     public int addVenue(String vId, String address, int vName){
        String cmdTemplate = "insert into Venue(vId, address, vName) values('%s', '%s', '%s')";
        String cmd = String.format(cmdTemplate, vId, vName, vName);
        return sqlUtil.execeuteUpdate(cmd);
    }
}
