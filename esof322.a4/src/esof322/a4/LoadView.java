package esof322.a4;

/**
 * View for loading the game 
 */

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
	private File[] fileList;  //list of files in save folder 
	private boolean empty = false; //save folder empty 
	JLabel fileLabel;
	JTextArea choice = addTextArea("Enter file choice number", 2, 1, 1, 1); 
	JButton okButton = addButton("OK", 3, 1, 1, 1); 
	
	
	public LoadView(WelcomeView a) {
		this.a = a; 
		choice.setEditable(true); 
		read(); 
	}
	
	//read file info 
	public void read() {
		String fileNames = "<html>"; 
		File folder = new File("SaveStuff");
		fileList = folder.listFiles();	//all files in save folder 
		if (fileList.length == 0) {
			choice.setText("No saved games found");
			empty = true; 
		}
		int i = 1; 
		for (File file : fileList) {	//display file names 
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
			if (empty == false) {	//save folder is not empty 
				boolean check = false; 
				String input = choice.getText(); 
				for (int i = 1; i <= fileList.length; i++) {	//find chosen file 
					if (input.equals(String.valueOf(i))) {
						check = true; 
						String fName = String.valueOf(fileList[i - 1]); 
						try (BufferedReader br = new BufferedReader(new FileReader(fName))) {	//read file info 
						    String line;
						    while ((line = br.readLine()) != null) {
						       fileInfo.add(line); 
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
				if (check == false) {	//valid choice not entered 
					choice.setText("Please enter valid number");
				} else {
					a.close();
					this.dispose(); 
				}
			} else {	//save folder is empty 
				this.dispose(); 
			}
		}
	}
}
