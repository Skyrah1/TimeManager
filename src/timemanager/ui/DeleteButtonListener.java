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

/**
 * A class that uses the ActionListener interface to delete
 * entries from a TreeMap<Date, String>
 *
 * @author ASUS
 */
public class DeleteButtonListener implements ActionListener{
    
    final PopUpWindow window;
    final TreeMap<Date, String> schedule;
    final Entry<Date, String> entry;
    
    public DeleteButtonListener(PopUpWindow window, TreeMap<Date, String> schedule,
				Entry<Date, String> entry){
	
	this.window = window;
	this.schedule = schedule;
	this.entry = entry;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
