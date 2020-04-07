package com.tj.ex3;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Homework extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone;
	private JTextField txtName;
	private JTextField txtPoint;
	private JTextArea jta;
	private JScrollPane scrollPane;
	private JButton btnJoin;
	private JButton btnSearch;
	private JButton btnOutput;
	private JButton btnExit;
	private ArrayList<Customer> customers;
	public Homework(String title) {
		super(title);
		customers = new ArrayList<Customer>(); // 회원가입은 arrayList(customers)에
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000", 15);
		txtPoint.setFocusable(false); // 포인트는 입력할 수 없고 수를 볼 수만 있게
		jta = new JTextArea(15,30);
		scrollPane = new JScrollPane(jta);
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		jpup.add(new JLabel("폰번호",(int)CENTER_ALIGNMENT)); jpup.add(txtPhone);
		jpup.add(new JLabel("이  름",(int)CENTER_ALIGNMENT)); jpup.add(txtName);
		jpup.add(new JLabel("포인트",(int)CENTER_ALIGNMENT)); jpup.add(txtPoint);
		jpdown.add(btnJoin);  jpdown.add(btnSearch);  jpdown.add(btnOutput); jpdown.add(btnExit);
		contenPane.add(jpup); contenPane.add(jpdown); contenPane.add(scrollPane);
		setBounds(300, 300, 400, 450);
		setResizable(false);
		setVisible(true);
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}
	public Homework() {
		this("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnJoin) {
			String phone, name;
			phone = txtPhone.getText().trim();
			name = txtName.getText().trim();
			if(!phone.equals("") && !name.equals("") &&
					phone.indexOf('-')+3<=phone.lastIndexOf('-')) { 
				// 폰번호와 이름은 입력해야 가입이 가능하고 중간 자리는 2자리 이상 쳐야함
				// 0 1 0 - 9 9 9 9 - 9 9 9 9
				// idx   3         8
				// 0 1 1 - 3 5 9 - 9 9 9 9
				// idx   3       7
				// 0 4 3 - 3 5 - 9 9 9 9
				// idx   3     6
				Customer newCustomer = new Customer(phone, name);
				customers.add(newCustomer);
				System.out.println(newCustomer + "가입성공");
				jta.setText(newCustomer.toString()+" 가입성공");
				txtPhone.setText("");
				txtName.setText("");
			}else if(phone.equals("")  || name.equals("")) {
				jta.setText("폰번호와 이름은 입력하셔야 가입이 가능합니다");
				return;
			}else if(phone.indexOf('-')+3>phone.lastIndexOf('-')) {
				jta.setText("폰번호는 국번-중간번호-뒷번호 같은 형식으로 가입이 가능합니다(중간자리는 2자리이상)");
				return;
			}
		}else if(e.getSource()==btnSearch) {// 폰뒷4자리조회. 조회되면 textField에 뿌리기
			String searchPhone = txtPhone.getText().trim();
			jta.setText("");
			for(int idx=0 ; idx<customers.size() ; idx++) {
				String customerPhone = customers.get(idx).getPhone();
				String postPhone = customerPhone.substring(customerPhone.lastIndexOf('-')+1);
				if(postPhone.equals(searchPhone)) {
					txtPhone.setText(customers.get(idx).getPhone());
					txtName.setText(customers.get(idx).getName());
					txtPoint.setText(String.valueOf(customers.get(idx).getPoint()));
					//txtPoint.setText(String.format("%d", customers.get(idx).getPoint()));
					jta.append(customers.get(idx).toString()+"\n");
				}
			}
			if(jta.getText().equals("")) {
				txtPhone.setText("없는 회원님");
				txtName.setText("");
				txtPoint.setText("");
			}
		}else if(e.getSource()==btnOutput) {
			/*OutputStream os = null;
			try {
				os = new FileOutputStream("src/com/tj/ex3/customer.txt");
				jta.setText("");
				for(Customer c : customers) {
					System.out.println(c);
					jta.append(c.toString()+"\r\n");
					os.write((c.toString()+"\r\n").getBytes());
				}
				System.out.println(" .. 이상 "+customers.size()+"명 가입");
				jta.append(" .. 이상 "+customers.size()+"명 가입");
				os.write((" .. 이상 "+customers.size()+"명 가입").getBytes());
			} catch (FileNotFoundException exc) {
				System.out.println(exc.getMessage());
			} catch (IOException exc) {
				System.out.println(exc.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
				}catch (Exception ignore) { }
			}*/
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/tj/ex3/customer.txt");
				jta.setText("");
				for(Customer c : customers) {
					System.out.println(c);
					jta.append(c.toString()+"\r\n");
					writer.write(c.toString()+"\r\n");;
				}
				System.out.println(" .. 이상 "+customers.size()+"명 가입");
				jta.append(" .. 이상 "+customers.size()+"명 가입");
				writer.write(" .. 이상 "+customers.size()+"명 가입");
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(writer!=null) writer.close();
				}catch (Exception e1) { }
			}
			/*
			PrintWriter printwriter = null;
			try {
				printwriter = new PrintWriter("src/com/tj/ex3/customer.txt");
				jta.setText("");
				for(Customer c : customers) {
					System.out.println(c);
					jta.append(c.toString()+"\r\n");
					printwriter.write(c.toString()+"\r\n");;
				}
				System.out.println(" .. 이상 "+customers.size()+"명 가입");
				jta.append(" .. 이상 "+customers.size()+"명 가입");
				printwriter.write(" .. 이상 "+customers.size()+"명 가입");
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} finally {
				if(printwriter!=null) printwriter.close();
			}*/
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Homework("회원관리");
	}
}
