package cn.mnsrc.corepaper.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.corepaper.dao.CorePaperDao;
import cn.mnsrc.corepaper.domain.CorePaper;

public class CorePaperService {
	private CorePaperDao corePaperDao = new CorePaperDao();

	public void add(CorePaper s) {
		corePaperDao.add(s);
	}

	public CorePaper load(String pid) {
		return corePaperDao.load(pid);
	}

	public void edit(CorePaper s) {
		corePaperDao.edit(s);
	}

	public void delete(String pid) {
		corePaperDao.delete(pid);
	}

	public PageBean<CorePaper> query(CorePaper criteria, int pc, int ps) {
		return corePaperDao.query(criteria, pc, ps);
	}

}
