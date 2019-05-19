package cn.tycoding.action;

import cn.tycoding.pojo.Customer;
import cn.tycoding.pojo.PageBean;
import cn.tycoding.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TyCoding
 * @date 18-3-8下午6:06
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    //采用属性驱动方式
    public Customer getModel() {
        return customer;
    }

    //手动new实体类
    private Customer customer = new Customer();

    //提供service成员属性，并提供set方法
    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 根据id查询
     */
    public String findById() {
        customer = customerService.findById(customer.getC_id());
        return "findById";
    }

    /**
     * 跳转到添加用户的页面
     */
    public String toSavePage() {
        return "toSavePage";
    }

    /**
     * 添加信息
     */
    public String save() {
        System.out.println("save+++++++++++++++++++++++++++++++++++");
        HttpServletRequest request = ServletActionContext.getRequest();
        customerService.save(customer);
        request.setAttribute("message","保存信息成功");
        return "save";
    }

    /**
     * 删除方法
     */
    public String delete() {

        HttpServletRequest request = ServletActionContext.getRequest();
        customer = customerService.findById(customer.getC_id());
        customerService.delete(customer);
        request.setAttribute("message","删除信息成功");
        return "delete";
    }

    /**
     * 修改的方法
     */
    public String update() {
        customerService.update(customer);
        return "update";
    }

    private String result;
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }


    /**
     * 为模态框提供的查询功能
     * 处理ajax的请求
     */
    public String search() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            String c_id = request.getParameter("c_id");
            System.out.println("你在jsp中点击的编号：" + c_id);
            customer = customerService.findById(customer.getC_id());

            //将数据放到Map集合中，再转换成json格式的数据
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("c_id", customer.getC_id());
            map.put("c_name", customer.getC_name());
            map.put("c_telephone", customer.getC_telephone());
            map.put("c_address", customer.getC_address());
            map.put("c_remark", customer.getC_remark());

            //将Map集合数据转换成json格式的数据
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
            System.out.println("这里我要传给前台页面的JSON数据是："+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 分页查询相关
     */
    //声明要返回的JSON字符串
    private String responseStr;

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    //属性驱动方式，当前页，默认页1
    private Integer pageCode = 1;
    public void setPageCode(Integer pageCode) {
        if (pageCode == null) {
            pageCode = 1;
        }
        this.pageCode = pageCode;
    }

    //默认每页显示的数据条数
    private Integer pageSize = 4;

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //分页查询的方法
    public String findByPage() {
        System.out.println("find");
        //调用service层
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        //拼接查询条件
        String c_name = customer.getC_name();
        String c_telephone = customer.getC_telephone();
        if (c_name != null && c_name.trim() != null) {
            criteria.add(Restrictions.like("c_name", "%" + c_name + "%"));
        }
        if (c_telephone != null && c_telephone.trim() != null) {
            criteria.add(Restrictions.like("c_telephone", "%" + c_telephone + "%"));
        }

        //查询
        PageBean<Customer> page = customerService.findByPage(pageCode, pageSize, criteria);
        //压栈
        ValueStack vs = ActionContext.getContext().getValueStack();
        //顶栈是map<"page",page对象>
        vs.set("page", page);
        return "page";
    }
}
