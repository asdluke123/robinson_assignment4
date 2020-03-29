import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedReader;
public class DuplicateRemover {

	 static ArrayList<String> uniqueWords = new ArrayList();
	 static ArrayList<String> dup = new ArrayList();
	 public int counter;
	 
public void remove(String dataFile) {
	try {
		counter =FileCount(dataFile);
		Scanner scan = new Scanner(new File(dataFile));		
		while(scan.hasNextLine()) {
			uniqueWords.add(scan.nextLine());}
	}catch(FileNotFoundException e) {
			System.out.printf("ERROR: File does not exist %s\n", e);
		}
		compare();
}
public void write(String outputFile) {
	try {
		File file = new File(outputFile);
		boolean test = file.createNewFile();
		if(test) {
			PrintWriter writer = new PrintWriter(file);
		    for (String line : dup) {
		        writer.println(line);
		    }
		    writer.close();
		}
		else {
			PrintWriter writer = new PrintWriter(file);
	    	for (String line : dup) {
	    		writer.println(line);
	    	}
	    	writer.close();
		}
	}
	catch (IOException e) {
	e.printStackTrace();
	}
}
public int FileCount(String File) {
	int count=0;
	try {
	File f1=new File(File); //Creation of File Descriptor for input file
    String[] words=null;    //Intialize the word Array
 
    FileReader fr = new FileReader(f1);    //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr);    //Creation of BufferedReader object
    String s;
    while((s=br.readLine())!=null)    //Reading Content from the file
    {
       words=s.split(" ");   //Split the word using space
       count=count+words.length;   //increase the word count for each word
    }
	}catch(FileNotFoundException e) {
		System.out.printf("This file does not exist. %s%n",e);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	return count;
}
public void compare() {
	for(int i = 0; i < counter - 1; i++) {
	    for(int j = i + 1; j < counter; j++) {
	    	if(uniqueWords.get(i).equals(uniqueWords.get(j))) {
	    		if(dup.contains(uniqueWords.get(i))) {
	    			break;}
	    			else {dup.add(uniqueWords.get(i));
	    			}
	        }
	    }
	}
	
}
}