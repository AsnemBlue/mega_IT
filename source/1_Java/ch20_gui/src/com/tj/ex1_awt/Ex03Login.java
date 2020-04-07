package com.tj.ex1_awt;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex03Login extends Frame{
	private Panel panel;
	private Label lbl1, lbl2;
	private TextField txtId;
	private TextField txtPw;
	private Button btn;
	public Ex03Login(String title) {
		super(title);
		panel = new Panel();
		panel.setLayout(new GridLayout(2, 2));
		//lbl1 = new Label("아  이  디");
		//lbl2 = new Label("비밀 번호 ");
		txtId = new TextField("ID", 20);
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btn = new Button("로그인");
		panel.add(new Label("아 이 디", (int)CENTER_ALIGNMENT));
		panel.add(txtId);
		panel.add(new Label("비밀번호", (int)CENTER_ALIGNMENT));
		panel.add(txtPw);
		add(panel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(400, 200));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex03Login() {
		this("");
	}
	public static void main(String[] args) {
		new Ex03Login("로그인 화면");
	}
}












