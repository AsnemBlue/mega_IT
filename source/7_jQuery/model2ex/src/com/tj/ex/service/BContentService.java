package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;
public class BContentService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fId = Integer.parseInt(request.getParameter("fId"));
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto dto = boardDao.contentView(fId);
		request.setAttribute("content_view", dto);
	}

}
