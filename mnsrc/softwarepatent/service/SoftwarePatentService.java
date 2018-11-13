package cn.mnsrc.softwarepatent.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.softwarepatent.dao.SoftwarePatentDao;
import cn.mnsrc.softwarepatent.domain.SoftwarePatent;

public class SoftwarePatentService {
	private SoftwarePatentDao softwarePatentDao = new SoftwarePatentDao();

	public void add(SoftwarePatent s) {
		// TODO Auto-generated method stub
		softwarePatentDao.add(s);
	}

	public SoftwarePatent load(String pid) {
		// TODO Auto-generated method stub
		return softwarePatentDao.load(pid);
	}

	public void edit(SoftwarePatent s) {
		// TODO Auto-generated method stub
		softwarePatentDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		softwarePatentDao.delete(pid);
	}

	public PageBean<SoftwarePatent> query(SoftwarePatent criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return softwarePatentDao.query(criteria, pc, ps);
	}
	

}
