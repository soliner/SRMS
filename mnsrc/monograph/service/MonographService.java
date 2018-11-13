package cn.mnsrc.monograph.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.monograph.dao.MonographDao;
import cn.mnsrc.monograph.domain.Monograph;

public class MonographService {
	private MonographDao monographDao = new MonographDao();

	public void add(Monograph s) {
		monographDao.add(s);
	}

	public Monograph load(String pid) {
		// TODO Auto-generated method stub
		return monographDao.load(pid);
	}

	public void edit(Monograph s) {
		// TODO Auto-generated method stub
		monographDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		monographDao.delete(pid);
	}

	public PageBean<Monograph> query(Monograph criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return monographDao.query(criteria, pc, ps);
	}

}
