package Pigmap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Parameter extends JPanel
{
	public static Parameter Instance()
	{
		if(instance == null)
			instance = new Parameter();
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
		tfs[0].setText(target.getText());

	}

	public TreeNode GetTarget()
	{
		return target;
	}

	private Parameter()
	{
		setLayout(new BorderLayout());
		ImageIcon img=new ImageIcon(this.getClass().getResource("icon.jpg"));
		ImageIcon img1=new ImageIcon(this.getClass().getResource("cat.png"));
		JLabel j=new JLabel(img);
		JLabel j1=new JLabel(img1);
		add(j,BorderLayout.NORTH);
		add(j1,BorderLayout.SOUTH);

		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd\n"+"HH:mm\n");//获取系统的时间
		String time=new String(date.format(new Date()));
		String happytree="";
		String label_strings ="欢迎使用" +
				"\n"
				+"思维导图创建于" +
				"\n"
				+time+happytree;
		JTextArea pane=new JTextArea(5,10);
		pane.setBackground(Color.WHITE);
		pane.setForeground(Color.BLACK);
		pane.setText(label_strings);

		pane.setFont(new Font("微软雅黑",Font.PLAIN,18));
		pane.setEditable(false);

			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			item.add(pane,BorderLayout.NORTH);
			add(item);


//		btn = new JButton("修改参数");
//		btn.setFont(new Font("宋体",Font.PLAIN,18));
//		add(btn, BorderLayout.SOUTH);
//
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(target==null)
//					return;
//				target.setText(tfs[0].getText());
//				//target.setLocation(Integer.parseInt(tfs[1].getText()), Integer.parseInt(tfs[2].getText()));
//				target.setSize(Integer.parseInt(tfs[3].getText()), Integer.parseInt(tfs[4].getText()));
//				target.setSize(new Dimension(tfs[0].getWidth()*10,50));
//				MindMap.Instance().SizeUpdate();
//				MindMap.Instance().validate();
//				MindMap.Instance().repaint();
//			}
//		});
	}
	private static Parameter instance;
	private static final long serialVersionUID = 1L;

	private JButton btn;
	private TreeNode target;
	private JTextField[] tfs;
}