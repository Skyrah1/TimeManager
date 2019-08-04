/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.util.Date;
import java.util.TreeMap;

/**
 * Handles the creation and updating of visual elements
 * @author Yek
 */
public class UiHandler {
    
    final TreeMap<Date, String> schedule;
    
    public UiHandler(TreeMap<Date, String> schedule){
	this.schedule = schedule;
    }
    
    public void run(){
	DisplayWindow window = new DisplayWindow("Time Manager", schedule);
	window.showWindow();
    }
    
}
