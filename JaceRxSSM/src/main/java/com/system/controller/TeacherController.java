package com.system.controller;


import com.system.po.Course;
import com.system.po.CourseCustom;

import com.system.po.SelectedCourseCustom;
import com.system.service.CourseService;
import com.system.service.SelectedCourseService;
import com.system.service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Resource(name="teacherServiceImpl")
    private TeacherService teacherService;
    @Resource(name="courseServiceImpl")
    private CourseService courseService;
    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;
    //Show the course
    @RequestMapping(value="/showCourse")
    public String showCourse(Model model,Integer page)throws Exception{
//        List<CourseCustom> list=null;
//        PagingVO pagingVO=new PagingVO();
//        //设置总页数
//        pagingVO.setTotalCount(courseService.getCountCouse());
//        if(page==null||page==0){
//            pagingVO.setToPageNo(1);
//            list=courseService.findByPaging(1);
//        }else{
//            pagingVO.setToPageNo(page);
//            list=courseService.findByPaging(page);
//        }
//        model.addAttribute("courseList",list);
//        model.addAttribute("pagingVO",pagingVO);
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        List<CourseCustom> list = courseService.findByTeacherID(Integer.parseInt(username));
        model.addAttribute("courseList", list);
        //teacherService.getCountTeacher();
        return "teacher/showCourse";
    }
    //Search the selectCourse
    @RequestMapping(value="/selectCourse",method = {RequestMethod.POST})
    public String selectCourse(String findByName,Model model)throws Exception{
        if(findByName==null){
            return "redirect:/teacher/showCourse";
        }
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        int name = Integer.valueOf(username);
        Course course=new Course();
        List<CourseCustom> courseCustoms=courseService.findByName(findByName);
        System.out.println("courseCustoms++++++++="+courseCustoms);
        System.out.println("findByName++++++++="+findByName);
        System.out.println("teacherId++++++="+username);
        for(Course course1:courseCustoms){
            System.out.println("c====="+course1.getTeacherid());
            if(course1.getTeacherid()==name){
                model.addAttribute("courseList",courseCustoms);
                return "teacher/showCourse";
            }
        }

        model.addAttribute("courseNull","该老师没有教这门课~");
        return "teacher/showCourse";
    }
    //Show the grade
    @RequestMapping(value="/gradeCourse")
    public String gradeCourse(Integer id,Model model)throws Exception{
        if(id == null){
            return "";
        }
        List<SelectedCourseCustom> list=selectedCourseService.findByCourseID(id);
        model.addAttribute("selectedCourseList",list);
        return "teacher/showGrade";
    }
    @RequestMapping(value = "/mark",method = {RequestMethod.GET})
    public String markUI(SelectedCourseCustom scc,Model model)throws Exception{
        SelectedCourseCustom selectedCourseCustom=selectedCourseService.findOne(scc);
        model.addAttribute("selectedCourse", selectedCourseCustom);
        return "teacher/mark";
    }
    //The mark
    @RequestMapping(value = "/mark",method = {RequestMethod.POST})
    public String mark(SelectedCourseCustom scc)throws Exception{
        selectedCourseService.updateOne(scc);

        return "redirect:/teacher/gradeCourse?id="+scc.getCourseid();
    }
    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception {
        return "teacher/passwordRest";
    }
}
