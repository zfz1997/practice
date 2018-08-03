package myiterator;

public class ArrayList<T> implements List<T> {
    private Object[] obj=null;//声明一个object类型的数组
    private int index;//数组的下标
    private int size;//记录数组中元素的个数
    
    public ArrayList() {
   	 obj=new Object[10];
   	 index=0;
   	 size=0;
    }
    public void add(T obj) {
   	 this.obj[index++]=obj;//把数组存放到数组中
   	 size++;//元素的个数加1
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