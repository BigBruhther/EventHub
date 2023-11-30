/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concertdb;

/**
 *
 * @author Kohner Smith & Logan Alpha
 */
import bo.User;
import concertdb.BaseWindow;
import concertdb.HostMainPage;
import concertdb.ArtistEditDescription;
import concertdb.UserMainPage2;
import utils.PasswordEncryptor;

public class ConcertDB 
{
    public User u;
    public static void main(String[] args) 
    {
        
        System.out.println("Running...");

        
        new LoginWindow();
        
        String pass = "artist1password";
        String pass2 = "artist2password";
        String pass3 = "artist3password";
        String pass4 = "artist4password";
        String pass5 = "artist5password";
        
        System.out.println(pass);
        
        pass = PasswordEncryptor.encrypt(pass);
        pass2 = PasswordEncryptor.encrypt(pass2);
        pass3 = PasswordEncryptor.encrypt(pass3);
        pass4 = PasswordEncryptor.encrypt(pass4);
        pass5 = PasswordEncryptor.encrypt(pass5);
        
        System.out.println(pass);
        System.out.println(pass2);
        System.out.println(pass3);
        System.out.println(pass4);
        System.out.println(pass5);
        
        //new UserMainPage(new BaseWindow(), new User(1, "MY NAME", "MYEMAIL", "MYPASSWORD"));
        //new ArtistEditDescription(new BaseWindow()).setVisible(true);
        //new HostMainPage(new BaseWindow()).setVisible(true);
        //new UserMainPage2(new BaseWindow(), new User(1, "artist1", "artist1@gmail.com", "artist1password")).setVisible(true);
        //new PaymentPage2(new BaseWindow()).setVisible(true);
        //new PaymentConfirmationPage(new BaseWindow()).setVisible(true);
        System.out.println("Main method complete.");

    }

}
