package pj;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class join extends JFrame implements ActionListener
{
	JButton b1 = new JButton("저장");
	JButton b2 = new JButton("취소");
	JTextField tf,tf1,tf2;
	private PrintWriter out;
	private final String filename = "data.txt";
	public join()
	{
		this.setSize(200,200);
		this.setLocation(900,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도창 버튼 누를시 종료되게하는거  
		setTitle("회원가입");

		JLabel label1= new JLabel("이름 : ");
		JLabel label2= new JLabel("아이디 : ");
		JLabel label3= new JLabel("패스워드 : ");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		tf = new JTextField();
		tf1 = new JTextField();
		tf2 = new JTextField();
		b1.addActionListener(this);
		b2.addActionListener(this);

		p1.setLayout(new GridLayout(6,2));
		p1.add(label1);
		p1.add(tf);
		p1.add(label2);
		p1.add(tf1);
		p1.add(label3);
		p1.add(tf2);
		p2.add(b1);
		p2.add(b2);

		add("North",p1);
		add("Center",p2);
		setVisible(true);
	}
	public void init()//텍스트필드 초기화
	{
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
	}
	public void join()//회원가입 데이터 저장 메소드
	{
		try{
			out = new PrintWriter(new FileWriter(filename, true));
			out.println(tf.getText() + "/" + tf1.getText() + "/" + tf2.getText());
			out.flush();
			out.close();
		}catch(IOException e1){//오류난 메소드 위치를 알려주는 예외처리
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "회원가입을 환영 합니다. ");
		setVisible(false);
	}
	public void actionPerformed(ActionEvent e)//이벤트처리
	{
		if(e.getSource() == b1)
		{
			join();
		   BodyCheck r = new BodyCheck();
		   setVisible(false);
		}

		if(e.getSource() == b2)
		{
			JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
			System.exit(0);
		}

	}
}
