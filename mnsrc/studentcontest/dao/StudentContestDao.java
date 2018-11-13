package cn.mnsrc.studentcontest.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.studentcontest.domain.StudentContest;

public class StudentContestDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(StudentContest s) {
		String sql = "insert into `学生竞赛情况统计` values(?,?,?,?,?,?,?,?)";
		Object[] params = { s.getId(), s.get姓名(), s.get学号(), s.get时间(), s.get参加竞赛名称(), s.get获奖级别(),
				s.get全部获奖人(), s.get备注() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public StudentContest load(String pid) {
		String sql = "select * from `学生竞赛情况统计` where id=?";
		try {
			return qr.query(sql, new BeanHandler<StudentContest>(StudentContest.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(StudentContest s) {
		try {
			String sql = "update `学生竞赛情况统计` set `姓名`=?, `学号`=?, `时间`=?, "
					+ " `参加竞赛名称`=?,`获奖级别`=?,`全部获奖人`=?, `备注`=? where id=?";
			Object[] params = { s.getId(), s.get姓名(), s.get学号(), s.get时间(), s.get参加竞赛名称(), s.get获奖级别(),
					s.get全部获奖人(), s.get备注(), s.getId()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `学生竞赛情况统计` where id=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public PageBean<StudentContest> query(StudentContest criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<StudentContest> pb = new PageBean<StudentContest>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `学生竞赛情况统计`");
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		/*
		 * 2.判断条件，完成向sql中追加where子句
		 */
		/*
		 * 3. 创建一个ArrayList，用来装载参数值
		 */
		List<Object> params = new ArrayList<Object>();
		String pid = criteria.get学号();
		if (pid != null && !pid.trim().isEmpty()) {
			whereSql.append(" and `工号` like ?");
			params.add("%" + pid + "%");
		}
		String pname = criteria.get时间();
		if (pname != null && !pname.trim().isEmpty()) {
			whereSql.append(" and `时间` between ? and ?");
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
		StringBuilder sql = new StringBuilder("select * from `学生竞赛情况统计`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<StudentContest> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<StudentContest>(StudentContest.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}


