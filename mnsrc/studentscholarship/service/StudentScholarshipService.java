package cn.mnsrc.studentscholarship.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.studentscholarship.dao.StudentScholarshipDao;
import cn.mnsrc.studentscholarship.domain.StudentScholarship;

public class StudentScholarshipService {
	private StudentScholarshipDao studentScholarshipDao = new StudentScholarshipDao();

	public void add(StudentScholarship s) {
		// TODO Auto-generated method stub
		studentScholarshipDao.add(s);
	}

	public StudentScholarship load(String name, String stu) {
		// TODO Auto-generated method stub
		return studentScholarshipDao.load(name, stu);
	}

	public void edit(StudentScholarship s) {
		// TODO Auto-generated method stub
		studentScholarshipDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		studentScholarshipDao.delete(pid);
	}

	public PageBean<StudentScholarship> query(StudentScholarship criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return studentScholarshipDao.query(criteria, pc, ps);
	}

}
