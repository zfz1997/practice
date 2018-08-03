package myiterator;

public class ArrayList<T> implements List<T> {
    private Object[] obj=null;//����һ��object���͵�����
    private int index;//������±�
    private int size;//��¼������Ԫ�صĸ���
    
    public ArrayList() {
   	 obj=new Object[10];
   	 index=0;
   	 size=0;
    }
    public void add(T obj) {
   	 this.obj[index++]=obj;//�������ŵ�������
   	 size++;//Ԫ�صĸ�����1
    }
    @SuppressWarnings("unchecked")
	public T get(int index) {
   	 return (T)this.obj[index];
    }
    public int size() {
   	 return size;
    }
    public Iterator<T> iterator() {
   	 return new MyIterator<T>(this);
    }
    
    
    
    
    
    
}