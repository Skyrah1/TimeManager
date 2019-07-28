/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import javax.swing.JFrame;

/**
 * The main display window, used to provide reminders
 * @author Yek
 */
public class DisplayWindow {
    
    final JFrame frame;
    
    public DisplayWindow(String title){
	this.frame = new JFrame(title);
    }
    
}
