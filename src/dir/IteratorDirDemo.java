package dir;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IteratorDirDemo {
   public static void main(String[] args) {
	   IteratorUtil.IteratorDir(new File("d:/JAVA"));
   }
}



class IteratorUtil{
	private static int level=0;//�㼶��
	public static void IteratorDir(File file) {
		if(file!=null) {
			//�ҳ��ݹ�ĳ���
			//�������ļ������ǿ��ļ��оͷ���
			if(file.isFile()||file.listFiles().length==0) {
				return;
			}else {
				File[] files=file.listFiles();
				//Ҫ����������ļ���������ļ�
				files=sort(files);
				for(File f:files) {
					//����һ����̬�ַ���
					StringBuilder sb=new StringBuilder();
					if(f.isFile()) {
						/*sb.append(getTab(level));
						sb.append(f.getName());*/
						System.out.print(getTab(level));
						System.out.print(f.getName());
						
					}else {
						/*sb.append(getTab(level));
						sb.append(f.getName());
						sb.append("\\");*/
						System.out.print(getTab(level));
						System.out.print(f.getName());
						System.out.print("\\");
					}
//					System.out.println(sb.toString());
					System.out.println();
				    //�������ļ���
					if(f.isDirectory()) {
						level++;//����Ŀ¼�������㼶��1
						IteratorDir(f);//�ݹ���ñ���Ŀ¼�ķ���
						level--;//Ŀ¼�㼶��һ��������һ��Ŀ¼������ӡ���
					}
					
				}
				
			}
		}
	}
	/**
	 * ��File���͵����������Ŀ¼���ļ�������
	 * @param files
	 * @return
	 */
	private static File[] sort(File[] files) {
		List<File> fList=new ArrayList<File>();
		//�ȴ���ļ��У�Ŀ¼)
		for(File f:files) {
			if(f.isDirectory()) {
				fList.add(f);
			}
			
		}
		//�ٴ���ļ�
		for(File f:files) {
			if(f.isFile()){
				fList.add(f);
			}
		}
		//�Ѽ����е�Ԫ��ת����ָ����С��ָ�����͵�����
		return fList.toArray(new File[fList.size()]);
	}
	//���Ǹ��ݲ㼶�����õ�\t����
	private static String getTab(int level) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<level;i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}