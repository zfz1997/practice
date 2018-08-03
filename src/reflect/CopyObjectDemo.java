package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CopyObjectDemo {
     public static void main(String[] args)
     {  //2����һ��ѧ�����󣨱����Ƶ��Ǹ�����Դ����
    	 Student stu=new Student(1,"����",30);
    	 try {
			Student stu2=(Student)ObjectCopyUtil.copyObj(stu);
			System.out.println("��ֵ����ɹ�");
			System.out.println(stu2.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
/**
 * ����һ����������Ĺ����࣬�ڲ��ṩ��һ��Copy����ķ���������Դ����
 * @author asus
 *
 */
class ObjectCopyUtil{
	public static  Object copyObj(Object obj) throws Exception {
		//3��ȡStudent��������Ӧ���͵�class����Ҳ����Student���������Ӧ��class����
		Class<?> classType=obj.getClass();
		//4ͨ��Class�����newInstance����������һ��Ŀ�����
		Object objRes=classType.newInstance();
		//5��ȡClass�����get��set����
		for(Field field:classType.getDeclaredFields()) {
			//�õ����Զ�Ӧ��get��set����
			String getMethodName="get"+field.getName().substring(0,1).
					toUpperCase()+field.getName().substring(1);//getId
			String setMethodName="set"+field.getName().substring(0,1).
					toUpperCase()+field.getName().substring(1);//setId
			//����Դ�����get������ȡ����ֵ
			Method getMethod=classType.getDeclaredMethod(getMethodName, new Class[] {});
			Object value=getMethod.invoke(obj, new Object[] {});
			//����Ŀ������set�����������Ը�ֵ
			Method setMethod=classType.getDeclaredMethod(setMethodName, new Class[] {field.getType()});
			setMethod.invoke(objRes,new Object[] {value});
		}
		return objRes;
	}
}

//1����һ��ѧ����
class Student{
	private int id;
	private String name;
	private int age;
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Student()
	{
		
	}
	public String toString()
	{
		return "id:"+id+" name:"+name+" age:"+age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
}