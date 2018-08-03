package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePadDemo {
    public static void main(String[] args) {
    	new MyFrame("记事本");
    }
}

@SuppressWarnings("serial")
class MyFrame extends JFrame{
	private JTextArea tv_area=null;
	private JScrollPane s_pane=null;//带滚动条的面板
	private JMenuBar mb=null;//菜单栏
	private JMenu m_file=null;
	private JMenu m_help=null;
	private JMenuItem item_new=null;
	private JMenuItem item_open=null;
	private JMenuItem item_exit=null;
	private JMenuItem item_about=null;
	public MyFrame(String title) {
		super(title);
		init();
		registerListener();
	}
	private void init() {
		tv_area=new JTextArea();
		s_pane=new JScrollPane(tv_area);
		s_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Container cpane=this.getContentPane();
		cpane.add(s_pane,BorderLayout.CENTER);
		this.setSize(500,300);
		mb=new JMenuBar();
		m_file=new JMenu("文件");
		item_new=new JMenuItem("新建");
		item_open=new JMenuItem("打开");
		item_exit=new JMenuItem("退出");
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_exit);
		m_help=new JMenu("帮助");
		item_about=new JMenuItem("关于");
		m_help.add(item_about);
		mb.add(m_file);
		mb.add(m_help);
		this.setJMenuBar(mb);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口居中显示
		//定义一个工具包
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth=screenSize.width;//获得屏幕的宽度
		int screenHeight=screenSize.height;//获得屏幕的高度
	    int windowWidth=this.getWidth();//获得当前窗体的宽度
		int windowHeight=this.getHeight();//获得当前窗体的高度
		this.setLocation((screenWidth-windowWidth)/2, (screenHeight-windowHeight)/2);
		this.setVisible(true);
	}
	private void registerListener() {
		item_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				newFile();
			}
		});
		item_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openFile();
			}
		});
		item_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				exit();
			}
		});
		item_about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AboutDialog(MyFrame.this,"关于-记事本",true);
			}
		});
	}
	
	
	
	
	//新建的功能
	private void newFile() {
		if(!tv_area.getText().equals("")) {
			int res=JOptionPane.showConfirmDialog(null,"是否保存","提示信息",
					JOptionPane.YES_NO_OPTION );
			if(res==JOptionPane.YES_OPTION) {
				//文件保存对话框
				FileDialog fd=new FileDialog(this,"保存文件",FileDialog.SAVE);
				fd.setVisible(true);
			}else {
				tv_area.setText("");//清空记事本中的内容
			}
		}
	}
	private void openFile() {
		FileDialog fd=new FileDialog(this,"打开文件",FileDialog.LOAD);
		fd.setVisible(true);
	}
	private void exit() {
		newFile();
		System.exit(0);
	}
}

@SuppressWarnings("serial")
class AboutDialog extends JDialog{
	 private JLabel desc=null;
	 private JPanel panel=null;
	 private JButton btn=null;
	 public AboutDialog(Frame frame,String title,boolean modal) {
		 
		 super(frame,title,modal);
		 init();
		 registerListener();
	 }
	 private void init() {
		   desc=new JLabel();
		   desc.setText("<html>这是一个自定义的记事本，开发初期阶段，还得<br/>大家多多指教</html>");
		   desc.setHorizontalAlignment(JLabel.CENTER);
		   panel=new JPanel();
		   btn=new JButton("ok");
		   panel.add(btn);
		   this.add(desc);//默认放在边界布局管理器的中间
		   this.add(panel,BorderLayout.SOUTH);
		   this.setSize(300,200);
		   
		}
	 private void registerListener() {
		 btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 AboutDialog.this.dispose();//退出对话框
			 }
		 });
		 Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension screenSize=kit.getScreenSize();
			int screenWidth=screenSize.width;//获得屏幕的宽度
			int screenHeight=screenSize.height;//获得屏幕的高度
		    int dialogWidth=this.getWidth();//获得当前窗体的宽度
			int dialogHeight=this.getHeight();//获得当前窗体的高度
			this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
		 this.setVisible(true);
	 }
}

