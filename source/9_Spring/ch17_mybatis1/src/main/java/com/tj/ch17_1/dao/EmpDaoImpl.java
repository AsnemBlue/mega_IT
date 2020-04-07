package com.tj.ch17_1.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tj.ch17_1.dto.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public List<Emp> empList(Emp searchEmp) {
		return sessionTemplate.selectList("empList", searchEmp);
	}
}