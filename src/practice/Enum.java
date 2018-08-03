package practice;

public class Enum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            System.out.println(Color.BLUE);
            Color[] colors=Color.values();
            for(Color color:colors)
            {
            	System.out.println(color);
            }
            Person[] persons=Person.values();
            for(Person person:persons)
            {
            	System.out.println(person);
            }
	}
//当jvm去加载使用枚举类的时候，会预先创建多个枚举类型的对象供外部类使用	
//public static final Color RED=new Color();
//public static final Color BLUE=new Color();
//public static final Color YELLOW=new Color();
	enum Color
{    
	
	RED,BLUE,YELLOW;//枚举类型的值必须作为第一条语句出现
		private Color()
		{
			System.out.println("构造方法");
		}
}
	
	enum Person
	{   
		P1("zs",30),P2("lisi",20),P3("wangwu",40);
		private String name;
		private int age;
		private Person(String name,int age)
		{
			this.name=name;
			this.age=age;
		}
		public String toString()
		{
			return name+"--"+age;
		}
	}
}
