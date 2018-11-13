package cn.mnsrc.softwarepatent.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.softwarepatent.domain.SoftwarePatent;


public class SoftwarePatentDao {
	QueryRunner qr = new TxQueryRunner();

	public void add(SoftwarePatent s) {
		String sql = "insert into `软件著作权统计` values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {s.getId(), s.get姓名(), s.get工号(), s.get时间(), s.get著作权名称(),
				s.get授权号(), s.get备注()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	

	public SoftwarePatent load(String pid) {
		String sql = "select * from `软件著作权统计` where id=?";
		try {
			return qr.query(sql, new BeanHandler<SoftwarePatent>(SoftwarePatent.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(SoftwarePatent s) {
		try {
			String sql = "update `软件著作权统计` set `姓名`=?, `工号`=?, `时间`=?, "
					+ " `著作权名称`=?,`授权号`=?,`备注`=? where id=?";
			Object[] params = { s.get姓名(), s.get工号(), s.get时间(), s.get著作权名称(),
					s.get授权号(), s.get备注(),  s.getId()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `软件著作权统计` where id=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public PageBean<SoftwarePatent> query(SoftwarePatent criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<SoftwarePatent> pb = new PageBean<SoftwarePatent>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `软件著作权统计`");
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		/*
		 * 2.判断条件，完成向sql中追加where子句
		 */
		/*
		 * 3. 创建一个ArrayList，用来装载参数值
		 */
		List<Object> params = new ArrayList<Object>();
		String pid = criteria.get工号();
		if (pid != null && !pid.trim().isEmpty()) {
			whereSql.append(" and `工号` like ?");
			params.add("%" + pid + "%");
		}
		String pname = criteria.get姓名();
		if (pname != null && !pname.trim().isEmpty()) {
			whereSql.append(" and `姓名` like ?");
			params.add(pname);
		}
		
		/**
		 * 执行
		 */
		try {

		Number num = (Number)qr.query(cntSql.append(whereSql).toString(), 
				new ScalarHandler(), params.toArray());
		int tr = num.intValue();
		pb.setTr(tr);
		/*
		 * 得到beanList
		 */
		StringBuilder sql = new StringBuilder("select * from `软件著作权统计`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<SoftwarePatent> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<SoftwarePatent>(SoftwarePatent.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}

