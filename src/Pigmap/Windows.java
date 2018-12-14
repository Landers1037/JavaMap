package Pigmap;
//有一个问题是为什么在jfame上添加画笔就会被覆盖无法绘图

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.annotation.Target;

/*
思维导图的最基本的窗体实现
 */
public class Windows extends JFrame {
    //建立最基本的窗体用来存放需要的组件

	public  static  void main(String args[]) {
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch(Exception err) {
			err.printStackTrace();
		}

		window = new Windows();//实例化窗口

	}
	//窗口函数的初始化
	public Windows(){
		//设置窗体的大小
		setSize(1280,960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		nb=new NewButton();//新建空白主题
		op=new Openfile();//打开
		sv=new Save();//保存
		ex=new Exit();//退出
		del=new DelNode();//删除节点
		help=new Help();//如何使用
		adc=new AddChild();//添加子节点
		mod1=new Treelike();//树形图
		mod2=new Linelike();//流线图


		cp=getContentPane();//得到容器
		InitMenu();//初始化菜单栏

		MindMap mmp=MindMap.Instance();//引用mindmap
		Parameter ap= Parameter.Instance();//右边部分用来显示节点的位置的表格
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
		sp.setDividerLocation(getWidth()/5*1);

		cp.add(sp);
		//设置窗体参数
		setTitle("思维导图MindMap");
		setVisible(true);


	}


	void InitMenu(){//初始化菜单方法
		JMenuBar menuBar=new JMenuBar();
		JMenuItem menuItem;//这里为接下来的menu下拉菜单分配
		JMenu m_file=new JMenu("选择文件");
		m_file.setFont(new Font("华文彩云", Font.PLAIN, 18));

		menuItem=new JMenuItem("新建");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(nb);
		m_file.add(menuItem);

		menuItem=new JMenuItem("打开");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(op);
		m_file.add(menuItem);

		menuItem=new JMenuItem("保存");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(sv);
		m_file.add(menuItem);

		menuItem=new JMenuItem("退出");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(ex);
		m_file.add(menuItem);

		menuBar.add(m_file);//放入菜单栏
		//在选择文件的下面设置菜单下拉

		JMenu m_edit=new JMenu("编辑");//第二个菜单的名字
		m_edit.setFont(new Font("华文彩云", Font.PLAIN, 18));
		menuItem=new JMenuItem("生成主题");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MindMap.Instance().Generate();//这里的作用是什么

			}
		});
		m_edit.add(menuItem);

		menuItem=new JMenuItem("删除节点");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(del);

				//在主类里添加删除的方法
		m_edit.add(menuItem);

		menuItem=new JMenuItem("添加子节点");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(adc);
		m_edit.add(menuItem);

		m_edit.addSeparator();

		menuItem=new JMenuItem("树状图");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(mod1);
		m_edit.add(menuItem);

		menuItem=new JMenuItem("流线图");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(mod2);
		m_edit.add(menuItem);

		menuBar.add(m_edit);//放入菜单栏

		JMenu m_help=new JMenu("帮助");
		m_help.setFont(new Font("华文彩云", Font.PLAIN, 18));

		menuItem=new JMenuItem("关于本软件");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(help);
		m_help.add(menuItem);

		menuItem=new JMenuItem("开发者名单");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(window,"开发者：廖仁杰 张凯航","许可",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		m_help.add(menuItem);
		menuBar.add(m_help);

		setJMenuBar(menuBar);//设置菜单可见

	}
	//设置调用的函数
	private class  NewButton implements ActionListener{//新建一个空白主题
		public  void actionPerformed(ActionEvent e){
			cp.removeAll();//清除屏幕的操作
			MindMap.Reset();
			FileManager.Reset();
			MindMap mmp=MindMap.Instance();//直接获取窗体
			Parameter ap= Parameter.Instance();
			JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
			sp.setDividerLocation(getWidth()/5*1);


			cp.add(sp);
			cp.validate();
			setTitle("MindMap");

		}


	}
	private  class Openfile implements  ActionListener{//打开文件
		public void actionPerformed(ActionEvent e){
			cp.removeAll();
			Parameter.Reset();
			MindMap.Reset();

			MindMap mmp=MindMap.Instance();
			Parameter ap= Parameter.Instance();
			JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,mmp,ap);
			sp.setDividerLocation(getWidth()/5*4);
			cp.add(sp);
			cp.validate();
			setTitle("思维导图");//初始化面板

			JFileChooser jfc=new JFileChooser();
			jfc.setFileFilter(new FileNameExtensionFilter("XML","xml"));
			int manage=jfc.showOpenDialog(null);
			if(manage==JFileChooser.APPROVE_OPTION){
				String path=jfc.getSelectedFile().getPath();//获取路径
				Tree t= FileManager.Load(path);
				if(t==null){
					return;
				}

				MindMap.Instance().Update(t);
				Parameter.Instance().Update(t.Root());
				window.setTitle("思维导图"+path);
			}
		}
	}
	private  class Save implements  ActionListener{//保存
		public void actionPerformed(ActionEvent e){
			String path = FileManager.WorkingFile();
			if(path == null)
			{
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("XML", "xml"));
				int ret = fc.showSaveDialog(null);
				if(ret == JFileChooser.APPROVE_OPTION)
				{
					path = fc.getSelectedFile().getPath();
					if(!path.substring(path.length()-4).equals(".xml"))
						path=path+".xml";
				}
			}
			if(path!=null)
			{
				FileManager.Save(Tree.last_instance, path);
				window.setTitle("MindMap - "+path);
			}


		}
	}
	private  class Exit implements  ActionListener{//退出
		public void actionPerformed(ActionEvent e){
			window.dispatchEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSING));
		}
	}
	private  class Help implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(window,"本思维导图软件使用Java开发实现\n" +
					"使用JDK版本jdk1.8.0_71 32bit\n" +
					"使用设备win10 LTSB Idea2018 & MacBook pro Eclipse photon\n" +
					"本软件已经使用MIT License许可证，开源鼓励有创新精神的开发者共同学习进步\n" +
					"源代码地址https://github.com/Landers1037/JavaMap\n" +
					"\n" +
					"简介：\n" +
					"这是一个简单的思维导图软件，可以为你提供思维导图的创建，使用“新建主题”来创建一个空的主题或者使用“树状图”，“线性图”来创建模板\n" +
					"本思维导图保存的格式为XML\n" +
					"\n" +
					"永远相信自己不是一个菜逼！\n" +

					"\n" +
					"The mind mapping software using Java development\n" +
					"Using JDK version jdk1.8.0 _71 32 bit\n" +
					"Using device win10 LTSB Idea2018 & MacBook pro Eclipse by photon\n" +
					"This software has been used MIT License, open source to encourage innovative developers common learning progress\n" +
					"\n" +
					"Brief introduction:\n" +
					"This is a simple mind mapping software, can provide you with the creation of mind maps, use the \"new topic\" to create an empty or use the theme of the \"tree\", \"linear\" to create a template\n" +
					"The mind map saved as XML format \n"+
					"Copyright HUST Liao&Zhang InvincibleTeam 2018\n" );
		}
	}
	private  class Treelike implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//树状图的mod1
			String mod1 = "1\n" +
					"	2\n" +
					"	3\n" +
					"	4\n";
			Tree tree = new Tree();
			tree.Parse(mod1,new Vec2(300,100));
			MindMap.Instance().Update(tree);
			Parameter.Instance().Update(tree.Root());
		}
	}
	private  class Linelike implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//树状图的mod1
			String mod2 = "1\n" +
					"	2\n" +
					"		3\n" +
					"			4\n";
			Tree tree = new Tree();
			tree.Parse(mod2,new Vec2(300,100));
			MindMap.Instance().Update(tree);
			Parameter.Instance().Update(tree.Root());
		}
	}
	private  class DelNode implements  ActionListener{
		public void actionPerformed(ActionEvent e){
			DelchildTask del=new DelchildTask(Parameter.Instance().GetTarget());
			MindMap.Instance().remove(Parameter.Instance().GetTarget());


		}
	}
	private  class AddChild implements  ActionListener{
		public void actionPerformed(ActionEvent e){
			String str=JOptionPane.showInputDialog(window,"建立子节点","");
			AddChildTask add=new AddChildTask(Parameter.Instance().GetTarget(),str);//添加子节点的方法

		}
	}
	//定义全局对象组件
	private  static  Windows window;
	private Container cp;
	ActionListener nb,op,sv,ex,del,adc,help,mod1,mod2;//定义监听器
	private static  final long serialVersionUID=1L;

}

class DelchildTask{
	public DelchildTask(TreeNode target){
	this.target=target;
	if(target==null){
		return;
	}
	target.RemoveChild(target);
	MindMap.Instance().remove(target);

	MindMap.Instance().Update();
	}
	private TreeNode target;
}
class AddChildTask{
	public AddChildTask(TreeNode target, String name)
	{
		this.target = target;
		this.name = name;
		if(target==null){
			return;
		}
		target.AddChild(child=new TreeNode(name));
		MindMap.Instance().Update();
	}
	private TreeNode target;
	private TreeNode child;
	private String name;

}

