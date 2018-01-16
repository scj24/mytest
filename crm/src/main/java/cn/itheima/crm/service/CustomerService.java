package cn.itheima.crm.service;

import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.utils.Page;

public interface CustomerService {
	
	/**
	 * 1.分页查询客户数据
	 */
	Page<Customer> queryCustomerPage(QueryVo queryVo);
	
	/**
	 *2. 根据客户id查询数据
	 */
	Customer queryCustomerById(Long custId);
	
	/**
	 * 3. 根据客户id修改客户信息
	 */
	void updateCustomerById(Customer customer);
	
	/**
	 * 4. 根据客户id删除客户
	 */
	void delCustomerById(Long custId);
}
