/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanager.ui;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * MouseListener subclass to make the frame draggable even when undecorated
 *
 * @author Yek
 */
public class DisplayMouseListener implements MouseMotionListener {

    private final JFrame frame;
    private boolean clicked;

    public DisplayMouseListener(JFrame frame) {
	this.frame = frame;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	Point mousePoint = MouseInfo.getPointerInfo().getLocation();
	int x = mousePoint.x;
	int y = mousePoint.y;
	int width = frame.getWidth();
	int height = frame.getHeight();
	frame.setBounds(x - (width / 3), y - (height / 3), width, height);
	frame.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
