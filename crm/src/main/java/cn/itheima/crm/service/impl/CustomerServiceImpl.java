package cn.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.crm.mapper.CustomerMapper;
import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.service.CustomerService;
import cn.itheima.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	// 注入客户mapper
	@Autowired
	private CustomerMapper customerMapper;
	public Page<Customer> queryCustomerPage(QueryVo queryVo) {
		// 1.计算记录开始数
		// 第一页：0，第二页：10，第三页：20.......
		int start=0;
		start = (queryVo.getPage()-1)*queryVo.getRows();
		queryVo.setStart(start);
		
		// 2.查询当前页的客户列表数据
		List<Customer> list = this.customerMapper.queryCustomerList(queryVo);
		
		// 3.统计符合条件的客户数量
		Integer totals = this.customerMapper.countUsers(queryVo);
		
		// 4.创建分页对象
		// public Page(int total, int page, int size, List<T> rows) {
		Page<Customer> page =  new Page<Customer>(totals,queryVo.getPage(),
				queryVo.getRows(),list);
		
		
		return page;
	}
	/**
	 * 2. 根据客户id查询数据
	 */
	public Customer queryCustomerById(Long custId) {
		Customer customer = this.customerMapper.queryCustomerById(custId);
		return customer;
	}
	/**
	 * 3. 根据客户id修改客户信息
	 */
	public void updateCustomerById(Customer customer) {

		this.customerMapper.updateCustomerById(customer);
	}
	/**
	 * 4. 根据客户id删除客户
	 */
	public void delCustomerById(Long custId) {

		this.customerMapper.delCustomerById(custId);
	}

}
