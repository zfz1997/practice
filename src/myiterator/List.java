package myiterator;

public interface List<T> {
	public void add(T obj);//��������������Ԫ��
	public T get(int index);//��ȡָ��λ���ϵ�����
	public int size();//��������е�Ԫ�ظ���
	public Iterator<T> iterator();//�õ�����ĵ���������

}
