package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;
public class BReplyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fId = Integer.parseInt(request.getParameter("fId"));
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto dto      = boardDao.modifyView_replyView(fId);
		request.setAttribute("reply_view", dto);
	}
}