package esof322.a4;

import java.awt.Choice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;

public class LoadView extends GBFrame{
	private WelcomeView a;  
	private File[] fileList;  
	JLabel fileLabel;
	JTextArea choice = addTextArea("Enter file choice number", 2, 1, 1, 1); 
	JButton okButton = addButton("OK", 3, 1, 1, 1); 
	
	
	public LoadView(WelcomeView a) {
		this.a = a; 
		choice.setEditable(true); 
		read(); 
	}
	
	public void read() {
		String fileNames = "<html>"; 
		File folder = new File("SaveStuff");
		fileList = folder.listFiles();
		int i = 1; 
		for (File file : fileList) {
		    if (file.isFile()) {
		        fileNames += i + ": " + file.getName() + "<br>";
		        i++; 
		    }
		}
		fileNames += "</html>"; 
		fileLabel = addLabel(fileNames, 1, 1, 1, 1); 
	}
	
	public void buttonClicked(JButton buttonObj) {
		ArrayList fileInfo = new ArrayList(); 
		if (buttonObj == okButton) {
			boolean check = false; 
			String input = choice.getText(); 
			for (int i = 1; i <= fileList.length; i++) {
				if (input.equals(String.valueOf(i))) {
					check = true; 
					String fName = String.valueOf(fileList[i - 1]); 
					try (BufferedReader br = new BufferedReader(new FileReader(fName))) {
					    String line;
					    while ((line = br.readLine()) != null) {
					       fileInfo.add(line); 
					       System.out.println(line);
					    }
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					a.setLoadInfo(fileInfo);
				}
			}
			if (check == false) {
				choice.setText("Please enter valid number");
			} else {
				a.close();
				this.dispose(); 
			}
		}
	}
}
