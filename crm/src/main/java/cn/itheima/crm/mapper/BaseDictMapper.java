package cn.itheima.crm.mapper;

import java.util.List;

import cn.itheima.crm.po.BaseDict;

public interface BaseDictMapper {
	/**
	 * 1.根据数据字典类型编码查询
	 */
	List<BaseDict> queryBaseDictByTypeCode(String typeCode);

}
