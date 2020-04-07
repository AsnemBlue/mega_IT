package com.tj.ch17_2.service;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tj.ch17_2.dao.DeptDao;
import com.tj.ch17_2.dao.EmpDao;
import com.tj.ch17_2.dto.Dept;
import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.dto.EmpDept;
import com.tj.ch17_2.util.Paging;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}
	@Override
	public List<Emp> empList(Emp emp) { // startRow, endRow는 controller에서
		return empDao.empList(emp);
	}
	@Override
	public int total() {
		return empDao.total();
	}
	@Override
	public Emp detail(int empno) {
		return empDao.detail(empno);
	}
	@Override
	public List<Emp> managerList() {
		return empDao.managerList();
	}
	@Override
	public int insert(Emp emp) {
		return empDao.insert(emp);
	}
	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}
	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}
	@Override
	public List<EmpDept> empDeptList(String pageNum) {
		Paging paging = new Paging(empDao.total(), pageNum, 10, 10);
		EmpDept empDept = new EmpDept();
		empDept.setStartRow(paging.getStartRow());
		empDept.setEndRow(paging.getEndRow());
		return empDao.empDeptList(empDept);
	}
	@Override
	public void insert50() {
		Emp emp = new Emp();
		for(int i=2000 ; i<2050 ; i++) {
			emp.setEmpno(i);
			emp.setEname("홍"+i);
			emp.setJob("IT");
			emp.setMgr(7566);
			emp.setHiredate(Timestamp.valueOf("2020-04-03 15:43:00"));
			emp.setSal(i);
			emp.setComm(i/10);
			emp.setDeptno(40);
			int result = empDao.insert(emp);
			System.out.println(result==1? i+"번째 성공":"실패");
		}
	}
}















