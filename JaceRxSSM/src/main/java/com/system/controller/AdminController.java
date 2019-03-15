package com.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.po.PagingVO;
import com.system.po.StudentCustom;
import com.system.service.CollegeService;
import com.system.service.CourseService;
import com.system.service.StudentService;
import com.system.service.UserloginService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name = "studentServiceImpl")
	private StudentService studentService;
	@Resource(name = "courseServiceImpl")
	private CourseService  courseService;


    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;
	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<学生操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //  学生信息显示
    @RequestMapping("/showStudent")
	public String showStudent(Model model,Integer page) throws Exception{
    	List<StudentCustom> list=null;
    	//页码对象
    	PagingVO pagingVO=new PagingVO();
    	//设置总页数
    	pagingVO.setTotalCount(studentService.getCountStudent());
    	if(page==null||page==0) {
    		pagingVO.setToPageNo(page);
    		list=studentService.findByPaging(1);
    	}else {
    		pagingVO.setNextPageNo(page);
    		list=studentService.findByPaging(page);
    	}
    	model.addAttribute("studentList",list);
    	model.addAttribute("pagingVO",pagingVO);
		return "admin/showStudent";
	}
}
