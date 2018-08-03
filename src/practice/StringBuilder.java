package practice;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;


public class StringBuilder {
       public static void main(String args[])
       {
    	   StringBuilder msb=new StringBuilder("aaa");
    	   /*msb.append("fuge").append("dadiaobao");
    	   System.out.println(msb.toString());
    	   System.out.println(msb.capacity());
    	   System.out.println(msb.length());*/
    	   msb.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	   System.out.println(msb.toString());
    	   System.out.println(msb.capacity());
    	   System.out.println(msb.length());
       }
	
	
	
	
	   private char [] value;
       private int count=0;
       public StringBuilder()
       {
    	   value=new char[16];
       }
       public StringBuilder(int capacity)
       {
    	   value=new char[capacity];
       }
       public StringBuilder(String str)
       {   
    	   value=new char[str.length()];
    	   value=str.toCharArray();
    	   count+=str.length();
       }
       
       public int length()
       {
    	   return count;
       }
       public int capacity()
       {
    	   return value.length;
       }
       public StringBuilder append(String str)
       {
    	   int len=str.length();
    	   ensureCapacity(count+len);
    	   str.getChars(0, len, value, count);
    	   count+=len;
    	   return this;
       }
       private void ensureCapacity(int capacity)
       {
    	   if(capacity-value.length<0) {
    		   return;
    	   }
    	   if(capacity-value.length>0)
    	   {
    		   int newCapacity=value.length*2+2;
    		   value=Arrays.copyOf(value, newCapacity);
    		   ensureCapacity(capacity);
    	   }
       }
       public String toString()
       {
    	   return new String(value,0,count);
       }
}
