package com.system.po;

import java.util.List;

/**
 * Student����չ��
 */
public class StudentCustom extends Student{
	//����Ժϵ��
	private String collegeName;
	//ѡ���б�
	private List<SelectedCourseCustom> selectedCourseList;
	
	public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getcollegeName() {
        return collegeName;
    }

    public void setSelectedCourseList(List<SelectedCourseCustom> selectedCourseList) {
        this.selectedCourseList = selectedCourseList;
    }

    public List<SelectedCourseCustom> getSelectedCourseList() {
        return selectedCourseList;
    }
}
