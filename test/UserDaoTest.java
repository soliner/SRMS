package test;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.itcast.usermng.dao.JdbcUserDaoImpl;
import cn.itcast.usermng.domain.Customer;
import cn.itcast.usermng.domain.PageBean;
import cn.itcast.usermng.domain.User;
import cn.itcast.usermng.service.CustomerService;

/**
 * UserDao的测试类
 * 
 * @author cxf
 *
 */
public class UserDaoTest {
	@Test
	public void testAddUser() {
		JdbcUserDaoImpl userDao = new JdbcUserDaoImpl();

		User form = new User();
		form.setUsername("李四");
		form.setPassword("142601199502127339");
		form.setAge(92);
		form.setGender("女");
		form.set工号("12220");
		form.set密码("女");

		userDao.addUser(form);
	}

	@Test
	public void testAdd() {
		CustomerService customerService = new CustomerService();
		Customer c = new Customer();
		for (int i = 0; i < 300; i++) {
			c.setCid(CommonUtils.uuid());
			c.setCname("李四"+i);
			c.setCellphone("18251929271"+i);
			c.setDescription("92"+i);
			c.setGender(i/2==0?"男":"女");
			c.setEmail(i+"1@qq.com");
			c.setBirthday("2018-10-03");
			customerService.add(c);

		}
	}

	@Test
	public void testFindByUsername() {
		JdbcUserDaoImpl userDao = new JdbcUserDaoImpl();

		User user = userDao.findByUsername("12226");

		System.out.println(user);
	}

	@Test
	public void testDelete() {
		CustomerService customerService = new CustomerService();

		customerService.delete("11");
	}
	@Test
	public void testQuery() {
		CustomerService customerService = new CustomerService();
		Customer c = new Customer();
		c.setGender("男");
		PageBean<Customer> pb = customerService.query(c, 1, 10);
		System.out.println(pb);
	}
}
