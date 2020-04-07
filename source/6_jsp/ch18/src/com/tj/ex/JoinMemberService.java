package com.tj.ex;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.member.MemberDao;
import com.tj.member.MemberDto;
public class JoinMemberService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dto = new MemberDto();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setBirth(Timestamp.valueOf(request.getParameter("tempbirth")+" 00:00:00"));
		dto.setAddress(request.getParameter("address"));
		MemberDao dao = MemberDao.getInstance();
		request.setAttribute("joinResult", dao.insertMember(dto));
	}
}
