/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concertdb;

/**
 *
 * @author Kohner Smith
 */
public class ConcertDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        	System.out.println("Running...");
		
		new LoginWindow();
		Password p = new Password();
		p.setPassword("Abcdefg-1234");
		System.out.println(p.toString());
		System.out.println(p.decrypt());
		
		System.out.println("Main method complete.");
    }
    
}
