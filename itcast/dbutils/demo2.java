package cn.itcast.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class demo2 {
	@Test
	public void fun1(){
		/*Stu s = new Stu(1001, "zhangsan", 99, "male");
		addStu(s);*/
		Stu s = load(1001);
		System.out.println(s);
	}

	public void addStu(Stu s) {
		QR qr = new QR(JdbcUtils.getDataSource());//创建对象时给出连接池
		String sql = "insert into t_stu values(?, ?, ?, ?)";//给出sql模板
		Object[] params = {s.getSid(), s.getSname(), s.getAge(), s.getGender() };//给出参数
		qr.update(sql, params);//调用update，执行增删改
		
	}
	public Stu load(int sid){
		QR qr = new QR(JdbcUtils.getDataSource());
		String sql = "select * from t_stu where sid = ?";
		Object[] params = {sid};
		RsHandler<Stu> rh = new RsHandler<Stu>() {

			@Override
			public Stu handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				if(!rs.next())  return null;
				Stu stu = new Stu();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setAge(rs.getInt("age"));
				stu.setGender(rs.getString("gender"));
				return stu;
			}
			
		};
		return (Stu) qr.query(sql, rh, params);
	}
	
	

}
