package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepositary studentRepositary=new StudentRepositary();
    public void addStudent(Student student){
        studentRepositary.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepositary.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        studentRepositary.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String student){
        Student response=studentRepositary.getStudentByName(student);
        return  response;
    }
    public Teacher getTeacherByName(String teacher){
       Teacher teacher1=studentRepositary.getTeacherByName(teacher);
       return  teacher1;
    }
    public List<String> getStudentsByTeacherName(String teacher){
       List<String>st= studentRepositary.getStudentsByTeacherName(teacher);
       return st;
    }
    public  List<String>getAllStudents(){
      List<String>list=studentRepositary.getAllStudents();
      return list;
    }
    public void deleteTeacherByName(String teacher){
        studentRepositary.deleteTeacherByName(teacher);

    }
    public void deleteAllTeachers(){
        studentRepositary.deleteAllTeachers();
    }
}
