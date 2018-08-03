package myiterator;

public interface List<T> {
	public void add(T obj);//给具体的容器添加元素
	public T get(int index);//获取指定位置上的数据
	public int size();//获得容器中的元素个数
	public Iterator<T> iterator();//得到具体的迭代器对象

}
