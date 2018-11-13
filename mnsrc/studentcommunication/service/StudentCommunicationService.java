package cn.mnsrc.studentcommunication.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.studentcommunication.dao.StudentCommunicationDao;
import cn.mnsrc.studentcommunication.domain.StudentCommunication;

public class StudentCommunicationService {
	private StudentCommunicationDao studentCommunicationDao = new StudentCommunicationDao();

	public void add(StudentCommunication s) {
		// TODO Auto-generated method stub
		studentCommunicationDao.add(s);
		
	}

	public StudentCommunication load(String pid) {
		// TODO Auto-generated method stub
		return studentCommunicationDao.load(pid);
	}

	public void edit(StudentCommunication s) {
		// TODO Auto-generated method stub
		studentCommunicationDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		studentCommunicationDao.delete(pid);
	}

	public PageBean<StudentCommunication> query(StudentCommunication criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return studentCommunicationDao.query(criteria, pc, ps);
	}

}
