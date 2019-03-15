package com.system.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������ �ַ�������ת����
 */
public class CustomDateConverter implements Converter<String, Date> {


    public Date convert(String s) {
        //ʵ�� �����ڴ�ת����������(��ʽ��yyyy-MM-dd)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //ת��ֱ�ӷ���
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //���������ʧ�ܷ���null
        return null;
    }
}