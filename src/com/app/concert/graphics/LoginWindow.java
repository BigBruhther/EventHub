package com.app.concert.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


/**
 * An object representing a login window to collect a user's
 * login data
 * 
 * @author  Logan Alpha (ADD YOUR NAME HERE IF YOU WORK ON THIS)
 * @version 11.8.2023
 */
public class LoginWindow extends JFrame 
{


	private JTextField txtUsername;			// Text field to input username
	private JPasswordField txtPassword;		// Password field to input password
	
	private boolean isHidden;		// Keeps track of whether or not the password is hidden
	
	private boolean isInstantiated;
	private JTextField txtEmail;
	private JPasswordField passHidden;
	private JTextField passShown;
	private JPanel pnlPassword;
	
	
	public LoginWindow() 
	{
		
		System.out.println("Creating login window...");
		
		// Code relating to the window itself ================================
		this.setSize(800,550);
		this.setResizable(false);
		this.setTitle("Log in");
		//this.setIconImage(new ImageIcon("ENTER IMAGE FILE NAME HERE").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		// Creates a WindowListener to make isInstantiated false
		// when exiting the login window
		this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	isInstantiated = false;
            	System.out.println("Exiting login window...");
            }
        });
		// ===================================================================
		
		
		JPanel pnlTextPanel = new JPanel();
		pnlTextPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		pnlTextPanel.setBackground(new Color(192, 192, 192));
		pnlTextPanel.setBounds(73, 58, 640, 338);
		getContentPane().add(pnlTextPanel);
		pnlTextPanel.setLayout(null);
		
		JPanel pnlEmail = new JPanel();
		pnlEmail.setBounds(37, 66, 565, 70);
		pnlTextPanel.add(pnlEmail);
		pnlEmail.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(38, 22, 104, 25);
		pnlEmail.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(152, 23, 166, 23);
		pnlEmail.add(txtEmail);
		txtEmail.setColumns(20);
		
		pnlPassword = new JPanel();
		pnlPassword.setBounds(37, 202, 565, 70);
		pnlTextPanel.add(pnlPassword);
		pnlPassword.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(38, 22, 104, 25);
		pnlPassword.add(lblPassword);
		
		// Creates the hidden version of the password's text field and adds it to the panel
		passHidden = new JPasswordField();
		passHidden.setBounds(152, 23, 166, 23);
		pnlPassword.add(passHidden);
		isHidden = true;
		
		// Creates the unmasked version of the password's text field
		passShown = new JTextField();
		passShown.setBounds(passHidden.getBounds());
		
		JButton btnHidePass = new JButton("");
		btnHidePass.setFocusable(false);
		btnHidePass.setToolTipText("Hide/unhide password");
		btnHidePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFieldType();
			}
		});
		
		btnHidePass.setBounds(330, 24, 21, 21);
		// ADD EYEBALL IMAGE HERE
		pnlPassword.add(btnHidePass);
		
		
		JPanel pnlSubmitPanel = new JPanel();
		pnlSubmitPanel.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.inactiveCaptionBorder, null, null, null));
		pnlSubmitPanel.setBackground(SystemColor.control);
		pnlSubmitPanel.setBounds(10, 453, 766, 50);
		getContentPane().add(pnlSubmitPanel);
		pnlSubmitPanel.setLayout(null);
		
		JButton btnCancel = new JButton("CANCEL");
		LoginWindow thisWindow = this;		// Creates a pointer for this login window to be used in the following ActionListener
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisWindow.dispatchEvent(new WindowEvent(thisWindow, WindowEvent.WINDOW_CLOSING));	// Closes the login window
			}
		});
		btnCancel.setFocusable(false);
		btnCancel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnCancel.setBounds(513, 10, 103, 30);
		pnlSubmitPanel.add(btnCancel);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Implement this.
				 * Should have:
				 * 		x Password checking (should reject the submission if some requirements are not met)
				 * 		x Submit email and password to be checked.
				 * 			o If valid, exit login window and continue to the next page
				 * 			o Else, state that the email/password is invalid and let the user retry
				 */
			}
		});
		btnSubmit.setFocusable(false);
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnSubmit.setBounds(626, 10, 103, 30);
		pnlSubmitPanel.add(btnSubmit);
		
		
		
		
		isInstantiated = true;
		
		this.setVisible(true);
		
		System.out.println("Created: Login window");
		
	}

	/**
	 * Sets the field concerning the password to whatever is opposite
	 * of the current field type (i.e. password field converts to text field and vice versa)
	 */
	private void setFieldType() {
		
		if(isHidden == true) {
			// Replaces the password field with a standard text field by 
			// copying the value over and removing the password field
			passShown.setText(String.valueOf(passHidden.getPassword()));
			pnlPassword.remove(passHidden);
			pnlPassword.add(passShown);
			isHidden = false;
		}
		else {
			// Replaces the standard text field with a password field by
			// copying the text over and removing it with a text field
			passHidden.setText(passShown.getText());
			pnlPassword.remove(passShown);
			pnlPassword.add(passHidden);
			isHidden = true;
		}
		
	}

	
	public boolean getCurrentUse() {return isInstantiated;}

}
