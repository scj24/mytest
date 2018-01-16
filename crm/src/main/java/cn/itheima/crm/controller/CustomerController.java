package cn.itheima.crm.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itheima.crm.po.BaseDict;
import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.service.BaseDictService;
import cn.itheima.crm.service.CustomerService;
import cn.itheima.crm.utils.Page;

/**
 * ===========================客户控制器=====
 */
@Controller
@RequestMapping("cust")
public class CustomerController {
	//注入service
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;

	/**
	 * 1. 查询客户列表
	 * @return
	 */
	@RequestMapping("list")
	public String list(ModelMap modelMap,QueryVo queryVo){
		
		//1.综合查询条件初始化
			//客户来源
		List<BaseDict> fromType = this.baseDictService.queryBaseDictByTypeCode("002");
			//所属行业
		List<BaseDict> industryType = this.baseDictService.queryBaseDictByTypeCode("001");
			//客户级别
		List<BaseDict> levelType = this.baseDictService.queryBaseDictByTypeCode("006");
		//2.响应综合查询条件
		modelMap.addAttribute("fromType",fromType);
		modelMap.addAttribute("industryType",industryType);
		modelMap.addAttribute("levelType",levelType);
		
		//3. 查询客户列表数据
		Page<Customer> page = this.customerService.queryCustomerPage(queryVo);
		//4. 响应客户端数据
		modelMap.addAttribute("page",page);
		
		// 5.参数数据回显
		modelMap.addAttribute("custName",queryVo.getCustName());
		modelMap.addAttribute("custSource",queryVo.getCustSource());
		modelMap.addAttribute("custIndustry",queryVo.getCustIndustry());
		modelMap.addAttribute("custLevel",queryVo.getCustLevel());
		
		return "customer";
	}
	/**
	 * 2. 根据客户id查询客户数据,即点击修改按钮后会显示客户数据
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Long id){
		Customer customer = this.customerService.queryCustomerById(id);
		return customer;
	}
	/**
	 * 3. 修改客户数据,保存到 数据库
	 */
	@RequestMapping("update")
	@ResponseBody
	public void update(Customer customer){
		this.customerService.updateCustomerById(customer);
	}
	
	/**
	 * 4. 根据客户id删除客户
	 */
	@RequestMapping("delcust")
	@ResponseBody
	public void del(Long id){
		this.customerService.delCustomerById(id);
	}
}
