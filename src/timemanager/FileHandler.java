/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.io.BufferedWriter;
import java.io.File;
import org.apache.commons.csv.CSVParser;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import static timemanager.DateParser.dateToString;
import static timemanager.DateParser.parseDate;


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
	TreeMap<Date, String> schedule = readFile("test.csv");
	try {
	    System.out.printf("%s\n", schedule.toString());
	} catch (Exception e){
	    e.printStackTrace();
	}
	writeFile("test2.csv", schedule);
    }
    
    public TreeMap<Date, String> readFile(String file){
	System.out.println("Reading file...");
	TreeMap<Date,String> schedule = new TreeMap<>();
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
	    parser.close();
	    reader.close();
	} catch (Exception e){
	    
	}
	return schedule;
    }
    
    public void writeFile(String file, TreeMap<Date, String> schedule){
	System.out.println("Writing file...");
	try {
	    //Create a new file if it doesn't exist, otherwise do nothing
	    File f = new File(path + "/" + file);
	    f.createNewFile();
	    BufferedWriter writer = new BufferedWriter(new FileWriter(f));
	    writer.write("Time,Activity\n");
	    for (Map.Entry<Date, String> entry : schedule.entrySet()){
		//do stuff
		writer.write(dateToString(entry.getKey()) + "," + entry.getValue() + "\n");
	    }
	    writer.close();
	} catch (Exception e){
	    
	}
    }
    
    
    
}
