package cn.mnsrc.studentcontest.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.studentcommunication.dao.StudentCommunicationDao;
import cn.mnsrc.studentcontest.dao.StudentContestDao;
import cn.mnsrc.studentcontest.domain.StudentContest;

public class StudentContestService {
	private StudentContestDao studentContestDao = new StudentContestDao();

	public void add(StudentContest s) {
		// TODO Auto-generated method stub
		studentContestDao.add(s);
	}

	public StudentContest load(String pid) {
		// TODO Auto-generated method stub
		return studentContestDao.load(pid);
	}

	public void edit(StudentContest s) {
		// TODO Auto-generated method stub
		studentContestDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		studentContestDao.delete(pid);
	}

	public PageBean<StudentContest> query(StudentContest criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return studentContestDao.query(criteria, pc, ps);
	}

}
