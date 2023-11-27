/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Kohner Smith
 */
public class Artist {
    private int artistID;
    private String name;
    private String genre;

    public Artist(int artistID, String name, String genre) {
        this.artistID = artistID;
        this.name = name;
        this.genre = genre;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }
    
    public String setArtistName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
