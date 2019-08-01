/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * The main display window, used to provide reminders
 * @author Yek
 */
public class DisplayWindow {
    
    final JFrame frame;
    final JTextArea textArea;
    final Font font;
    
    public DisplayWindow(String title){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int textX = 25;
	int textY = 25;
	int frameWidth = 300;
	int frameHeight = 200;
	int frameX = (int)screenSize.getWidth() - frameWidth;
	int frameY = (int)screenSize.getHeight() - frameHeight;
	this.frame = new JFrame(title);
	this.textArea = new JTextArea();
	this.font = new Font("Arial", Font.PLAIN, 18);
	textArea.setFont(font);
	textArea.setBounds(textX, textY, 200, 18);
	frame.setBounds(frameX, frameY, frameWidth, frameHeight);
	frame.setLayout(null);
	frame.setAlwaysOnTop(true);
	frame.setFocusableWindowState(false);
	frame.setUndecorated(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void updateWindow(String text){
	if (text != null){
	    textArea.setText(text);
	    textArea.setVisible(true);
	} else {
	    textArea.setText("");
	    textArea.setVisible(false);
	}
	frame.add(textArea);
    }
    
    public void showWindow(){
	frame.setVisible(true);
    }
    
    public void hideWindow(){
	frame.setVisible(false);
    }
    
}
