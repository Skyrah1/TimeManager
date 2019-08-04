/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.util.Date;
import java.util.TreeMap;
import timemanager.ui.UiHandler;

/**
 * Updates UI based on existing data, and updates data based on
 * user input
 * Creates an instance of FileHandler and UiHandler
 * @author Yek
 */
public class Presenter {
    
    public void test(){
	FileHandler fileHandler = new FileHandler("src/csv");
	fileHandler.test();
    }
    
    public void run(){
	FileHandler fileHandler = new FileHandler("src/csv");
	TreeMap<Date, String> schedule = fileHandler.readFile("test.csv");
	UiHandler uiHandler = new UiHandler("Time Manager", schedule);
	long nextTime = System.currentTimeMillis() + 60000;
	boolean running = true;
	try {
	    System.out.printf("%s\n", schedule.toString());
	    uiHandler.showWindow();
	    while (running){
		if (System.currentTimeMillis() >= nextTime){
		    nextTime += 60000;
		}
	    }
	} catch (Exception e){
	    e.printStackTrace();
	    running = false;
	}
    }
    
}
