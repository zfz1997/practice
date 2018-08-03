package practice;

import java.util.Random;



public class ExceptionTest {
	 public static void main(String args[])
	   {
	     Worker worker=new Worker();
	     Doctor doctor=new Doctor();
	   try
	   {
		   worker.work();
	   }
	   catch(SickException e)
	   {
		   System.out.println(e.getMessage());
		   doctor.cure(worker);
		   if(worker.getStatus().equals("����"))
		   {
			   System.out.println("��ϲ����Իָ���");
		   }
		   else
		   {
			   System.out.println("sorry,�Ҿ�����");
		   }
	   }
}
}

 class Worker
{
	private String status;
	public void setStatus(String status)
	{
		this.status=status;
	}
	public String getStatus()
	{
		return status;
	}
	public void work()throws SickException
	{
		Random random=new Random();
		int rad=random.nextInt(3)+1;
		if(rad==1)
		{
			throw new SickException("���в�");
		}
		else
		{
			System.out.println("���彡������������");
		}
	}
}

@SuppressWarnings("serial")
class SickException extends Exception
{
	private String message;
	public SickException(String message)
	{
		this.message=message;
	}
	public String getMessage()
	{
		return message;
	}
}

class Doctor
{
	public void cure(Worker worker)
	{
		Random random=new Random();
		int rad=random.nextInt(2)+1;
		if(rad==1)
		{
			worker.setStatus("����");
		}
		else
		{
			worker.setStatus("����");
		}
	}
}




