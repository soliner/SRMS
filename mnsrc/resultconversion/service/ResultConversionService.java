package cn.mnsrc.resultconversion.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.resultconversion.dao.ResultConversionDao;
import cn.mnsrc.resultconversion.domain.ResultConversion;

public class ResultConversionService {
	private ResultConversionDao resultConversionDao = new ResultConversionDao();

	public void add(ResultConversion s) {
		// TODO Auto-generated method stub
		resultConversionDao.add(s);
	}

	public ResultConversion load(String pid) {
		// TODO Auto-generated method stub
		return resultConversionDao.load(pid);
	}

	public void edit(ResultConversion s) {
		// TODO Auto-generated method stub
		resultConversionDao.edit(s);
		
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		resultConversionDao.delete(pid);
		
	}

	public PageBean<ResultConversion> query(ResultConversion criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return resultConversionDao.query(criteria, pc, ps);
	}

}
