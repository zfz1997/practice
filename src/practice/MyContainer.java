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
	public void add(T obj);//�������������
	public T get(int index);//��ȡָ���±�λ�ô���Ԫ������
	public int size();//����������Ԫ�صĸ���
}

class ArrayList<T> implements IContainer<T>{
	 private Object[] data=null;
	 private int size=0;//��¼����Ԫ�صĸ���
	 public ArrayList() {
		 data=new Object[10];//��ʼ��СΪ10
	 }
	 public ArrayList(int capacity) {
		 data=new Object[capacity];//ָ�������Ĵ�С
	 }
	 public void add(T obj) {
		//�ж�Ԫ�صĸ����Ƿ��Ѿ�������������������
		 //Ӧ�ö�������������
		 ensureCapacity(size+1);
		 data[size++]=obj;
		 }
	 
	 private void ensureCapacity(int capacity) {
		 if(capacity>data.length) {
			 int oldCapacity=data.length;//��ȡԭ�����������Ĵ�С
			 int newCapacity=oldCapacity+(oldCapacity>>1);//����Ϊԭ��������1.5��
			 data=Arrays.copyOf(data, newCapacity);//��ԭ�������е����ݿ������´�����������
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