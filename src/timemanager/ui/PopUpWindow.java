/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import static timemanager.DateParser.dateToString;

/**
 * A pop-up window for when the user wants to edit their schedule
 * @author Yek
 */
public class PopUpWindow {
    
    final JFrame frame;
    final JComboBox hourComboBox;
    final JComboBox minuteComboBox;
    final JComboBox amPmComboBox;
    final JTable table;
    final DefaultTableModel model;
    final JTextArea textArea;
    final JButton button;
    final String[] hours = ",1,2,3,4,5,6,7,8,9,10,11,12".split(",");
    final String[] minutes;
    final String[] amPm = {"", "AM", "PM"};
    final ArrayList<JButton> deleteButtons;
    
    public PopUpWindow(String title,  String[] headings, String buttonText){
	this.minutes = new String[61];
	minutes[0] = "";
	for (int i = 0; i <= 59; i++){
	    minutes[i + 1] = Integer.toString(i);
	}
	this.model = new DefaultTableModel();
	this.model.setColumnIdentifiers(headings);
	
	this.table = new JTable(model);
	this.frame = new JFrame(title);
	this.textArea = new JTextArea();
	this.button = new JButton(buttonText);
	this.hourComboBox = new JComboBox(hours);
	this.minuteComboBox = new JComboBox(minutes);
	this.amPmComboBox = new JComboBox(amPm);
	
	this.deleteButtons = new ArrayList<>();
    }
    
    private void fillTable(TreeMap<Date, String> schedule){
	model.setRowCount(0);
	int count = 0;
	JButton deleteButton;
	for (Entry<Date, String> entry : schedule.entrySet()){
	    this.model.insertRow(count, new Object[]{dateToString(entry.getKey()), entry.getValue()});
	    deleteButton = new JButton("X");
	    deleteButtons.add(deleteButton);
	    deleteButton.addActionListener(new DeleteButtonListener(this, schedule, entry));
	    System.out.printf("Added row: %s and %s\n", dateToString(entry.getKey()), entry.getValue());
	    count++;
	}
    }
    
    public void createWindow(TreeMap<Date, String> schedule){
	updateWindow(schedule);
	frame.setVisible(true);
    }
    
    public void hideWindow(){
	frame.setVisible(false);
    }
    
    public void updateWindow(TreeMap<Date, String> schedule){
	final int rowHeight = 25;
	int rowCount = schedule.size();
	int tableSpace = rowHeight * rowCount;
	final int textAreaWidth = 300;
	final int textAreaHeight = 75;
	
	fillTable(schedule);
	
	frame.setLayout(null);
	frame.setBounds(500, 500, 450, tableSpace + 250);
	
	table.setRowHeight(rowHeight);
	table.setBounds(50, 0, 350, tableSpace);
	table.getColumnModel().getColumn(0).setMaxWidth(50);
	frame.add(table);
	
	updateDeleteButtons(rowHeight, 0, 0);
	
	hourComboBox.setBounds(25, tableSpace + 25, 50, 20);
	minuteComboBox.setBounds(100, tableSpace + 25, 50, 20);
	amPmComboBox.setBounds(175, tableSpace + 25, 50, 20);
	frame.add(hourComboBox);
	frame.add(minuteComboBox);
	frame.add(amPmComboBox);
	
	textArea.setBounds(25, tableSpace + 75, textAreaWidth, textAreaHeight);
	textArea.setWrapStyleWord(true);
	textArea.setLineWrap(true);
	frame.add(textArea);
	
	button.setBounds(textAreaWidth - 50, (tableSpace + textAreaHeight + 85), 75, 30);
	button.setVisible(true);
	button.addActionListener(new AddButtonListener(hourComboBox, minuteComboBox,
		amPmComboBox, textArea, schedule, this));
	frame.add(button);
	
    }
    
    private void updateDeleteButtons(int rowHeight, int tableX, int tableY){
	int index = 0;
	for (JButton b : deleteButtons){
	    b.setBounds(tableX, tableY + (rowHeight * index), 45, rowHeight);
	    frame.add(b);
	    index++;
	}
    }
    
    public void showWindow(){
	frame.setVisible(true);
    }
    
    
}
