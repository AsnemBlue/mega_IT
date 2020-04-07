package com.tj.ch13.service;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import com.tj.ch13.dao.BoardDao;
import com.tj.ch13.dto.BoardDto;
public class BModifyService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDto           bDto    = (BoardDto)map.get("bDto");
		bDto.setBip(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		model.addAttribute("modifyResult", bDao.modify(bDto));
	}

}
