/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Handles the reading of image files in a directory
 * 
 * @author Yek
 */
public class ImageHandler {
    
    String path;
    
    public ImageHandler(String path){
	this.path = path;
    }
    
    public ArrayList<BufferedImage> getImages(){
	ArrayList<BufferedImage> images = new ArrayList<>();
	File[] files = new File(path).listFiles();
	for (File file : files){
	    try {
		//images.add(ImageIO.read(file));
		System.out.printf("Reading %s\n", file.getCanonicalPath());
	    } catch (IOException e){
		e.printStackTrace();
	    }
	}
	return images;
    }
    
    public ImageIcon getImageIcon(String file){
	String filePath = path + "/" + file;
	System.out.printf("Reading %s\n", filePath);
	ImageIcon icon = new ImageIcon(filePath);
	return icon;
    }
    
}
