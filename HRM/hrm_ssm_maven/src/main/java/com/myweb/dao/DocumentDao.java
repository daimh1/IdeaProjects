package com.myweb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import com.myweb.domain.Document;

import static com.myweb.util.HrmConstants.DOCUMENTTABLE;

/**   
 * @Description: DocumentMapper接口  
 * @version V1.0   
 */
public interface DocumentDao {

	 
	List<Document> selectByPage(Map<String, Document> params);
		
 	Integer count(Map<String, Document> params);
		
	// 动态插入文档
 	void save(Document document);
	
 	Document selectById(int id);
	
	// 根据id删除文档
 	void deleteById(Integer id);
		
	// 动态修改文档
 	void update(Document document);
		
}
