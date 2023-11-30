/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concertdb;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;


/**
 * Parent class that the majority of our window will be based on.
 * 
 * @author Logan Alpha
 * @version 11.19.23
 *
 */
public class BaseWindow extends JFrame 
{
	
	protected JFrame lastWindow;
	protected JFrame nextWindow;
	private boolean isInstantiated;
	
	public BaseWindow()
	{
		
		this.setBackground(new Color(240, 240, 240));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(950, 750);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	isInstantiated = false;
            	System.out.println("Exiting window...");
            }
        });
		
	}
	
	public boolean getCurrentUse() {return isInstantiated;}
	
	public void invertUse() { isInstantiated = !isInstantiated;}
	
	protected void closePrevious() {
		
		lastWindow.setDefaultCloseOperation(HIDE_ON_CLOSE);
		lastWindow.dispose();
	}
		
}