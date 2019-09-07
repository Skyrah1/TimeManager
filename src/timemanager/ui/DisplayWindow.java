/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * The main display window, used to provide reminders
 * @author Yek
 */
public class DisplayWindow {
    
    final JFrame frame;
    final JTextArea textArea;
    final Font font;
    final PopUpWindow window;
    final JButton button;
    ArrayList<BufferedImage> images;
    private final ImageIcon icon;
    //private Image image;
    final private JLabel imageLabel;
    
    public DisplayWindow(String title, TreeMap<Date, String> schedule,
			ImageIcon icon){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int textX = 25;
	int textY = 25;
	int frameWidth = 300;
	int frameHeight = 300;
	int frameX = (int)screenSize.getWidth() - frameWidth;
	int frameY = (int)screenSize.getHeight() - frameHeight - 70;
	int imageX = 25;
	int imageY = 50;
	int imageWidth = 200;
	int imageHeight = 150;
	this.frame = new JFrame(title);
	this.textArea = new JTextArea();
	this.font = new Font("Arial", Font.PLAIN, 18);
	this.window = new PopUpWindow("test2", new String[]{"Time", "Activity"}, "Submit");
	this.button = new JButton("Pop-up");
	this.icon = icon;
	
	this.imageLabel = new JLabel();
	this.imageLabel.setIcon(this.icon);
	this.imageLabel.setOpaque(false);
	this.icon.setImageObserver(imageLabel);
	this.frame.add(imageLabel);
	
	this.imageLabel.setText("jellyfish");
	this.imageLabel.setBounds(imageX, imageY, imageWidth, imageHeight);
	
	this.window.createWindow(schedule);
	this.window.hideWindow();
	this.textArea.setFont(font);
	this.textArea.setBounds(textX, textY, 196, 32);
	this.textArea.setEditable(false);
	this.button.setFont(font);
	this.button.setBounds((frameWidth/2) - 50, frameHeight-100, 100, 25);
	this.button.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		openPopUpWindow();
	    }
	    
	});
	this.frame.add(textArea);
	this.frame.add(button);
	this.frame.setBounds(frameX, frameY, frameWidth, frameHeight);
	this.frame.setLayout(null);
	//this.frame.setAlwaysOnTop(true);
	this.frame.setFocusableWindowState(true);
	this.frame.setUndecorated(true);
	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.frame.setBackground(new Color(0, 0, 0, 0));
	//icon = new ImageIcon(images.get(imageIndex));
	//updateImage();
    }
    
    public void updateWindow(String text){
	if (text != null){
	    textArea.setText(text);
	    textArea.setVisible(true);
	} else {
	    textArea.setText("");
	    textArea.setVisible(false);
	}
	frame.add(textArea);
	//updateImage();
    }
    
    public void showWindow(){
	frame.setVisible(true);
    }
    
    public void hideWindow(){
	frame.setVisible(false);
    }
    
    public void openPopUpWindow(){
	window.showWindow();
    }
    
}
