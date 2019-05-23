package cn.tycoding.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author huys
 * @date 18-3-10下午12:47
 */
public class PageBean<T> implements Serializable {

    //当前页
    private int pageCode;

    //总页数=总条数/每页显示的条数
    //private int totalPage;

    //总记录数
    private int totalCount;

    //每页显示的记录条数
    private int pageSize;

    //每页显示的数据
    private List<T> beanList;

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    /**
     * 调用getTotalPage() 获取到总页数
     * JavaBean属性规定：totalPage是javaBean属性 ${pageBean.totalPage}
     */
    public int getTotalPage() {
        //计算
        int totalPage = totalCount / pageSize;
        //说明整除
        if(totalCount % pageSize == 0){
            return totalPage;
        }else{
            return totalPage + 1;
        }
    }

   /* public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }*/

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

}