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
    public int addVenue(int artistID, String name, String genre){
        String cmdTemplate = "insert into Artist(artistID, name, genre) values('%d', '%s', '%s')";
        String cmd = String.format(cmdTemplate, artistID, name, genre);
        return sqlUtil.execeuteUpdate(cmd);
    }
    
}
