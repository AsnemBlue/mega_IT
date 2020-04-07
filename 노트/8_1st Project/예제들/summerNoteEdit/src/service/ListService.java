package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bdao;
import dto.Bdto;

public class ListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Bdao bdao = new Bdao();
		ArrayList<Bdto> list = bdao.list();
		request.setAttribute("list", list);
	}

	
}
