package com.app.concert.graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 */
public class LoginWindow extends JFrame 
{

	private JTextField txtUsername;			// Text field to input username
	private JPasswordField txtPassword;		// Password field to input password

	private JButton btnSubmit;		// Button to submit information
	
	private boolean isInstantiated;

	public LoginWindow() 
	{
		
		System.out.println("Creating login window...");
		
		this.setSize(800,550);
		this.setResizable(false);
		this.setTitle("Login");
		//this.setIconImage(new ImageIcon("ENTER IMAGE FILE NAME HERE").getImage());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	isInstantiated = false;
            	System.out.println("Exiting login window...");
            }
        });
		isInstantiated = true;
		
		this.setVisible(true);
		
		System.out.println("Created: Login window");
		
	}

	
	public boolean getCurrentUse() {return isInstantiated;};
	
}
