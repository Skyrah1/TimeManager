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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    
    private final JFrame frame;
    private final JTextArea textArea;
    private final Font font;
    private final PopUpWindow window;
    private final JButton popUpButton;
    private final JButton okButton;
    private ArrayList<BufferedImage> images;
    private final ImageIcon icon;
    //private Image image;
    private final JLabel imageLabel;
    
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
	int buttonLength = 100;
	int buttonHeight = 25;
	this.frame = new JFrame(title);
	this.textArea = new JTextArea();
	this.font = new Font("Arial", Font.PLAIN, 18);
	this.window = new PopUpWindow("test2", new String[]{"Time", "Activity"}, "Submit");
	this.popUpButton = new JButton("Pop-up");
	this.okButton = new JButton("OK");
	this.icon = icon;
	
	this.imageLabel = new JLabel();
	this.imageLabel.setIcon(this.icon);
	this.imageLabel.setOpaque(false);
	this.icon.setImageObserver(imageLabel);
	this.frame.add(imageLabel);
	
	this.imageLabel.setText("jellyfish");
	this.imageLabel.setBounds(imageX, imageY, imageWidth, imageHeight);
	this.imageLabel.addMouseMotionListener(new DisplayMouseListener(this.frame));
	
	this.window.createWindow(schedule);
	this.window.hideWindow();
	this.textArea.setFont(font);
	this.textArea.setBounds(textX, textY, 196, 32);
	this.textArea.setEditable(false);
	this.popUpButton.setFont(font);
	this.popUpButton.setBounds((frameWidth/2), frameHeight-100, buttonLength, buttonHeight);
	this.popUpButton.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		openPopUpWindow();
	    }
	    
	});
	this.okButton.setFont(font);
	this.okButton.setBounds((frameWidth/2) - 100, frameHeight-100, buttonLength, buttonHeight);
	this.okButton.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e){
		textArea.setText("");
	    }
	});
	this.frame.add(textArea);
	this.frame.add(popUpButton);
	this.frame.add(okButton);
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
    
    public void toggleOkButton(){
	if (okButton.isVisible()){
	    okButton.setVisible(false);
	} else {
	    okButton.setVisible(true);
	}
    }
    
    public void openPopUpWindow(){
	window.showWindow();
    }

}
