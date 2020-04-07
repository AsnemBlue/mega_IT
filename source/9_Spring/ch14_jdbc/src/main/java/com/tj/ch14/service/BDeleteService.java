package com.tj.ch14.service;
import java.util.Map;
import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
public class BDeleteService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("deleteResult", bDao.delete(bid));
	}

}
