package com.myweb.service;

import java.util.List;

import com.myweb.domain.Dept;
import com.myweb.domain.Document;
import com.myweb.domain.Employee;
import com.myweb.domain.Job;
import com.myweb.domain.Notice;
import com.myweb.domain.User;
import com.myweb.util.PageModel;

/**   
 * @Description: 人事管理服务层接口
 * @version V1.0   
 */
public interface HrmService {


	/**
	 * 用户登录
	 * @param  loginname
	 * @param  password
	 * @return User对象
	 * */
	User login(String loginname, String password);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return 用户对象
	 * */
	User findUserById(Integer id);
	
	/**
	 * 获得所有用户
	 * @return User对象的List集合
	 * */
	List<User> findUser(User user, PageModel pageModel);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * */
	void removeUserById(Integer id);
	
	/**
	 * 修改用户
	 * @param user 用户对象
	 * */
	void modifyUser(User user);
	
	/**
	 * 添加用户
	 * @param user 用户对象
	 * */
	void addUser(User user);


	//employee相关
	/**
	 * 获取所有员工
	 * @param employee
	 * @param pageModel
	 * @return
	 */
	List<Employee> findEmployee(Employee employee,PageModel pageModel);

	/**
	 * 根据id删除员工
	 * @param id
	 */
	void removeEmployeeById(Integer id);

	/**
	 * 根据id查员工
	 * @param id
	 * @return
	 */
	Employee findEmployeeById(Integer id);

	/**
	 * 添加员工
	 * @param employee
	 */
	void addEmployee(Employee employee);

	/**
	 * 修改员工
	 * @param employee
	 */
	void modifyEmployee(Employee employee);


	//部门相关
	/**
	 * 获取部门分页
	 * @param dept
	 * @param pageModel
	 * @return
	 */
	List<Dept> findDept(Dept dept,PageModel pageModel);

	/**
	 * 获得所有部门
	 * @return
	 */
	List<Dept> findAllDept();

	/**
	 * 根据id删除部门
	 * @param id
	 */
	public void removeDeptById(Integer id);

	/**
	 * 添加部门
	 * @param dept
	 */
	void addDept(Dept dept);

	/**
	 * 根据id查询部门
	 * @param id
	 * @return
	 */
	Dept findDeptById(Integer id);

	/**
	 * 修改部门
	 * @param dept
	 */
	void modifyDept(Dept dept);

	//职位相关
	/**
	 * 获取所有职位
	 * @return
	 */
	List<Job> findAllJob();

	/**
	 * 获取职位分页
	 * @param job
	 * @param pageModel
	 * @return
	 */
	List<Job> findJob(Job job,PageModel pageModel);

	/**
	 * 根据id删除职位
	 * @param id
	 */
	public void removeJobById(Integer id);

	/**
	 * 添加职位
	 * @param job
	 */
	void addJob(Job job);

	/**
	 * 根据id查询职位
	 * @param id
	 * @return
	 */
	Job findJobById(Integer id);

	/**
	 * 修改职位
	 * @param job
	 */
	void modifyJob(Job job);


	//公告相关

	/**
	 * 获取所有公告
	 * @param notice
	 * @param pageModel
	 * @return
	 */
	List<Notice> findNotice(Notice notice,PageModel pageModel);

	/**
	 * 根据id查询公告
	 * @param id
	 * @return
	 */
	Notice findNoticeById(Integer id);

	/**
	 * 根据id删除公告
	 * @param id
	 */
	public void removeNoticeById(Integer id);

	/**
	 * 添加公告
	 * @param notice
	 */
	void addNotice(Notice notice);

	/**
	 * 修改公告
	 * @param notice
	 */
	void modifyNotice(Notice notice);

	//文档相关

	/**
	 * 获取所有文档
	 * @param document
	 * @param pageModel
	 * @return
	 */
	List<Document> findDocument(Document document,PageModel pageModel);

	/**
	 * 添加文档
	 * @param document
	 */
	void addDocument(Document document);

	/**
	 * 根据id查询文档
	 * @param id
	 * @return
	 */
	Document findDocumentById(Integer id);

	/**
	 * 根据id删除文档
	 * @param id
	 */
	public void removeDocumentById(Integer id);

	/**
	 * 修改文档
	 * @param document
	 */
	void modifyDocument(Document document);
















}
