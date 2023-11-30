/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.Artist;
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
public class ArtistHandler {
    private SQLUtil sqlUtil;
    
    public ArtistHandler() {
        sqlUtil = new SQLUtil();
    }
     public int addArtist(int artistId, String genre, String description){
        String cmdTemplate = "insert into Artist (artistId, genre, description) values (%d, '%s', '%s')";
        String cmd = String.format(cmdTemplate,artistId, genre, description);
        return sqlUtil.executeUpdate(cmd);
    }
     public List<Artist> getArtist(){
        List<Artist> artists = new ArrayList<> ();
        String cmdTemplate = "select * from Artist;";
        String cmd = String.format(cmdTemplate);
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                int artistId = rs.getInt("artistId");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Artist b = new Artist(artistId, genre, description);
                artists.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArtistHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artists;
    }
     public String loadArtistDescription(String keyword){
         String artistDescription = null;
         String cmdTemplate = "select description from Artist where artistId = (select userId from User where userEmail = '%s')";
         String cmd = String.format(cmdTemplate, keyword);
         ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                artistDescription = rs.getString("description");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArtistHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistDescription;
     }
     
     public int updateArtistDescription(String description, String userEmail){
         String cmdTemplate = "update Artist set description = '%s' where artistID = (select userId from User where userEmail = '%s')";
         String cmd = String.format(cmdTemplate,description, userEmail);
         return sqlUtil.executeUpdate(cmd);
     }

}

