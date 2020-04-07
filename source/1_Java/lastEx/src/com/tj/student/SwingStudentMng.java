package com.tj.student;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class SwingStudentMng extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel    jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mNames; // 콤보박스에 들어갈 전공리스트를 담을 vector
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate;
	private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private String driver;
	private String url;
	private Connection        conn;
	private PreparedStatement pstmt;
	private ResultSet         rs;
	ArrayList<StudentDTO> students;
	ArrayList<StudentDTO2> students2;
	public SwingStudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		students = new ArrayList<StudentDTO>();     //db
		students2 = new ArrayList<StudentDTO2>();   //db
		driver= "oracle.jdbc.driver.OracleDriver";  //db
		url ="jdbc:oracle:thin:@127.0.0.1:1521:xe"; //db
		contenPane = getContentPane(); // 화면구현
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mNames = new Vector<String>();
		mNames.add("");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement("SELECT MNAME FROM MAJOR");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mNames.add(rs.getString("mname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}// try-catch-finally
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		btnInput       = new JButton("학생입력");
		btnUpdate      = new JButton("학생수정");
		btnStudentOut  = new JButton("학생출력");
		btnExpelOut  = new JButton("제적자출력");
		btnExpel     = new JButton("제적처리");
		btnExit      = new JButton("종료");
		txtPool      = new JTextArea(10, 50);
		scrollPane   = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600, 400));
		setLocation(200,150);
		setVisible(true);
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSNoSearch) { //학번검색
			String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M "+ 
					"    WHERE S.MNO=M.MNO AND SNO=?";
			String sNo = txtSNo.getText().trim();
			if(!sNo.equals("")) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sNo);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						txtSName.setText(rs.getString("sName"));
						comMname.setSelectedItem(rs.getString("mname"));
						txtScore.setText(rs.getString("score"));
						txtPool.setText(sNo+"검색 완료");
					}else {
						txtSName.setText("");
						comMname.setSelectedItem("");
						txtScore.setText("");
						txtPool.setText("없는 학번입니다");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e1) { }
				}
			}else {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("학번을 입력 후 학번 검색을 하세요");
			}
		}else if(e.getSource()==btnSNameSearch) { // 이름검색
			String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M " + 
					"    WHERE S.MNO=M.MNO AND SNAME=?";
			String sName = txtSName.getText().trim();
			if(sName.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sName);
					rs = pstmt.executeQuery();
					students2.clear();
					while(rs.next()) {
						String sNo   = rs.getString("sNo");
						String mName = rs.getString("mName");
						int score    = rs.getInt("score");
						txtSNo.setText(sNo);
						txtSName.setText(sName);
						comMname.setSelectedItem(mName);
						txtScore.setText(String.valueOf(score));
						students2.add(new StudentDTO2(sNo, sName, mName, score));
						txtPool.setText("");
					}
					if(students2.size()==0) {
						txtPool.setText("해당 이름의 학생이 없습니다");
						txtSNo.setText("");
						comMname.setSelectedItem("");
						txtScore.setText("");
					}else if(students2.size()>1) {
						txtPool.setText("\t학번\t이름\t학과명\t점수\n");
						txtPool.append("\t──────────────────────────\n");
						for(StudentDTO2 s : students2) {
							txtPool.append("\t"+s.toString()+"\n");
						}
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e1) { }
				}
			}else {
				txtSNo.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("이름은 입력하고 검색해야지");
			}
		}else if(e.getSource()==btnMNameSearch) { // 전공검색
			String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||mNO||')' mNAME, SCORE " + 
					"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M  " + 
					"            WHERE S.mNO=m.mNO AND mNAME=?" + 
					"            ORDER BY SCORE DESC)";
			String mName = comMname.getSelectedItem().toString();
			if(!mName.equals("")) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mName);
					rs = pstmt.executeQuery();
					students.clear();
					while(rs.next()) {
						int rank      = rs.getInt("rank");
						String nameNo = rs.getString("name_no");
						mName = rs.getString("mNAME");
						int score         = rs.getInt("score");
						students.add(new StudentDTO(rank, nameNo, mName, score));
					}
					if(students.size()!=0) {
						txtPool.setText("\t학번\t이름\t\t학과명\t점수\n");
						txtPool.append("\t────────────────────────────────\n");
						for(StudentDTO s : students) {
							txtPool.append("\t"+s.toString()+"\n");
						}
					}else {
						txtPool.setText("해당 학생이 없습니다");
					}					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(rs   != null) rs.close();
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("전공은 선택하고 검색해야지");
			}
		}else if(e.getSource()==btnInput) {//학생입력
			String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES " + 
					"    (TO_CHAR(SYSDATE, 'YYYY') " + 
					"    ||(SELECT mNO FROM MAJOR WHERE mNAME= ? ) " + 
					"    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')), " + 
					"    ?, (SELECT mNO FROM MAJOR WHERE mNAME=?), ?)";
			String sName = txtSName.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			if(sName.length()!=0 && mName.length()!=0) {
				int score = 0;
				try {
					score = Integer.parseInt(txtScore.getText());
					if(score<0 || score>100) {
						System.out.println("유효한 점수가 아니면 0점 처리");
						score = 0;
					}
				}catch (Exception e1) {
					System.out.println("점수를 입력을 안 하거나 문자이면 0점 처리");
				}
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mName);
					pstmt.setString(2, sName);
					pstmt.setString(3, mName);
					pstmt.setInt(4, score);
					int result = pstmt.executeUpdate();
					txtPool.setText(result>0? "학생입력성공":"학생입력실패");
					txtSNo.setText("");
					txtSName.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("학생입력시 학번, 이름, 전공을 입력해야해");
			}
		}else if(e.getSource()==btnUpdate) {//학생 수정
			String sql = "UPDATE STUDENT SET  sNAME=?, " + 
					"   		mNO=(SELECT mNO FROM MAJOR WHERE mNAME=?)," + 
					"       	SCORE = ?" + 
					"       WHERE SNO=?";
			String sNo = txtSNo.getText().trim();
			String sName = txtSName.getText().trim();
			if(sNo.length()!=0 && sName.length()!=0 && comMname.getSelectedIndex() !=0) {
				int score = 0;
				try {
					score = Integer.parseInt(txtScore.getText());
					if(score<0 || score>100) {
						System.out.println("유효한 점수가 아니면 0점 처리");
						score = 0;
					}
				}catch (Exception e1) {
					System.out.println("점수를 입력을 안 하거나 문자이면 0점 처리");
				}
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sName);
					pstmt.setString(2, comMname.getSelectedItem().toString());
					pstmt.setInt(3, score);
					pstmt.setString(4, sNo);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "학생수정성공":"학생수정실패");
					txtPool.setText(result>0? "학생수정성공":"학생수정실패");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("학생수정시 학번, 이름, 전공을 입력해야해");
			}
		}else if(e.getSource()==btnStudentOut) {//학생출력(제적자제외)
			String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME, SCORE " + 
					"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M " + 
					"            WHERE S.mNO=m.mNO AND sEXPEL=0 " + 
					"            ORDER BY SCORE DESC)";
			try {
				conn = DriverManager.getConnection(url, "scott","tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				students.clear();
				while(rs.next()) {
					int    rank    = rs.getInt("rank");
					String nameNo = rs.getString("name_no");
					String mName   = rs.getString("mname");
					int    score   = rs.getInt("score");
					students.add(new StudentDTO(rank, nameNo, mName, score));
				}
				if(!students.isEmpty()) {
					txtPool.setText("\t학번\t이름\t학과명\t점수\n");
					txtPool.append("\t───────────────────────────────\n");
					for(StudentDTO s : students) {
						txtPool.append("\t"+s.toString()+"\n");
					}
				}else {
					txtPool.setText("\t 해당 학생이 없습니다");
				}					
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(rs   != null) rs.close();
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e1) {System.out.println(e1.getMessage());}
			}
		}else if(e.getSource()==btnExpelOut) {//제적자 출력
			String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME, SCORE " + 
					"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M " + 
					"            WHERE S.mNO=m.mNO AND sEXPEL=1 " + 
					"            ORDER BY SCORE DESC)";
			try {
				conn = DriverManager.getConnection(url, "scott","tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				students.clear();
				while(rs.next()) {
					int    rank    = rs.getInt("rank");
					String nameNo = rs.getString("name_no");
					String mName   = rs.getString("mname");
					int    score   = rs.getInt("score");
					students.add(new StudentDTO(rank, nameNo, mName, score));
				}
				if(!students.isEmpty()) {
					txtPool.setText("\t학번\t이름\t학과명\t점수\n");
					txtPool.append("\t──────────────────────────────\n");
					for(StudentDTO s : students) {
						txtPool.append("\t"+s.toString()+"\n");
					}
				}else {
					txtPool.append("\t 해당 학생이 없습니다");
				}					
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(rs   != null) rs.close();
					if(pstmt!= null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e1) {System.out.println(e1.getMessage());}
			}
		}else if(e.getSource()==btnExpel) { // 제적처리
			String sql = "UPDATE STUDENT SET sEXPEL = 1 WHERE SNO = ?";
			String sNo = txtSNo.getText().trim();
			if(sNo.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sNo);
					int result = pstmt.executeUpdate();
					if(result>0) {
						System.out.println("제적처리 성공");
						txtPool.setText("제적처리 성공");
					}else {
						System.out.println("해당 학번이 없어 제적처리 불가");
						txtPool.setText("해당 학번이 없어 제적처리 불가");
					}
					txtSNo.setText("");
					txtSName.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						if(pstmt!= null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e1) {System.out.println(e1.getMessage());}
				}
			}else {
				txtPool.setText("학번은 입력하고 제적처리해야지");
			}
		}else if(e.getSource()==btnExit) {// 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SwingStudentMng("학사관리");
	}
}
