package myiterator;

public class MyIterator<T> implements Iterator<T> {
   private List<T> list=null;
   private int index=0;
   //���ʵ�������Ԫ�صĵ�ǰ�±�
   //����һ�������������ʱ�����Ҫ�������ľ������������
   public MyIterator(List<T> list) {
	   this.list=list;
   }
		   @Override
	//�ж��Ƿ�����һ��Ԫ��
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index<list.size();
	}
    //ȡ����һ��Ԫ��
    public T next(){
    	return (T)list.get(index++);
    }
}
