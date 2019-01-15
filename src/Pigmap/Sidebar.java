package Pigmap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
此部分分工 廖仁杰
 */



//侧边栏类

public class Sidebar extends JPanel
{	public static JTextArea pane;
	public static Sidebar Instance()
	{
		if(instance == null)
			instance = new Sidebar();
		return instance;
	}
	public static void Reset()
	{
		instance = null;
	}

	public void Apply()
	{
		btn.doClick();
	}

	public void Update(TreeNode node)
	{
		target=node;

	}

	public TreeNode GetTarget()
	{
		return target;

	}

	private Sidebar()
	{
		setLayout(null);
		setBackground(Color.WHITE);
		//ImageIcon img=new ImageIcon(this.getClass().getResource("icon.png"));//软件图标
		ImageIcon img1=new ImageIcon(this.getClass().getResource("open.png"));
		ImageIcon img2=new ImageIcon(this.getClass().getResource("pic.png"));
		ImageIcon img3=new ImageIcon(this.getClass().getResource("set.png"));
		JLabel j=new JLabel();
		j.setText("  Z Map");//软件名称
		j.setFont(new Font("Comic Sans Ms",Font.BOLD,40));
		JLabel version=new JLabel();
		version.setText("version 1.12.4 beta");//版本号
		version.setBounds(10,600,192,20);
		j.setBounds(0,0,192,192);
		JButton j1=new JButton(img1);//打开本地文件
		j1.setBorderPainted(false);
		j1.setBounds(0,480,64,64);
		JButton j2=new JButton(img2);//保存图片
		j2.setBorderPainted(false);
		j2.setBounds(66,480,64,64);
		JButton j3 =new JButton(img3);//快捷设置
		j3.setBorderPainted(false);
		j3.setBounds(132,480,64,64);

		add(j);
		add(j1);
		add(j2);
		add(j3);
		add(version);
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Windows.cp.removeAll();
				Sidebar.Reset();
				MindMap.Reset();
				MindMap mmp=MindMap.Instance();
				Sidebar ap= Sidebar.Instance();
				JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ap,mmp);
				sp.setDividerLocation(Windows.cp.getWidth()/13*2);
				Windows.cp.add(sp);
				Windows.cp.validate();
				//初始化面板

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
		});
		j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedImage map=new BufferedImage(MindMap.Instance().panel.getWidth(),MindMap.Instance().panel.getHeight(),BufferedImage.TYPE_INT_RGB);
				Graphics2D g=map.createGraphics();
				MindMap.Instance().panel.printAll(g);
				JFileChooser jfc=new JFileChooser();
				jfc.showSaveDialog(null);
				String path=jfc.getSelectedFile().getPath();
				if(Windows.format==null){
					File f=new File(path+"."+"jpg");
					try{
						ImageIO.write(map,"jpg",f);
					}catch(IOException err){
						err.printStackTrace();
					}
				}
				else{
					File f=new File(path+"."+Windows.format);

				try{
					ImageIO.write(map,Windows.format,f);
				   }catch(IOException err){
					err.printStackTrace();
				   }
			    }
			}
		});
		j3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				ImageIcon theme=new ImageIcon(this.getClass().getResource("theme.png"));
				ImageIcon geshi=new ImageIcon(this.getClass().getResource("geshi.png"));
				JLabel yanse=new JLabel(theme);//新建一个主题的图标
				yanse.setBounds(20,5,64,64);
				JLabel picf=new JLabel(geshi);//新建一个格式的图标
				picf.setBounds(140,5,64,64);

				JFrame f1=new JFrame("设置");
				f1.setSize(300,300);
				f1.setLocation(300,150);
				f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JPanel setting=new JPanel();
				setting.setSize(300,300);
				setting.setBackground(Color.WHITE);
				//添加设置项
				setting.setLayout(null);
				//添加一个button组
				ButtonGroup bg1=new ButtonGroup();
				ButtonGroup bg2=new ButtonGroup();
				JRadioButton white=new JRadioButton("默认");
				white.setFont(new Font("微软雅黑",Font.PLAIN,18));
				white.setBounds(20,75, 75,30);
				JRadioButton pink=new JRadioButton("粉色");
				pink.setFont(new Font("微软雅黑",Font.PLAIN,18));
				pink.setBounds(20,106, 75,30);
				JRadioButton gray=new JRadioButton("灰色");
				gray.setFont(new Font("微软雅黑",Font.PLAIN,18));
				gray.setBounds(20,137, 75,30);
				JRadioButton yellow=new JRadioButton("黄色");
				yellow.setFont(new Font("微软雅黑",Font.PLAIN,18));
				yellow.setBounds(20,168, 75,30);

				JRadioButton jpg=new JRadioButton("保存为JPG");
				jpg.setFont(new Font("微软雅黑",Font.PLAIN,18));
				jpg.setBounds(130,75, 130,30);

				JRadioButton png=new JRadioButton("保存为PNG");
				png.setFont(new Font("微软雅黑",Font.PLAIN,18));
				png.setBounds(130,106, 130,30);

				bg1.add(white);
				bg1.add(pink);
				bg1.add(gray);
				bg1.add(yellow);

				bg2.add(jpg);
				bg2.add(png);

				setting.add(white);
				setting.add(pink);
				setting.add(gray);
				setting.add(yellow);
				setting.add(jpg);
				setting.add(png);

				setting.add(yanse);
				setting.add(picf);
				//添加颜色的监听
				white.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MindMap.panel.setBackground(Color.WHITE);
						Sidebar.Instance().setBackground(Color.WHITE);
						Sidebar.pane.setBackground(Color.WHITE);
						Windows.background=Color.WHITE;
						repaint();
					}
				});
				pink.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MindMap.panel.setBackground(Color.PINK);
						Sidebar.Instance().setBackground(Color.PINK);
						Sidebar.pane.setBackground(Color.PINK);
						Windows.background=Color.PINK;
						repaint();
					}
				});
				gray.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MindMap.panel.setBackground(Color.GRAY);
						Sidebar.Instance().setBackground(Color.GRAY);
						Sidebar.pane.setBackground(Color.GRAY);
						Windows.background=Color.GRAY;
						repaint();
					}
				});
				yellow.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MindMap.panel.setBackground(Color.YELLOW);
						Sidebar.Instance().setBackground(Color.YELLOW);
						Sidebar.pane.setBackground(Color.YELLOW);
						Windows.background=Color.YELLOW;
						repaint();
					}
				});
				jpg.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Windows.format="jpg";
					}
				});
				png.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Windows.format="png";
					}
				});
				f1.add(setting);
				f1.setVisible(true);
				Windows.cp.add(f1);

			}
		});


		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd  "+"HH:mm\n");//获取系统的时间
		String time=new String(date.format(new Date()));
		String label_strings =time;
		pane=new JTextArea(5,10);
		pane.setBackground(Color.WHITE);
		pane.setForeground(Color.BLACK);
		pane.setText(label_strings);

		pane.setFont(new Font("微软雅黑",Font.PLAIN,14));
		pane.setEditable(false);
		pane.setBounds(10,580,192,60);
		add(pane);

		JLabel tag=new JLabel();
		tag.setText("欢迎使用");
		JLabel tag1=new JLabel();
		tag1.setText("开始自己的思维导图");
		JLabel tag2=new JLabel();
		tag2.setText("：)");

		tag.setFont(new Font("宋体",Font.BOLD,30));
		tag.setBounds(30,200,192,50);
		add(tag);
		tag1.setFont(new Font("宋体",Font.BOLD,20));
		tag1.setBounds(0,250,192,30);
		add(tag1);
		tag2.setFont(new Font("微软雅黑",Font.BOLD,60));
		tag2.setBounds(50,280,192,100);
		add(tag2);




	}
	private static Sidebar instance;
	private static final long serialVersionUID = 1L;

	private JButton btn;
	private TreeNode target;
}