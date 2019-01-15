package Pigmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
此部分分工：廖仁杰
 */



//菜单选择文件模板类
public class Sample extends JFrame {
	public Sample(){
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setSize(150,420);
		panel.setBackground(Color.GRAY);

		ImageIcon icon1 = new ImageIcon(this.getClass().getResource("一级主题.jpg"));
		JLabel j1=new JLabel(icon1);
		j1.setBounds(0,0,150,100);
		ImageIcon icon2 = new ImageIcon(this.getClass().getResource("二级主题.jpg"));
		JLabel j2=new JLabel(icon2);
		j2.setBounds(0,105,150,100);
		ImageIcon icon3 = new ImageIcon(this.getClass().getResource("鱼骨图.jpg"));
		JLabel j3=new JLabel(icon3);
		j3.setBounds(0,210,150,100);
		ImageIcon icon4 = new ImageIcon(this.getClass().getResource("树形图.jpg"));
		JLabel j4=new JLabel(icon4);
		j4.setBounds(0,315,150,100);
		add(panel);
		panel.add(j1);
		panel.add(j2);
		panel.add(j3);
		panel.add(j4);

		//添加监听
		j1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					Windows.cp.removeAll();
					Sidebar.Reset();
					MindMap.Reset();
					MindMap mmp = MindMap.Instance();
					Sidebar ap = Sidebar.Instance();
					JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ap, mmp);
					sp.setDividerLocation(Windows.cp.getWidth() / 13 * 2);
					Windows.cp.add(sp);
					Windows.cp.validate();
					String path =Sample.class.getResource("/xmlsam/first.xml").getPath();
					Tree t = FileManager.Load(path);
					MindMap.Instance().Update(t);
					Sidebar.Instance().Update(t.Root());
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					setVisible(false);
			}
		});
		j2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					Windows.cp.removeAll();
					Sidebar.Reset();
					MindMap.Reset();
					MindMap mmp = MindMap.Instance();
					Sidebar ap = Sidebar.Instance();
					JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ap, mmp);
					sp.setDividerLocation(Windows.cp.getWidth() / 13 * 2);
					Windows.cp.add(sp);
					Windows.cp.validate();
					String path = Sample.class.getResource("/xmlsam/second.xml").getPath();
					Tree t = FileManager.Load(path);
					MindMap.Instance().Update(t);
					Sidebar.Instance().Update(t.Root());
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					setVisible(false);
			}
		});
		j3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					Windows.cp.removeAll();
					Sidebar.Reset();
					MindMap.Reset();
					MindMap mmp = MindMap.Instance();
					Sidebar ap = Sidebar.Instance();
					JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ap, mmp);
					sp.setDividerLocation(Windows.cp.getWidth() / 13 * 2);
					Windows.cp.add(sp);
					Windows.cp.validate();
					String path = Sample.class.getResource("xmlsam/fish.xml").getPath();
					Tree t = FileManager.Load(path);
					MindMap.Instance().Update(t);
					Sidebar.Instance().Update(t.Root());
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					setVisible(false);
			}
		});
		j4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					Windows.cp.removeAll();
					Sidebar.Reset();
					MindMap.Reset();
					MindMap mmp = MindMap.Instance();
					Sidebar ap = Sidebar.Instance();
					JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ap,mmp);
					sp.setDividerLocation(Windows.cp.getWidth() / 13 * 2);
					Windows.cp.add(sp);
					Windows.cp.validate();
					String path = Sample.class.getResource("/xmlsam/tree.xml").getPath();
					Tree t = FileManager.Load(path);
					MindMap.Instance().Update(t);
					Sidebar.Instance().Update(t.Root());
				}
				if(e.getButton()==MouseEvent.BUTTON3)
					setVisible(false);
			}
		});

		setUndecorated(true);
		setSize(150,420);
		setVisible(true);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setVisible(true);
			}
		});
		MindMap.panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setVisible(false);
			}
		});
	}

}
