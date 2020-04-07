package com.tj.ch17_2.dao;
import java.util.List;
import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.dto.EmpDept;
public interface EmpDao {
	public List<Emp> empList(Emp emp);
	public int total();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public List<EmpDept> empDeptList(EmpDept empDept);
}
