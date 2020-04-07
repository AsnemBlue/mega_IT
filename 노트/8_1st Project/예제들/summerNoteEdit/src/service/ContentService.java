package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bdao;
import dto.Bdto;

public class ContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Bdao bdao = new Bdao();
		int bno = Integer.parseInt(request.getParameter("bno"));
		Bdto dto = bdao.getDto(bno);
		request.setAttribute("dto", dto);
	}

}
