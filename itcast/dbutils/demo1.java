package cn.itcast.dbutils;

import java.sql.Connection;

import org.junit.Test;

/**
 * commons-dbutils
 * 简化jdbc的代码
 * @author Administrator
 *
 */
public class demo1 {
	@Test
	public void fun1(){
		Connection con = null;
		try{
			con = JdbcUtils.getConnection();
		}catch(Exception e){
			String sql = "insert into t_user values";
			
		}finally{
			
		}
	}
}
