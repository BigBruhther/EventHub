package com.app.concert.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.app.concert.user.Account;
import com.app.concert.user.Password;

import com.app.concert.graphics.HostMainPage;

import dao.UserHandler;
import bo.User;
import utils.GlobalData;
import javax.swing.JOptionPane;


/**
 * An object representing a login window to collect a user's
 * login data
 * 
 * @author  Logan Alpha (ADD YOUR NAME HERE IF YOU WORK ON THIS)
 * @version 11.8.2023
 */
public class LoginWindow extends BaseWindow 
{


	private JTextField txtUsername;			// Text field to input username
	private JPasswordField txtPassword;		// Password field to input password
	
	private boolean isHidden;		// Keeps track of whether or not the password is hidden
	
	private JTextField txtEmail;
	private JPasswordField passHidden;
	private JTextField passShown;
	private JPanel pnlPassword;
	private BaseWindow self;
	
	public LoginWindow() 
	{
		
		System.out.println("Creating login window...");
		
		// Code relating to the window itself ================================
		this.setSize(950,610);
		this.setResizable(false);
		this.setTitle("Log in");
		//this.setIconImage(new ImageIcon("ENTER IMAGE FILE NAME HERE").getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.lastWindow = null;
		this.nextWindow = new AccountCreationWindow();
		self = this;
		
		getContentPane().setLayout(null);
		
		
		
		
		JPanel pnlTextPanel = new JPanel();
		pnlTextPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		pnlTextPanel.setBackground(new Color(92, 64, 51));
		pnlTextPanel.setBounds(201, 37, 533, 466);
		getContentPane().add(pnlTextPanel);
		pnlTextPanel.setLayout(null);
		
		JPanel pnlEmail = new JPanel();
		pnlEmail.setBackground(new Color(92, 64, 51));
		pnlEmail.setBounds(56, 273, 420, 70);
		pnlTextPanel.add(pnlEmail);
		pnlEmail.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setForeground(new Color(255, 222, 89));
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 20));
		lblEmail.setBounds(38, 22, 104, 25);
		pnlEmail.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(152, 23, 166, 23);
		pnlEmail.add(txtEmail);
		txtEmail.setColumns(20);
		
		pnlPassword = new JPanel();
		pnlPassword.setBackground(new Color(92, 64, 51));
		pnlPassword.setBounds(56, 341, 420, 70);
		pnlTextPanel.add(pnlPassword);
		pnlPassword.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(new Color(255, 222, 89));
		lblPassword.setFont(new Font("Constantia", Font.PLAIN, 20));
		lblPassword.setBounds(38, 22, 104, 25);
		pnlPassword.add(lblPassword);
		
		// Creates the hidden version of the password's text field and adds it to the panel
		passHidden = new JPasswordField();
		passHidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clack");
			}
		});
		passHidden.setBounds(152, 23, 166, 23);
		pnlPassword.add(passHidden);
		isHidden = true;
		
		// Creates the unmasked version of the password's text field
		passShown = new JTextField();
		passShown.setBounds(passHidden.getBounds());
		
		JButton btnHidePass = new JButton("👁");
		btnHidePass.setMargin(new Insets(0, 0, 0, 0));
		btnHidePass.setFocusable(false);
		btnHidePass.setToolTipText("Hide/unhide password");
		btnHidePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFieldType();
			}
		});
		
		btnHidePass.setBounds(330, 24, 21, 21);
		pnlPassword.add(btnHidePass);
		
		JPanel pnlParagraph = new JPanel();
		pnlParagraph.setBackground(new Color(92, 64, 51));
		pnlParagraph.setBounds(56, 54, 420, 223);
		pnlTextPanel.add(pnlParagraph);
		pnlParagraph.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setForeground(new Color(255, 222, 89));
		lblNewLabel.setBounds(20, 0, 133, 41);
		lblNewLabel.setFont(new Font("Ink Free", Font.ITALIC, 33));
		pnlParagraph.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 222, 89));
		separator.setForeground(new Color(255, 222, 89));
		separator.setBounds(20, 61, 123, 2);
		pnlParagraph.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Discover your favorite artists and find local events near you!");
		lblNewLabel_1.setForeground(new Color(255, 222, 89));
		lblNewLabel_1.setFont(new Font("Constantia", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 73, 380, 26);
		pnlParagraph.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New to EventHub? ");
		lblNewLabel_2.setForeground(new Color(255, 222, 89));
		lblNewLabel_2.setFont(new Font("Constantia", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 109, 133, 26);
		pnlParagraph.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Sign Up");
		AccountCreationWindow ac = (AccountCreationWindow) nextWindow;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!ac.getCurrentUse()) {
					ac.invertUse();
					ac.setVisible(true);
				}
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Constantia", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 222, 89));
		btnNewButton.setBackground(new Color(92, 64, 51));
		btnNewButton.setBounds(163, 109, 96, 26);
		pnlParagraph.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("*By using EventHub you agree to our term of service.");
		lblNewLabel_3.setForeground(new Color(255, 222, 89));
		lblNewLabel_3.setFont(new Font("Constantia", Font.ITALIC, 9));
		lblNewLabel_3.setBounds(20, 171, 380, 42);
		pnlParagraph.add(lblNewLabel_3);
		
		
		JPanel pnlSubmitPanel = new JPanel();
		pnlSubmitPanel.setBounds(0, 406, 533, 50);
		pnlTextPanel.add(pnlSubmitPanel);
		pnlSubmitPanel.setBorder(null);
		pnlSubmitPanel.setBackground(new Color(92, 64, 51));
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
		btnCancel.setBounds(109, 10, 103, 30);
		pnlSubmitPanel.add(btnCancel);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnSubmitActionPerformed(e);
                    }
		});
		btnSubmit.setFocusable(false);
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnSubmit.setBounds(321, 10, 103, 30);
		pnlSubmitPanel.add(btnSubmit);
		
		
		JLabel lblImage = new JLabel();
		Image image = new ImageIcon(this.getClass().getResource("/com/app/concert/graphics/login_image.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setBounds(-885, -187, 1836, 776);
		getContentPane().add(lblImage);
		
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

        private void btnSubmitActionPerformed(ActionEvent e){
             String email = txtEmail.getText();
             String password = new String(passHidden.getPassword());
             GlobalData.usr = new UserHandler().login(email, password);
                               
            if(GlobalData.usr==null){
                // Failed
                JOptionPane.showMessageDialog(this, "Incorrect login info!");
            } else {
                this.dispose();
                new UserMainPage(self);
            }
        }
	
	private String[] submit(String email, String password) {
		
		
		String[] accInfo = new String[2];
		accInfo[0] = email;
		accInfo[1] = password;
		return accInfo;
	}
}
