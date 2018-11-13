package cn.mnsrc.researchproject.service;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import cn.itcast.usermng.domain.Customer;
import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.researchproject.dao.ResearchProjectDao;
import cn.mnsrc.researchproject.domain.ResearchProject;

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
	public List exportExcel() {
		return researchProjectDao.exportExcel();
		
	}
	public void exportExcel1(String excelname, List<Map<String, Object>> list, OutputStream out, String string) {
		// TODO Auto-generated method stub
		
	}

}
