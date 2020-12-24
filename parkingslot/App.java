package com.parkingslot;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
	JInternalFrame[] jInternalFrame;
	JLabel[] names = new JLabel[5],vechicles;
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
		multipleFrames();
		deskFunctions();
		setMapDefaultValues();
		jInternalFrame1.setLayout(new FlowLayout());
		jInternalFrame1.setVisible(true);
		alot.addActionListener(this);
		remove.addActionListener(this);
		//Common Statements for frame...
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * The 4 above statements are common for every code
		 */				
	}
	public void setMapDefaultValues() {
		for(int i=0;i<5;i++) {
			String key = "P"+(i+1);
			map.put(key,"-1");
		}
	}
	public void multipleFrames() {		
		jInternalFrame = new JInternalFrame[5];
		for(int i=0;i<jInternalFrame.length;i++) {
			String frameName = "P"+(i+1);
			jInternalFrame[i] = new JInternalFrame(frameName);
			//jInternalFrame[i].add(new JLabel("Name"));
			//jInternalFrame[i].setBounds(0, 200, 150, 100);
			jInternalFrame[i].setPreferredSize(new Dimension(180,80));
			jInternalFrame[i].setVisible(true);
			names[i] = new JLabel();
		}		
	}
	public void deskFunctions() {
		desk = new JDesktopPane();
		for(JInternalFrame jInternalFrame1:jInternalFrame) {
			desk.add(jInternalFrame1);
		}
		desk.setLayout(new FlowLayout());		
		add(desk);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equalsIgnoreCase("alot")) {
			if(map.get((String)positions.getSelectedItem()).equals("-1")) {
				map.put((String)positions.getSelectedItem(),nameTextField.getText()+"-"+vechicleTextField.getText());
				alotParking();
			}
		}else if(e.getActionCommand().equalsIgnoreCase("remove")) {
			map.put((String)positions.getSelectedItem(),"-1");
			alotParking();
		}		
		System.out.println(map);
	}
	public void alotParking() {
		int i=0;
		for (Map.Entry<String,String> entry : map.entrySet()) {
			String str = entry.getValue();
			if(!str.equals("-1")) {
				for(int j=0;j<str.length();j++) {					
					if(str.charAt(j)=='-') {								
						names[i].setText(str.substring(0,j)+"-"+str.substring(j+1));
					}
				}
			}else {
				names[i].setText("");
			}
			jInternalFrame[i].getContentPane().add(names[i]);
			jInternalFrame[i].setLayout(new FlowLayout());
			jInternalFrame[i].setVisible(true);
			i++;
		}
		deskFunctions();
	}
}