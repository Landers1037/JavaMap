package Pigmap;

import Pigmap.Windows.AddChildTask;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.LinkedList;


import static Pigmap.MindMap.panel;
import static Pigmap.TreeNode.Moveall;
/*
此部分分工
树tree的设置：廖仁杰
节点treenode的属性设置（大小，背景，链接，备注，图标） 廖仁杰
节点treenode的移动，添加，删除，获取节点的信息         张凯航
鼠标移动监听：张凯航
鼠标点击，进入离开监听：廖仁杰
链接添加：廖仁杰
 */


//使用树结构的节点类

public class Tree implements TreeModel//创建的树结构
{
	public static Tree last_instance;
	public static Tree LastInstance()//用来获取树的方法
	{
		if(last_instance == null)
			last_instance = new Tree();
		return last_instance;
	}

	public Tree()
	{
		last_instance = this;
	}

	public void addTreeModelListener(TreeModelListener arg0) {}
	public void removeTreeModelListener(TreeModelListener l) {}
	public void valueForPathChanged(TreePath path, Object newValue) {}
	public Object getChild(Object arg0, int arg1) {
		TreeNode node = (TreeNode)arg0;
		return node.getList().get(arg1);
	}
	public int getChildCount(Object parent) {
		TreeNode node = (TreeNode)parent;
		return node.getList().size();
	}
	public int getIndexOfChild(Object parent, Object child) {
		TreeNode node = (TreeNode)parent;
		return node.getList().indexOf(child);
	}
	public boolean isLeaf(Object node) {
		TreeNode tnode = (TreeNode)node;
		return tnode.getList().size()==0;
	}
	public void Draw(Graphics g)
	{
		root.Draw(g);
	}
	public TreeNode getRoot()
	{
		return Root();
	}
	public void SetRoot(TreeNode root)
	{
		this.root = root;
	}

	public TreeNode Root()
	{
		return root;
	}
	public void Parse(String s, Vec2 root_pos)
	{
		String[] lines = s.split("\n");//定一个字符串数组，把每一个\n作为分隔，把字符导入到数组中
		if(lines.length == 0)
			return;

		root=null;
		TreeNode cur = null;//定义一个树节点cur
		int cur_tc = -1;//定义一个常量与节点比较
		for(String i : lines)
		{
			TreeNode node = new TreeNode(EraseTab(i));//新的一个节点，传入擦除空格方法的参数
			if(TabCnt(i) == cur_tc + 1){//如果空格的数目为0
				if(cur!=null)//如果节点的坐标不为空
				{
					cur.AddChild(node);//创建子节点
					cur = node;
				}
				else
				{
					root = cur = node;//根节点的坐标确立
					root.setLocation((int)root_pos.x, (int)root_pos.y);
				}
				cur_tc = TabCnt(i);
			}
			else if(TabCnt(i)<=cur_tc)//如果空格的数目小于比较的值
			{
				int cnt = TabCnt(i);
				while(cur!=null && cnt++ <= cur_tc)
					cur = cur.Parent();
				if(cur == null)
					return;
				cur.AddChild(node);
				cur=node;
				cur_tc = TabCnt(i);
			}
			else
				return;
		}
	}

	private String EraseTab(String s)//擦除空格方法
	{
		int i=0;
		while(s.charAt(i)=='\t')//获取第i位字符串的字符，如果是空格的话
			i++;
		return s.substring(i);//返回一个子字符串具体参考substring方法
	}
	private int TabCnt(String s)//空格计数方法
	{
		int i = 0;
		while(s.charAt(i) == '\t')//如果是空格就返回空格的数量i
			i++;
		return i;
	}

	private TreeNode root;
}
//节点类
class TreeNode extends JLabel
{
	public static JPopupMenu popupMenu;//右键菜单
	public  static String copy;//节点的文字
	public  static Icon icon;//节点图标
	public  String weblink;//网页链接
	public  String notepad;//备注


