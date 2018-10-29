package pj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends  Application {


	private BufferedReader in;
	private final String filename = "data.txt";
	public static String[] search = new String[10];
	boolean s;


	Image sc = new Image("file:사진.jpg");
	GridPane pane = new GridPane();

	Label ID = new Label("아이디:");
	Label pw = new Label("비밀번호:");
	Button btn = new Button("로그인");
	Button btn1 = new Button("회원가입");
	TextField IDTX = new TextField();
	PasswordField pwBox = new PasswordField();

	public void start(Stage arg) {
		arg.centerOnScreen();
		ImageView iv =new ImageView();
		arg.setTitle("체중 관리 프로그램");
		iv.setImage(sc);
		iv.setFitHeight(100);
		iv.setFitWidth(350);
		pane.getChildren().add(iv);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(20, 20, 20, 20));

		pane.add(ID, 0, 1);
		pane.add(IDTX,0 , 2);
		pane.add(pw, 0, 3);
		pane.add(pwBox, 0, 4);

		VBox hbBtn = new VBox(10);
		btn.setPrefSize(100,40);

		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		pane.add(hbBtn, 0, 5);


		btn1.setPrefSize(100,40);
		VBox hbBtn1 = new VBox(10);
		hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn1.getChildren().add(btn1);
		pane.add(hbBtn1, 0, 6);
		Scene scene = new Scene(pane, 365, 320);
		arg.setResizable(false);
		scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
		arg.setScene(scene);
		arg.show();

		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) 
			{
				check();
				if(s == true)
					arg.close();
			}

		});

		btn1.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent e) {
				join sc = new join();
				arg.close();

			}
		});
	}
	public void check()
	{
		String data = "";
		try{
			in = new BufferedReader(new FileReader(filename));
			while((data = in.readLine()) != null)
			{
				String[] search = data.split("/");//데이터 자르는 기준
				if(search[1].equals(IDTX.getText()) && search[2].equals(pwBox.getText()))
				{
					JOptionPane.showMessageDialog(null,"환영 합니다.");
					s=true;
					BodyCheck rm = new BodyCheck();
					break;
				}
			}
			if(data == null)// 예외처리
			{
				JOptionPane.showMessageDialog(null,"아아디 혹은 비밀번호가 틀렸습니다.");
				clear();
			}
		}catch(IOException e1)//데이터 파일 에러 예외처린
		{
			JOptionPane.showMessageDialog(null,"데이터 파일을 찾아 올 수 없습니다.");
		}

	}
	public void clear()
	{
		IDTX.setText("");
		pwBox.setText("");

	}
	public static void main(String[] args) {

		launch(args);
	}

}
