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
    
    public String[][] readFile(String file){
	String[][] schedule = new String[0][0];	    //return this ONLY if file
						    //is not found
	try {
	    FileInputStream inputStream = new FileInputStream(file);
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL);
	} catch (Exception e){
	    
	}
	return schedule;
    }
    
}
