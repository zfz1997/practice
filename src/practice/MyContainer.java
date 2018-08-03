package practice;

import java.util.Arrays;

public class MyContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
		IContainer<String> list=new ArrayList<String>();
        for(int i=0;i<12;i++) {
        	list.add("data:"+(i+1));
        }
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i));
        }
	}

}

interface IContainer<T>{
	public void add(T obj);//给容器添加数据
	public T get(int index);//获取指定下标位置处的元素内容
	public int size();//返回容器中元素的个数
}

class ArrayList<T> implements IContainer<T>{
	 private Object[] data=null;
	 private int size=0;//记录容器元素的个数
	 public ArrayList() {
		 data=new Object[10];//初始大小为10
	 }
	 public ArrayList(int capacity) {
		 data=new Object[capacity];//指定容器的大小
	 }
	 public void add(T obj) {
		//判断元素的个数是否已经超过了容器，超过了
		 //应该对容器进行扩容
		 ensureCapacity(size+1);
		 data[size++]=obj;
		 }
	 
	 private void ensureCapacity(int capacity) {
		 if(capacity>data.length) {
			 int oldCapacity=data.length;//获取原有数组容量的大小
			 int newCapacity=oldCapacity+(oldCapacity>>1);//扩容为原有容量的1.5倍
			 data=Arrays.copyOf(data, newCapacity);//把原有数组中的数据拷贝到新创建的数组中
		 }
	 }
	 @SuppressWarnings("unchecked")
	public T get(int index) {
		 return (T)data[index];
	 }
	public int size() {
		return size;
	}
	 
}