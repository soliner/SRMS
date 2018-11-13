package cn.itcast.usermng.dao;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.usermng.domain.PageBean;
import cn.itcast.usermng.domain.Teacher;

public class TeacherDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加项目
	 */
	public void add(Teacher rp) {
		String sql = "insert into `教师基本信息表` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { rp.get姓名(), rp.get工号(), rp.get性别(), rp.get出生年月(), rp.get政治面貌(), rp.get民族(),
				rp.get籍贯(), rp.get身份证号(), rp.get密码(), rp.get学历(), rp.get参加工作时间(), rp.get职称(), rp.get婚姻状态(), 
				rp.get联系方式(), rp.get电子邮箱(), rp.get家庭住址(), rp.get总共登录次数(), rp.is管理员() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Teacher load(String pid) {
		String sql = "select * from `教师基本信息表` where `工号`=?";
		try {
			return qr.query(sql, new BeanHandler<Teacher>(Teacher.class), pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(Teacher rp) {
		try {
			String sql = "update `教师基本信息表` set `姓名`=?, `工号`=?, `性别`=?, "
					+ " `出生年月`=?,`政治面貌`=?,`民族`=?,`籍贯`=?, `身份证号`=?," 
					+ " `密码`=?,`学历`=?,`参加工作时间`=?,`职称`=?, `婚姻状态`=?," 
					+ " `联系方式`=?,`电子邮箱`=?,`家庭住址`=?,`总共登录次数`=?, `管理员`=? where `工号`=?";
			Object[] params = { rp.get姓名(), rp.get工号(), rp.get性别(), rp.get出生年月(), rp.get政治面貌(), rp.get民族(),
					rp.get籍贯(), rp.get身份证号(), rp.get密码(), rp.get学历(), rp.get参加工作时间(), rp.get职称(), rp.get婚姻状态(), 
					rp.get联系方式(), rp.get电子邮箱(), rp.get家庭住址(), rp.get总共登录次数(), rp.is管理员(), rp.get工号() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String pid) {
		try {
			String sql = "delete from `教师基本信息表` where `工号`=?";
			qr.update(sql, pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public PageBean<Teacher> query(Teacher criteria, int pc, int ps) {
		/*
		 * 1. 创建PageBean对象 2. 设置已有的属性，pc和ps 3. 得到tr 4. 得到beanList
		 * 
		 */
		/*
		 * 创建pb，设置已有属性
		 */
		PageBean<Teacher> pb = new PageBean<Teacher>();
		pb.setPc(pc);
		pb.setPs(ps);
		/*
		 * 得到tr
		 */
		/*
		 * 1. 给出一个sql语句前半部分
		 */
		StringBuilder cntSql = new StringBuilder("select count(*) from `教师基本信息表`");
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

			Number num = (Number) qr.query(cntSql.append(whereSql).toString(), new ScalarHandler(), params.toArray());
			int tr = num.intValue();
			pb.setTr(tr);
			/*
			 * 得到beanList
			 */
			StringBuilder sql = new StringBuilder("select * from `教师基本信息表`");
			// 我们查询beanList这一步，还需要给出limit子句
			StringBuilder limitSql = new StringBuilder(" limit ?,?");
			// params中需要给出limit后两个问号对应的值
			params.add((pc - 1) * ps);
			params.add(ps);
			// 执行之
			List<Teacher> beanList = qr.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Teacher>(Teacher.class), params.toArray());
			pb.setBeanList(beanList);
			return pb;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	/**
	 * 查询所有
	 * @return
	 */
	public List<Map<String, Object>> findAll() {
		try {
			String sql = "select * from `教师基本信息表`";
			return qr.query(sql, new MapListHandler());
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
