package cn.itheima.crm.mapper;

import java.util.List;

import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
public interface CustomerMapper {

	/**
	 * 1.查询当前页客户列表数据
	 */
	List<Customer> queryCustomerList(QueryVo queryVo);
	
	/**
	 * 2.统计符合条件的客户数量
	 */
	Integer countUsers(QueryVo queryVo);
	
	/**
	 * 3. 根据客户id查询数据
	 */
	Customer queryCustomerById(Long custId);
	
	/**
	 * 4. 根据客户id修改客户信息
	 */
	void updateCustomerById(Customer customer);
	
	/**
	 * 5. 根据客户id删除客户
	 */
	void delCustomerById(Long custId);
	
}
