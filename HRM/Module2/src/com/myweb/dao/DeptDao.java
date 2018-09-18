package com.myweb.dao;

import java.util.List;
import java.util.Map;


import com.myweb.domain.Dept;

import static com.myweb.util.HrmConstants.DEPTTABLE;

/**   
 * @Description: DeptMapper接口  
 * @date 2016年7月11日 上午10:53:32 
 * @version V1.0   
 */
public interface DeptDao {

	// 动态查询
	List<Dept> selectByPage(Map<String, Dept> params);
	
	Integer count(Map<String, Dept> params);
	
	List<Dept> selectAllDept();
	
	Dept selectById(int id);

	// 根据id删除部门
	void deleteById(Integer id);
	
	// 动态插入部门
	void save(Dept dept);
	
	// 动态修改用户
	void update(Dept dept);
}
