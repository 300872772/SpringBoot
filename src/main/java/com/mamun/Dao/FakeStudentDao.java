package com.mamun.Dao;

import com.mamun.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mamun on 1/3/17.
 */


@Repository
@Qualifier("fakeData")
public class FakeStudentDao implements StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1,"Mamun","Soft Eng"));
                put(2, new Student(2,"Nashrah","Accounting"));
                put(3, new Student(3,"Mou","Language"));
                put(4, new Student(4,"Kalam","Electrical Eng"));
                put(5, new Student(5,"Milton","Finance"));



            }
        };

    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){

        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),student);

    }

    @Override
    public void insertStudentToDB(Student student) {

        this.students.put(student.getId(),student);
    }

}
