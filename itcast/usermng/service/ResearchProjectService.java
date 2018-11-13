package cn.itcast.usermng.service;

import cn.itcast.usermng.dao.ResearchProjectDao;
import cn.itcast.usermng.domain.Customer;
import cn.itcast.usermng.domain.PageBean;
import cn.itcast.usermng.domain.ResearchProject;

public class ResearchProjectService {
	private ResearchProjectDao researchProjectDao = new ResearchProjectDao();
	/**
	 * 添加项目
	 * @param rp
	 */
	public void add(ResearchProject rp) {
		researchProjectDao.add(rp);
	}
	public ResearchProject load(String pid) {
		return researchProjectDao.load(pid);
	}
	public void edit(ResearchProject rp) {
		researchProjectDao.edit(rp);
	}
	public void delete(String pid) {
		researchProjectDao.delete(pid);
		
	}
	public PageBean<ResearchProject> query(ResearchProject criteria, int pc, int ps) {
		return researchProjectDao.query(criteria, pc, ps);
	}

}
