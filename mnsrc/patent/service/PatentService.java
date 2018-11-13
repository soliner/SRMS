package cn.mnsrc.patent.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.patent.dao.PatentDao;
import cn.mnsrc.patent.domain.Patent;

public class PatentService {
	private PatentDao patentDao = new PatentDao();

	public void add(Patent s) {
		// TODO Auto-generated method stub
		patentDao.add(s);
	}

	public Patent load(String pid) {
		// TODO Auto-generated method stub
		return patentDao.load(pid);
	}

	public void edit(Patent s) {
		// TODO Auto-generated method stub
		patentDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		patentDao.delete(pid);
	}

	public PageBean<Patent> query(Patent criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return patentDao.query(criteria, pc, ps);
	}

}
