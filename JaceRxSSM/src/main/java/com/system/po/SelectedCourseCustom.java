package com.system.po;

/*
 * �γ��Զ���
 * */
public class SelectedCourseCustom extends Selectedcourse {
	 //����Student �����ֶ�
    private StudentCustom studentCustom;
    //��չ�γ���Ϣ����
    private CourseCustom courseCustom;

    //�жϸ�ѧ���Ƿ��Ѿ���ɸÿγ�
    private Boolean over = false;


    public Boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }

    public CourseCustom getCouseCustom() {
        return courseCustom;
    }

    public void setCouseCustom(CourseCustom couseCustom) {
        this.courseCustom = couseCustom;
    }
}