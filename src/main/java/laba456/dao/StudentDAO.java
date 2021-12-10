package laba456.dao;

import laba456.models.Person;
import laba456.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> index() {
        return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class));
    }
    public void save(Student student) {
        jdbcTemplate.update("INSERT student(lastname, yearOfBirth,sex,studentGroup, email,averageScore) " +
                        "VALUES(?,?,?,?,?,?)", student.getLastname(), student.getYearOfBirth(), student.getSex(),
                student.getStudentGroup(), student.getEmail(), student.getAverageScore());
    }
    public Student show(int id) {
        return jdbcTemplate.query("SELECT * FROM student WHERE id=?",
                new Object[]{id},  new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(null);
    }
    public void update(int id, Student student) {
        jdbcTemplate.update("UPDATE student SET lastname=?, yearOfBirth=?, sex=?, " +
                        "studentGroup=?, email=?, averageScore=? WHERE id=?",
                student.getLastname(), student.getYearOfBirth(), student.getSex(),
                student.getStudentGroup(), student.getEmail(), student.getAverageScore(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM student WHERE id=?",id);
    }
}
