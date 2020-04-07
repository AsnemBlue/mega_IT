package com.tj.supermarket;
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
public class CustomerMng extends JFrame implements ActionListener{
	//Swing
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField jtxtId, jtxtTel, jtxtName, jtxtPoint, jtxtAmount;
	private Vector<String> levels;
	private JComboBox<String> jcomLevel;
	private JButton jbtnTelSearch, jbtnNameSearch, jbtnPoint;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAllOutput, 
				jbtnInsert, jbtnTelUpdate, jbtnDelete, jbtnExit;
	private JTextArea jtxtPool;
	private JScrollPane scrollPane;
	//JDBC 관련 변수
	private String driver;
	private String url;
	private Connection        conn;
	private PreparedStatement pstmt;
	private ResultSet         rs;
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();
		jtxtId = new JTextField(20);
		jtxtTel = new JTextField(20);
		jtxtName = new JTextField(20);
		jtxtPoint = new JTextField(20);
		jtxtAmount = new JTextField(20);
		levels = new Vector<String>();
		levels.add("");
		// 이부분 대신 db에서 LEVELNAME들 가져와 vector에 add : 1단계 ~ 7단계
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			Class.forName(driver); // 1단계
			conn = DriverManager.getConnection(url,"scott","tiger");//2단계
			pstmt = conn.prepareStatement(sql); // 3단계
			rs = pstmt.executeQuery(); // 4+5단계
			while(rs.next()) { //6단계
				levels.add(rs.getString("levelname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7단계
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}// levels 벡터에 LEVENAME들 add
		jcomLevel = new JComboBox<String>(levels);
		jbtnTelSearch = new JButton("폰4자리(FULL) 검색");
		jbtnNameSearch = new JButton("고객 이름 검색");
		jbtnPoint = new JButton("포인트로만 구매");
		jpup.add(new JLabel(" 아 이 디 ",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtId);
		jpup.add(new JLabel(""));
		jpup.add(new JLabel("고 객 전 화",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("고 객 이 름",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("포  인  트",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("구 매 금 액",(int) CENTER_ALIGNMENT));
		jpup.add(jtxtAmount);
		jpup.add(new JLabel(""));//빈 라벨 추가하는 부분
		jpup.add(new JLabel("고 객 등 급",(int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		jbtnBuy = new JButton("물품 구매");
		jbtnLevelOutput = new JButton("등급별출력");
		jbtnAllOutput = new JButton("전체출력");
		jbtnInsert = new JButton("회원가입");
		jbtnTelUpdate = new JButton("번호수정");
		jbtnDelete = new JButton("회원탈퇴");
		jbtnExit = new JButton("나가기");
		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAllOutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelUpdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		jtxtPool = new JTextArea(6, 60);
		scrollPane = new JScrollPane(jtxtPool);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setSize(new Dimension(750, 370));setLocation(200, 200);
		setVisible(true);
		jtxtPool.setText("\t★ ★ ★ 고객검색 후 구매하세요 ★ ★ ★");
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAllOutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelUpdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);
		jtxtPoint.setFocusable(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		if(e.getSource()==jbtnTelSearch) { // 폰번호 검색
			String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
				"        (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO !=5) LEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L " + 
				"    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||?";
			String ctel = jtxtTel.getText().trim();
			if(ctel.length() >= 4) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						int cid = rs.getInt("cid");
						ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
						jtxtId.setText(String.valueOf(cid));
						jtxtTel.setText(ctel);
						jtxtName.setText(cname);
						jtxtPoint.setText(String.valueOf(cpoint));
						jcomLevel.setSelectedItem(levelname);
					}
					jtxtPool.setText("전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 앞으로 구매할 금액\n");
					jtxtPool.append("─────────────────────────────────────────────────────\n");
					if(customers.size()==0) {
						jtxtPool.append("해당 전화번호가 없습니다");
						jtxtId.setText("");
						jtxtTel.setText("");
						jtxtName.setText("");
						jtxtPoint.setText("");
						jcomLevel.setSelectedIndex(0);
					}else {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try{
						if(rs!=null) rs.close(); 
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("적어도 폰4자리 이상 입력하시고 검색하세요");
			}//폰 뒷4자리는 입력했는지 if 
		}else if(e.getSource()==jbtnNameSearch) { // 이름검색
			String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO!=5) LEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO AND cNAME=?";
			String cname = jtxtName.getText().trim();
			if(cname.length()!=0) {
				try {
					conn=DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cname);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						int cid = rs.getInt("cid");
						String ctel = rs.getString("ctel");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
						jtxtId.setText(String.valueOf(cid));
						jtxtTel.setText(ctel);
						jtxtName.setText(cname);
						jtxtPoint.setText(String.valueOf(cpoint));
						jcomLevel.setSelectedItem(levelname);
					}
					jtxtPool.setText("전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 앞으로 구매할 금액\n");
					jtxtPool.append("─────────────────────────────────────────────────────\n");
					if(!customers.isEmpty()) {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
					}else {
						jtxtPool.append("해당 이름의 고객이 없어요");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(rs!=null) rs.close(); 
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("이름을 입력하신 뒤 이름검색하세요");
			}//if 이름입력 여부
		}else if(e.getSource()==jbtnPoint) { // 포인트로 구매
			String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT-? WHERE cID=?";
			String cid = jtxtId.getText().trim();
			int cpoint = Integer.parseInt(jtxtPoint.getText());
			int camount = Integer.parseInt(jtxtAmount.getText());
			if(cpoint>=camount && cid.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, camount);
					pstmt.setString(2, cid);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("포인트로만 구매 성공");
						// 차감된 포인트를 DB에서 가져오지 않고 그냥 계산해서 넣음
						jtxtPoint.setText(String.valueOf(cpoint-camount)); 
						jtxtAmount.setText("");
					}else {
						jtxtPool.setText("해당 ID가 없습니다");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(rs   !=null) rs.close(); 
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else { // 포인트가 살 구매금액보다 작은 경우
				jtxtPool.setText("id도 알아야 하고, 포인트도 부족하면 포인트 결제가 불가해요");
			}
		}else if(e.getSource()==jbtnBuy) { // 물품구매
			String sql = "UPDATE CUSTOMER SET cPOINT = cPOINT+?*0.05, " + 
				"              cAMOUNT = cAMOUNT + ?, " + 
				"              LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L" + 
				"                         WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID=?)" + 
				"            WHERE cID=?";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				int camount = Integer.parseInt(jtxtAmount.getText().trim());
				int cid = Integer.parseInt(jtxtId.getText());
				pstmt.setInt(1, camount);
				pstmt.setInt(2, camount);
				pstmt.setInt(3, camount);
				pstmt.setInt(4, cid);
				pstmt.setInt(5, cid);
				int result = pstmt.executeUpdate();
				if(result>0) {
					jtxtPool.setText("물품구매 성공\n");
					int cpoint = Integer.parseInt(jtxtPoint.getText());
					int updatePoint = (int)(cpoint+camount*0.05);
					jtxtPoint.setText(String.valueOf(updatePoint));
					jtxtAmount.setText("");
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}finally {
				try{
					if(pstmt !=null) pstmt.close();
					if(conn  !=null) conn.close();
				}catch (Exception ignored) { }
			}//try-catch-finally

		}else if(e.getSource()==jbtnLevelOutput) {// 등급별출력
			String sql = "SELECT CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
					"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO!=5) LEVELUP " + 
					"    FROM CUSTOMER C, CUS_LEVEL L" + 
					"    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=?";
			if(jcomLevel.getSelectedIndex()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, jcomLevel.getSelectedItem().toString());
					rs = pstmt.executeQuery();
					while(rs.next()) {
						String ctel = rs.getString("ctel");
						String cname = rs.getString("cname");
						int cpoint = rs.getInt("cpoint");
						int camount = rs.getInt("camount");
						String levelname= rs.getString("levelname");
						int levelup = rs.getInt("levelup");
						customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
					}
					jtxtPool.setText("전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 구매할 금액\n");
					jtxtPool.append("─────────────────────────────────────────────────────\n");
					if(!customers.isEmpty()) {
						for(CustomerDto c : customers)
							jtxtPool.append(c.toString());
						jtxtPool.append("─────────────────────────────────────────────────────\n");
						jtxtPool.append("총 "+customers.size()+"명");
					}else {
						jtxtPool.append("해당 고객은 없습니다");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try{
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("등급을 선택 후 등급별 출력을 클릭하세요");
			}
		}else if(e.getSource()==jbtnAllOutput) { // 전체출력
			String sql = "SELECT CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
					"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE cID=C.cID AND LEVELNO!=5) LEVELUP" + 
					"    FROM CUSTOMER C, CUS_LEVEL L" + 
					"    WHERE C.LEVELNO=L.LEVELNO" + 
					"    ORDER BY CAMOUNT DESC";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String ctel = rs.getString("ctel");
					String cname = rs.getString("cname");
					int cpoint = rs.getInt("cpoint");
					int camount = rs.getInt("camount");
					String levelname= rs.getString("levelname");
					int levelup = rs.getInt("levelup");
					customers.add(new CustomerDto(ctel, cname, cpoint, camount, levelname, levelup));
				}
				jtxtPool.setText("전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 구매할 금액\n");
				jtxtPool.append("─────────────────────────────────────────────────────\n");
				if(!customers.isEmpty()) {
					for(CustomerDto c : customers)
						jtxtPool.append(c.toString());
					jtxtPool.append("─────────────────────────────────────────────────────\n");
					jtxtPool.append("총 "+customers.size()+"명");
				}else {
					jtxtPool.append("고객이 없습니다");
				}
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try{
					if(rs   !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				}catch (Exception ignored) { }
			}//try-catch-finally
		}else if(e.getSource()==jbtnInsert) { // 회원가입
			String sql = "INSERT INTO CUSTOMER (cID, cTEL, cNAME) VALUES " + 
							"    (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
			String ctel = jtxtTel.getText().trim();
			String cname = jtxtName.getText().trim();
			if(ctel.length()!=0 && cname.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					pstmt.setString(2, cname);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("회원가입 감사합니다. 포인트 1000점을 회원가입선물로 드립니다");
						jtxtPoint.setText("1000");
						jcomLevel.setSelectedIndex(1);
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("전화번호와 이름을 입력후 회원가입이 가능해요");
			}// if 회원가입시 전화번호와 이름을 입력해야 가능
		}else if(e.getSource()==jbtnTelUpdate) { // 폰번호 수정
			String sql = "UPDATE CUSTOMER SET cTEL=? WHERE cID=?";
			String cid = jtxtId.getText().trim();
			String ctel = jtxtTel.getText().trim();
			if(cid.length()!=0 && ctel.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ctel);
					pstmt.setString(2, cid);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText("번호 수정이 완료되었습니다");
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("전화번호와 이름을 입력후 번호수정이 가능해요");
			}// if 번호수정시 전화번호와 이름을 입력해야 가능

		}else if(e.getSource()==jbtnDelete) { // 회원탈퇴
			String sql = "DELETE FROM CUSTOMER WHERE cID=?";
			String cid = jtxtId.getText().trim();
			if(cid.length()!=0) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, cid);
					int result = pstmt.executeUpdate();
					if(result>0) {
						jtxtPool.setText(jtxtTel.getText().trim()+"님 회원 탈퇴가 완료되었습니다");
						jtxtId.setText("");
						jtxtTel.setText(""); jtxtName.setText(""); 
						jtxtPoint.setText(""); jcomLevel.setSelectedIndex(0);
					}
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try{
						if(pstmt!=null)pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception ignored) { }
				}//try-catch-finally
			}else {
				jtxtPool.setText("아이디가 있어야 회원탈퇴 가능해요");
			} // if 회원탈퇴시 전화번호가 입력되어 있어야 가능

		}else if(e.getSource()==jbtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMng("고객관리");
	}
}
