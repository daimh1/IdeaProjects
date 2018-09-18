package com.myweb.controller;


import java.util.List;

import com.myweb.domain.Dept;
import com.myweb.domain.Employee;
import com.myweb.domain.Job;
import com.myweb.service.HrmService;
import com.myweb.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**   
 * @Description: 处理员工请求控制器   
 * @version V1.0   
 */
@Controller
public class EmployeeController {
    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    @RequestMapping(value="/employee/selectEmployee")
    public String selectEmployee(Integer pageIndex,
                                 Integer job_id,Integer dept_id,
                                 @ModelAttribute Employee employee,
                                 Model model){
        // 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
        this.genericAssociation(job_id, dept_id, employee);
        // 创建分页对象
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        // 查询职位信息，用于模糊查询
        List<Job> jobs = hrmService.findAllJob();
        // 查询部门信息 ，用于模糊查询
        List<Dept> depts = hrmService.findAllDept();
        // 查询员工信息
        List<Employee> employees = hrmService.findEmployee(employee,pageModel);
        // 设置Model数据
        model.addAttribute("employees", employees);
        model.addAttribute("jobs", jobs);
        model.addAttribute("depts", depts);
        model.addAttribute("pageModel", pageModel);
        // 返回员工页面
        return "employee/employee";

    }

    @RequestMapping(value="/employee/addEmployee")
    public ModelAndView addEmployee(
            String flag,
            Integer job_id,Integer dept_id,
            @ModelAttribute Employee employee,
            ModelAndView mv){
        if(flag.equals("1")){
            // 查询职位信息
            List<Job> jobs = hrmService.findAllJob();
            // 查询部门信息
            List<Dept> depts = hrmService.findAllDept();
            // 设置Model数据
            mv.addObject("jobs", jobs);
            mv.addObject("depts", depts);
            // 返回添加员工页面
            mv.setViewName("employee/showAddEmployee");
        }else{
            // 判断是否有关联对象传递，如果有，创建关联对象
            this.genericAssociation(job_id, dept_id, employee);
            // 添加操作
            hrmService.addEmployee(employee);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/employee/selectEmployee");
        }
        // 返回
        return mv;

    }
    @RequestMapping(value="/employee/removeEmployee")
    public ModelAndView removeEmployee(String ids,ModelAndView mv){
        // 分解id字符串
        String[] idArray = ids.split(",");
        for(String id : idArray){
            // 根据id删除员工
            hrmService.removeEmployeeById(Integer.parseInt(id));
        }
        // 设置客户端跳转到查询请求
//		mv.setView(new RedirectView("/hrmapp/employee/selectEmployee"));
//		mv.setViewName("forward:/employee/selectEmployee");
        mv.setViewName("redirect:/employee/selectEmployee");
        // 返回ModelAndView
        return mv;
    }
    @RequestMapping(value="/employee/updateEmployee")
    public ModelAndView updateEmployee(
            String flag,
            Integer job_id,Integer dept_id,
            @ModelAttribute Employee employee,
            ModelAndView mv){
        if(flag.equals("1")){
            // 根据id查询员工
            Employee target = hrmService.findEmployeeById(employee.getId());
            // 需要查询职位信息
            List<Job> jobs = hrmService.findAllJob();
            // 需要查询部门信息
            List<Dept> depts = hrmService.findAllDept();
            // 设置Model数据
            mv.addObject("jobs", jobs);
            mv.addObject("depts", depts);
            mv.addObject("employee", target);
            // 返回修改员工页面
            mv.setViewName("employee/showUpdateEmployee");
        }else{
            // 创建并封装关联对象
            this.genericAssociation(job_id, dept_id, employee);
            System.out.println("updateEmployee -->> " + employee);
            // 执行修改操作
            hrmService.modifyEmployee(employee);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/employee/selectEmployee");
        }
        // 返回
        return mv;
    }
    private void genericAssociation(Integer job_id,
                                    Integer dept_id,Employee employee){
        if(job_id != null){
            Job job = new Job();
            job.setId(job_id);
            employee.setJob(job);
        }
        if(dept_id != null){
            Dept dept = new Dept();
            dept.setId(dept_id);
            employee.setDept(dept);
        }
    }
}
