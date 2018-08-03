package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class practice {
       
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception, IllegalAccessException {
		Student stu=new Student(1,"¸£¸ç",20);
		Class<?> a=stu.getClass();
		
		Object obj=a.newInstance();
		Field field[]=a.getDeclaredFields();
		int b=field.length;
		System.out.println(b);
		System.out.println(field[0].getName());
		Method getMethod=a.getDeclaredMethod("getId", new Class[] {});
		Object value=getMethod.invoke(stu, new Object[] {});
		Method setMethod=a.getDeclaredMethod("setId",  new Class[] {field[0].getType()});
		setMethod.invoke(obj, new Object[] {value});
		Student stu2=(Student) obj;
		System.out.println(stu2.toString());
		
		
	}

}




     