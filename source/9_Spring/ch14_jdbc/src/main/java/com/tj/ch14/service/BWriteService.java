package com.tj.ch14.service;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import com.tj.ch14.dao.BoardDao;
import com.tj.ch14.dto.BoardDto;
public class BWriteService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // model안의 attribute값을 추출하기 위해 map화
		BoardDto bDto = (BoardDto)map.get("boardDto"); // bname, btitle, bcontent
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		bDto.setBip(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.write(bDto);
		model.addAttribute("writeResult", result);
	}
}















