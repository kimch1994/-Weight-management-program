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
	JButton b1 = new JButton("측정");
	JButton b2 = new JButton("운동법");
	JButton b3 = new JButton("식단");
	JButton b4 = new JButton("초기화");
	JButton b5 = new JButton("프로그램 종료");
	JPanel p3 = new JPanel();
	JTextField tf,tf1;
	JTextArea ta,tb;

	public BodyCheck()
	{
		
		this.setSize(400,440);// 사이즈
		this.setLocation(760,270);// 처음 시작 위치
		this.setResizable(false);//창 크기 제한
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		setTitle("체중 관리 프로그램");


		JLabel label1= new JLabel("몸무게(Kg) : ",JLabel.CENTER);
		JLabel label2= new JLabel("키(M) : ",JLabel.CENTER);
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p4 = new JPanel();

		ta = new JTextArea(11,11);//텍스트에어리어 줄
		tb = new JTextArea(5,10);
		tf = new JTextField();
		tf1 = new JTextField();
		
	
		p.setBackground(Color.lightGray);//버튼및 패널 배경색지정
		p1.setBackground(Color.lightGray);
		p2.setBackground(Color.lightGray);
		p3.setBackground(Color.lightGray);
		p4.setBackground(Color.lightGray);
		ta.setBackground(Color.lightGray);
		tb.setBackground(Color.lightGray);
		b1.addActionListener(this);//버튼 누르면 결과창에 몸무게 키 bmi지수 
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
		setVisible(true);// 창전환


	}
	public void init()//텍스트필드 초기화
	{
		tf.setText("");
		tf1.setText("");
		ta.setText("");
		tb.setText("");
	}
	public void ex()//sport창으로 넘기는 메소드
	{
		try 
		{
			sports sc = new sports();
		} catch (IOException e1) 
		{
			e1.printStackTrace();//에러가 나는 메소드를 알려주는 예외처리
		}
	}
	public void me()//meal창으로 넘기는 메소드
	{
		try {
			meal sc = new meal();
		} catch (IOException e1) 
		{
			e1.printStackTrace();//에러가 나는 메소드를 알려주는 예외처리
		}
	}
	public void ch()//텍스트필드 창에 입력된 값을 계산하여 정보를 텍스트에어리어에 표시하는 메소드
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

		double m = Double.parseDouble(s);//라벨의 매개변수는 String만 되므로 강제 형변환을 시킨다.
		double m1 = Double.parseDouble(s1);

		BMI=m / Math.pow(m1,2);
		ta.append("몸무게(Kg) :"+s+"\n");
		ta.append("키(M) :"+s1+"\n");
		ta.append("BMI 지수 :"+dt.format(BMI)+"\n");
		ta.append("----표준 BMI지수----\n");
		ta.append("25 미만 저제충상태\n");
		ta.append("25 이상 30미만 정상상태\n");
		ta.append("30 이상 비만상태\n");
		ta.append("---------------------------\n");
		if(BMI < 25)
		{
			ta.append("당신의 몸 상태는 저체중입니다.\n ");
			ta.append("당신의 혈압은 저혈암 위험군입니다.\n ");
			ta.append("※아래 표는 혈압 위험도입니다.※");
			tb.append("추천 사이트\n");
			tb.append("*보충제*\n");
			tb.append("www.fitfood.co.kr\n");
			tb.append("www.rankingdak.com\n");
			String path = "C:\\Users\\musoul12\\Desktop\\자바프젝\\px씌운거\\혈압이미지\\저혈압.png";;//이미지를 불러와서
			JLabel label = new JLabel(new ImageIcon(path));//라벨에 넣은것
			for(int i=0; i<21;i++)// 배열을 생성하여 라벨을 20개를 만듬
				p3.add(labelt[i]);
			p3.add(label);
			
			
		}

		else if(BMI >= 25 && BMI < 30)
		{
			ta.append("당신의 몸 상태는 정상입니다.\n");
			ta.append("당신의 혈압은 정상 범위입니다.\n ");
			ta.append("※아래 표는 혈압 위험도입니다.※");
			tb.append("추천 사이트\n");
			tb.append("*보충제*\n");
			tb.append("www.runwhey.co.kr\n");
			tb.append("www.h-w.co.kr\n");
			String path = "C:\\Users\\musoul12\\Desktop\\자바프젝\\px씌운거\\혈압이미지\\정상.png";
			JLabel label = new JLabel(new ImageIcon(path));
			for(int i=0; i<21;i++)
				p3.add(labelt[i]);
			p3.add(label);
			
		}

		else if(BMI >= 30)
		{
			ta.append("당신의 몸 상태는 비만입니다.\n");
			ta.append("당신의 혈압은 고혈압 위험군입니다.\n ");
			ta.append("※아래 표는 혈압 위험도입니다.※");
			tb.append("추천 사이트\n");
			tb.append("*보충제*\n");
			tb.append("www.fitfood.co.kr\n");
			tb.append("www.hong-dak.com\n");
			String path = "C:\\Users\\musoul12\\Desktop\\자바프젝\\px씌운거\\혈압이미지\\고혈압.png";
			JLabel label = new JLabel(new ImageIcon(path));
			for(int i=0; i<21;i++)
				p3.add(labelt[i]);
			p3.add(label);
			
		}

		
		
	}
	
	public void actionPerformed(ActionEvent e) // 각 버튼 이벤트 처리
	{
		if(e.getSource() == b1)
		{
			ch();

		}

		if(e.getSource() == b2)
		{
			JOptionPane.showMessageDialog(null, "운동법으로 이동합니다.");// 메세지를 주기 위해 창을 하나더 생성
			setVisible(false);// 창전환 라이브러리
			ex();
		}
		if(e.getSource() == b3)
		{
			JOptionPane.showMessageDialog(null, "식단으로 이동합니다.");
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
			JOptionPane.showMessageDialog(null, "이용해 주셔서 감사합니다.");
			setVisible(false);
		}

	}

}
