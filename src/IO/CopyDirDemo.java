package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDirDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
			CopyDirUtil.copyDir(new File("d:\\aaa"), new File("d:\\bbb"));
			System.out.println("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}

class CopyDirUtil{
	public static void copyDir(File src,File dst)throws IOException{
		dst.mkdirs();//创建目标文件夹
		
		if(src!=null) {
			File[] files=src.listFiles();//遍历源文件夹中的所有文件或目录
			if(files!=null) {
				for(File f:files) {
					if(f.isFile()) {
						//复制文件
						FileInputStream fis=new FileInputStream(f);
						FileOutputStream fos=new FileOutputStream(
						dst.getAbsolutePath()+"\\"+f.getName()		);
						byte[] buff=new byte[1024*1024];
						int len=0;//保存的是读到的字节个数
						while((len=fis.read(buff))!=-1) {
							fos.write(buff,0,len);
						}
						fis.close();
						fos.close();
					}else {
						copyDir(f,new File(dst.getAbsolutePath()+"\\"+f.getName()));
					}
				}
			}
			
		}else
			System.out.println("文件不存在");
	}
}