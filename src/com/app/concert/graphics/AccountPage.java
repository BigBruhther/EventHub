/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concertdb;

import java.awt.Color;

import bo.User;
import javax.swing.JLabel;

public class AccountPage extends BaseWindow
{

	public AccountPage(User u)
	{
		getContentPane().setBackground(new Color(255, 222, 89));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User ID: ");
		lblNewLabel.setBounds(31, 10, 79, 51);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUserEmail = new JLabel("Name: ");
		lblUserEmail.setBounds(31, 71, 79, 51);
		getContentPane().add(lblUserEmail);
		
		JLabel lblName = new JLabel("User Email: ");
		lblName.setBounds(31, 132, 79, 51);
		getContentPane().add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("<ID>");
		lblNewLabel_1.setBounds(120, 29, 105, 13);
		lblNewLabel_1.setText("" + u.getUserId());
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("<NAME>");
		lblNewLabel_1_1.setBounds(120, 90, 105, 13);
		lblNewLabel_1_1.setText(u.getUserName());
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("<EMAIL>");
		lblNewLabel_1_2.setBounds(120, 151, 105, 13);
		lblNewLabel_1_2.setText(u.getUserEmail());
		getContentPane().add(lblNewLabel_1_2);
		setBackground(new Color(255, 222, 89));
		setTitle("Account Info");
		
		
	}
}
