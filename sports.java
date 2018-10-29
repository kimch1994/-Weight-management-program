package pj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class sports extends JFrame implements ActionListener 
{
	JButton b1 = new JButton("나가기");
	JTextArea ta;
	
	public sports() throws IOException
	{
		this.setLocation(760,270);
		this.setResizable(false);
		setTitle("체중 관리 프로그램");
		ta = new JTextArea();
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();

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

	public void ad1() throws IOException//BMI지수에 맞는 파일 불러오는 메소드
	{
		FileReader fr = null;
		char[] cbuf = new char[200];
		int c;
		if(BodyCheck.BMI<25)
		{
			fr = new FileReader("C:\\Users\\musoul12\\Desktop\\자바프젝\\px씌운거\\데이터\\ex1.txt");
			while((c=fr.read(cbuf)) != -1)
			{
				String data =new String(cbuf,0,c);
				ta.append(data);
			}
			fr.close();
		} 
		else if(BodyCheck.BMI>=25 &&  BodyCheck.BMI<30)
		{
			fr = new FileReader("C:\\Users\\musoul12\\Desktop\\자바프젝\\px씌운거\\데이터\\ex2.txt");
			while((c=fr.read(cbuf)) != -1)
			{
				String data =new String(cbuf,0,c);
				ta.append(data);
			}
			fr.close();
		}
		else 
		{
			fr = new FileReader("C:\\Users\\musoul12\\Desktop\\자바프젝\\px씌운거\\데이터\\ex3.txt");
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
