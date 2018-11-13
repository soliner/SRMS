package cn.mnsrc.holdacademicreport.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.holdacademicreport.dao.HoldAcademicReportDao;
import cn.mnsrc.holdacademicreport.domain.HoldAcademicReport;

public class HoldAcademicReportService {
	private HoldAcademicReportDao holdAcademicReportDao = new HoldAcademicReportDao();

	public void add(HoldAcademicReport s) {
		// TODO Auto-generated method stub
		holdAcademicReportDao.add(s);
	}

	public HoldAcademicReport load(String pid) {
		// TODO Auto-generated method stub
		return holdAcademicReportDao.load(pid);
	}

	public void edit(HoldAcademicReport s) {
		// TODO Auto-generated method stub
		holdAcademicReportDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		holdAcademicReportDao.delete(pid);
	}

	public PageBean<HoldAcademicReport> query(HoldAcademicReport criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return holdAcademicReportDao.query(criteria, pc, ps);
	}

}
