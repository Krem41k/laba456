package laba456.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PracticeReport {
    private int id;

    private int practiceId;
    private int studentId;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date expirationDate;
    private int grade;

    public PracticeReport() {
    }

    public PracticeReport(int id, int practiceId, int studentId, Date expirationDate, int grade) {
        this.id = id;
        this.practiceId = practiceId;
        this.studentId = studentId;
        this.expirationDate = expirationDate;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(int practiceId) {
        this.practiceId = practiceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
