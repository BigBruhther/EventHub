package com.app.concert.graphics;

import utils.GlobalData;
import dao.UserHandler;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;


/**
 * Representation for the Account Creation Page
 * 
 * @author Logan Alpha
 * @version 11.20.23
 *
 */
public class AccountCreationWindow extends BaseWindow {
	
	private JTextField txtEmail;
	
	private JPasswordField passHidden;
	private JPasswordField passHidden2;
	private JTextField passShown;
	private JTextField passShown2;
	private boolean isHidden = true;
	
	
	private JPanel panel;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField textField;

	public AccountCreationWindow() {

		System.out.println("Creating account creation window...");

		this.setTitle("Account creation");
		this.setBounds(0,0,922, 743);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 936, 713);
		getContentPane().add(scrollPane);
		
		JPanel pnlScrollablePanel = new JPanel();
		scrollPane.setViewportView(pnlScrollablePanel);
		pnlScrollablePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		pnlScrollablePanel.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/com/app/concert/graphics/backstage.jpg")).getImage();
		lblNewLabel.setBounds(0, 0, 907, 711);
		lblNewLabel.setIcon(new ImageIcon(image));
		layeredPane.add(lblNewLabel);
		
		panel = new JPanel();
		layeredPane.setLayer(panel, 1);
		panel.setBounds(87, 50, 743, 610);
		panel.setBackground(new Color(0, 0, 0, 200));
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(panel, popupMenu);
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up!");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setForeground(new Color(255, 222, 89));
		lblNewLabel_1.setBounds(104, 52, 166, 65);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 222, 89));
		separator.setBackground(new Color(255, 222, 89));
		separator.setBounds(68, 127, 606, 20);
		panel.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Already have an EventHub account?");
		lblNewLabel_2.setForeground(new Color(255, 222, 89));
		lblNewLabel_2.setBounds(326, 80, 221, 20);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Sign In");
		BaseWindow thisWindow = this;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				thisWindow.dispatchEvent(new WindowEvent(thisWindow, WindowEvent.WINDOW_CLOSING));	// Closes the window
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 222, 89));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(548, 80, 94, 21);
		panel.add(btnNewButton);
                
                JButton btnCreateButton = new JButton("Create Account");
		btnCreateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                            btnAddActionPerformed(e);
			}
		});
		btnCreateButton.setBackground(new Color(0, 0, 0));
		btnCreateButton.setForeground(new Color(255, 222, 89));
		btnCreateButton.setFocusable(false);
		btnCreateButton.setBounds(548, 458, 94, 21);
		panel.add(btnCreateButton);
		
		txtEmail = new JTextField();
		txtEmail.setCaretColor(new Color(255, 222, 89));
		txtEmail.setMargin(new Insets(2, 5, 2, 2));
		txtEmail.setForeground(new Color(255, 222, 89));
		txtEmail.setBackground(panel.getBackground());
		txtEmail.setBorder(new LineBorder(new Color(255, 222, 89), 2));
		txtEmail.setFont(new Font("Constantia", Font.PLAIN, 14));
		txtEmail.setBounds(68, 178, 345, 32);
		panel.add(txtEmail);
		txtEmail.setColumns(25);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 222, 89));
		lblNewLabel_3.setBounds(68, 157, 87, 20);
		panel.add(lblNewLabel_3);
		
		passHidden = new JPasswordField();
		passHidden.setCaretColor(new Color(255, 222, 89));
		passHidden.setMargin(new Insets(2, 5, 2, 2));
		passHidden.setForeground(new Color(255, 222, 89));
		passHidden.setFont(new Font("Constantia", Font.PLAIN, 14));
		passHidden.setColumns(25);
		passHidden.setBorder(new LineBorder(new Color(255, 222, 89), 2));
		passHidden.setBackground(new Color(0, 0, 0));
		passHidden.setBounds(68, 257, 345, 32);
		panel.add(passHidden);
		
		passShown = new JTextField();
		passShown.setForeground(passHidden.getForeground());
		passShown.setFont(passShown.getFont());
		passShown.setColumns(passHidden.getColumns());
		passShown.setBorder(passHidden.getBorder());
		passShown.setBackground(passHidden.getBackground());
		passShown.setBounds(passHidden.getBounds());
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 222, 89));
		lblPassword.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblPassword.setBounds(68, 236, 87, 20);
		panel.add(lblPassword);
		
		passHidden2 = new JPasswordField();
		passHidden2.setCaretColor(new Color(255, 222, 89));
		passHidden2.setMargin(new Insets(2, 5, 2, 2));
		passHidden2.setForeground(new Color(255, 222, 89));
		passHidden2.setFont(new Font("Constantia", Font.PLAIN, 14));
		passHidden2.setColumns(25);
		passHidden2.setBorder(new LineBorder(new Color(255, 222, 89), 2));
		passHidden2.setBackground(new Color(0, 0, 0));
		passHidden2.setBounds(68, 331, 345, 32);
		panel.add(passHidden2);
		
		passShown2 = new JTextField();
		passShown2.setForeground(passHidden2.getForeground());
		passShown2.setFont(passShown2.getFont());
		passShown2.setColumns(passHidden2.getColumns());
		passShown2.setBorder(passHidden2.getBorder());
		passShown2.setBackground(passHidden2.getBackground());
		passShown2.setBounds(passHidden2.getBounds());
		
		
		
		JLabel lblReEnterPassword = new JLabel("Re-Enter Password");
		lblReEnterPassword.setForeground(new Color(255, 222, 89));
		lblReEnterPassword.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblReEnterPassword.setBounds(68, 310, 140, 20);
		panel.add(lblReEnterPassword);
		
		JButton btnNewButton_1 = new JButton("👁");
		btnNewButton_1.setToolTipText("Hide/Show password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFieldType();
			}
		});
		btnNewButton_1.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_1.setIconTextGap(0);
		btnNewButton_1.setForeground(new Color(255, 222, 89));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(419, 293, 36, 34);
		btnNewButton_1.setBackground(panel.getBackground());
		panel.add(btnNewButton_1);
		
		txtFirst = new JTextField();
		txtFirst.setCaretColor(new Color(255, 222, 89));
		txtFirst.setMargin(new Insets(2, 5, 2, 2));
		txtFirst.setForeground(new Color(255, 222, 89));
		txtFirst.setFont(new Font("Constantia", Font.PLAIN, 14));
		txtFirst.setColumns(15);
		txtFirst.setBorder(new LineBorder(new Color(255, 222, 89), 2));
		txtFirst.setBackground(new Color(0, 0, 0, 200));
		txtFirst.setBounds(470, 178, 204, 32);
		panel.add(txtFirst);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(255, 222, 89));
		lblFirstName.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblFirstName.setBounds(470, 157, 204, 20);
		panel.add(lblFirstName);
		
		txtLast = new JTextField();
		txtLast.setCaretColor(new Color(255, 222, 89));
		txtLast.setMargin(new Insets(2, 5, 2, 2));
		txtLast.setForeground(new Color(255, 222, 89));
		txtLast.setFont(new Font("Constantia", Font.PLAIN, 14));
		txtLast.setColumns(15);
		txtLast.setBorder(new LineBorder(new Color(255, 222, 89), 2));
		txtLast.setBackground(new Color(0, 0, 0, 200));
		txtLast.setBounds(470, 257, 204, 32);
		panel.add(txtLast);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(255, 222, 89));
		lblLastName.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblLastName.setBounds(470, 236, 204, 20);
		panel.add(lblLastName);
		
		JComboBox cbCountry = new JComboBox();
		cbCountry.setBorder(new LineBorder(new Color(255, 222, 89), 3));
		cbCountry.setLightWeightPopupEnabled(false);
		cbCountry.setFocusable(false);
		cbCountry.setForeground(new Color(255, 222, 89));
		cbCountry.setBackground(new Color(0, 0, 0));
		cbCountry.setModel(new DefaultComboBoxModel(new String[] {"Australia", "Brazil", "Canada", "China", "Denmark", "France", "Germany", "India", "Ireland", "Italy", "Japan", "Mexico", "Netherlands", "Russia", "Scotland", "Spain", "Turkey", "Ukraine", "United Kingdom", "United States"}));
		cbCountry.setSelectedIndex(19);
		cbCountry.setBounds(244, 393, 153, 28);
		panel.add(cbCountry);
		
		JLabel lblCountryOfOrigin = new JLabel("Country of Residence");
		lblCountryOfOrigin.setForeground(new Color(255, 222, 89));
		lblCountryOfOrigin.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblCountryOfOrigin.setBounds(68, 399, 175, 20);
		panel.add(lblCountryOfOrigin);
		
		JLabel lblZip = new JLabel("Zip Code");
		lblZip.setForeground(new Color(255, 222, 89));
		lblZip.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblZip.setBounds(68, 461, 94, 20);
		panel.add(lblZip);

		textField = new JTextField();
		textField.setCaretColor(new Color(255, 222, 89));
		textField.setMargin(new Insets(2, 5, 2, 2));
		textField.setForeground(new Color(255, 222, 89));
		textField.setFont(new Font("Constantia", Font.PLAIN, 14));
		textField.setColumns(15);
		textField.setBorder(new LineBorder(new Color(255, 222, 89), 2));
		textField.setBackground(new Color(0, 0, 0));
		textField.setBounds(172, 449, 241, 32);
		panel.add(textField);
		
		

		System.out.println("Created: Account creation window");

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
			passShown2.setText(String.valueOf(passHidden2.getPassword()));
			panel.remove(passHidden);
			panel.remove(passHidden2);
			panel.add(passShown);
			panel.add(passShown2);
			isHidden = false;
		}
		else {
			// Replaces the standard text field with a password field by
			// copying the text over and removing it with a text field
			passHidden.setText(passShown.getText());
			passHidden2.setText(passShown2.getText());
			panel.remove(passShown);
			panel.remove(passShown2);
			panel.add(passHidden);
			panel.add(passHidden2);
			isHidden = true;
		}
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
        
        private void btnAddActionPerformed(ActionEvent e){
            String name = txtFirst.getText();
            String email = txtEmail.getText();
            String password = passHidden.getText();
            int ret = new UserHandler().addUser(name, email, password);
            
            // Account creation if statement.
            // We can add additional features such as checking if fields are empty and if passwords match later on.
           
            if(ret == -1){
                JOptionPane.showMessageDialog(this, "Failed to Add User");
            } else {
                JOptionPane.showMessageDialog(this, "Succeeded!", "Succeeded", JOptionPane.INFORMATION_MESSAGE);
            } 
            
            txtEmail.setText(null);
            txtFirst.setText(null);
            passHidden.setText(null);
            passHidden2.setText(null);
        }
        
         public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountCreationWindow().setVisible(true);
            }
        });
    }
}
