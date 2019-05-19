package cn.tycoding.action;

import cn.tycoding.pojo.Admin;
import cn.tycoding.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

/**
 * @author huys
 * @date 18-3-10下午5:56
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

    //手动new实体类
    private Admin admin = new Admin();

    /**
     * 采用模型驱动方式
     * @return
     */
    @Override
    public Admin getModel() {
        return admin;
    }

    /**
     * 注入service
     */
    private AdminService adminService;
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 登录功能
     */
    public String adminLogin(){
        try{
            Admin existAdmin = adminService.login(admin);
            String adminName = existAdmin.getAdminname();
            if(existAdmin != null){
                // 登录成功,将其放到域对象中
                ServletActionContext.getRequest().setAttribute("adminName",adminName);
                return "adminLogin";
            }else{
                ServletActionContext.getRequest().setAttribute("message","没有查询到当前用户登录信息");
                return "error";
            }
        }catch(Exception e){
            System.out.println("你输入的用户名或则密码错误");
            ServletActionContext.getRequest().setAttribute("message","你输入的用户名或则密码错误");
            return "error";
        }
    }

    /**
     * 提供跳转到首页的方法
     */
    public String toIndexPage(){
        return "toIndexPage";
    }

}
