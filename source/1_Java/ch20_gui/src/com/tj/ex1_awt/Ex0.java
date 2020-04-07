package com.tj.ex1_awt;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("버튼");
		frame.add(btn);
		Button btn2 = new Button("그냥 버튼");
		frame.add(btn2);
		frame.setSize(new Dimension(300, 200));
		//frame.pack(); // 최소한의 사이즈 
		frame.setLocation(100, 50);
		frame.setVisible(true);// frame을 화면에 보이게 함
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		frame.setVisible(false); // 화면에 안 보이게
		frame.dispose();         // 자원해제
		System.exit(0);          // 강제 종료
	}
}
