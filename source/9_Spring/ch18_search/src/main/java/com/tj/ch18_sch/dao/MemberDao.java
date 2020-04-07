package com.tj.ch18_sch.dao;
import com.tj.ch18_sch.dto.Member;
public interface MemberDao {
	public int idConfirm(String mid);
	public int joinMember(Member member);
	public Member getMember(String mid);
	public int modifyMember(Member member);
}