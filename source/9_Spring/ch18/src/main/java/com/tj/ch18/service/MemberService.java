package com.tj.ch18.service;
import javax.servlet.http.HttpSession;
import com.tj.ch18.dto.Member;
public interface MemberService {
	public Member getMember(String mid);
	public int idConfirm(String mid);
	public int joinMember(Member member, HttpSession httpSession);
	public String loginCheck(String mid, String mpw, HttpSession httpSession);
	public int modifyMember(Member member);
}
