package Pigmap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
思维导图的最基本的窗体实现
软件名称：Z Map 团队名称：无敌团队
开发者 廖仁杰 张凯航 2018年-2019年
电磁场与无线技术1601班 使用软件idea和elipse 图标绘制使用photoshop
 */

/*

此部分分工： 编写者 廖仁杰
 */
public class Windows extends JFrame {
    //建立最基本的窗体用来存放需要的组件

	public  static  void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch(Exception err) {
			err.printStackTrace();
		}

		window = new Windows();//实例化窗口
		s=new Sample();//模板栏
		s.setVisible(false);
		BufferedImage frameicon=null;
		try {
			frameicon=ImageIO.read(window.getClass().getResource("frameicon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		window.setIconImage(frameicon);
		JDialog splash=new JDialog(window,"欢迎使用",true);//欢迎页面
		splash.setUndecorated(true);
		ImageIcon wel=new ImageIcon(window.getClass().getResource("splash.jpg"));
		JLabel welcome=new JLabel(wel);
		welcome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1){
					splash.setVisible(false);
				}
			}
		});
		splash.add(welcome);
		splash.setBounds(340,50,640,650);
		splash.setVisible(true);


	}
	//窗口函数的初始化
	public Windows(){
		//设置窗体的大小
		setSize(1280,720);
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
		img=new Outimg();//保存为图片
		trushpan=new Trush();//删除界面内内容

		cp=getContentPane();//得到容器
		cp.setBackground(Color.WHITE);
		InitMenu();//初始化菜单栏

		MindMap mmp=MindMap.Instance();//引用mindmap
		Sidebar ap= Sidebar.Instance();//右边部分用来显示节点的位置的表格
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
		sp.setDividerLocation(getWidth()/13*2);

		cp.add(sp);
		//设置窗体参数
		setTitle("思维导图 ZMap");
		setVisible(true);


	}


	void InitMenu(){//初始化菜单方法
		JMenuBar menuBar=new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		JMenuItem menuItem;//这里为接下来的menu下拉菜单分配
		JMenu m_file=new JMenu("选择文件");
		m_file.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		menuItem=new JMenuItem("新建");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(nb);
		m_file.add(menuItem);

		menuItem=new JMenuItem("打开");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(op);
		m_file.add(menuItem);

		menuItem=new JMenuItem("保存文件");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(sv);
		m_file.add(menuItem);

		menuItem=new JMenuItem("保存图片");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(img);
		m_file.add(menuItem);

		menuItem=new JMenuItem("退出");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(ex);
		m_file.add(menuItem);

		menuBar.add(m_file);//放入菜单栏
		//在选择文件的下面设置菜单下拉

		JMenu m_edit=new JMenu("编辑");//第二个菜单的名字
		m_edit.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		menuItem=new JMenuItem("生成新主题");
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
		m_help.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		menuItem=new JMenuItem("关于本软件");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(help);
		m_help.add(menuItem);

		menuItem=new JMenuItem("入门指南");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Guide guidemap=new Guide();
				System.out.print(MindMap.panel.getTree().getChildCount(MindMap.panel.getTree().Root()));
			}
		});
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

		menuItem=new JMenuItem("思维导图框架图");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new JFrame();
				frame.setBounds(100,10,800,901);
				JLabel map=new JLabel();
				ImageIcon daotu= new ImageIcon("src/Pigmap/思维导图框架.png");
				map.setIcon(daotu);
				map.setBounds(0,0,800,901);
				frame.add(map);
				frame.setVisible(true);
			}
		});
		m_help.add(menuItem);
		menuBar.add(m_help);

		JMenu m_color=new JMenu("主题背景");
		m_color.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		menuItem=new JMenuItem("默认");
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MindMap.Instance().panel.setBackground(Color.WHITE);
				Sidebar.Instance().setBackground(Color.WHITE);
				Sidebar.pane.setBackground(Color.WHITE);
				background=Color.WHITE;
			}
		});
		m_color.add(menuItem);
		menuItem=new JMenuItem("粉色");
		menuItem.setForeground(Color.PINK);
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MindMap.Instance().panel.setBackground(Color.PINK);
				Sidebar.Instance().setBackground(Color.PINK);
				Sidebar.pane.setBackground(Color.PINK);
				background=Color.PINK;
			}
		});
		m_color.add(menuItem);
		menuItem=new JMenuItem("灰色");
		menuItem.setForeground(Color.GRAY);
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MindMap.Instance().panel.setBackground(Color.GRAY);
				Sidebar.Instance().setBackground(Color.gray);
				Sidebar.pane.setBackground(Color.gray);
				background=Color.GRAY;
			}
		});
		m_color.add(menuItem);
		menuItem=new JMenuItem("黄色");
		menuItem.setForeground(Color.YELLOW);
		menuItem.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MindMap.Instance().panel.setBackground(Color.YELLOW);
				Sidebar.Instance().setBackground(Color.YELLOW);
				Sidebar.pane.setBackground(Color.YELLOW);
				background=Color.YELLOW;
			}
		});
		m_color.add(menuItem);
		menuBar.add(m_color);


		//图标快捷菜单
		JButton getnew=new JButton();
		ImageIcon newmap = new ImageIcon(this.getClass().getResource("new.png"));
		getnew.setBorderPainted(false);
		getnew.setFocusPainted(false);
		getnew.setIcon(newmap);
		getnew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MindMap.Instance().Generate();
			}
		});
		menuBar.add(getnew);

		JButton getblank=new JButton();
		ImageIcon trush = new ImageIcon(this.getClass().getResource("trush.png"));
		getblank.setBorderPainted(false);
		getblank.setFocusPainted(false);
		getblank.setIcon(trush);
		getblank.addActionListener(trushpan);
		menuBar.add(getblank);

		JButton newchild=new JButton();
		ImageIcon newcl = new ImageIcon(this.getClass().getResource("newchild.png"));
		newchild.setBorderPainted(false);
		newchild.setFocusPainted(false);
		newchild.setIcon(newcl);
		newchild.addActionListener(adc);
		menuBar.add(newchild);

		JButton getsample1=new JButton();//模板1
		ImageIcon sam1 = new ImageIcon(this.getClass().getResource("1.png"));
		getsample1.setBorderPainted(false);
		getsample1.setFocusPainted(false);
		getsample1.setIcon(sam1);
		getsample1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.removeAll();
				Sidebar.Reset();
				MindMap.Reset();
				MindMap mmp=MindMap.Instance();
				Sidebar ap= Sidebar.Instance();
				JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
				sp.setDividerLocation(getWidth()/13*2);
				cp.add(sp);
				cp.validate();
				String path=Sample.class.getResource("/xmlsam/first.xml").getPath();
				Tree t= FileManager.Load(path);
				MindMap.Instance().Update(t);
				Sidebar.Instance().Update(t.Root());
			}
		});
		menuBar.add(getsample1);

		JButton getsample2=new JButton();//模板2
		ImageIcon sam2 = new ImageIcon(this.getClass().getResource("3.png"));
		getsample2.setBorderPainted(false);
		getsample2.setFocusPainted(false);
		getsample2.setIcon(sam2);
		getsample2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.removeAll();
				Sidebar.Reset();
				MindMap.Reset();
				MindMap mmp=MindMap.Instance();
				Sidebar ap= Sidebar.Instance();
				JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
				sp.setDividerLocation(getWidth()/13*2);
				cp.add(sp);
				cp.validate();
				String path=Sample.class.getResource("/xmlsam/second.xml").getPath();
				Tree t= FileManager.Load(path);
				MindMap.Instance().Update(t);
				Sidebar.Instance().Update(t.Root());
			}
		});
		menuBar.add(getsample2);

		JButton getsample3=new JButton();//模板3
		ImageIcon sam3 = new ImageIcon(this.getClass().getResource("2.png"));
		getsample3.setBorderPainted(false);
		getsample3.setFocusPainted(false);
		getsample3.setIcon(sam3);
		getsample3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.removeAll();
				Sidebar.Reset();
				MindMap.Reset();
				MindMap mmp=MindMap.Instance();
				Sidebar ap= Sidebar.Instance();
				JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
				sp.setDividerLocation(getWidth()/13*2);
				cp.add(sp);
				cp.validate();
				String path=Sample.class.getResource("/xmlsam/fish.xml").getPath();
				Tree t= FileManager.Load(path);
				MindMap.Instance().Update(t);
				Sidebar.Instance().Update(t.Root());
			}
		});
		menuBar.add(getsample3);

		JButton exit=new JButton();
		ImageIcon out = new ImageIcon(this.getClass().getResource("5.png"));
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setIcon(out);
		exit.addActionListener(ex);
		menuBar.add(exit);

		JButton github=new JButton();
		ImageIcon git = new ImageIcon(this.getClass().getResource("7.png"));
		github.setBorderPainted(false);
		github.setFocusPainted(false);
		github.setIcon(git);
		github.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://github.com/Landers1037/JavaMap");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(github);

		JButton xml=new JButton();//模板按钮
		ImageIcon xmlsam = new ImageIcon(this.getClass().getResource("8.png"));
		xml.setBorderPainted(false);
		xml.setFocusPainted(false);
		xml.setIcon(xmlsam);
		xml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				s.setVisible(true);
				s.setLocation(e.getXOnScreen(),e.getYOnScreen());
			}
		});

		menuBar.add(xml);

		setJMenuBar(menuBar);//设置菜单可见

	}


	//设置调用的函数
	private class  Trush implements ActionListener {//新建一个空白主题
		public void actionPerformed(ActionEvent e) {
			cp.removeAll();//清除屏幕的操作
			MindMap.Reset();
			FileManager.Reset();
			MindMap mmp = MindMap.Instance();//直接获取窗体
			Sidebar ap = Sidebar.Instance();
			MindMap.panel.setBackground(background);
			JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ap, mmp);
			sp.setDividerLocation(getWidth() / 13 * 2);
			cp.add(sp);
			cp.validate();

		}
	}
	private class  NewButton implements ActionListener{//新建一个空白主题
		public  void actionPerformed(ActionEvent e){
			cp.removeAll();//清除屏幕的操作
			MindMap.Reset();
			FileManager.Reset();
			MindMap mmp=MindMap.Instance();//直接获取窗体
			Sidebar ap= Sidebar.Instance();
			JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
			sp.setDividerLocation(getWidth()/13*2);
			cp.add(sp);
			cp.validate();

		}


	}
	private  class Openfile implements  ActionListener{//打开文件
		public void actionPerformed(ActionEvent e){
			cp.removeAll();
			Sidebar.Reset();
			MindMap.Reset();

			MindMap mmp=MindMap.Instance();
			Sidebar ap= Sidebar.Instance();
			JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);


			sp.setDividerLocation(getWidth()/13*2);
			cp.add(sp);
			cp.validate();//清除所有组件初始化

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
				Sidebar.Instance().Update(t.Root());
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
			}


		}
	}
	private class Outimg implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			BufferedImage map=new BufferedImage(MindMap.Instance().panel.getWidth(),MindMap.Instance().panel.getHeight(),BufferedImage.TYPE_INT_RGB);
			Graphics2D g=map.createGraphics();
			MindMap.Instance().panel.printAll(g);
			JFileChooser jfc=new JFileChooser();
			jfc.showSaveDialog(null);
			String path=jfc.getSelectedFile().getPath();
			if(format==null){
				File f=new File(path+".jpg");

				try{
					ImageIO.write(map,"jpg",f);
				}catch(IOException err){
					err.printStackTrace();
				}
			}
			else {
				File f = new File(path + "." + format);


				try {
					ImageIO.write(map, format, f);
				} catch (IOException err) {
					err.printStackTrace();
				}

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
					"使用设备windows 10 Idea2018 & MacBook pro Eclipse photon\n" +
					"本软件已经上传到Github仓库\n" +
					"源代码地址https://github.com/Landers1037/JavaMap\n" +
					"\n" +
					"简介：\n" +
					"这是一个简单的思维导图软件，可以为你提供思维导图的创建，使用“新建主题”来创建一个空的主题或者使用提供的不同模板建立多样的思维导图\n" +
					"思维导图可以保存的格式为XML也可以导出为jpg和png图片\n" +
					"\n" +
					"来自invincible team\n" +

					"\n" +
					"The mind mapping software using Java development\n" +
					"Using JDK version jdk1.8.0 _71 32 bit\n" +
					"Using device windows 10 Idea2018 & MacBook pro Eclipse by photon\n" +
					"This software has been pushed to Github\n" +
					"Source code address is https://github.com/Landers1037/JavaMap\n"+
					"\n" +
					"Brief introduction:\n" +
					"This is a simple mind mapping software, can provide you with the creation of mind maps, use the \"new topic\" to create an empty or use the theme of the \"tree\", \"linear\" to create a template\n" +
					"The mind map saved as XML format or jpg and png \n"+
					"Copyright HUST Liao&Zhang Invincible Team 2018\n" ,"软件信息",JOptionPane.INFORMATION_MESSAGE);
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
			Sidebar.Instance().Update(tree.Root());
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
			Sidebar.Instance().Update(tree.Root());
		}
	}
	private  class DelNode implements  ActionListener{
		public void actionPerformed(ActionEvent e){
			AddChildTask del=new AddChildTask(Sidebar.Instance().GetTarget(), Sidebar.Instance().GetTarget().getText());
			del.delChild();


		}
	}
	public  class AddChild implements  ActionListener{
		public void actionPerformed(ActionEvent e){
			String str=JOptionPane.showInputDialog(window,"建立子节点","");
			AddChildTask add=new  AddChildTask(Sidebar.Instance().GetTarget(),str);//添加子节点的方法
			add.addChild();

		}
	}
	//定义全局对象组件
	private  static  Windows window;
	private static  Sample s;
	public static String format;
	public static Container cp;
	public static Color background;
	ActionListener nb,op,sv,ex,del,adc,help,mod1,mod2,img,trushpan;//定义监听器
	private static  final long serialVersionUID=1L;

	public static class AddChildTask{
		public AddChildTask(TreeNode target, String name) {
			this.target = target;
			this.name = name;
		}
		public void addChild(){
			if(target==null){
				return;
			}
			target.AddChild(child=new TreeNode(name));
			MindMap.Instance().Update();


		}
		public void delChild(){
			if(target==null){
				return;
			}
			target.Parent().RemoveChild(Sidebar.Instance().GetTarget());

			MindMap.Instance().Update();
			MindMap.Instance().repaint();

		}
		private TreeNode target;
		private TreeNode child;
		private String name;

	}

}




