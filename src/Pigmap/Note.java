package Pigmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
此部分分工： 张凯航
 */


//节点的添加备注类

public class Note extends JTextArea {//继承自文本域的备注类
	private static Note note;//实例备注框
	private  static JFrame text;



	public static Note Instance(){
		if(note ==null) {
			note = new Note();
		}

		note.setFont(new Font("宋体",Font.PLAIN,16));
		note.setLineWrap(true);
		note.setRows(12);
		note.setColumns(18);
		note.setEditable(true);
		note.setBackground(Color.PINK);
		note.setVisible(true);
		JScrollPane jScrollPane=new JScrollPane(note);
		jScrollPane.setBounds(0,0,300,150);
		//按钮部分
		JButton yes=new JButton("添加");
		JButton delete=new JButton("清空");
		yes.setFont(new Font("宋体",Font.PLAIN,18));
		yes.setBackground(Color.WHITE);
		yes.setBounds(0,150,150,50);
		delete.setFont(new Font("宋体",Font.PLAIN,18));
		delete.setBackground(Color.WHITE);
		delete.setBounds(150,150,150,50);
		//窗口部分
		text=new JFrame("添加备注");
		text.setLocation(Sidebar.Instance().GetTarget().getX()*2, Sidebar.Instance().GetTarget().getY()+40);
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createBevelBorder(4,Color.blue,Color.BLACK));
		panel.setLayout(null);
		text.add(panel);
		panel.add(jScrollPane);
		panel.add(yes);
		panel.add(delete);

		//确定备注监听
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(note.getText()==null) text.setVisible(false);
				else if(note.getText()!=null) {
					Sidebar.Instance().GetTarget().notepad = note.getText();
					Sidebar.Instance().GetTarget().setBackground(Color.RED);
				}
			}
		});

		//删除备注监听
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sidebar.Instance().GetTarget().setBackground(Color.darkGray);
				note.setText(null);
				Sidebar.Instance().GetTarget().notepad=null;
			}
		});

		text.setSize(320,250);
		panel.setSize(320,250);
		return note;

	}

	//添加备注
	public void setNote(){

		text.setVisible(true);
	}
	public void shownote(){
		if(Sidebar.Instance().GetTarget().notepad!=null) {
			note.setText(Sidebar.Instance().GetTarget().notepad);
			text.setVisible(true);
		}
		else if(Sidebar.Instance().GetTarget().notepad==null){
			JFrame noNote=new JFrame();
			noNote.setLayout(null);
			noNote.setUndecorated(true);
			noNote.setBounds(500,300,140,70);
			JLabel label=new JLabel("没有备注");
			label.setFont(new Font("黑体",Font.BOLD,25));
			label.setForeground(Color.RED);
			label.setBounds(15,5,120,60);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					noNote.setVisible(false);
				}
			});
			noNote.add(label);
			noNote.setVisible(true);
		}


	}

}
