/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author ASUS
 */
public abstract class DateParser {
    /**
     * Note: the field in the first record in the CSV file will ALWAYS be an
     * unparseable date (reserved for headers)
     * 
     * @param dateString
     * @return 
     */
    public static Optional<Date> parseDate(String dateString){
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
    
    public static String dateToString(Date date){
	String dateString = date.toString();
	dateString = dateString.replace("Thu Jan 01 ", "");
	dateString = dateString.replace(":00 SGT 1970", "");
	return dateString;
    }
}
