package com.app.concert;

import com.app.concert.graphics.AccountCreationWindow;
import com.app.concert.graphics.LoginWindow;
import com.app.concert.user.Password;

public class Main 
{

	public static void main(String[] args) 
	{
	
		System.out.println("Running...");
		
		//AccountCreationWindow a = new AccountCreationWindow();
		//a.setVisible(true);
		
		
		
		new LoginWindow();
		Password p = new Password();
		p.setPassword("Abcdefg-1234");
		System.out.println(p.toString());
		System.out.println(p.decrypt());
		
		System.out.println("Main method complete.");
		
	}
	
}
