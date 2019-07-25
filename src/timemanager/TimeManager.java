/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.util.Date;
import java.util.TreeMap;
import timemanager.ui.PopUpWindow;

/**
 *
 * @author ASUS
 */
public class TimeManager {

    /**
     * Main class
     */
    public static void main(String[] args) {
	// TODO code application logic here
	testPopUpWindow();
	//testFileHandler();
    }
    
    public static void testFileHandler(){
	FileHandler fileHandler = new FileHandler("src/csv");
	fileHandler.test();
    }
    
    public static void testPopUpWindow(){
	//PopUpWindow window = new PopUpWindow("test");
	//window.createWindow();
	FileHandler fileHandler = new FileHandler("src/csv");
	TreeMap<Date, String> schedule = fileHandler.readFile("test.csv");
	PopUpWindow window = new PopUpWindow("test2", schedule, new String[]{"Time", "Activity"});
	window.createWindow(schedule);
    }
    
}
