package com.example.student_data_collect;

public class Student {
    private String name;
    private int age;
    private String Enrl_no;
    private String reg_no;
    private String ph_no;
    private String course;
    private String branch;
    private int student_id;
//private int null;
    public Student(String name, int age, String enrl_no, String reg_no, String ph_no, String course, String branch,int student_id ) {
        this.name = name;
        this.age = age;
        Enrl_no = enrl_no;
        this.reg_no = reg_no;
        this.ph_no = ph_no;
        this.course = course;
        this.branch = branch;
        this.student_id=student_id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEnrl_no() {
        return Enrl_no;
    }

    public void setEnrl_no(String enrl_no) {
        Enrl_no = enrl_no;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
