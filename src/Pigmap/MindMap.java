package Pigmap;

import javax.swing.*;
import java.awt.*;
;
import java.awt.Color;
import java.awt.Dimension;;
import java.awt.Graphics;
import javax.swing.JPanel;


/*
此部分分工： 廖仁杰
 */



//思维导图的绘制面板类

public class MindMap extends JPanel {
	//思维导图的画图面板
	private static  MindMap instance;//全局对象的建立
	public static  MindMapBody panel;//定义一个面板
	private  static  final  long serialVersionUID=1L;



	public static  MindMap Instance(){
		if(instance==null)
			instance=new MindMap();
			return instance;//返回这个例子


	}

	public static void Reset(){
		instance=null;
	}
	public void Update(Tree tree){
		panel.removeAll();
		panel.setTree(tree);
 		UpdateSub(tree.Root());
		SizeUpdate();
		validate();
		repaint();


	}


	public  void Update(){
		panel.removeAll();
		UpdateSub(panel.getTree().Root());
		SizeUpdate();
		validate();
		repaint();

	}
	public void SizeUpdate()
	{
		panel.SizeUpdate();
	}

	public void UpdateSub(TreeNode cur){
		panel.add(cur);//添加节点的方法
		for(TreeNode i:cur.getList()){
			UpdateSub(i);
			//panel.add(i);

		}

	}

	public void Generate(){
		String mod0 = "新的主题\n";
		Tree tree = new Tree();
		tree.Parse(mod0,new Vec2(300,100));
		Instance().Update(tree);
		Sidebar.Instance().Update(tree.Root());
	}
	//定义mindmap面板
	public  MindMap() {
		//初始化函数初始化mindmap
		setLayout(new BorderLayout());
		JLabel J = new JLabel();
		add(J, BorderLayout.NORTH);
		J.setFont(new Font("宋体", Font.BOLD, 17));
		panel = new MindMapBody();

		//新建主体
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(new JScrollPane(panel), BorderLayout.CENTER);//可滚动的视图

	}



}
//定义一个body 作为面板来使用
class MindMapBody extends JPanel {
	//这是一个思维导图的面板

	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(tree!=null){
		tree.Root().Draw(g);//这里可以看出新的对象tree下的root（）方法里面有draw，这是最主要的
		}
	}
	public  void setTree(Tree tree){
		this.tree=tree;
	}
	public Tree getTree(){
		return  tree;
		//直接定义返回树的方法

	}
	public void SizeUpdate(){
		setPreferredSize(new Dimension(tree.Root().MaxX()+100,tree.Root().MaxY()+100));
	}
	//在这里引用来自Tree的对象
	private Tree tree;//在这里定义了一个树的对象
	private static  final  long serialVersionUID=1L;
}


