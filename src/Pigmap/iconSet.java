package Pigmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
此部分分工
图标方法函数： 廖仁杰
图标按钮添加：张凯航
 */


//节点的图标设置类

public class iconSet extends JMenuItem{

	public static iconSet iconSet;
	public static taskicon task;
	public static flagicon flag;
	public static workicon work;

	public static iconSet Instance(){

		iconSet = new iconSet();
		return iconSet;
	}
	public iconSet(){
		task=new taskicon();
		flag=new flagicon();
		work=new workicon();



	}
}

	 class taskicon extends JMenuItem {
	//初始化
		 public JMenuItem m1;
		 public JMenuItem m2;
		 public JMenuItem m3;
		 public JMenuItem m4;
		 public JMenuItem m5;
		 public JMenuItem m6;
		 public JMenuItem m7;
		 public JMenuItem m8;
		 public JMenuItem m9;
//		 public JMenuItem m10;
//		 public JMenuItem m11;
//		 public JMenuItem m12;
//		 public JMenuItem m13;
//		 public JMenuItem m14;
//		 public JMenuItem m15;


		 public taskicon() {



				 ImageIcon clock = new ImageIcon(this.getClass().getResource("/iconSet/alarm_clock.png"));
				 ImageIcon date = new ImageIcon(this.getClass().getResource("/iconSet/date.png"));
				 ImageIcon keypoint = new ImageIcon(this.getClass().getResource("/iconSet/key.png"));
				 ImageIcon weblink = new ImageIcon(this.getClass().getResource("/iconSet/globe_with_meridians.png"));
				 ImageIcon doc = new ImageIcon(this.getClass().getResource("/iconSet/doc.png"));
				 ImageIcon flag = new ImageIcon(this.getClass().getResource("/iconSet/flag.png"));
			     ImageIcon did= new ImageIcon(this.getClass().getResource("/iconSet/do.png"));
				 ImageIcon point = new ImageIcon(this.getClass().getResource("/iconSet/point.png"));
				 ImageIcon trash = new ImageIcon(this.getClass().getResource("/iconSet/trash.png"));



				 m1 = new JMenuItem("关键标注");
				 m1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				 m1.addActionListener(new ActionListener() {
					 @Override
					 public void actionPerformed(ActionEvent e) {
						 if (Sidebar.Instance().GetTarget() == null)
							 return;
						 else {
							 if(Sidebar.Instance().GetTarget().getIcon()==null) {
							 	int width = Sidebar.Instance().GetTarget().getWidth();
							 	Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							    Sidebar.Instance().GetTarget().setIcon(keypoint);
							 }
							 else{
							 	Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							 	Sidebar.Instance().GetTarget().setIcon(keypoint);
							 }
						 }
					 }
				 });
				 m2 = new JMenuItem("重点");
				 m2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				 m2.addActionListener(new ActionListener() {
					 @Override
					 public void actionPerformed(ActionEvent e) {
							 if(Sidebar.Instance().GetTarget().getIcon()==null) {
								 int width = Sidebar.Instance().GetTarget().getWidth();
								 Sidebar.Instance().GetTarget().setSize(width + 32, 50);
								 Sidebar.Instance().GetTarget().setIcon(point);
							 }
							 else{
								 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
								 Sidebar.Instance().GetTarget().setIcon(point);
							 }
					 }
				 });
				 m3= new JMenuItem("舍弃");
				 m3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				 m3.addActionListener(new ActionListener() {
					 @Override
					 public void actionPerformed(ActionEvent e) {
						 if(Sidebar.Instance().GetTarget().getIcon()==null) {
							 int width = Sidebar.Instance().GetTarget().getWidth();
							 Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							 Sidebar.Instance().GetTarget().setIcon(trash);
						 }
						 else{
							 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							 Sidebar.Instance().GetTarget().setIcon(trash);
						 }
					 }
				 });
			 m4= new JMenuItem("已完成");
			 m4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			 m4.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 if(Sidebar.Instance().GetTarget().getIcon()==null) {
						 int width = Sidebar.Instance().GetTarget().getWidth();
						 Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						 Sidebar.Instance().GetTarget().setIcon(did);
					 }
					 else{
						 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						 Sidebar.Instance().GetTarget().setIcon(did);
					 }
				 }
			 });
			 m5= new JMenuItem("未完成");
			 m5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			 m5.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 if(Sidebar.Instance().GetTarget().getIcon()==null) {
						 int width = Sidebar.Instance().GetTarget().getWidth();
						 Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						 Sidebar.Instance().GetTarget().setIcon(flag);
					 }
					 else{
						 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						 Sidebar.Instance().GetTarget().setIcon(flag);
					 }
				 }
			 });
			 m6= new JMenuItem("闹钟");
			 m6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			 m6.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 if(Sidebar.Instance().GetTarget().getIcon()==null) {
						 int width = Sidebar.Instance().GetTarget().getWidth();
						 Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						 Sidebar.Instance().GetTarget().setIcon(clock);
					 }
					 else{
						 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						 Sidebar.Instance().GetTarget().setIcon(clock);
					 }
				 }
			 });
			 m7= new JMenuItem("日程");
			 m7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			 m7.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 if(Sidebar.Instance().GetTarget().getIcon()==null) {
						 int width = Sidebar.Instance().GetTarget().getWidth();
						 Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						 Sidebar.Instance().GetTarget().setIcon(date);
					 }
					 else{
						 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						 Sidebar.Instance().GetTarget().setIcon(date);
					 }
				 }
			 });
			 m8= new JMenuItem("附件");
			 m8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			 m8.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 if(Sidebar.Instance().GetTarget().getIcon()==null) {
						 int width = Sidebar.Instance().GetTarget().getWidth();
			 		Sidebar.Instance().GetTarget().setSize(width + 32, 50);
			 		Sidebar.Instance().GetTarget().setIcon(doc);
			 }
					 else{
					 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
					 Sidebar.Instance().GetTarget().setIcon(doc);
		 		}
	 			}
			 });
			 m9= new JMenuItem("链接");
			 m9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			 m9.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 if(Sidebar.Instance().GetTarget().getIcon()==null) {
						 int width = Sidebar.Instance().GetTarget().getWidth();
						 Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						 Sidebar.Instance().GetTarget().setIcon(weblink);
					 }
					 else{
						 Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						 Sidebar.Instance().GetTarget().setIcon(weblink);
					 }
				 }
			 });


		 }
		 }


		//第二类属性标记图标
		class flagicon extends JMenuItem {
			//初始化
			public JMenuItem m1;
			public JMenuItem m2;
			public JMenuItem m3;
			public JMenuItem m4;
			public JMenuItem m5;
			public JMenuItem m6;
			public JMenuItem m7;
			public JMenuItem m8;
			public JMenuItem m9;
			public JMenuItem m10;
			public JMenuItem m11;
			public JMenuItem m12;
			public JMenuItem m13;
			public JMenuItem m14;
			public JMenuItem m15;

			public flagicon(){
				ImageIcon u = new ImageIcon(this.getClass().getResource("/iconSet/u.png"));
				ImageIcon d = new ImageIcon(this.getClass().getResource("/iconSet/d.png"));
				ImageIcon l = new ImageIcon(this.getClass().getResource("/iconSet/l.png"));
				ImageIcon r = new ImageIcon(this.getClass().getResource("/iconSet/r.png"));
				ImageIcon one = new ImageIcon(this.getClass().getResource("/iconSet/1.png"));
				ImageIcon two = new ImageIcon(this.getClass().getResource("/iconSet/2.png"));
				ImageIcon three = new ImageIcon(this.getClass().getResource("/iconSet/3.png"));
				ImageIcon four = new ImageIcon(this.getClass().getResource("/iconSet/4.png"));
				ImageIcon five = new ImageIcon(this.getClass().getResource("/iconSet/5.png"));
				ImageIcon six = new ImageIcon(this.getClass().getResource("/iconSet/6.png"));
				ImageIcon seven = new ImageIcon(this.getClass().getResource("/iconSet/7.png"));
				ImageIcon eight = new ImageIcon(this.getClass().getResource("/iconSet/8.png"));
				ImageIcon nine = new ImageIcon(this.getClass().getResource("/iconSet/9.png"));
				ImageIcon ten = new ImageIcon(this.getClass().getResource("/iconSet/10.png"));
				ImageIcon zero= new ImageIcon(this.getClass().getResource("/iconSet/0.png"));


				m1 = new JMenuItem("上箭头");
				m1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(u);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(u);
						}
					}
				});
				m2 = new JMenuItem("下箭头");
				m2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(d);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(d);
						}
					}
				});
				m3 = new JMenuItem("左箭头");
				m3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(l);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(l);
						}
					}
				});
				m4 = new JMenuItem("右箭头");
				m4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(r);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(r);
						}
					}
				});
				m5 = new JMenuItem("标记1");
				m5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(one);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(one);
						}
					}
				});
				m6 = new JMenuItem("标记2");
				m6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(two);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(two);
						}
					}
				});
				m7 = new JMenuItem("标记3");
				m7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(three);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(three);
						}
					}
				});
				m8 = new JMenuItem("标记4");
				m8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m8.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(four);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(four);
						}
					}
				});
				m9 = new JMenuItem("标记5");
				m9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m9.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(five);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(five);
						}
					}
				});
				m10 = new JMenuItem("标记6");
				m10.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m10.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(six);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(six);
						}
					}
				});
				m11 = new JMenuItem("标记7");
				m11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m11.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(seven);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(seven);
						}
					}
				});
				m12 = new JMenuItem("标记8");
				m12.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m12.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(eight);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(eight);
						}
					}
				});
				m13 = new JMenuItem("标记9");
				m13.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m13.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(nine);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(nine);
						}
					}
				});
				m14 = new JMenuItem("标记10");
				m14.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m14.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(ten);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(ten);
						}
					}
				});
				m15 = new JMenuItem("标记0");
				m15.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				m15.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Sidebar.Instance().GetTarget().getIcon()==null) {
							int width = Sidebar.Instance().GetTarget().getWidth();
							Sidebar.Instance().GetTarget().setSize(width + 32, 50);
							Sidebar.Instance().GetTarget().setIcon(zero);
						}
						else{
							Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
							Sidebar.Instance().GetTarget().setIcon(zero);
						}
					}
				});
			}
		}

