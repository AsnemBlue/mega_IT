package com.tj.ch17_2.service;
import java.util.List;
import com.tj.ch17_2.dto.*;
public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp emp);//paging - controller단
	public int total();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public List<EmpDept> empDeptList(String pageNum); // paging-service단
	public void insert50();
}
