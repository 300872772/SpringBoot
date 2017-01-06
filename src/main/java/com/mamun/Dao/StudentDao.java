package com.mamun.Dao;

import com.mamun.Entity.Student;

import java.util.Collection;

/**
 * Created by kamrulislam on 1/3/17.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudentToDB(Student student);
}
