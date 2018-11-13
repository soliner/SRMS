package cn.mnsrc.resultidentification.dao;


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


import cn.mnsrc.resultidentification.domain.ResultIdentification;

public class ResultIdentificationDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(ResultIdentification s) {
		String sql = "insert into `成果鉴定` values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { s.getId(), s.get成果名称(),s.get姓名(), s.get工号(),  s.get参与人员(), s.get鉴定验收单位(),
				s.get鉴定日期(), s.get鉴定结论(), s.get电子附件() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultIdentification load(String pid) {
		String sql = "select * from `成果鉴定` where id=?";
		try {
			return qr.query(sql, new BeanHandler<ResultIdentification>(ResultIdentification.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(ResultIdentification s) {
		try {
			String sql = "update `成果鉴定` set `成果名称`=?, `姓名`=?, `工号`=?,  "
					+ " `参与人员`=?,`鉴定验收`=?,`鉴定日期`=?,`鉴定结论`=?, `电子附件`=? where id=?";
			Object[] params = {  s.get成果名称(),s.get姓名(), s.get工号(),  s.get参与人员(), s.get鉴定验收单位(),
					s.get鉴定日期(), s.get鉴定结论(), s.get电子附件(), s.getId()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `成果鉴定` where id=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public PageBean<ResultIdentification> query(ResultIdentification criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<ResultIdentification> pb = new PageBean<ResultIdentification>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `成果鉴定`");
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
		StringBuilder sql = new StringBuilder("select * from `成果鉴定`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<ResultIdentification> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<ResultIdentification>(ResultIdentification.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}
