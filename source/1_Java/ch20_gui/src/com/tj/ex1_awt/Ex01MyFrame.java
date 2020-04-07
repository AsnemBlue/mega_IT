package com.tj.ex1_awt;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex01MyFrame extends Frame{
	private Button btn, btn2;
	public Ex01MyFrame(String title) {
		super(title);
		//setLayout(new BorderLayout()); // 기본이 borderLayout(south, north, west, east, enter)
		setLayout(new FlowLayout()); //  add 순서대로 컴포넌트가 차곡차곡 추가
		btn = new Button("버튼");
		btn2 = new Button("그냥 버튼");
		add(btn);
		add(btn2);
		
		setSize(new Dimension(300, 200));
		setLocation(100, 50);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex01MyFrame() {
		this("");
	}
	public static void main(String[] args) {
		new Ex01MyFrame("첫예제");
	}
}
