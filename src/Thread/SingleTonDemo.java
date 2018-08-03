package Thread;

public class SingleTonDemo {
     public static void main(String[] args) {
    	 
     
	    SThread sThread=new SThread();
	    Thread t1=new Thread(sThread);
	    t1.start();
	    Thread t2=new Thread(sThread);
	    t2.start();
     }
}
class SThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SingleTon.getInstance();
	}
	
}
class SingleTon{
	private static SingleTon singleTon=null;
	private SingleTon() {
		System.out.println("µ¥ÀýÄ£Ê½");
	}
	public static SingleTon getInstance() {
		if(singleTon==null) {
			
		
			synchronized(SingleTon.class) {
			if(singleTon==null){
				singleTon=new SingleTon();
			}
		}
		}
		return singleTon;
	}
}