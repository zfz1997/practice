package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copy {
             public static void main(String[] args) throws IOException {
				
            	@SuppressWarnings("unused")
			    int data=0;
				File start=new File("d:/IOpractice/practice.txt");
				
				File end=new File("d:/IOpractice/practice2.txt");
				@SuppressWarnings("unused")
				FileInputStream input=new FileInputStream(start);
			    FileOutputStream output=new FileOutputStream(end);
			    
			    BufferedInputStream bufferedInputStream=new BufferedInputStream(input);
			    BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(output);
			    
			    while((data=bufferedInputStream.read())!=-1);
			    {
			    	bufferedOutputStream.write(data);
			    }
			    bufferedOutputStream.close();
			    bufferedInputStream.close();
			}
}
