package practice;

import java.util.Arrays;
//内部类
public class Container {
	public static void main(String args[])
	{
		Container container=new Container();
		container.put("jay", "周杰伦");
		container.put("jj", "林俊杰");
		Container.Entry[] entrys=container.entryArrays();
		
		for(int i=0;i<entrys.length;i++)
		{   Container.Entry entry=entrys[i];
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
		
	}
	
	     private Entry[] entrys=new Entry[5];
         private int count=0;
	     public void put(String key,String value)
	     {
	    	 Entry entry=new Entry();
	    	 entry.setKey(key);
	    	 entry.setValue(value);
	    	 entrys[count++]=entry;
	    	 if(count>=entrys.length)
	    	 {
	    		 int newCapacity=entrys.length*2;
	    		 entrys=Arrays.copyOf(entrys, newCapacity);
	    	 }
	     }
	
	     public Entry[] entryArrays()
	     {
	    	 return Arrays.copyOfRange(entrys, 0, count);
	     }
	
	
	
	public static class Entry
	{
		private String key;
		private String value;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}
