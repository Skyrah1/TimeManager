/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

/**
 * Handles the creation and updating of visual elements
 * @author Yek
 */
public class UiHandler {
    
    final TreeMap<Date, String> schedule;
    final DisplayWindow window;
    
    public UiHandler(String title, TreeMap<Date, String> schedule,
		    ArrayList<BufferedImage> images){
	this.schedule = schedule;
	this.window = new DisplayWindow("Time Manager", schedule, images);
    }
    
    public void showWindow(){
	window.showWindow();
    }
    
    public void updateText(String text){
	window.updateWindow(text);
    }
    
    public void updateImage(){
	window.updateImage();
    }
    
}
