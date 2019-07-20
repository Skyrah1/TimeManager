/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

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
	UiHandler uiHandler = new UiHandler();
    }
    
}
