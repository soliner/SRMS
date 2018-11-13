package cn.itcast.usermng.service;

import java.util.List;

import cn.itcast.usermng.dao.CustomerDao;
import cn.itcast.usermng.domain.Customer;
import cn.itcast.usermng.domain.PageBean;

/**
 * 业务层
 * @author Administrator
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	/**
	 * 添加客户
	 */
	public void add(Customer c){
		customerDao.add(c);
	}
	/**
	 * 查询所有
	 * @return
	 */
	public List<Customer> findAll(){
		return customerDao.findAll();
	}
	/**
	 * 加载客户
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		
		return customerDao.load(cid);
	}
	/**
	 * 编辑客户
	 * @param c
	 */
	public void edit(Customer c) {
		customerDao.edit(c);
		
	}
	public void delete(String cid) {
		customerDao.delete(cid);
		
	}
	public PageBean<Customer> findAll(int pc, int ps) {
		
		return customerDao.findAll(pc, ps);
	}
	public PageBean<Customer> query(Customer criteria, int pc, int ps) {
		return customerDao.query(criteria, pc, ps);
		
	}

}
