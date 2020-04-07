package com.tj.ex1_awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Ex04Frame extends Frame implements ActionListener{
	private Panel panel;
	private TextField txtField;
	private Button btnOk;
	private Button btnExit;
	private List   list;
	public Ex04Frame() {
		// 컴포넌트 객체 생성
		panel = new Panel(new FlowLayout());
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 200));
		setLocation(300, 200);
		btnOk.addActionListener(this); // 이벤트추가
		btnExit.addActionListener(this);
	}
	public Ex04Frame(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}else if(e.getSource()==btnOk) {
			// txtField.getText()를 list에 add
			list.add(txtField.getText());
			// txtField의 text를 ""
			txtField.setText("");
		}
	}
	public static void main(String[] args) {
		new Ex04Frame("여러 컴포넌트 예제");
	}
	
}
