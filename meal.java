package pj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class meal extends JFrame implements ActionListener 
{
	JButton b1 = new JButton("������");
	JTextArea ta;
	
	public meal() throws IOException
	{
		this.setLocation(760,270);
		this.setResizable(false);
		setTitle("ü�� ���� ���α׷�");
		
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		
		ta = new JTextArea();
	    b1.addActionListener(this);
		ta.setEditable(false);
		ad1();
		
		p.add(ta);
		p1.add(b1);
		
		add("North",p);
		add("South",p1);
		
		pack();
		setVisible(true);
	}

	public void ad1() throws IOException////BMI������ �´� ���� �ҷ����� �޼ҵ�
	{
		FileReader fr = null;
		char[] cbuf = new char[100];//�о�� �ؽ�Ʈ�� �����ؿ� �޼ҵ�
		int c;
		if(BodyCheck.BMI<25)
		{
			fr = new FileReader("C:\\Users\\musoul12\\Desktop\\�ڹ�����\\px�����\\������\\�Ĵ�.txt");
			while((c=fr.read(cbuf)) != -1)
			{
				String data =new String(cbuf,0,c);
				ta.append(data);
			}
			fr.close();
		} 
		else if(BodyCheck.BMI>=25 &&  BodyCheck.BMI<30)
		{
			fr = new FileReader("C:\\Users\\musoul12\\Desktop\\�ڹ�����\\px�����\\������\\�Ĵ�1.txt");
			while((c=fr.read(cbuf)) != -1)
			{
				String data =new String(cbuf,0,c);
				ta.append(data);
			}
			fr.close();
		}
		else 
		{
			fr = new FileReader("C:\\Users\\musoul12\\Desktop\\�ڹ�����\\px�����\\������\\�Ĵ�2.txt");
			while((c=fr.read(cbuf)) != -1)
			{
				String data =new String(cbuf,0,c);
				ta.append(data);
			}
			fr.close();
		}

		
	}

	public void actionPerformed(ActionEvent e) 
	{
      if(e.getSource() == b1)
      {
    	  setVisible(false);
    	  BodyCheck sc = new BodyCheck();
      }

	}
}
