package cn.mnsrc.holdacademicreport.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.holdacademicreport.domain.HoldAcademicReport;

public class HoldAcademicReportDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(HoldAcademicReport s) {
		String sql = "insert into `举办学术报告统计表` values(?,?,?,?,?,?,?,?)";
		Object[] params = { s.get报告人姓名(), s.get举办时间(), s.get单位(), s.get职务(), s.get报告题目(), s.get地点(),
				s.get联系人(), s.get备注() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HoldAcademicReport load(String pid) {
		String sql = "select * from `举办学术报告统计表` where `报告题目`=?";
		try {
			return qr.query(sql, new BeanHandler<HoldAcademicReport>(HoldAcademicReport.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(HoldAcademicReport s) {
		try {
			String sql = "update `举办学术报告统计表` set `报告人姓名`=?, `举办时间`=?, `单位`=?, "
					+ " `职务`=?,`报告题目`=?,`地点`=?,`联系人`=?, `备注`=? where `报告题目`=?";
			Object[] params = { s.get报告人姓名(), s.get举办时间(), s.get单位(), s.get职务(), s.get报告题目(), s.get地点(),
					s.get联系人(), s.get备注(), s.get报告题目()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `举办学术报告统计表` where `报告题目`=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public PageBean<HoldAcademicReport> query(HoldAcademicReport criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<HoldAcademicReport> pb = new PageBean<HoldAcademicReport>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `举办学术报告统计表`");
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		/*
		 * 2.判断条件，完成向sql中追加where子句
		 */
		/*
		 * 3. 创建一个ArrayList，用来装载参数值
		 */
		List<Object> params = new ArrayList<Object>();
		String pid = criteria.get报告人姓名();
		if (pid != null && !pid.trim().isEmpty()) {
			whereSql.append(" and `工号` like ?");
			params.add("%" + pid + "%");
		}
		String pname = criteria.get举办时间();
		if (pname != null && !pname.trim().isEmpty()) {
			whereSql.append(" and `举办时间` between ? and ?");
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
		StringBuilder sql = new StringBuilder("select * from `举办学术报告统计表`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<HoldAcademicReport> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<HoldAcademicReport>(HoldAcademicReport.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}

