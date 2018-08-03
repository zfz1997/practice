package practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class CollectionsDemo2 {
      public static void main(String[] args) {
    	  List<Person> data=new ArrayList<Person>();
    	  data.add(new Person("jack",20,10));
    	  data.add(new Person("rose",10,7));
    	  data.add(new Person("marry",30,6));
    	  data.add(new Person("zhang",50,18));
    	  data.add(new Person("jay",20,11));
    	  Collections.sort(data, new Comparator<Person>() {
    		  public int compare(Person o1,Person o2) {
    			  if(o1.getAge()-o2.getAge()>0) {
    				  return 1;
    			  }else if(o1.getAge()-o2.getAge()<0) {
    				  return -1;
    			  }else {
    				  return o1.getName().compareTo(o2.getName());
    			  }
    		  }
		});
    	  for(Person p:data) {
    		  System.out.println(p);
    	  }
      }
}

class Person{
	private String name;
	private int age;
	private int id;
	public String getName() {
		return name;
	}
	public Person(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return name+"--"+age+"--"+id;
	}
}