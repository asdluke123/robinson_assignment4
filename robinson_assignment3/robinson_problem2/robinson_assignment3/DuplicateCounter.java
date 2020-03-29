package robinson_assignment3;

import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class DuplicateCounter {

	private Map<String,Integer>wordCounter;//Create wordCounter map 

	
	public void count(String dataFile)  {
		try {
			wordCounter= new HashMap<String,Integer>();//Save wordCounter as a new HashMap that hold a String and Integer
		 Scanner file = new Scanner(new File(dataFile));//Scan the paramater datafile for the file  
				while(file.hasNext()) {
					String words = file.next().toLowerCase();//Variable word to hold string scanned from file 
					Integer token = wordCounter.get(words);//Token varable to keep count of the amount of words
					if(token == null) {//If there is no words in the file token equals 1
						token = 1;}
					else {//if there are words token goes up by 1
						token = token +1;}
					wordCounter.put(words,token);//Put the corresponding word and token number together in the map 
				}
		}catch(FileNotFoundException e) {//Catches a file not found exception
			System.out.printf("That File does not exist %s%n",e );
		}		
	}//end of count method 
	public void write(String outputFile) {
		try {
			File file = new File(outputFile);//creates a file object with outputFile perameter
			boolean test = file.createNewFile();//tests to see if the file already exists or not 
			if(test) {//if test is true 	
				PrintWriter writer = new PrintWriter(file);//create a printWriter object with the file object
			    for (String line : wordCounter.keySet()) {//creates a for loop to the amount of sets in wordCounter
			        writer.println(line+" "+wordCounter.get(line));//prints the word and corresponding count to a new line
			    }
			    writer.close();
			}
			else {
				PrintWriter writer = new PrintWriter(file);
				for (String line : wordCounter.keySet()) {
			        writer.println(line+" "+wordCounter.get(line));
		    	}
		    	writer.close();
			}
		}catch (IOException e) {
		e.printStackTrace();
		}
	}
}//end of DuplicateCounter

