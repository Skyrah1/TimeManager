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

/**
 * A class that uses the ActionListener interface to delete
 * entries from a TreeMap<Date, String>
 *
 * @author ASUS
 */
public class DeleteButtonListener implements ActionListener{
    
    private final PopUpWindow window;
    private final TreeMap<Date, String> schedule;
    private final Entry<Date, String> entry;
    private final JButton deleteButton;
    
    public DeleteButtonListener(PopUpWindow window, TreeMap<Date, String> schedule,
				Entry<Date, String> entry, JButton deleteButton){
	
	this.window = window;
	this.schedule = schedule;
	this.entry = entry;
	this.deleteButton = deleteButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	window.getDeleteButtons().remove(deleteButton);
	deleteButton.setVisible(false);
	//System.out.println("...");
	//window.getFrame().remove(deleteButton);
	//window.getFrame().revalidate();
	//window.getFrame().repaint();
	schedule.remove(entry.getKey());
	window.updateWindow(schedule);
	//deleteButton.removeActionListener(this);
    }
    
}
