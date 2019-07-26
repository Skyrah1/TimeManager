/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 * A class that uses the ActionListener interface to handle creating a new
 * schedule entry
 *
 * @author Yek
 */
public class ButtonListener implements ActionListener {

    final JComboBox hourComboBox;
    final JComboBox minuteComboBox;
    final JComboBox amPmComboBox;
    final JTextArea textArea;

    public ButtonListener(JComboBox hourComboBox, JComboBox minuteComboBox,
	    JComboBox amPmComboBox, JTextArea textArea) {
	this.hourComboBox = hourComboBox;
	this.minuteComboBox = minuteComboBox;
	this.amPmComboBox = amPmComboBox;
	this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	String timeString;
	String hourString = (String) hourComboBox.getSelectedItem();
	String minuteString = (String) minuteComboBox.getSelectedItem();
	String amPmString = (String) amPmComboBox.getSelectedItem();
	if (hourString.equals("") || minuteString.equals("") || amPmString.equals("")) {
	    System.out.println("What do?");
	} else {
	    if (minuteString.length() == 1) {
		minuteString = "0" + minuteString;
	    }
	    if (amPmString.equals("AM")) {
		timeString = (hourString) + ":"
			+ minuteString;
	    } else if (amPmString.equals("PM")) {
		int hour = (Integer.parseInt(hourString) + 12) % 24;
		timeString = (Integer.toString(hour)) + ":"
			+ minuteString;
	    } else {
		timeString = "";
	    }
	    System.out.printf("Time: %s\n", timeString);
	}

    }

}
