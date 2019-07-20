/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.io.File;
import org.apache.commons.csv.CSVParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Optional;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


/**
 * Reads/writes CSV files from/to a designated path
 * @author Yek
 */
public class FileHandler {
    
    String path;
    
    public FileHandler(String path){
	this.path = path;
    }
    
    public void test(){
	Hashtable<Date, String> schedule = readFile("test.csv");
	try {
	    System.out.printf("%s\n", schedule.toString());
	} catch (Exception e){
	    e.printStackTrace();
	}
	
    }
    
    public Hashtable<Date, String> readFile(String file){
	System.out.println("Reading file...");
	Hashtable<Date,String> schedule = new Hashtable<>();
	try {
	    FileInputStream inputStream = new FileInputStream(path +  "/" + file);
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL);
	    for (CSVRecord record : parser){
		//enter data from record into hashtable,
		//converting the first field into a Date object
		Optional<Date> date = parseDate(record.get(0));
		if (date.isPresent()){
		    schedule.put(date.get(), record.get(1));
		}
	    }
	} catch (Exception e){
	    
	}
	return schedule;
    }
    
    /**
     * Note: the field in the first record in the CSV file will ALWAYS be an
     * unparseable date for some reason
     * 
     * @param dateString
     * @return 
     */
    private Optional<Date> parseDate(String dateString){
	System.out.println(dateString);
	SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	Date date;
	Optional<Date> optional;
	try {
	    date = format.parse(dateString);
	    System.out.println(date.toString());
	    optional = Optional.of(date);
	} catch (Exception e){
	    format = new SimpleDateFormat("H:mm");
	    try {
		date = format.parse(dateString);
		System.out.println(date.toString());
		optional = Optional.of(date);
	    } catch (Exception ex){
		//ex.printStackTrace();
		optional = Optional.empty();
		System.out.println("No dates! #foreveralone");
	    }
	}
	return optional;
    }
    
}
