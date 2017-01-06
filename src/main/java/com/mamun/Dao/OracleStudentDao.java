package com.mamun.Dao;

import com.mamun.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mamun on 1/3/17.
 */

@Repository
@Qualifier("oracleData")
public class OracleStudentDao implements StudentDao {
    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>(){
            {
                add(new Student(1,"Mario","Nothing"));
            }
        };
    }

    @Override
    public Student getStudentById(int id) {
        return null ;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudentToDB(Student student) {

    }
}
