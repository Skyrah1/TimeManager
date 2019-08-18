/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JPanel;
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
    private int imageIndex;
    
    public DisplayWindow(String title, TreeMap<Date, String> schedule,
			ArrayList<BufferedImage> images){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int textX = 25;
	int textY = 25;
	int frameWidth = 300;
	int frameHeight = 200;
	int frameX = (int)screenSize.getWidth() - frameWidth;
	int frameY = (int)screenSize.getHeight() - frameHeight;
	this.frame = new JFrame(title);
	this.textArea = new JTextArea();
	this.font = new Font("Arial", Font.PLAIN, 18);
	this.window = new PopUpWindow("test2", new String[]{"Time", "Activity"}, "Submit");
	this.button = new JButton("Pop-up");
	this.images = images;
	this.imageIndex = 0;
	window.createWindow(schedule);
	window.hideWindow();
	textArea.setFont(font);
	textArea.setBounds(textX, textY, 200, 18);
	button.setFont(font);
	button.setBounds((frameWidth/2) - 50, frameHeight-50, 100, 25);
	button.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		openPopUpWindow();
	    }
	    
	});
	frame.add(textArea);
	frame.add(button);
	frame.setBounds(frameX, frameY, frameWidth, frameHeight);
	frame.setLayout(null);
	frame.setAlwaysOnTop(true);
	frame.setFocusableWindowState(false);
	frame.setUndecorated(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	updateImage();
    }
    
    public void updateImage(){
	JLabel currentImage = new JLabel(new ImageIcon(images.get(imageIndex)));
	frame.add(currentImage);
	imageIndex = (imageIndex + 1) % images.size();
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
