package pj;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

import javax.swing.*;

import org.omg.CORBA.UserException;

import java.io.*;
import java.text.DecimalFormat;

class BodyCheck extends JFrame implements ActionListener 
{

	static double BMI;
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("���");
	JButton b3 = new JButton("�Ĵ�");
	JButton b4 = new JButton("�ʱ�ȭ");
	JButton b5 = new JButton("���α׷� ����");
	JPanel p3 = new JPanel();
	JTextField tf,tf1;
	JTextArea ta,tb;

	public BodyCheck()
	{
		
		this.setSize(400,440);// ������
		this.setLocation(760,270);// ó�� ���� ��ġ
		this.setResizable(false);//â ũ�� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		setTitle("ü�� ���� ���α׷�");


		JLabel label1= new JLabel("������(Kg) : ",JLabel.CENTER);
		JLabel label2= new JLabel("Ű(M) : ",JLabel.CENTER);
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p4 = new JPanel();

		ta = new JTextArea(11,11);//�ؽ�Ʈ����� ��
		tb = new JTextArea(5,10);
		tf = new JTextField();
		tf1 = new JTextField();
		
	
		p.setBackground(Color.lightGray);//��ư�� �г� ��������
		p1.setBackground(Color.lightGray);
		p2.setBackground(Color.lightGray);
		p3.setBackground(Color.lightGray);
		p4.setBackground(Color.lightGray);
		ta.setBackground(Color.lightGray);
		tb.setBackground(Color.lightGray);
		b1.addActionListener(this);//��ư ������ ���â�� ������ Ű bmi���� 
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		tf.setEditable(true);
		tf1.setEditable(true);
		ta.setEditable(false);
		tb.setEditable(false);
		
		p.setLayout(new GridLayout(4,1));
		p.add(label1);
		p.add(tf);
		p.add(label2);
		p.add(tf1);
		p.add(b1);
		p.add(b4);
		p.add(b5);
		p1.add(ta);
		p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
		p2.add(b2);
		p2.add(b3);
		p4.add(tb);
		
		add("North",p);
		add("West",p1);
		add("East",p2);
		add("South",p3);
		add("Center",p4);
		setVisible(true);// â��ȯ


	}
	public void init()//�ؽ�Ʈ�ʵ� �ʱ�ȭ
	{
		tf.setText("");
		tf1.setText("");
		ta.setText("");
		tb.setText("");
	}
	public void ex()//sportâ���� �ѱ�� �޼ҵ�
	{
		try 
		{
			sports sc = new sports();
		} catch (IOException e1) 
		{
			e1.printStackTrace();//������ ���� �޼ҵ带 �˷��ִ� ����ó��
		}
	}
	public void me()//mealâ���� �ѱ�� �޼ҵ�
	{
		try {
			meal sc = new meal();
		} catch (IOException e1) 
		{
			e1.printStackTrace();//������ ���� �޼ҵ带 �˷��ִ� ����ó��
		}
	}
	public void ch()//�ؽ�Ʈ�ʵ� â�� �Էµ� ���� ����Ͽ� ������ �ؽ�Ʈ���� ǥ���ϴ� �޼ҵ�
	{
		DecimalFormat dt = new DecimalFormat("#.##");
		String s = tf.getText();
		String s1 = tf1.getText();
		JLabel labelt[] = new JLabel[21];
		int cnt=0;
		for(int i=0; i<21; i++)
		{
			
			labelt[i]=new JLabel(String.valueOf(cnt));
			cnt +=5;
				
		}

		double m = Double.parseDouble(s);//���� �Ű������� String�� �ǹǷ� ���� ����ȯ�� ��Ų��.
		double m1 = Double.parseDouble(s1);

		BMI=m / Math.pow(m1,2);
		ta.append("������(Kg) :"+s+"\n");
		ta.append("Ű(M) :"+s1+"\n");
		ta.append("BMI ���� :"+dt.format(BMI)+"\n");
		ta.append("----ǥ�� BMI����----\n");
		ta.append("25 �̸� ���������\n");
		ta.append("25 �̻� 30�̸� �������\n");
		ta.append("30 �̻� �񸸻���\n");
		ta.append("---------------------------\n");
		if(BMI < 25)
		{
			ta.append("����� �� ���´� ��ü���Դϴ�.\n ");
			ta.append("����� ������ ������ ���豺�Դϴ�.\n ");
			ta.append("�ؾƷ� ǥ�� ���� ���赵�Դϴ�.��");
			tb.append("��õ ����Ʈ\n");
			tb.append("*������*\n");
			tb.append("www.fitfood.co.kr\n");
			tb.append("www.rankingdak.com\n");
			String path = "C:\\Users\\musoul12\\Desktop\\�ڹ�����\\px�����\\�����̹���\\������.png";;//�̹����� �ҷ��ͼ�
			JLabel label = new JLabel(new ImageIcon(path));//�󺧿� ������
			for(int i=0; i<21;i++)// �迭�� �����Ͽ� ���� 20���� ����
				p3.add(labelt[i]);
			p3.add(label);
			
			
		}

		else if(BMI >= 25 && BMI < 30)
		{
			ta.append("����� �� ���´� �����Դϴ�.\n");
			ta.append("����� ������ ���� �����Դϴ�.\n ");
			ta.append("�ؾƷ� ǥ�� ���� ���赵�Դϴ�.��");
			tb.append("��õ ����Ʈ\n");
			tb.append("*������*\n");
			tb.append("www.runwhey.co.kr\n");
			tb.append("www.h-w.co.kr\n");
			String path = "C:\\Users\\musoul12\\Desktop\\�ڹ�����\\px�����\\�����̹���\\����.png";
			JLabel label = new JLabel(new ImageIcon(path));
			for(int i=0; i<21;i++)
				p3.add(labelt[i]);
			p3.add(label);
			
		}

		else if(BMI >= 30)
		{
			ta.append("����� �� ���´� ���Դϴ�.\n");
			ta.append("����� ������ ������ ���豺�Դϴ�.\n ");
			ta.append("�ؾƷ� ǥ�� ���� ���赵�Դϴ�.��");
			tb.append("��õ ����Ʈ\n");
			tb.append("*������*\n");
			tb.append("www.fitfood.co.kr\n");
			tb.append("www.hong-dak.com\n");
			String path = "C:\\Users\\musoul12\\Desktop\\�ڹ�����\\px�����\\�����̹���\\������.png";
			JLabel label = new JLabel(new ImageIcon(path));
			for(int i=0; i<21;i++)
				p3.add(labelt[i]);
			p3.add(label);
			
		}

		
		
	}
	
	public void actionPerformed(ActionEvent e) // �� ��ư �̺�Ʈ ó��
	{
		if(e.getSource() == b1)
		{
			ch();

		}

		if(e.getSource() == b2)
		{
			JOptionPane.showMessageDialog(null, "������� �̵��մϴ�.");// �޼����� �ֱ� ���� â�� �ϳ��� ����
			setVisible(false);// â��ȯ ���̺귯��
			ex();
		}
		if(e.getSource() == b3)
		{
			JOptionPane.showMessageDialog(null, "�Ĵ����� �̵��մϴ�.");
			setVisible(false);
			me();
		}
		if(e.getSource() == b4)
		{
			init();
			p3.removeAll();
		}
		if(e.getSource() == b5)
		{
			JOptionPane.showMessageDialog(null, "�̿��� �ּż� �����մϴ�.");
			setVisible(false);
		}

	}

}
