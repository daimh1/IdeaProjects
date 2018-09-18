package com.myweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweb.dao.DeptDao;
import com.myweb.dao.DocumentDao;
import com.myweb.dao.EmployeeDao;
import com.myweb.dao.JobDao;
import com.myweb.dao.NoticeDao;
import com.myweb.dao.UserDao;
import com.myweb.domain.Dept;
import com.myweb.domain.Document;
import com.myweb.domain.Employee;
import com.myweb.domain.Job;
import com.myweb.domain.Notice;
import com.myweb.domain.User;
import com.myweb.service.HrmService;
import com.myweb.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Description: 人事管理系统服务层接口实现类 
 * @version V1.0   
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService{

	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private UserDao userDao;

	@Autowired
	private DeptDao deptDao;

	@Autowired
	private DocumentDao documentDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private JobDao jobDao;

	@Autowired
	private NoticeDao noticeDao;
 
	
	/*****************用户服务接口实现*************************************/
	/**
	 * HrmServiceImpl接口login方法实现
	 *  @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password) {
//		System.out.println("HrmServiceImpl login -- >>");
		HashMap<String, String> hashMap= new HashMap<>();
		hashMap.put("loginname",  loginname );
		hashMap.put("password",  password );

		
		return userDao.selectByLoginnameAndPassword( hashMap );
	}

	/**
	 * HrmServiceImpl接口findUser方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<User> findUser(User user,PageModel pageModel) {

		Map<String,User> params = new HashMap<>();
		params.put("user",user);
		int recordCount=userDao.count(params);
		System.out.println("recordCount hrmser85:"+recordCount);
		pageModel.setRecordCount(recordCount);
//		if(recordCount>0){
//			params.put("pageModel",pageModel);
//		}
//
//
		List<User> users = userDao.selectByPage(params);
		 
		return users;
	}
	
	/**
	 * HrmServiceImpl接口findUserById方法实现
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public User findUserById(Integer id) {
		return userDao.selectById(id);
	}
	
	/**
	 * HrmServiceImpl接口removeUserById方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void removeUserById(Integer id) {
 		userDao.deleteById(id);
	}
	
	/**
	 * HrmServiceImpl接口addUser方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void modifyUser(User user) {
		userDao.update(user);
		
	}
	
	/**
	 * HrmServiceImpl接口modifyUser方法实现
	 * @see { HrmService }
	 * */
	@Override
	public void addUser(User user) {
		userDao.save(user);
 		
	}









	/*****************部门服务接口实现*************************************/


	@Override
	@Transactional(readOnly =true)
	public List<Dept> findDept(Dept dept, PageModel pageModel) {
		Map<String,Dept> params=new HashMap<>();
		params.put("dept",dept);
		int recordCount = deptDao.count(params);

		/*pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel",pageModel);
		}*/
		List<Dept> depts=deptDao.selectByPage(params);
		return depts;
	}

	@Override
	@Transactional(readOnly =true)
	public List<Dept> findAllDept() {
		return deptDao.selectAllDept();
	}

	@Override
	public void removeDeptById(Integer id) {
		deptDao.deleteById(id);
	}

	@Override
	public void addDept(Dept dept) {
		deptDao.save(dept);
	}

	@Override
	@Transactional(readOnly =true)
	public Dept findDeptById(Integer id) {
		return deptDao.selectById(id);
	}

	@Override
	public void modifyDept(Dept dept) {
		deptDao.update(dept);
	}

 
	/*****************员工服务接口实现*************************************/

	@Override
	@Transactional(readOnly =true)
	public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
		Map<String,Employee> params=new HashMap<>();
		params.put("employee",employee);
		int recordCount = employeeDao.count(params);

		/*pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel",pageModel);
		}*/
		List<Employee> employees=employeeDao.selectByPage(params);
		return employees;
	}

	@Override
	public void removeEmployeeById(Integer id) {
		employeeDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly =true)
	public Employee findEmployeeById(Integer id) {
		return employeeDao.selectById(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void modifyEmployee(Employee employee) {
		employeeDao.update(employee);
	}
 
	
	/*****************职位接口实现*************************************/


	@Override
	@Transactional(readOnly =true)
	public List<Job> findAllJob() {
		return jobDao.selectAllJob();
	}

	@Override
	@Transactional(readOnly =true)
	public List<Job> findJob(Job job, PageModel pageModel) {
		Map<String,Job> params=new HashMap<>();
		params.put("job",job);
		int recordCount = jobDao.count(params);

		/*pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel",pageModel);
		}*/
		List<Job> jobs=jobDao.selectByPage(params);
		return jobs;
	}

	@Override
	public void removeJobById(Integer id) {
		jobDao.deleteById(id);
	}

	@Override
	public void addJob(Job job) {
		jobDao.save(job);
	}

	@Override
	@Transactional(readOnly =true)
	public Job findJobById(Integer id) {
		return jobDao.selectById(id);
	}

	@Override
	public void modifyJob(Job job) {
		jobDao.update(job);
	}



	/*****************公告接口实现*************************************/


	@Override
	@Transactional(readOnly =true)
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		Map<String,Notice> params=new HashMap<>();
		params.put("notice",notice);
		int recordCount = noticeDao.count(params);

		/*pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel",pageModel);
		}*/
		List<Notice> notices=noticeDao.selectByPage(params);
		return notices;
	}

	@Override
	public Notice findNoticeById(Integer id) {
		return noticeDao.selectById(id);
	}

	@Override
	@Transactional(readOnly =true)
	public void removeNoticeById(Integer id) {
		noticeDao.deleteById(id);
	}

	@Override
	public void addNotice(Notice notice) {
		noticeDao.save(notice);
	}

	@Override
	public void modifyNotice(Notice notice) {
		noticeDao.update(notice);
	}


	/*****************文件接口实现*************************************/


	@Override
	@Transactional(readOnly =true)
	public List<Document> findDocument(Document document, PageModel pageModel) {
		Map<String,Document> params=new HashMap<>();
		params.put("document",document);
		int recordCount = documentDao.count(params);

		/*pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel",pageModel);
		}*/
		List<Document> documents=documentDao.selectByPage(params);
		return documents;
	}

	@Override
	public void addDocument(Document document) {
		documentDao.save(document);
	}

	@Override
	@Transactional(readOnly =true)
	public Document findDocumentById(Integer id) {
		return documentDao.selectById(id);
	}

	@Override
	public void removeDocumentById(Integer id) {
		documentDao.deleteById(id);
	}

	@Override
	public void modifyDocument(Document document) {
		documentDao.update(document);
	}
 
	
}