class workicon extends MenuItem{
	public JMenuItem m1;
	public JMenuItem m2;
	public JMenuItem m3;
	public JMenuItem m4;
	public JMenuItem m5;
	public JMenuItem m6;
	public JMenuItem m7;
	public JMenuItem m8;
	public JMenuItem m9;
	public JMenuItem m10;
	public JMenuItem m11;
	public JMenuItem m12;
	public JMenuItem m13;
	public JMenuItem m14;


	public workicon(){
		ImageIcon work = new ImageIcon(this.getClass().getResource("/iconSet/airplane.png"));
		ImageIcon atm = new ImageIcon(this.getClass().getResource("/iconSet/atm.png"));
		ImageIcon eat = new ImageIcon(this.getClass().getResource("/iconSet/hamburger.png"));
		ImageIcon pet = new ImageIcon(this.getClass().getResource("/iconSet/pig.png"));
		ImageIcon party = new ImageIcon(this.getClass().getResource("/iconSet/tada.png"));
		ImageIcon music = new ImageIcon(this.getClass().getResource("/iconSet/music.png"));
		ImageIcon phone = new ImageIcon(this.getClass().getResource("/iconSet/telephone.png"));
		ImageIcon money = new ImageIcon(this.getClass().getResource("/iconSet/money.png"));
		ImageIcon mail = new ImageIcon(this.getClass().getResource("/iconSet/mail.png"));
		ImageIcon sport = new ImageIcon(this.getClass().getResource("/iconSet/sport.png"));
		ImageIcon study = new ImageIcon(this.getClass().getResource("/iconSet/study.png"));
		ImageIcon pill = new ImageIcon(this.getClass().getResource("/iconSet/pill.png"));
		ImageIcon house = new ImageIcon(this.getClass().getResource("/iconSet/house.png"));
		ImageIcon hospital = new ImageIcon(this.getClass().getResource("/iconSet/hospital.png"));

		m1 = new JMenuItem("工作");
		m1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(work);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(work);
					}
				}
			}
		});
		m2 = new JMenuItem("学习");
		m2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(study);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(study);
					}
				}
			}
		});
		m3 = new JMenuItem("家庭");
		m3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(house);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(house);
					}
				}
			}
		});
		m4 = new JMenuItem("医院");
		m4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(hospital);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(hospital);
					}
				}
			}
		});
		m5 = new JMenuItem("存款");
		m5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(atm);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(atm);
					}
				}
			}
		});
		m6 = new JMenuItem("健身");
		m6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(sport);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(sport);
					}
				}
			}
		});
		m7 = new JMenuItem("开销");
		m7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(money);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(money);
					}
				}
			}
		});
		m8 = new JMenuItem("饮食");
		m8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(eat);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(eat);
					}
				}
			}
		});
		m9 = new JMenuItem("宠物");
		m9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(pet);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(pet);
					}
				}
			}
		});
		m10 = new JMenuItem("聚会");
		m10.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(party);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(party);
					}
				}
			}
		});
		m11 = new JMenuItem("音乐");
		m11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(music);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(music);
					}
				}
			}
		});
		m12 = new JMenuItem("吃药");
		m12.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(pill);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(pill);
					}
				}
			}
		});
		m13 = new JMenuItem("电话");
		m13.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(phone);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(phone);
					}
				}
			}
		});
		m14 = new JMenuItem("邮件");
		m14.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		m14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sidebar.Instance().GetTarget() == null)
					return;
				else {
					if(Sidebar.Instance().GetTarget().getIcon()==null) {
						int width = Sidebar.Instance().GetTarget().getWidth();
						Sidebar.Instance().GetTarget().setSize(width + 32, 50);
						Sidebar.Instance().GetTarget().setIcon(mail);
					}
					else{
						Sidebar.Instance().GetTarget().setSize(Sidebar.Instance().GetTarget().getWidth(),50);
						Sidebar.Instance().GetTarget().setIcon(mail);
					}
				}
			}
		});
	}
}


