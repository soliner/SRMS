package cn.itcast.usermng.service;

import cn.itcast.usermng.dao.TeacherDao;
import cn.itcast.usermng.domain.PageBean;
import cn.itcast.usermng.domain.Teacher;

public class TeacherService {
	private TeacherDao teacherDao = new TeacherDao();

	public void add(Teacher c) {
		// TODO Auto-generated method stub
		teacherDao.add(c);
	}

	public Teacher load(String pid) {
		// TODO Auto-generated method stub
		return teacherDao.load(pid);
	}

	public void edit(Teacher rp) {
		// TODO Auto-generated method stub
		teacherDao.edit(rp);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		teacherDao.delete(pid);
	}

	public PageBean<Teacher> query(Teacher criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return teacherDao.query(criteria, pc, ps);
	}

}
