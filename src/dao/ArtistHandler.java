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
public class ArtistHandler {
    private SQLUtil sqlUtil;
    public ArtistHandler() {
        sqlUtil = new SQLUtil();
    }
    public int addVenue(int iD, String genre){
        String cmdTemplate = "insert into Artist(iD, genre) values('%d', '%s')";
        String cmd = String.format(cmdTemplate, iD, genre);
        return sqlUtil.execeuteUpdate(cmd);
    }
    
}
