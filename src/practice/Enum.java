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
//��jvmȥ����ʹ��ö�����ʱ�򣬻�Ԥ�ȴ������ö�����͵Ķ����ⲿ��ʹ��	
//public static final Color RED=new Color();
//public static final Color BLUE=new Color();
//public static final Color YELLOW=new Color();
	enum Color
{    
	
	RED,BLUE,YELLOW;//ö�����͵�ֵ������Ϊ��һ��������
		private Color()
		{
			System.out.println("���췽��");
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
