package cn.mnsrc.studentscholarship.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.studentscholarship.domain.StudentScholarship;

public class StudentScholarshipDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(StudentScholarship s) {
		String sql = "insert into `学生获奖学金情况统计` values(?,?,?,?,?,?,?,?)";
		Object[] params = { s.getId(), s.get姓名(), s.get学号(), s.get时间(), s.get奖学金名称(), s.get获奖级别(),
				s.get全部获奖人(), s.get备注() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public StudentScholarship load(String name, String stu) {
		String sql = "select * from `学生获奖学金情况统计` where `姓名`=? and `奖学金名称`=?";
		try {
			return qr.query(sql, new BeanHandler<StudentScholarship>(StudentScholarship.class), name, stu);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(StudentScholarship s) {
		try {
			String sql = "update `学生获奖学金情况统计` set `姓名`=?,  `时间`=?, "
					+ " `奖学金名称`=?,`获奖级别`=?,`全部获奖人`=?, `备注`=? where `姓名`=? and `奖学金名称`=?";
			Object[] params = { s.get姓名(), s.get时间(), s.get奖学金名称(), s.get获奖级别(),
					s.get全部获奖人(), s.get备注(), s.get姓名(), s.get奖学金名称()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `学生获奖学金情况统计` where `奖学金名称`=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public PageBean<StudentScholarship> query(StudentScholarship criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<StudentScholarship> pb = new PageBean<StudentScholarship>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `学生获奖学金情况统计`");
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		/*
		 * 2.判断条件，完成向sql中追加where子句
		 */
		/*
		 * 3. 创建一个ArrayList，用来装载参数值
		 */
		List<Object> params = new ArrayList<Object>();
		String pid = criteria.get姓名();
		if (pid != null && !pid.trim().isEmpty()) {
			whereSql.append(" and `工号` like ?");
			params.add("%" + pid + "%");
		}
		Date time = (Date)criteria.get时间();
		if (time != null && !time.toString().trim().isEmpty()) {
			whereSql.append(" and `举办时间` between ? and ?");
			params.add(time);
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
		StringBuilder sql = new StringBuilder("select * from `学生获奖学金情况统计`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<StudentScholarship> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<StudentScholarship>(StudentScholarship.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}


