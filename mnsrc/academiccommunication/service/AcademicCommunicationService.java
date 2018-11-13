package cn.mnsrc.academiccommunication.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.academiccommunication.dao.AcademicCommunicationDao;
import cn.mnsrc.academiccommunication.domain.AcademicCommunication;

public class AcademicCommunicationService {
	private AcademicCommunicationDao academicCommunicationDao = new AcademicCommunicationDao();

	public void add(AcademicCommunication s) {
		// TODO Auto-generated method stub
		academicCommunicationDao.add(s);
	}

	public AcademicCommunication load(String pid) {
		// TODO Auto-generated method stub
		return academicCommunicationDao.load(pid);
	}

	public void edit(AcademicCommunication s) {
		// TODO Auto-generated method stub
		academicCommunicationDao.edit(s);
		
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		academicCommunicationDao.delete(pid);
	}

	public PageBean<AcademicCommunication> query(AcademicCommunication criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return academicCommunicationDao.query(criteria, pc, ps);
	}

}
