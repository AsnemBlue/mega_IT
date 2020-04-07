package com.tj.ex.service;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;
public class MemberJoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tempbirth = request.getParameter("tempbirth");
		Timestamp birth = null;
		if(tempbirth!=null) {
			birth = Timestamp.valueOf(tempbirth + " 00:00:00");
		}
		String address = request.getParameter("address");
		MemberDto member = new MemberDto(id, pw, name, email, birth, null, address);
		MemberDao mDao = MemberDao.getInstance();
		request.setAttribute("joinResult", mDao.insertMember(member));
	}
}











