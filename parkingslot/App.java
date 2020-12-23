package com.parkingslot;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class App 
{
    public static void main( String[] args )
    {
    	FirstGUI firstGUI = new FirstGUI();
    }
}
class FirstGUI extends JFrame implements ActionListener{
	JTextField nameTextField,vechicleTextField;
	JLabel nameLabel,vehicleNumberLabel;
	JButton alot,remove;
	JComboBox<String> positions; 
	HashMap<String,String> map = new HashMap<String,String>();
	JDesktopPane desk;
	JInternalFrame frame1, frame2, frame3, frame4,frame5;
	FirstGUI(){
		// create a internal frame 
		JInternalFrame  jInternalFrame1 = new JInternalFrame("Add Vechicle Details");
		//Creating field objects...
		nameTextField = new JTextField(15);
		vechicleTextField = new JTextField(15);
		//Creating label objects...
		nameLabel = new JLabel("Customer Name");
		vehicleNumberLabel = new JLabel("Vehicle Number");
		String s1[] = { "P1", "P2", "P3", "P4", "P5","P6" };  
		positions = new JComboBox<String>(s1); 	    
		//Creating button objects...
		alot = new JButton("Alot");
		remove = new JButton("Remove");
		//Adding the created objects to JFrame
		jInternalFrame1.add(nameLabel);
		jInternalFrame1.add(nameTextField);
		jInternalFrame1.add(vehicleNumberLabel);
		jInternalFrame1.add(vechicleTextField);
		jInternalFrame1.add(positions);
		jInternalFrame1.add(alot);
		jInternalFrame1.add(remove);
		add(jInternalFrame1);		
		//this.multipleFrames();
		add(desk);
		jInternalFrame1.setLayout(new FlowLayout());
		jInternalFrame1.setVisible(true);
		alot.addActionListener(this);
		remove.addActionListener(this);
		//Common Statements for frame...
		setLayout(new FlowLayout());
		this.setVisible(true);
		this.setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * The 4 above statements are common for every code
		 */				
	}
	/*public void multipleFrames() {
		frame = new JFrame("Multiple Frames");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	}*/
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("alot")) {
			map.put((String)positions.getSelectedItem(),nameTextField.getText()+"-"+vechicleTextField.getText());
		}else if(e.getActionCommand().equalsIgnoreCase("remove")) {
			map.remove(positions.getSelectedItem());
		}
		System.out.println(map);
	}
}