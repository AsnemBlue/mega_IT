package com.tj.ch18_sch.service;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.tj.ch18_sch.dao.MemberDao;
import com.tj.ch18_sch.dto.Member;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao; 
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Override
	public Member getMember(String mid) {
		return memberDao.getMember(mid);
	}
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}
	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		// member.getmmail()에게 가입감사메일 보내기
		MimeMessagePreparator message = new MimeMessagePreparator() {
		String content = 
			"  <h1>"+member.getMname()+"님의 회원가입을 축하드립니다</h1>"+
			"  <div>" + 
			"    <div>" + 
			"      아무개 싸이트에서만 쓰실 수 있는 쿠폰을 드립니다\n\n" + 
			"      <hr color=\"red\"/>" + 
			"    </div>" + 
			"    <did>" + 
			"      <p style=\"color:blue;\" >파란색 감사</p>" + 
			"      <p style=\"color:red;\">빨간색 감사</p>" + 
			"    </did>" + 
			"  </div>" + 
			"    <div>" + 
			"      <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
			"    </div>" + 
			"    <div style=\"font-weight: blod; font-size: 1.2em;\">아무개 사이트 일동</div>\n" + 
			"    <div style=\"color:red;\">서울시 종로구 수표로 육의전BD 803호</div>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, 
						new InternetAddress(member.getMmail()));
				mimeMessage.setFrom(new InternetAddress("hybrid0506@gmail.com "));
				mimeMessage.setSubject(member.getMname()+"님 회원가입감사합니다(HTML)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		httpSession.setAttribute("mid", member.getMid());
		return memberDao.joinMember(member);
	}
	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memberDao.getMember(mid);
		if(member == null) {
			result = "유효하지 않은 아이디입니다";
		}else if(!member.getMpw().equals(mpw)) {
			result = "비밀번호가 맞지 않습니다";
		}else {
			// 로그인 성공
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mid", mid);
		}
		return result;
	}
	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}
}
