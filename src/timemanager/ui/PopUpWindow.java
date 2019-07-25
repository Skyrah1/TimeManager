/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    /*
    public PopUpWindow(String title){
	this.minutes = new String[61];
	minutes[0] = "";
	for (int i = 1; i <= 60; i++){
	    minutes[i] = Integer.toString(i);
	}
	this.frame = new JFrame(title);
	this.model = new DefaultTableModel();
	this.table = new JTable(model);
	//scrollPane.setViewportView(table);
	this.hourComboBox = new JComboBox(hours);
	this.minuteComboBox = new JComboBox(minutes);
	this.amPmComboBox = new JComboBox(amPm);
    }*/
    
    public PopUpWindow(String title, TreeMap<Date, String> map, String[] headings, String buttonText){
	this.minutes = new String[61];
	minutes[0] = "";
	for (int i = 1; i <= 60; i++){
	    minutes[i] = Integer.toString(i);
	}
	this.model = new DefaultTableModel();
	this.model.setColumnIdentifiers(headings);
	fillTable(map);
	this.table = new JTable(model);
	this.frame = new JFrame(title);
	this.textArea = new JTextArea();
	this.button = new JButton(buttonText);
	this.hourComboBox = new JComboBox(hours);
	this.minuteComboBox = new JComboBox(minutes);
	this.amPmComboBox = new JComboBox(amPm);
    }
    
    private void fillTable(TreeMap<Date, String> map){
	int count = 0;
	for (Entry<Date, String> entry : map.entrySet()){
	    this.model.insertRow(count, new Object[]{dateToString(entry.getKey()), entry.getValue()});
	    System.out.printf("Added row: %s and %s\n", dateToString(entry.getKey()), entry.getValue());
	    count++;
	}
    }
    
    public void createWindow(TreeMap<Date, String> map){
	final int rowHeight = 25;
	int rowCount = map.size();
	int tableSpace = rowHeight * rowCount;
	final int textAreaWidth = 300;
	final int textAreaHeight = 75;
	
	frame.setLayout(null);
	frame.setBounds(500, 500, 400, tableSpace + 250);
	
	table.setRowHeight(rowHeight);
	table.setBounds(25, 0, 350, tableSpace);
	table.getColumnModel().getColumn(0).setMaxWidth(50);
	//table.getColumnModel().getColumn(1).setMinWidth(400);
	frame.add(table);
	
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
	frame.add(button);
	
	frame.setVisible(true);
	//frame.pack();
    }
    
    
}
