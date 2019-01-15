package Pigmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
此部分分工：廖仁杰
 */


//入门指南类
public class Guide extends JFrame {
	public Guide(){
		setTitle("入门");
		setSize(750,450);
		setLocation(400,200);
		setLayout(null);
		JButton guide1=new JButton("菜单功能");
		JButton guide2=new JButton("快捷设置");
		JButton guide3=new JButton("图标功能");
		JButton guide4=new JButton("软件设置");

		ImageIcon gu1 = new ImageIcon(this.getClass().getResource("一.jpg"));
		ImageIcon gu2 = new ImageIcon(this.getClass().getResource("二.jpg"));
		ImageIcon gu3 = new ImageIcon(this.getClass().getResource("三.jpg"));
		ImageIcon gu4 = new ImageIcon(this.getClass().getResource("四.jpg"));

		JLabel g=new JLabel();
		JLabel g1=new JLabel("Z Map使用指南");
		g1.setFont(new Font("宋体",Font.BOLD,30));


		guide1.setBounds(0,0,120,80);
		guide2.setBounds(0,95,120,80);
		guide3.setBounds(0,190,120,80);
		guide4.setBounds(0,285,120,80);
		g1.setBounds(250,0,300,350);
		guide1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.setBounds(135,0,550,350);
				add(g);
				g.setIcon(gu1);
				g1.setText(null);
				repaint();
			}
		});
		guide2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.setBounds(135,0,550,350);
				add(g);
				g.setIcon(gu2);
				g1.setText(null);
				repaint();
			}
		});
		guide3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.setBounds(135,0,550,350);
				add(g);
				g.setIcon(gu3);
				g1.setText(null);
				repaint();
			}
		});
		guide4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.setBounds(135,0,550,350);
				add(g);
				g.setIcon(gu4);
				g1.setText(null);
				repaint();
			}
		});

		add(guide1);
		add(guide2);
		add(guide3);
		add(guide4);
		add(g1);

		setVisible(true);



	}

}
