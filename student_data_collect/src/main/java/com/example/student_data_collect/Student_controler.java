package com.example.student_data_collect;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
@RestController
public class Student_controler {
    HashMap<Integer,Student> studentdb=new HashMap<>();
    @PatchMapping("/addStudentViaParameters")
    public String addStudent(@RequestParam("name")String name,@RequestParam("age")Integer age,@RequestParam("Enrl_no")String Enrl_no,@RequestParam("reg_no")String reg_no,@RequestParam("ph_no")String ph_no,@RequestParam("course")String course,@RequestParam("branch")String branch,@RequestParam("student_id")Integer student_id){
        Student student=new Student(name,age,Enrl_no,reg_no,ph_no,course,branch,student_id);
        studentdb.put(student_id,student);
      return "student add successfully";
    }
    @PostMapping("/addStudentViaRequestBody")
    public String addStudent(@RequestBody Student student) {
        if (student == null) {
            return "Invalid student details provided.";
        }

        String key;
        if (student.getStudent_id() != 0) {
            key = String.valueOf(student.getStudent_id());
        } else if (student.getReg_no() != null) {
            key = student.getReg_no();
        } else if (student.getEnrl_no() != null) {
            key = student.getEnrl_no();
        } else {
            return "Invalid student details provided.";
        }

        try {
            studentdb.put(Integer.valueOf(key), student);
            return "Student added successfully via " + (student.getStudent_id() != 0 ? "student ID." :
                    student.getReg_no() != null ? "registration number." : "enrollment number.");
        } catch (Exception e) {
            return "Error occurred while adding student: " + e.getMessage();
        }
    }
    @GetMapping("/getStudentInfo")
public Student getStudent(@RequestParam("student_id")Integer student_id,@RequestParam("reg_no")Integer reg_no,@RequestParam("Enrl_no")Integer Enrl_no){
        if(student_id!=null){
            return studentdb.get(student_id);
        } else if (reg_no!=null) {
            return studentdb.get(reg_no);
        } else if (Enrl_no!=null) {
            return studentdb.get(Enrl_no);
        }
        else{
            return null;
        }
    }
@GetMapping("/getAllInfoStudent")
public List<Student> getAllStudent(){
        List<Student> students=new ArrayList<>();
for(Student s:studentdb.values()){
    students.add(s);

}
return students;
    }
    @GetMapping("/getStuentByName")
    public Student getStudentByName(@RequestParam("name")String name){
        for(Student s:studentdb.values()){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }
@GetMapping("/addStudentGreaterThanAge")
    public List<Student> getBytheAge(@RequestParam("age")Integer age){
        List<Student> students=new ArrayList<>();
        for (Student s:studentdb.values()){
            if(s.getAge()>age){
                students.add(s);
            }
        }
        return students;
}
}
