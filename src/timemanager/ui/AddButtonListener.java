/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import timemanager.DateParser;

/**
 * A class that uses the ActionListener interface to handle creating a new
 * schedule entry
 *
 * Note: This is tightly coupled with PopUpWindow
 * 
 * @author Yek
 */
public class AddButtonListener extends DateParser implements ActionListener {

    private final JComboBox hourComboBox;
    private final JComboBox minuteComboBox;
    private final JComboBox amPmComboBox;
    private final JTextArea textArea;
    private final TreeMap<Date, String> schedule;
    private final PopUpWindow window;

    public AddButtonListener(JComboBox hourComboBox, JComboBox minuteComboBox,
	    JComboBox amPmComboBox, JTextArea textArea, TreeMap<Date, String> schedule,
	    PopUpWindow window) {
	this.hourComboBox = hourComboBox;
	this.minuteComboBox = minuteComboBox;
	this.amPmComboBox = amPmComboBox;
	this.textArea = textArea;
	this.schedule = schedule;
	this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	String timeString;
	String hourString = (String) hourComboBox.getSelectedItem();
	String minuteString = (String) minuteComboBox.getSelectedItem();
	String amPmString = (String) amPmComboBox.getSelectedItem();
	
	String activityString = textArea.getText();
	
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
	    System.out.printf("Time: %s\nActivity: %s\n", timeString, activityString);
	    if (parseDate(timeString).isPresent()){
		schedule.put(parseDate(timeString).get(), activityString);
		System.out.printf("%s\n", schedule.toString());
		window.updateWindow(schedule);
	    }
	}

    }

}