	public TreeNode(String s)
	{
		children = new LinkedList<TreeNode>();
		setText(s);
		weblink=null;
		notepad=null;
		Dimension d=new Dimension(s.length()*20,50);
		setOpaque(true);
		setSize(d);
		setHorizontalAlignment(CENTER);
		setFont(new Font("微软雅黑", Font.PLAIN, 18));//设置节点的文字
		MouseInputHandler h = new MouseInputHandler();
		setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		repaint();


		c = getBackground();
		addMouseListener(h);
		addMouseMotionListener(h);
		popupMenu=new JPopupMenu();
		JMenuItem bt=new JMenuItem("修改内容");
		JMenuItem bt1=new JMenuItem("添加节点");
		JMenuItem bt2=new JMenuItem("复制节点");
		JMenuItem bt3=new JMenuItem("粘贴节点");
		JMenu bt4=new JMenu("功能图标");
		JMenu bt5=new JMenu("属性图标");
		JMenu bt6=new JMenu("事件图标");
		JMenuItem bt7=new JMenuItem("删除图标");
		JMenuItem bt8=new JMenuItem("添加备注");
		JMenuItem bt9=new JMenuItem("显示备注");
		JMenuItem bt10=new JMenuItem("删除节点");

		bt4.add(iconSet.Instance().task.m1);
		bt4.add(iconSet.Instance().task.m2);
		bt4.add(iconSet.Instance().task.m3);
		bt4.add(iconSet.Instance().task.m4);
		bt4.add(iconSet.Instance().task.m5);
		bt4.add(iconSet.Instance().task.m6);
		bt4.add(iconSet.Instance().task.m7);
		bt4.add(iconSet.Instance().task.m8);
		bt4.add(iconSet.Instance().task.m9);


		bt5.add(iconSet.Instance().flag.m1);
		bt5.add(iconSet.Instance().flag.m2);
		bt5.add(iconSet.Instance().flag.m3);
		bt5.add(iconSet.Instance().flag.m4);
		bt5.add(iconSet.Instance().flag.m5);
		bt5.add(iconSet.Instance().flag.m6);
		bt5.add(iconSet.Instance().flag.m7);
		bt5.add(iconSet.Instance().flag.m8);
		bt5.add(iconSet.Instance().flag.m9);
		bt5.add(iconSet.Instance().flag.m10);
		bt5.add(iconSet.Instance().flag.m11);
		bt5.add(iconSet.Instance().flag.m12);
		bt5.add(iconSet.Instance().flag.m13);
		bt5.add(iconSet.Instance().flag.m14);
		bt5.add(iconSet.Instance().flag.m15);

		bt6.add(iconSet.Instance().work.m1);
		bt6.add(iconSet.Instance().work.m2);
		bt6.add(iconSet.Instance().work.m3);
		bt6.add(iconSet.Instance().work.m4);
		bt6.add(iconSet.Instance().work.m5);
		bt6.add(iconSet.Instance().work.m6);
		bt6.add(iconSet.Instance().work.m7);
		bt6.add(iconSet.Instance().work.m8);
		bt6.add(iconSet.Instance().work.m9);
		bt6.add(iconSet.Instance().work.m10);
		bt6.add(iconSet.Instance().work.m11);
		bt6.add(iconSet.Instance().work.m12);
		bt6.add(iconSet.Instance().work.m13);
		bt6.add(iconSet.Instance().work.m14);


		bt.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt1.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt2.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt3.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt4.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt5.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt6.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt7.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt8.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt9.setFont(new Font("微软雅黑",Font.BOLD,15));
		bt10.setFont(new Font("微软雅黑",Font.BOLD,15));

		JTextArea textArea=new JTextArea();
		textArea.setSize(160, 60);
		textArea.setFont(new Font("宋体",Font.PLAIN,15));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane jScrollPane=new JScrollPane(textArea);
		jScrollPane.setSize(180,60);
		popupMenu.add(jScrollPane);
		popupMenu.add(bt);
		//popupMenu.addSeparator();
		popupMenu.add(bt1);
		//popupMenu.addSeparator();
		popupMenu.add(bt2);
		//popupMenu.addSeparator();
		popupMenu.add(bt3);
		popupMenu.addSeparator();
		popupMenu.add(bt4);
		//popupMenu.addSeparator();
		popupMenu.add(bt5);
		//popupMenu.addSeparator();
		popupMenu.add(bt6);
		//popupMenu.addSeparator();
		popupMenu.add(bt7);
		panel.add(popupMenu);
		popupMenu.addSeparator();
		popupMenu.add(bt8);
		panel.add(popupMenu);
		//popupMenu.addSeparator();
		popupMenu.add(bt9);
		panel.add(popupMenu);
		popupMenu.addSeparator();
		popupMenu.add(bt10);
		panel.add(popupMenu);
		popupMenu.getComponent();
		popupMenu.setEnabled(true);
		//添加修改的监听
		// TODO 自动生成的方法存根
		bt.addActionListener(new ActionListener() {//添加文本内容到节点

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (Sidebar.Instance().GetTarget() == null)
					return;
				if (textArea.getText().length() == 0) {
					return;
				}
				else if(Sidebar.Instance().GetTarget().getIcon()!=null){
					Sidebar.Instance().GetTarget().setText(textArea.getText());
					Sidebar.Instance().GetTarget().setSize(new Dimension(textArea.getText().length() * 20+32, 50));
					setHorizontalAlignment(CENTER);
				}
				else if(Sidebar.Instance().GetTarget().getIcon()==null){
					Sidebar.Instance().GetTarget().setText(textArea.getText());
					Sidebar.Instance().GetTarget().setSize(new Dimension(textArea.getText().length() * 20, 50));
					setHorizontalAlignment(CENTER);
				}
			}


		});
		//添加第二种增添节点的监听
		bt1.addActionListener(new ActionListener() {//添加节点
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Sidebar.Instance().GetTarget()==null)
					return;
				if(textArea.getText().length()==0)
					return;
				else {
					String str=textArea.getText();
					AddChildTask addChildTask= new AddChildTask(Sidebar.Instance().GetTarget(),str);
					addChildTask.addChild();
					}

				}


		});
		bt2.addActionListener(new ActionListener() {//复制
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Sidebar.Instance().GetTarget()==null)
					return;
				else{
					 copy= Sidebar.Instance().GetTarget().getText();
					 icon= Sidebar.Instance().GetTarget().getIcon();

				}
			}
		});
		bt3.addActionListener(new ActionListener() {//粘贴
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Sidebar.Instance().GetTarget()==null)
					return;
				else{
					AddChildTask addChildTask= new AddChildTask(Sidebar.Instance().GetTarget(),copy);
					addChildTask.addChild();

				}
			}
		});
		bt7.addActionListener(new ActionListener() {//删除图标
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Sidebar.Instance().GetTarget().getIcon()!=null){
				Sidebar.Instance().GetTarget().setIcon(null);
				Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth()-32,50);
				Sidebar.Instance().GetTarget().repaint();
				Sidebar.Instance().GetTarget().setVisible(true);}
				else return;
			}
		});
		bt8.addActionListener(new ActionListener() {//新建备注
			@Override
			public void actionPerformed(ActionEvent e) {
				Note.Instance().setText(null);
				Note.Instance().setNote();
			}
		});
		bt9.addActionListener(new ActionListener() {//显示备注
			@Override
			public void actionPerformed(ActionEvent e) {
				Note.Instance().shownote();
			}
		});
		bt10.addActionListener(new ActionListener() {//删除节点
			@Override
			public void actionPerformed(ActionEvent e) {
				AddChildTask del=new AddChildTask(Sidebar.Instance().GetTarget(), Sidebar.Instance().GetTarget().getText());
				del.delChild();
			}
		});

	}
	//迭代的移动整体节点
	public static void Moveall(TreeNode node,int dx,int dy){
		node.setLocation(node.getX()+dx,node.getY()+dy);
		for(TreeNode child:node.getList()){
			Moveall(child,dx,dy);
		}

	}
	public void Draw(Graphics g)
	{
		int bold = 2;
		((Graphics2D)g).setStroke(new BasicStroke(bold, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for(TreeNode i:children)
			i.Draw(g);

		if(parent == null)
			return;

		g.setColor(Color.BLACK);
		Vec2[] pvs = new Vec2[4];
		Vec2[] cvs = new Vec2[4];
		pvs[0] = new Vec2(parent.getX()+parent.getWidth(), parent.getY()+parent.getHeight()/2);
		pvs[1] = new Vec2(parent.getX()+parent.getWidth()/2, parent.getY()+parent.getHeight());
		pvs[2] = new Vec2(parent.getX(), parent.getY()+parent.getHeight()/2);
		pvs[3] = new Vec2(parent.getX()+parent.getWidth()/2, parent.getY());
		cvs[0] = new Vec2(getX()+getWidth(), getY()+getHeight()/2);
		cvs[1] = new Vec2(getX()+getWidth()/2, getY()+getHeight());
		cvs[2] = new Vec2(getX(), getY()+getHeight()/2);
		cvs[3] = new Vec2(getX()+getWidth()/2, getY());
		Vec2 pv = pvs[0];
		Vec2 cv = cvs[0];
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				if(pvs[i].Sub(cvs[j]).Length() < pv.Sub(cv).Length())
				{
					pv=pvs[i];
					cv=cvs[j];
				}
		g.drawLine((int)pv.x, (int)pv.y, (int)cv.x, (int)cv.y);
	}

	public void AddChild(TreeNode node)
	{
		AddChild(node, true);//shou'dong
	}

	public void AddChild(TreeNode node, boolean auto_positioning)
	{
		if(auto_positioning)
		{
			Point pos = getLocation();//得到当前的位置
			pos.translate(children.size()*150, 150);//用来位移坐标
			node.setLocation(pos);
		}
		node.parent = this;
		this.getList().add(node);
	}

	public void RemoveChild(TreeNode node)
	{
		//node.parent = null;
		node.parent.getList().remove(node);//从链表里面删除节点的信息并且重新绘制


	}

	public TreeNode Parent()
	{
		return parent;
	}

	public LinkedList<TreeNode> getList()
	{
		return children;
	}



	public int MaxX()
	{
		int ret=getX() + getWidth();
		for(TreeNode i:children)
			ret = Math.max(ret, i.MaxX());
		return ret;
	}

	public int MaxY()
	{
		int ret=getY() + getHeight();
		for(TreeNode i:children)
			ret = Math.max(ret, i.MaxY());
		return ret;
	}

	public Color Color()
	{
		return c;
	}

	public void SetColor(Color c)
	{
		this.c=c;
		setBackground(c);
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		if(r+g+b<=0x77*3)
			setForeground(Color.WHITE);
		else
			setForeground(Color.BLACK);
	}


	private Color c;
	private TreeNode parent;
	private LinkedList<TreeNode> children;
	private static final long serialVersionUID = 1L;


}

class MouseInputHandler extends MouseInputAdapter {

	public void mousePressed(MouseEvent e) {
		//if (e.getButton() == MouseEvent.BUTTON1) {
			px = e.getX();
			py = e.getY();
			Component c = (Component) e.getSource();
			ox = c.getX();
			oy = c.getY();
			ow = c.getWidth();
			oh = c.getHeight();

			c.setFocusable(true);
			c.requestFocus();
			Sidebar.Instance().Update((TreeNode) c);//用来更新子节点的位置
		//}

	}


	public void mouseExited(MouseEvent e) {
		//if (e.getButton() == MouseEvent.BUTTON1) {
			Component c = (Component) e.getSource();
			c.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		//}
	}


	public void mouseReleased(MouseEvent e) {
		Component c = (Component) e.getSource();
		int curx = c.getX();
		int cury = c.getY();
		int curw = c.getWidth();
		int curh = c.getHeight();
		c.setLocation(ox, oy);
		c.setSize(ow, oh);
		Fresh fresh = new Fresh(c, curx, cury, curw, curh, ox, oy, ow, oh);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {//右键单击出现菜单
			Component c = (Component) e.getSource();
			TreeNode.popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
		if(e.getButton()==MouseEvent.BUTTON1&&e.getClickCount()==2){//双击出现网址选择框
			JFrame frame=new JFrame("网页链接");
			frame.setUndecorated(true);
			JPanel web=new JPanel();
			web.setBorder(BorderFactory.createBevelBorder(0,Color.BLACK,Color.GRAY));
			web.setLayout(null);
			web.setSize(300,200);
			JTextField link=new JTextField();
			link.setColumns(20);
			link.setEditable(true);

			JLabel putlink=new JLabel();
			JButton addlink=new JButton("添加网址");
			JButton closelink=new JButton("关闭窗口");
			JButton dellink=new JButton("删除网址");

			web.add(link);
			web.add(addlink);
			web.add(closelink);
			web.add(dellink);
			web.add(putlink);
			frame.add(web);
			link.setBounds(10,10,150,30);
			addlink.setBounds(170,10,100,30);
			closelink.setBounds(10,130,120,50);
			dellink.setBounds(150,130,120,50);
			putlink.setBounds(10,60,290,30);
			closelink.setFont(new Font("宋体",Font.PLAIN,18));
			dellink.setFont(new Font("宋体",Font.PLAIN,18));

			if(Sidebar.Instance().GetTarget().weblink!=null) {
				putlink.setForeground(Color.RED);
				putlink.setText(Sidebar.Instance().GetTarget().weblink);
			}
			else putlink.setText("还没有收藏的网址");

			frame.setBounds(Sidebar.Instance().GetTarget().getX()+200, Sidebar.
					Instance().GetTarget().getY()+150,300,200);
			addlink.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Component c = (Component) e.getSource();
					Sidebar.Instance().GetTarget().weblink=link.getText();//网址赋值
					ImageIcon weblink = new ImageIcon("src/iconSet/globe_with_meridians.png");
					Sidebar.Instance().GetTarget().setIcon(weblink);
					Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth()+32,50);
					putlink.setText(link.getText());
					putlink.setForeground(Color.RED);
				}
			});
			putlink.addMouseListener(new MouseAdapter() {//打开网址
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
						try {
							Runtime.getRuntime().exec("cmd.exe /c start " + Sidebar.Instance().GetTarget().weblink);
						} catch (Exception ex) {
							ex.printStackTrace();

						}
					}
				}
			});

			dellink.addActionListener(new ActionListener() {//删除网址
				@Override
				public void actionPerformed(ActionEvent e) {
					Sidebar.Instance().GetTarget().weblink=null;
					if(Sidebar.Instance().GetTarget().getIcon()!=null) {
						Sidebar.Instance().GetTarget().setIcon(null);
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth()-32,50);
					}
				}
			});
			closelink.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
				}
			});

			frame.setVisible(true);


		}
	}

	public void mouseDragged(MouseEvent e) {
			Component c = (Component) e.getSource();
			int dx = e.getX() - px;
			int dy = e.getY() - py;
			if(c==MindMap.panel.getTree().Root()){
				//如果是根节点
				Moveall(MindMap.panel.getTree().Root(),dx,dy);

			}
			else c.setLocation(c.getX() + dx, c.getY() + dy);

			MindMap.Instance().SizeUpdate();
			MindMap.Instance().validate();
			MindMap.Instance().repaint();
			Sidebar.Instance().Update((TreeNode) c);
		}


	private int dragType;
	private int px, py;
	private int ox, oy;
	private int ow, oh;
};


class Fresh//实现拖拽的类
{
	public Fresh(Component c, int curx, int cury, int curw, int curh, int ux, int uy, int uw, int uh)
	{
		this.c=c;
		this.curx = curx;
		this.cury=cury;
		this.curw=curw;
		this.curh=curh;
		this.ux = ux;
		this.uy = uy;
		this.uw = uw;
		this.uh = uh;

		c.setLocation(curx, cury);
		c.setSize(curw, curh);

		MindMap.Instance().SizeUpdate();
		MindMap.Instance().validate();
		MindMap.Instance().repaint();
		Sidebar.Instance().Update((TreeNode)c);//用于更新拖拽后的节点用
	}

	private Component c;
	private int curx, cury, curw, curh;
	private int ux, uy, uw, uh;
}
