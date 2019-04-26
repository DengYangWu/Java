package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.*;
import com.system.service.CourseService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import com.system.service.impl.CourseServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;
    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;

    //Show all course
    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model, Integer page) throws Exception {

        List<CourseCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCouse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "student/showCourse";
    }
    //curricula-variable
    @RequestMapping(value = "/stuSelectedCourse")
    public String stuSelectedCourse(int id) throws Exception {
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        SelectedCourseCustom s = selectedCourseService.findOne(selectedCourseCustom);

        if (s == null) {
            System.out.println("selectedCourseCustom:"+selectedCourseCustom);
            selectedCourseService.save(selectedCourseCustom);
        } else {
            throw new CustomException("该门课程你已经选了，不能再选");
        }

        return "redirect:/student/selectedCourse";
    }
    //The drop operation
    @RequestMapping(value = "/outCourse")
    public String outCourse(Integer id) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        selectedCourseService.remove(selectedCourseCustom);

        return "redirect:/student/selectedCourse";
    }
    //show selectedCourse

    //Search the selectedCourse
    @RequestMapping(value = "/selectedCourse",method = {RequestMethod.GET})
    public String selectedCourse(Model model) throws Exception {
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName(username);

       // System.out.println("+++++++++++++++++++++++++++"+studentCustom);
        if(studentCustom!=null) {
            List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();
            //StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
            System.out.println("------====selectedCourse"+list);
            model.addAttribute("selectedCourseList", list);
            return "student/selectCourse";
        }
        return "student/selectCourse";
    }
    //Post-search processing
    @RequestMapping(value = "/selectCourse",method = {RequestMethod.POST})
    public String selectCourse(String findByName,Model model)throws Exception{
        if(findByName==null){
            return "redirect:/admin/showCourse";
        }
        List<CourseCustom> courseCustoms=courseService.findByName(findByName);
        model.addAttribute("courseList",courseCustoms);
        return "student/showCourse";
    }
    //Have courses
    @RequestMapping(value = "/overCourse")
    public String overCourse(Model model)throws Exception{
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        if(studentCustom!=null) {
            List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();
            //StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
            System.out.println("----------studentCustom:"+list);
            model.addAttribute("selectedCourseList",list);
            return "student/overCourse";
        }

        return "student/overCourse";
    }
    //Change password
    @RequestMapping(value = "/passwordRest")
    public String passwordRest()throws Exception{
        return "student/passwordRest";
    }

}
