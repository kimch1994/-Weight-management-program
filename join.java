package pj;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class join extends JFrame implements ActionListener
{
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("���");
	JTextField tf,tf1,tf2;
	private PrintWriter out;
	private final String filename = "data.txt";
	public join()
	{
		this.setSize(200,200);
		this.setLocation(900,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����â ��ư ������ ����ǰ��ϴ°�  
		setTitle("ȸ������");

		JLabel label1= new JLabel("�̸� : ");
		JLabel label2= new JLabel("���̵� : ");
		JLabel label3= new JLabel("�н����� : ");
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
	public void init()//�ؽ�Ʈ�ʵ� �ʱ�ȭ
	{
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
	}
	public void join()//ȸ������ ������ ���� �޼ҵ�
	{
		try{
			out = new PrintWriter(new FileWriter(filename, true));
			out.println(tf.getText() + "/" + tf1.getText() + "/" + tf2.getText());
			out.flush();
			out.close();
		}catch(IOException e1){//������ �޼ҵ� ��ġ�� �˷��ִ� ����ó��
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "ȸ�������� ȯ�� �մϴ�. ");
		setVisible(false);
	}
	public void actionPerformed(ActionEvent e)//�̺�Ʈó��
	{
		if(e.getSource() == b1)
		{
			join();
		   BodyCheck r = new BodyCheck();
		   setVisible(false);
		}

		if(e.getSource() == b2)
		{
			JOptionPane.showMessageDialog(null, "���α׷��� �����մϴ�.");
			System.exit(0);
		}

	}
}
