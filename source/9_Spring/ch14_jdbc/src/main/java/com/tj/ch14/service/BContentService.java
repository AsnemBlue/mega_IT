package com.tj.ch14.service;
import java.util.Map;
import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
public class BContentService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("dto", bDao.contentView(bid));
	}
}
