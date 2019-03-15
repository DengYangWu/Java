package com.system.po;
/**
 *  ��ҳ��Ϣ pojo��
 */
public class PagingVO {

    //��ǰҳ��,Ĭ�ϵ�һҳ
    private int curentPageNo = 1;
    //��ҳ��
    private int totalCount;
    //ҳ������
    private int pageSize=5;
    //��һҳ
    private int upPageNo;
    //��һҳ
    private int nextPageNo;
    //Ҫǰ����ҳ��,Ĭ��0
    private int toPageNo = 0;

    public void setToPageNo(Integer toPageNo) {
        //��һҳ
        this.toPageNo = (toPageNo-1) * pageSize ;
        //������ת��ǰ��ҳ��
        setCurentPageNo(toPageNo);
    }

    public Integer getTopageNo() {
        return toPageNo;
    }

    public int getCurentPageNo() {
        return curentPageNo;
    }

    //���õ�ǰҳ��
    public void setCurentPageNo(int curentPageNo) {
        if (curentPageNo != 1) {
            this.upPageNo = curentPageNo - 1;
        }
        this.nextPageNo = curentPageNo + 1;

        this.curentPageNo = curentPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount%pageSize > 0) {
            this.totalCount = (totalCount/pageSize)+1;
        } else {
            this.totalCount = totalCount/pageSize;
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getUpPageNo() {
        return upPageNo;
    }

    public void setUpPageNo(int upPageNo) {
        this.upPageNo = upPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }
}
