package com.mamun.Dao;

import com.mamun.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mamun on 1/5/17.
 */
@Repository
@Qualifier ("mysql")
public class MySqlStudentDao implements StudentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
       final String sql = "SELECT id, name, course from students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        final String sql = "SELECT id, name, course from students where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public void removeStudentById(int id) {
        final String sql = "DELETE from students where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateStudent(Student student) {
        final String sql = "UPDATE students SET name = ?, course = ? where id = ?";
        final int id = student.getId();
        final String name =student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[] {name, course, id});
    }

    @Override
    public void insertStudentToDB(Student student) {
        final String sql = "INSERT INTO students (name, course) VALUES (?, ?)";
        final String name =student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[] { name, course});
    }
}
