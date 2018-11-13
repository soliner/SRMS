package cn.mnsrc.eipaper.dao;

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
import cn.mnsrc.eipaper.domain.EIPaper;
import cn.mnsrc.researchproject.domain.ResearchProject;

public class EIPaperDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(EIPaper s) {
		String sql = "insert into `ei论文统计` values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { s.get序号(), s.get姓名(), s.get工号(), s.get论文名称(), s.get发表时间(), s.get作者(),
				s.get是否是第一完成单位(), s.get收录号(),s.get分区(), s.get他引次数(), s.get备注() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public EIPaper load(String pid) {
		String sql = "select * from `ei论文统计` where `序号`=?";
		try {
			return qr.query(sql, new BeanHandler<EIPaper>(EIPaper.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(EIPaper s) {
		try {
			String sql = "update `ei论文统计` set `姓名`=?, `工号`=?, `论文名称`=?, "
					+ " `发表时间`=?,`作者`=?,`是否是第一完成单位`=?,`收录号`=?, `分区`=?," 
					+ "`他引次数`=?,`备注`=? where `序号`=?";
			Object[] params = { s.get序号(), s.get姓名(), s.get工号(), s.get论文名称(), s.get发表时间(), s.get作者(),
					s.get是否是第一完成单位(), s.get收录号(),s.get分区(), s.get他引次数(), s.get备注()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `ei论文统计` where `序号`=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public PageBean<EIPaper> query(EIPaper criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<EIPaper> pb = new PageBean<EIPaper>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `ei论文统计`");
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
		StringBuilder sql = new StringBuilder("select * from `ei论文统计`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<EIPaper> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<EIPaper>(EIPaper.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}
