package com.tj.ch18_sch.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch18_sch.dto.Member;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public int idConfirm(String mid) {
		return sessionTemplate.selectOne("idConfirm", mid);
	}
	@Override
	public int joinMember(Member member) {
		return sessionTemplate.insert("joinMember", member);
	}
	@Override
	public Member getMember(String mid) {
		return sessionTemplate.selectOne("getMember", mid);
	}
	@Override
	public int modifyMember(Member member) {
		return sessionTemplate.update("modifyMember", member);
	}
}
