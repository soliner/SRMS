package cn.mnsrc.resultidentification.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.resultidentification.dao.ResultIdentificationDao;
import cn.mnsrc.resultidentification.domain.ResultIdentification;

public class ResultIdentificationService {
	private ResultIdentificationDao resultIdentificationDao = new ResultIdentificationDao();

	public void add(ResultIdentification s) {
		// TODO Auto-generated method stub
		resultIdentificationDao.add(s);
	}

	public ResultIdentification load(String pid) {
		// TODO Auto-generated method stub
		return resultIdentificationDao.load(pid);
	}

	public void edit(ResultIdentification s) {
		// TODO Auto-generated method stub
		resultIdentificationDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		resultIdentificationDao.delete(pid);
	}

	public PageBean<ResultIdentification> query(ResultIdentification criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return resultIdentificationDao.query(criteria, pc, ps);
	}
	

}
