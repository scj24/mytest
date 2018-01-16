package cn.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.crm.mapper.BaseDictMapper;
import cn.itheima.crm.po.BaseDict;
import cn.itheima.crm.service.BaseDictService;
@Service
public class BaseDictServiceImpl implements BaseDictService {

	//注入mapper
	@Autowired
	private BaseDictMapper bdm;
	/**
	 * 1.根据数据字典类型编码查询
	 */
	public List<BaseDict> queryBaseDictByTypeCode(String typeCode) {
		List<BaseDict> list = this.bdm.queryBaseDictByTypeCode(typeCode);
		return list;
	}

}
