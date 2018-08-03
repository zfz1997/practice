package myiterator;

public class MyIterator<T> implements Iterator<T> {
   private List<T> list=null;
   private int index=0;
   //访问到容器中元素的当前下标
   //创建一个迭代器对象的时候接收要被迭代的具体的容器对象
   public MyIterator(List<T> list) {
	   this.list=list;
   }
		   @Override
	//判断是否有下一个元素
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index<list.size();
	}
    //取出下一个元素
    public T next(){
    	return (T)list.get(index++);
    }
}
