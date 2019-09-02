package plag;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;

public class fileread 
{
    
	
	static String readFile(String f1) throws IOException
	{
		FileReader file = new FileReader(f1);
		
	    BufferedReader br = new BufferedReader(file);
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        
	        return sb.toString();
	    }
	    finally {
	    
	        br.close();
	    }
	}
	
	

}