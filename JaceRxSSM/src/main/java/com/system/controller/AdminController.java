package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.*;
import com.system.service.*;
import com.system.service.impl.CourseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "collegeServiceImpl")
    private CollegeService collegeService;

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<学生操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    @RequestMapping(value = "/showStudent")
    public String showStudent(Model model, Integer page) throws Exception {
        List<StudentCustom> studentCustomList = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置页面的总页数
        pagingVO.setTotalCount(studentService.getCountStudent());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            studentCustomList = studentService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            studentCustomList = studentService.findByPaging(page);
        }
        //Display number of badges
        int studentNumber = studentService.getCountStudent();
        model.addAttribute("studentNumber", studentNumber);

        model.addAttribute("studentList", studentCustomList);
        model.addAttribute("pagingVO", pagingVO);
        return "/admin/showStudent";

    }
    //  添加学生信息页面显示
    @RequestMapping(value = "/addStudent", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {

        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);

        return "admin/addStudent";
    }

    // 添加学生信息操作
    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public String addStudent(StudentCustom studentCustom, Model model) throws Exception {

        Boolean result = studentService.save(studentCustom);

        if (!result) {
            model.addAttribute("message", "学号重复");
            return "error";
        }
        //添加成功后，也添加到登录表
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(studentCustom.getUserid().toString());
        userlogin.setPassword("123");
        userlogin.setRole(2);
        userloginService.save(userlogin);

        //重定向
        return "redirect:/admin/showStudent";
    }
    @RequestMapping(value = "/editStudent", method = {RequestMethod.GET})
    public String editStudentUI(Integer id, Model model) throws Exception {
        if (id == null) {
            //假如没有带学生id，就返回到显示页面
            return "redirect:/admin/showStudent";
        }
        StudentCustom studentCustom = studentService.findById(id);
        if (studentCustom == null) {
            throw new ClassCastException("未找到该学生");
        }
        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);
        model.addAttribute("student", studentCustom);


        return "admin/editStudent";
    }

    @RequestMapping(value = "/editStudent", method = {RequestMethod.POST})
    public String updateStudent(StudentCustom studentCustom) throws Exception {

        studentService.updataById(studentCustom.getUserid(), studentCustom);
        return "redirect:/admin/showStudent";
    }

    @RequestMapping(value = "/removeStudent", method = {RequestMethod.GET})
    public String remove(Integer id) throws Exception {
        System.out.println(id);
        if (id == null) {
            return "admin/showStudent";
        }
        selectedCourseService.remove(id);
        studentService.removeById(id);
        //userloginService.removeByName(id.toString());


        return "redirect:/admin/showStudent";
    }

    @RequestMapping(value = "/selectStudent", method = RequestMethod.POST)
    public String selectStudent(String findByName, Model model) throws Exception {
        if (findByName == null) {
            return "redirect:/admin/showStudent";
        }
        List<StudentCustom> studentCustoms = studentService.findByName(findByName);

        model.addAttribute("studentList", studentCustoms);
        return "admin/showStudent";
    }

    //-----------------------教师操作----------------------------------//
    //show teacher
    @RequestMapping("/showTeacher")
    public String showTeacher(Model model, Integer page) throws Exception {

        List<TeacherCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(teacherService.getCountTeacher());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = teacherService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = teacherService.findByPaging(page);
        }
        int teacherNumber = teacherService.getCountTeacher();
        model.addAttribute("teacherNumber",teacherNumber);
        model.addAttribute("teacherList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "admin/showTeacher";

    }
    //add teacher information
    @RequestMapping(value = "/addTeacher", method = {RequestMethod.GET})
    public String addTeacherUI(Model model) throws Exception {

        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);
        return "admin/addTeacher";
    }
    //post-processing teacher
    @RequestMapping(value = "/addTeacher", method = {RequestMethod.POST})
    public String addTeacher(TeacherCustom teacherCustom, Model model) throws Exception {

        Boolean result = teacherService.save(teacherCustom);
        System.out.println(result+"-----------");
        if (!result) {
            model.addAttribute("message", "工号重复");
            return "error";
        }
        //添加成功后，也添加到登录表
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(teacherCustom.getUserid().toString());
        userlogin.setPassword("123");
        userlogin.setRole(1);
        userloginService.save(userlogin);

        //重定向
        return "redirect:/admin/showTeacher";
    }
    //Modify teacher information
    @RequestMapping(value = "/editTeacher",method = {RequestMethod.GET})
    public String editTeacherUI(Integer id,Model model)throws Exception{
        if(id==null){
            return "redirect:/admin/showTeacher";
        }
        TeacherCustom teacherCustom=teacherService.findById(id);
        if(teacherCustom==null){
            throw new CustomException("未找到该名学生");
        }
        List<College> list=collegeService.finAll();
        model.addAttribute("collegeList",list);
        model.addAttribute("teacher",teacherCustom);
        return "admin/editTeacher";
    }
    //Modified page processing
    @RequestMapping(value = "/editTeacher",method = {RequestMethod.POST})
    public String editTeacher(TeacherCustom teacherCustom)throws Exception{
        teacherService.updateById(teacherCustom.getUserid(),teacherCustom);
        return "redirect:/admin/showTeacher";
    }

    //delete teacher
    @RequestMapping("/removeTeacher")
    public String removeTeacher(Integer id)throws Exception{
        if(id == null){
           //if id is empty,return home
            return "admin/showTeacher";
        }
        System.out.println("------------id:"+id);
        courseService.removeTeacher(id);
        //userloginService.removeByName(id.toString());
        teacherService.removeById(id);
        return "redirect:/admin/showTeacher";
    }
    //search the teacher
    @RequestMapping(value = "/selectTeacher",method = {RequestMethod.POST})
    public String selectTeacher(String findByName,Model model)throws Exception{
        if (findByName == null) {
            return "redirect:/admin/showTeacher";
        }
        List<TeacherCustom> teacherCustoms=teacherService.findByName(findByName);
        System.out.println(teacherCustoms);
        model.addAttribute("teacherList",teacherCustoms);
        return "admin/showTeacher";
    }
    //-------------------------Course-------------------------//
    //Show Course
    @RequestMapping(value="/showCourse")
    public String showCourse(Integer page,Model model)throws Exception{
        List<CourseCustom> list=null;
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCouse());
        if(page==null||page==0){
            pagingVO.setToPageNo(1);
            list=courseService.findByPaging(1);
        }else{
            pagingVO.setToPageNo(page);
            list=courseService.findByPaging(page);
        }
        int courseNumber=courseService.getCountCouse();
        model.addAttribute("courseNumber",courseNumber);
        model.addAttribute("courseList",list);
        model.addAttribute("pagingVO",pagingVO);
        return "admin/showCourse";
    }
    //Search the course
    @RequestMapping(value = "/selectCourse",method = {RequestMethod.POST})
    public String selectCourse(String findByName,Model model)throws Exception{
        if(findByName==null){
            return "redirect:/admin/showCourse";
        }
        List<CourseCustom> courseCustoms=courseService.findByName(findByName);
        model.addAttribute("courseList",courseCustoms);
        return "admin/showCourse";
    }
    //add course information
    @RequestMapping(value = "/addCourse",method = {RequestMethod.GET})
    public String addCourseUI(Model model)throws Exception{
        List<Teacher> teachers=teacherService.findAll();
        List<College> colleges=collegeService.finAll();
        model.addAttribute("teacherList",teachers);
        model.addAttribute("collegeList",colleges);
        return "admin/addCourse";
    }
    //Add course post processing
    @RequestMapping(value = "/addCourse",method = {RequestMethod.POST})
    public String addCourse(CourseCustom courseCustom,Model model)throws Exception{
        Boolean result=courseService.save(courseCustom);
        if(!result){
            model.addAttribute("message","课程号重复");
            return "error";
        }

        return "redirect:/admin/showCourse";
    }
    //Modify the Course
    @RequestMapping(value = "/editCourse",method = {RequestMethod.GET})
    public String editCourseUI(Model model,Integer id)throws Exception{
        if(id==null){
            return "redirect:/admin/showCourse";
        }
        CourseCustom courseCustom=courseService.findById(id);
        if(courseCustom==null){
            throw new CustomException("未找到课程！");
        }
        List<Teacher> teachers=teacherService.findAll();
        List<College> colleges=collegeService.finAll();
        model.addAttribute("teacherList",teachers);
        model.addAttribute("collegeList",colleges);
        model.addAttribute("course", courseCustom);
        return "admin/editCourse";
    }
    //Modify course post processing
    @RequestMapping(value = "/editCourse",method = {RequestMethod.POST})
    public String editCourse(CourseCustom courseCustom)throws Exception{
        courseService.upadteById(courseCustom.getCourseid(),courseCustom);
        return "redirect:/admin/showCourse";
    }
    //delete course
    @RequestMapping(value = "/removeCourse")
    public String removeCourse(Integer id)throws Exception{
        if (id == null) {
            //加入没有带教师id就进来的话就返回教师显示页面
            return "admin/showCourse";
        }
        selectedCourseService.remove(id);
        courseService.removeById(id);
        return "redirect:/admin/showCourse";
    }
    //---------------------------------Other operating-------------------------------
    //Password reset for normal user accounts
    @RequestMapping(value = "/userPasswordRest")
    public String userPasswordRestUI()throws Exception{
        return "admin/userPasswordRest";
    }
    //Password and account reset for normal before operation
    @RequestMapping(value = "/userPasswordRest",method = {RequestMethod.POST})
    public String userPasswordRest(Userlogin userlogin)throws Exception{
        Userlogin userlogin1=userloginService.findByName(userlogin.getUsername());
        if(userlogin1!=null){
            if(userlogin1.getRole()==0){
                throw new CustomException("该账户为管理员账号，没法修改");
            }
            userlogin1.setPassword(userlogin.getPassword());
            userloginService.updateByName(userlogin.getPassword(),userlogin1);
        }else{
            throw new CustomException("没找到该用户");
        }
        return "admin/userPasswordRest";
    }
    //This account password is reset
    @RequestMapping(value = "/passwordRest")
    public String passwordRest(){
        return "admin/passwordRest";
    }
}
