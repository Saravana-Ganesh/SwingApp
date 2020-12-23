package com.parkingslot;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MultipleFrames {
	JDesktopPane desk;
	JInternalFrame frame1, frame2, frame3, frame4,frame5;
	JFrame frame;

	public static void main(String[] args) {
		MultipleFrames d = new MultipleFrames();
	}

	public MultipleFrames() {
		frame = new JFrame("Multiple Frames");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.multiple();
	}
	public void multiple() {
		desk = new JDesktopPane();
		frame1 = new JInternalFrame("Frame1");
		frame1.setBounds(20, 200, 150, 100);
		frame1.setVisible(true);
		frame2 = new JInternalFrame("Frame2");
		frame2.setBounds(200, 200, 150, 100);
		frame2.setVisible(true);
		frame3 = new JInternalFrame("Frame3");
		frame3.setBounds(400, 200, 150, 100);
		frame3.setVisible(true);
		frame4 = new JInternalFrame("Frame4");
		frame4.setBounds(600, 200, 150, 100);
		frame4.setVisible(true);
		frame5 = new JInternalFrame("Frame5");
		frame5.setBounds(800, 200, 150, 100);
		frame5.setVisible(true);
		desk.add(frame1);
		desk.add(frame2);
		desk.add(frame3);
		desk.add(frame4);
		desk.add(frame5);
		frame.add(desk);
		frame.setSize(1000,600);
		frame.setVisible(true);
	}
}