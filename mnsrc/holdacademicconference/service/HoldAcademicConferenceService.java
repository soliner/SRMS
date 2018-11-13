package cn.mnsrc.holdacademicconference.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.holdacademicconference.dao.HoldAcademicConferenceDao;
import cn.mnsrc.holdacademicconference.domain.HoldAcademicConference;

public class HoldAcademicConferenceService {
	private HoldAcademicConferenceDao holdAcademicConferenceDao = new HoldAcademicConferenceDao();

	public void add(HoldAcademicConference s) {
		// TODO Auto-generated method stub
		holdAcademicConferenceDao.add(s);
	}

	public HoldAcademicConference load(String pid) {
		// TODO Auto-generated method stub
		return holdAcademicConferenceDao.load(pid);
	}

	public void edit(HoldAcademicConference s) {
		// TODO Auto-generated method stub
		holdAcademicConferenceDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		holdAcademicConferenceDao.delete(pid);
	}

	public PageBean<HoldAcademicConference> query(HoldAcademicConference criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return holdAcademicConferenceDao.query(criteria, pc, ps);
	}
	

}
