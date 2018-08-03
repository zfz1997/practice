package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class writer {
          public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
        	  @SuppressWarnings("unused")
			 File file=new File("d:/IOpractice/practice.txt");
              
             FileOutputStream out=new FileOutputStream(file,true);
        	 OutputStreamWriter outputStreamWriter=new OutputStreamWriter(out,"utf-8");
			 BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
			 try {
				bufferedWriter.write("ÄãºÃ");
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	    
              
          }
}
