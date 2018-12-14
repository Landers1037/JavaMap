package Pigmap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		//tfs[1].setText(target.getLocation().x+"");
		//tfs[2].setText(target.getLocation().y+"");
		tfs[3].setText(target.getWidth()+"");
		tfs[4].setText(target.getHeight()+"");
	}

	public TreeNode GetTarget()
	{
		return target;
	}

	private Parameter()
	{
		setLayout(new BorderLayout());
		ImageIcon img=new ImageIcon("src/Pigmap/5.png");
		JLabel j=new JLabel(img);
		//j.setFont(new Font("宋体",Font.PLAIN,17));
		add(j,BorderLayout.NORTH);
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(3, 1, 0, 20));

		//String[] label_strings = {"标题:", "横轴:", "纵轴:", "宽度:", "高度:"};
		String[] label_strings = {"标题:", "宽度:", "高度:"};
		tfs = new JTextField[3];
		for(int i=0;i<label_strings.length;i++)
		{
			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			JLabel label=new JLabel(label_strings[i]);
			label.setFont(new Font("微软雅黑",Font.PLAIN,17));
			item.add(label,BorderLayout.WEST);
			tfs[i] = new JTextField("");
			tfs[i].setPreferredSize(new Dimension(100, 30));
			item.add(tfs[i], BorderLayout.CENTER);
			if(i==0)
				tfs[i].setEditable(true);
			body.add(item);
		}

		JPanel layout = new JPanel();
		layout.setLayout(new BorderLayout());
		layout.add(body, BorderLayout.NORTH);
		add(layout);

		//add(new JScrollPane(layout), BorderLayout.CENTER);

		btn = new JButton("修改参数");
		btn.setFont(new Font("宋体",Font.PLAIN,18));
		add(btn, BorderLayout.SOUTH);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(target==null)
					return;
				target.setText(tfs[0].getText());
				//target.setLocation(Integer.parseInt(tfs[1].getText()), Integer.parseInt(tfs[2].getText()));
				target.setSize(Integer.parseInt(tfs[3].getText()), Integer.parseInt(tfs[4].getText()));
				target.setSize(new Dimension(tfs[0].getWidth(),50));
				MindMap.Instance().SizeUpdate();
				MindMap.Instance().validate();
				MindMap.Instance().repaint();
			}
		});
	}
	private static Parameter instance;
	private static final long serialVersionUID = 1L;

	private JButton btn;
	private TreeNode target;
	private JTextField[] tfs;
}