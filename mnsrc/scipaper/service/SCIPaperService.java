package cn.mnsrc.scipaper.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.scipaper.dao.SCIPaperDao;
import cn.mnsrc.scipaper.domain.SCIPaper;

public class SCIPaperService {
	private SCIPaperDao sciPaperDao = new SCIPaperDao();


	public void add(SCIPaper s) {
		sciPaperDao.add(s);
		
	}


	public SCIPaper load(String pid) {
		return sciPaperDao.load(pid);
	}


	public void edit(SCIPaper s) {
		sciPaperDao.edit(s);
		
	}


	public void delete(String pid) {
		sciPaperDao.delete(pid);
	}


	public PageBean<SCIPaper> query(SCIPaper criteria, int pc, int ps) {
		return sciPaperDao.query(criteria, pc, ps);
	}
	

}
