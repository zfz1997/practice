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
	private static int level=0;//层级数
	public static void IteratorDir(File file) {
		if(file!=null) {
			//找出递归的出口
			//假设是文件或者是空文件夹就返回
			if(file.isFile()||file.listFiles().length==0) {
				return;
			}else {
				File[] files=file.listFiles();
				//要求是先输出文件夹再输出文件
				files=sort(files);
				for(File f:files) {
					//这是一个动态字符串
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
				    //假如是文件夹
					if(f.isDirectory()) {
						level++;//进入目录遍历，层级加1
						IteratorDir(f);//递归调用遍历目录的方法
						level--;//目录层级减一，返回上一级目录继续打印输出
					}
					
				}
				
			}
		}
	}
	/**
	 * 对File类型的数组进行先目录后文件的排列
	 * @param files
	 * @return
	 */
	private static File[] sort(File[] files) {
		List<File> fList=new ArrayList<File>();
		//先存放文件夹（目录)
		for(File f:files) {
			if(f.isDirectory()) {
				fList.add(f);
			}
			
		}
		//再存放文件
		for(File f:files) {
			if(f.isFile()){
				fList.add(f);
			}
		}
		//把集合中的元素转换成指定大小和指定类型的数组
		return fList.toArray(new File[fList.size()]);
	}
	//就是根据层级数来得到\t个数
	private static String getTab(int level) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<level;i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}