package com.system.service;

import com.system.po.Userlogin;

public interface UserloginService {
	 //�������ֲ����û�
    Userlogin findByName(String name) throws Exception;

    //�����û���¼��Ϣ
    void save(Userlogin userlogin) throws Exception;

    //��������ɾ��
    void removeByName(String name) throws Exception;

    //�����û�������
    void updateByName(String name, Userlogin userlogin);

}
