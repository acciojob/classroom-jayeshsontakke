package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepositary {
    HashMap<String,Student>studentDb=new HashMap<>();
    HashMap<String,Teacher>teacherDb=new HashMap<>();
    HashMap<String,List<String>>studentTeacherPair=new HashMap<>();


    public void  addStudent(Student student){
        String key=student.getName();
        studentDb.put(key,student);

    }
    public void addTeacher(Teacher teacher){
        String key=teacher.getName();
        teacherDb.put(key,teacher);

    }
    public void addStudentTeacherPair(String student,String teacher){
        List<String>list=studentTeacherPair.get(teacher);
        if(list==null){
            list=new ArrayList<>();
        }
        list.add(teacher);
        studentTeacherPair.put(student,list);
    }
    public Student getStudentByName(String student){
        for(Student st:studentDb.values()){
            if(st.getName().equals(student)){
                return st;
            }
        }
        return null;
    }
    public Teacher getTeacherByName(String teacher){
        for (Teacher teacher1:teacherDb.values()){
            if(teacher1.getName().equals(teacher)){
                return teacher1;
            }
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String teacher){
     List<String >list=studentTeacherPair.get(teacher);
     if(list==null)
      return null;
     else {
         return list;
     }
    }

    public  List<String>getAllStudents(){
        List<String>list=new ArrayList<>();
        for(Student student:studentDb.values()){
            list.add(student.getName());
        }
       return list;
    }
    public void deleteTeacherByName(String teacher){

      for(String st:studentTeacherPair.get(teacher)){
          studentDb.remove(st);
      }
        studentTeacherPair.remove(teacher);
        teacherDb.remove(teacher);
    }
    public void deleteAllTeachers(){
         for(String teacher:teacherDb.keySet()){
             for (String st:studentTeacherPair.get(teacher)){
                 studentDb.remove(st);
             }
             studentTeacherPair.remove(teacher);
             teacherDb.remove(teacher);

         }

    }

}
