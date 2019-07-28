/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.Font;
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
	this.frame = new JFrame(title);
	this.textArea = new JTextArea();
	this.font = new Font("Arial", Font.PLAIN, 20);
	textArea.setFont(font);
	frame.setLayout(null);
    }
    
    public void updateWindow(String text){
	if (text != null){
	    textArea.setText(text);
	} else {
	    textArea.setText("");
	}
	frame.add(textArea);
    }
    
}
