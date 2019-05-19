package cn.tycoding.action;

import cn.tycoding.pojo.Admin;
import cn.tycoding.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
    //new对象admin实体类
    private Admin admin = new Admin();
    //注入Service
    private AdminService adminService;
    @Override
    public Admin getModel() {
        return admin;
    }

    //登陆Action功能
    public String adminLogin() throws Exception{
        Admin adminexist=adminService.login(admin);
        String name=adminexist.getAdminname();
        try {
            if (adminexist != null) {
                ServletActionContext.getRequest().setAttribute("adminName", name);
                return "adminLogin";
            } else {
                ServletActionContext.getRequest().setAttribute("message", "没有查询到当前用户登陆信息！");
                return "error";
            }
        }catch (Exception e){
            System.out.println("你输入的用户名或密码错误！");
            ServletActionContext.getRequest().setAttribute("message","你输入的用户名或密码错误！");
            return "error";
        }
    }

    //提供跳转到首页的方法
    public String toIndexPage(){
        return "toIndexPage";
    }

}
