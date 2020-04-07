package com.tj.ch17_1.service;
import java.util.List;
import com.tj.ch17_1.dto.Dept;
import com.tj.ch17_1.dto.Emp;
public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}