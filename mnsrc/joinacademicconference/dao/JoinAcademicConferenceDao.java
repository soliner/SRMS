package cn.mnsrc.joinacademicconference.dao;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.joinacademicconference.domain.JoinAcademicConference;


public class JoinAcademicConferenceDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(JoinAcademicConference s) {
		String sql = "insert into `参加学术会议情况` values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { s.get姓名(), s.get时间(), s.get会议名称(), s.get会议级别(), s.get地点(), s.get参会形式(),
				s.get分会报告(), s.get参与会议相关材料(),  s.get备注() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JoinAcademicConference load(String pid) {
		String sql = "select * from `参加学术会议情况` where `会议名称`=?";
		try {
			return qr.query(sql, new BeanHandler<JoinAcademicConference>(JoinAcademicConference.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(JoinAcademicConference s) {
		try {
			String sql = "update `参加学术会议情况` set `姓名`=?, `时间`=?, `会议名称`=?, "
					+ " `会议级别`=?,`地点`=?,`参会形式`=?,`分会报告`=?, `参与会议相关材料`=?, `备注`=? where `会议名称`=?";
			Object[] params = { s.get姓名(), s.get时间(), s.get会议名称(), s.get会议级别(), s.get地点(), s.get参会形式(),
					s.get分会报告(), s.get参与会议相关材料(),  s.get备注(), s.get会议名称()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `参加学术会议情况` where `会议名称`=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public PageBean<JoinAcademicConference> query(JoinAcademicConference criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<JoinAcademicConference> pb = new PageBean<JoinAcademicConference>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `参加学术会议情况`");
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
			whereSql.append(" and `姓名` like ?");
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
		StringBuilder sql = new StringBuilder("select * from `参加学术会议情况`");
		//我们查询beanList这一步，还需要给出limit子句
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		//params中需要给出limit后两个问号对应的值
		params.add((pc-1)*ps);
		params.add(ps);
		//执行之
		List<JoinAcademicConference> beanList = qr.query(
				sql.append(whereSql).append(limitSql).toString(), 
				new BeanListHandler<JoinAcademicConference>(JoinAcademicConference.class), 
				params.toArray());
		pb.setBeanList(beanList);
		return pb;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
		
	}

}


