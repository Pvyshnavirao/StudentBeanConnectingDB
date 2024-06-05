package com.example.Student.Repository;

import com.example.Student.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;


    public void save(Student s) {
        String sql = "insert into student(sid,sname,marks) values(?,?,?)";
//if we use execute function in the jdbc then we should specify the values in the query
        int rows = jdbc.update(sql, s.getSid(), s.getSname(), s.getMarks());

        System.out.println(rows);
    }


    public List<Student> findAll() {

        String sql = "select * from student";
        RowMapper<Student> mapper = (rs, rowNum) ->
        {
            Student s = new Student();
            s.setSid(rs.getInt("sid"));
            s.setSname(rs.getString("sname"));
            s.setMarks(rs.getInt("marks"));
            return s;
        };


        return jdbc.query(sql, mapper);
    }
}

