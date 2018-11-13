package cn.mnsrc.joinacademicconference.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.joinacademicconference.dao.JoinAcademicConferenceDao;
import cn.mnsrc.joinacademicconference.domain.JoinAcademicConference;

public class JoinAcademicConferenceService {
	private JoinAcademicConferenceDao joinAcademicConferenceDao = new JoinAcademicConferenceDao();

	public void add(JoinAcademicConference s) {
		// TODO Auto-generated method stub
		joinAcademicConferenceDao.add(s);
	}

	public JoinAcademicConference load(String pid) {
		// TODO Auto-generated method stub
		return joinAcademicConferenceDao.load(pid);
	}

	public void edit(JoinAcademicConference s) {
		// TODO Auto-generated method stub
		joinAcademicConferenceDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		joinAcademicConferenceDao.delete(pid);
	}

	public PageBean<JoinAcademicConference> query(JoinAcademicConference criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return joinAcademicConferenceDao.query(criteria, pc, ps);
	}
	 

}
