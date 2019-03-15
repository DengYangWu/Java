package com.system.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *    ȫ���쳣������
 *    springmvc�ṩһ��HandlerExceptionResolver�ӿ�
 *      ֻҪʵ�ָýӿڣ������õ�spring ������������
 *      ��ΪĬ��ȫ���쳣������
 *
 *   ȫ���쳣������ֻ��һ�������ö��Ҳû�á�
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();

        CustomException customException;
        if (e instanceof CustomException) {
            customException = (CustomException)e;
        } else if (e instanceof UnknownAccountException) {
            //�û��������쳣
            modelAndView.addObject("message", "û�и��û�");
            modelAndView.setViewName("error");
            return modelAndView;
        } else if (e instanceof IncorrectCredentialsException) {
            //�û��������쳣
            modelAndView.addObject("message", "�������");
            modelAndView.setViewName("error");
            return modelAndView;
        } else {
            customException = new CustomException("δ֪����");
        }

        //������Ϣ
        String message = customException.getMessage();



        //������Ϣ���ݺʹ���ҳ����ת
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");


        return modelAndView;
    }
}