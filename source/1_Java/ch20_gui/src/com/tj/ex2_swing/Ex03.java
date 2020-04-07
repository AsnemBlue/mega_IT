package com.tj.ex2_swing;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Ex03 extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private ImageIcon i1, i2;
	private JButton   btnInput;
	private JButton   btnOutput;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private HashMap<String, Person> person;
	public Ex03(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());//전체 컨테이너를 flowLayout으로
		jpup = new JPanel(new GridLayout(3, 2));
		//jpup.setLayout(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		txtName = new JTextField(15);
		txtPhone = new JTextField(15);
		txtAge = new JTextField(15);
		i1 = new ImageIcon("icon/bell.gif");
		btnInput = new JButton("입력", i1); // 이미지 추가된 button
		i2 = new ImageIcon("icon/write.gif");
		btnOutput = new JButton("출력",i1);
		textArea = new JTextArea(5, 30);
		scrollPane = new JScrollPane(textArea);
		person = new HashMap<String, Person>();
		jpup.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
		jpup.add(txtAge);
		jpdown.add(btnInput);
		jpdown.add(btnOutput);
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollPane);
		setVisible(true);
		//setSize(new Dimension(200, 400));
		//setLocation(100, 100);
		setBounds(100, 100, 400, 320);
		btnInput.addActionListener(this); // 이벤트 처리할 컴포넌트들 추가
		btnOutput.addActionListener(this);
	}
	public static void main(String[] args) {
		new Ex03("GUI 예제");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) {
			// txtName, txtPhone, txtAge를 person에 추가
			String name, phone; int age=0;
			name = txtName.getText().trim();
			phone = txtPhone.getText().trim();
			try {
				age = Integer.parseInt(txtAge.getText().trim());
			}catch (NumberFormatException excep) {
				textArea.setText("나이의 타입이 유효하지 않아 입력 실패");
				return;
			}
			if(name.equals("") || phone.equals("")) {
				textArea.setText("이름과 전화번호를 입력하지 않아 입력 실패");
				return;
			}
			if(age>150 || age<0) {
				textArea.setText("유효하지 않는 나이는 입력 실패");
				return;
			}
			// person(hashmap)에 같은 phone이 있는지 검사
			int idx = 0; // phone이랑 같은 번호가 있는지 없는지 확인용
			Iterator<String> iterator = person.keySet().iterator();
			// 010-9999-9999, 홍길동객체
			// 010-8888-8888, 김길동객체
			while(iterator.hasNext()) {
				String tempPhone = iterator.next();
				if(tempPhone.equals(phone)) {
					break;
				}
				idx++;
			}
			if(idx < person.size()) { // tempPhone과 phone이 같아서 break되서 나온 경우
				textArea.setText("중복된 전화번호가 있어서 입력 실패");
				return;
			}
			Person p = new Person(name, phone, age);
			person.put(phone, p); // person(hashmap)에 추가
			textArea.setText(p.toString() + "입력 성공");
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
		}else if(e.getSource()==btnOutput) {
			// person 을 파일 출력과 콘솔창, textArea에 출력
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/tj/ex2_swing/person.txt");
				Iterator<String> iterator = person.keySet().iterator();
				textArea.setText("");
				while(iterator.hasNext()) {
					String tempPhone = iterator.next();
					Person p = person.get(tempPhone);
					System.out.println(p);         // 콘솔출력
					textArea.append(p.toString()); // textArea에 출력
					writer.write(p.toString());    // 파일 출력
				}
				System.out.println(person.size()+"명 입력됨"); // 콘솔에도 몇명 입력인지 출력
				textArea.append(person.size()+"명 입력됨");    // textArea에도 몇명 입력되었는지 출력
				writer.write(person.size()+"명 입력됨");       // 파일에도 몇명 입력되었는지 출력
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(writer!=null) writer.close();
				}catch (Exception e1) { }
			}
			
		}		
	}
}













