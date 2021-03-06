package com.system.po;

import java.io.Serializable;

public class Course implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.courseID
     *
     * @mbggenerated
     */
    private Integer courseid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.courseName
     *
     * @mbggenerated
     */
    private String coursename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.teacherID
     *
     * @mbggenerated
     */
    private Integer teacherid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.courseTime
     *
     * @mbggenerated
     */
    private String coursetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.classRoom
     *
     * @mbggenerated
     */
    private String classroom;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.courseWeek
     *
     * @mbggenerated
     */
    private Integer courseweek;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.courseType
     *
     * @mbggenerated
     */
    private String coursetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.collegeID
     *
     * @mbggenerated
     */
    private Integer collegeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.score
     *
     * @mbggenerated
     */
    private Integer score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table course
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.courseID
     *
     * @return the value of course.courseID
     *
     * @mbggenerated
     */
    public Integer getCourseid() {
        return courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.courseID
     *
     * @param courseid the value for course.courseID
     *
     * @mbggenerated
     */
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.courseName
     *
     * @return the value of course.courseName
     *
     * @mbggenerated
     */
    public String getCoursename() {
        return coursename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.courseName
     *
     * @param coursename the value for course.courseName
     *
     * @mbggenerated
     */
    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.teacherID
     *
     * @return the value of course.teacherID
     *
     * @mbggenerated
     */
    public Integer getTeacherid() {
        return teacherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.teacherID
     *
     * @param teacherid the value for course.teacherID
     *
     * @mbggenerated
     */
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.courseTime
     *
     * @return the value of course.courseTime
     *
     * @mbggenerated
     */
    public String getCoursetime() {
        return coursetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.courseTime
     *
     * @param coursetime the value for course.courseTime
     *
     * @mbggenerated
     */
    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime == null ? null : coursetime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.classRoom
     *
     * @return the value of course.classRoom
     *
     * @mbggenerated
     */
    public String getClassroom() {
        return classroom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.classRoom
     *
     * @param classroom the value for course.classRoom
     *
     * @mbggenerated
     */
    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.courseWeek
     *
     * @return the value of course.courseWeek
     *
     * @mbggenerated
     */
    public Integer getCourseweek() {
        return courseweek;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.courseWeek
     *
     * @param courseweek the value for course.courseWeek
     *
     * @mbggenerated
     */
    public void setCourseweek(Integer courseweek) {
        this.courseweek = courseweek;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.courseType
     *
     * @return the value of course.courseType
     *
     * @mbggenerated
     */
    public String getCoursetype() {
        return coursetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.courseType
     *
     * @param coursetype the value for course.courseType
     *
     * @mbggenerated
     */
    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype == null ? null : coursetype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.collegeID
     *
     * @return the value of course.collegeID
     *
     * @mbggenerated
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.collegeID
     *
     * @param collegeid the value for course.collegeID
     *
     * @mbggenerated
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.score
     *
     * @return the value of course.score
     *
     * @mbggenerated
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.score
     *
     * @param score the value for course.score
     *
     * @mbggenerated
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Course other = (Course) that;
        return (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()))
            && (this.getCoursename() == null ? other.getCoursename() == null : this.getCoursename().equals(other.getCoursename()))
            && (this.getTeacherid() == null ? other.getTeacherid() == null : this.getTeacherid().equals(other.getTeacherid()))
            && (this.getCoursetime() == null ? other.getCoursetime() == null : this.getCoursetime().equals(other.getCoursetime()))
            && (this.getClassroom() == null ? other.getClassroom() == null : this.getClassroom().equals(other.getClassroom()))
            && (this.getCourseweek() == null ? other.getCourseweek() == null : this.getCourseweek().equals(other.getCourseweek()))
            && (this.getCoursetype() == null ? other.getCoursetype() == null : this.getCoursetype().equals(other.getCoursetype()))
            && (this.getCollegeid() == null ? other.getCollegeid() == null : this.getCollegeid().equals(other.getCollegeid()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        result = prime * result + ((getCoursename() == null) ? 0 : getCoursename().hashCode());
        result = prime * result + ((getTeacherid() == null) ? 0 : getTeacherid().hashCode());
        result = prime * result + ((getCoursetime() == null) ? 0 : getCoursetime().hashCode());
        result = prime * result + ((getClassroom() == null) ? 0 : getClassroom().hashCode());
        result = prime * result + ((getCourseweek() == null) ? 0 : getCourseweek().hashCode());
        result = prime * result + ((getCoursetype() == null) ? 0 : getCoursetype().hashCode());
        result = prime * result + ((getCollegeid() == null) ? 0 : getCollegeid().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseid=").append(courseid);
        sb.append(", coursename=").append(coursename);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", coursetime=").append(coursetime);
        sb.append(", classroom=").append(classroom);
        sb.append(", courseweek=").append(courseweek);
        sb.append(", coursetype=").append(coursetype);
        sb.append(", collegeid=").append(collegeid);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}