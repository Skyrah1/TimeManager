/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Optional;
import java.util.TreeMap;
import timemanager.ui.UiHandler;

/**
 * Updates UI based on existing data, and updates data based on user input
 * Creates an instance of FileHandler and UiHandler
 *
 * @author Yek
 */
public class Presenter extends DateParser{

    public void test() {
	FileHandler fileHandler = new FileHandler("src/csv");
	fileHandler.test();
    }

    public void run() {
	String file = "test3.csv";
	FileHandler fileHandler = new FileHandler("src/csv");
	TreeMap<Date, String> schedule = fileHandler.readFile(file);
	TreeMap<Date, String> tempSchedule = fileHandler.readFile(file);
	UiHandler uiHandler = new UiHandler("Time Manager", schedule);
	long nextTime = System.currentTimeMillis() + 60000;
	long checkTime = System.currentTimeMillis() + 1000;
	Optional<Date> date;
	boolean running = true;
	try {
	    System.out.printf("%s\n", schedule.toString());
	    uiHandler.showWindow();
	    while (running) {
		//Every second, do this
		if (System.currentTimeMillis() >= checkTime) {
		    if (!schedule.equals(tempSchedule)){
			updateSchedule(fileHandler, file, schedule, tempSchedule);
		    }
		    date = parseDate(dateToString(new Date()));
		    if (date.isPresent() && schedule.containsKey(date.get())){
			uiHandler.updateText(schedule.get(date));
		    }
		    checkTime = System.currentTimeMillis() + 1000;
		    
		}
		//Every minute, do this
		if (System.currentTimeMillis() >= nextTime) {
		    nextTime = System.currentTimeMillis() + 60000;
		    
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    //running = false;
	}
    }

    private void updateSchedule(FileHandler fileHandler, String file,
	    TreeMap<Date, String> schedule, TreeMap<Date, String> tempSchedule) {
	try {
	    fileHandler.writeFile(file, schedule);
	    tempSchedule = fileHandler.readFile(file);
	} catch (ConcurrentModificationException e) {
	    long waitTime = System.currentTimeMillis() + 100;
	    while (System.currentTimeMillis() < waitTime){
		//do nothing
	    }
	    updateSchedule(fileHandler, file, schedule, tempSchedule);
	}
    }

}
