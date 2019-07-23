/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * A pop-up window for when the user wants to edit their schedule
 * @author Yek
 */
public class PopUpWindow {
    
    final JFrame frame;
    final JComboBox hourComboBox;
    final JComboBox minuteComboBox;
    final JComboBox amPmComboBox;
    final String[] hours = "1,2,3,4,5,6,7,8,9,10,11,12".split(",");
    final String[] minutes;
    final String[] amPm = {"AM", "PM"};
    
    public PopUpWindow(String title){
	this.minutes = new String[60];
	for (int i = 1; i <= 60; i++){
	    minutes[i] = Integer.toString(i);
	}
	this.frame = new JFrame(title);
	this.hourComboBox = new JComboBox(hours);
	this.minuteComboBox = new JComboBox(minutes);
	this.amPmComboBox = new JComboBox(amPm);
    }
    
    
    
}
