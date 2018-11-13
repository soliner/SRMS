package cn.itcast.usermng.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.usermng.domain.Customer;
import cn.itcast.usermng.domain.PageBean;
import cn.itcast.usermng.domain.ResearchProject;

public class ResearchProjectDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(ResearchProject rp) {
		String sql = "insert into `科研项目统计表` values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { rp.get项目序号(), rp.get姓名(), rp.get工号(), rp.get参与人(), rp.get项目来源(), rp.get项目编号(),
				rp.get项目名称(), rp.get起始时间(),rp.get结束时间(), rp.get合同经费(), rp.get进账总经费(), rp.get备注() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResearchProject load(String pid) {
		String sql = "select * from `科研项目统计表` where `项目编号`=?";
		try {
			return qr.query(sql, new BeanHandler<ResearchProject>(ResearchProject.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(ResearchProject rp) {
		try {
			String sql = "update `科研项目统计表` set `姓名`=?, `工号`=?, `参与人`=?, "
					+ " `项目来源`=?,`项目名称`=?,`起始时间`=?,`结束时间`=?, `合同经费`=?," 
					+ "`进账总经费`=?,`备注`=? where `项目编号`=?";
			Object[] params = { rp.get姓名(), rp.get工号(), rp.get参与人(), rp.get项目来源(), 
					rp.get项目名称(), rp.get起始时间(),rp.get结束时间(), rp.get合同经费(), rp.get进账总经费(), rp.get备注(), rp.get项目编号()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `科研项目统计表` where `项目编号`=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public PageBean<ResearchProject> query(ResearchProject criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<ResearchProject> pb = new PageBean<ResearchProject>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `科研项目统计表`");
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
		Date startdate = criteria.get起始时间();
		if (startdate != null && !startdate.toString().trim().isEmpty()) {
			whereSql.append(" between `起始时间` = ?");
			params.add(startdate );
		}
		Date enddate = criteria.get结束时间();
		if (enddate != null && !enddate.toString().trim().isEmpty()) {
			whereSql.append(" and `结束时间`=?");
			params.add(enddate);
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
		StringBuilder sql = new StringBuilder("select * from `科研项目统计表`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<ResearchProject> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<ResearchProject>(ResearchProject.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}
