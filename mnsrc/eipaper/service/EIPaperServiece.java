package cn.mnsrc.eipaper.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.eipaper.dao.EIPaperDao;
import cn.mnsrc.eipaper.domain.EIPaper;
import cn.mnsrc.scipaper.domain.SCIPaper;


public class EIPaperServiece {
	private EIPaperDao eiPaperDao = new EIPaperDao();

	public void add(EIPaper s) {
		eiPaperDao.add(s);
		
	}

	public EIPaper load(String pid) {
		return eiPaperDao.load(pid);
	}

	public void edit(EIPaper s) {
		eiPaperDao.edit(s);
		
	}

	public void delete(String pid) {
		 eiPaperDao.delete(pid);
	}

	public PageBean<EIPaper> query(EIPaper criteria, int pc, int ps) {
		return eiPaperDao.query(criteria, pc, ps);
	}

}
