/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ComparableDate extends DateParser implements Comparable<ComparableDate> {
    
    final private Date date;
    
    public ComparableDate(Date date){
	this.date = date;
    }
    
    public Date getDate(){
	return date;
    }
    
    @Override
    public int compareTo(ComparableDate cDate){
	
    }
}
