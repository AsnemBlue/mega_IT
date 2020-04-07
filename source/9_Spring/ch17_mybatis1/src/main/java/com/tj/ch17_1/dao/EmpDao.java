package com.tj.ch17_1.dao;
import java.util.List;
import com.tj.ch17_1.dto.Emp;
public interface EmpDao {
	public List<Emp> empList(Emp searchEmp);
}