package com.system.controller;

import com.system.po.College;
import com.system.po.PagingVO;
import com.system.po.StudentCustom;
import com.system.service.CollegeService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import com.system.service.UserloginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class StudentController {
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "collegeServiceImpl")
    private CollegeService collegeService;

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<学生操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @RequestMapping(value = "/showStudent")
    public String showStudent(Model model,Integer page)throws Exception{
        List<StudentCustom> studentCustomList=null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置页面的总页数
        pagingVO.setTotalCount(studentService.getCountStudent());
        if(page == null || page == 0){
            pagingVO.setToPageNo(1);
            studentCustomList=studentService.findByPaging(1);
        }else{
            pagingVO.setToPageNo(page);
            studentCustomList=studentService.findByPaging(page);
        }
        //Display number of badges
        int studentNumber=studentService.getCountStudent();
        model.addAttribute("studentNumber",studentNumber);

        model.addAttribute("studentList",studentCustomList);
        model.addAttribute("pagingVO",pagingVO);
        return "/admin/showStudent";

    }
    @RequestMapping(value = "/editStudent",method = {RequestMethod.GET})
    public String editStudentUI(Integer id,Model model)throws Exception{
        if(id == null){
            //假如没有带学生id，就返回到显示页面
            return "redirect:/admin/showStudent";
        }
        StudentCustom studentCustom=studentService.findById(id);
        if(studentCustom == null){
            throw new ClassCastException("未找到该学生");
        }
        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);
        model.addAttribute("student", studentCustom);


        return "admin/editStudent";
    }
    @RequestMapping(value = "/editStudent", method = {RequestMethod.POST})
    public String updateStudent(StudentCustom studentCustom)throws Exception{

        studentService.updataById(studentCustom.getUserid(),studentCustom);
        return "redirect:/admin/showStudent";
    }
    @RequestMapping(value = "/removeStudent",method = {RequestMethod.GET})
    public String remove(Integer id)throws Exception{
        if(id==null){
            return "admin/showStudent";
        }
        selectedCourseService.remote(id);
        studentService.removeById(id);
        //userloginService.removeByName(id.toString());


        return "redirect:/admin/showStudent";
    }
}
