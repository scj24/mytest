package cn.itheima.crm.service;

import java.util.List;

import cn.itheima.crm.po.BaseDict;

public interface BaseDictService {
	
	List<BaseDict> queryBaseDictByTypeCode(String typeCode);

}
