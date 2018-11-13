package cn.mnsrc.resultadoption.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.resultadoption.dao.ResultAdoptionDao;
import cn.mnsrc.resultadoption.domain.ResultAdoption;

public class ResultAdoptionService {
	private ResultAdoptionDao resultAdoptionDao = new ResultAdoptionDao();

	public void add(ResultAdoption c) {
		// TODO Auto-generated method stub
		resultAdoptionDao.add(c);
	}

	public ResultAdoption load(String pid) {
		// TODO Auto-generated method stub
		return resultAdoptionDao.load(pid);
	}

	public void edit(ResultAdoption rp) {
		// TODO Auto-generated method stub
		resultAdoptionDao.edit(rp);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		resultAdoptionDao.delete(pid);
	}

	public PageBean<ResultAdoption> query(ResultAdoption criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return resultAdoptionDao.query(criteria, pc, ps);
	}
	

}
