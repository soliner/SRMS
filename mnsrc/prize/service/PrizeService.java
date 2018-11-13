package cn.mnsrc.prize.service;

import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.prize.dao.PrizeDao;
import cn.mnsrc.prize.domain.Prize;

public class PrizeService {
	private PrizeDao prizeDao = new PrizeDao();

	public void add(Prize s) {
		// TODO Auto-generated method stub
		prizeDao.add(s);
	}

	public Prize load(String pid) {
		// TODO Auto-generated method stub
		return prizeDao.load(pid);
	}

	public void edit(Prize s) {
		// TODO Auto-generated method stub
		prizeDao.edit(s);
	}

	public void delete(String pid) {
		// TODO Auto-generated method stub
		prizeDao.delete(pid);
	}

	public PageBean<Prize> query(Prize criteria, int pc, int ps) {
		// TODO Auto-generated method stub
		return prizeDao.query(criteria, pc, ps);
	}

}
