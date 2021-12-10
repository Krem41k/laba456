package laba456.models;

import javax.validation.constraints.*;

public class Student {
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "([а-яА-Я]+)", message = "Поле должно содержать строку написанную русскими буквами")
    private String lastname;


    @Min(value = 1995, message = "Поле должно содержать число больше чем 1994")
    @Max(value = 2003, message = "Поле должно содержать число меньше чем 2004")
    private int yearOfBirth;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "[м,М]ужской|[ж,Ж]енский", message = "Поле должно содержать значения Мужской или Женский")
    private String sex;

    @NotEmpty(message = "Поле не должно быть пустым")
    private String studentGroup;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Email(message = "Email должен быть валидным")
    private String email;

    @Min(value = 1, message = "Поле должно содержать число больше чем 0")
    @Max(value = 5, message = "Поле должно содержать число меньше чем 6")
    private int averageScore;

    public Student() {
    }

    public Student(int id, String lastname, int yearOfBirth, String sex,
                   String studentGroup, String email, int averageScore) {
        this.id = id;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
        this.sex = sex;
        this.studentGroup = studentGroup;
        this.email = email;
        this.averageScore = averageScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String group) {
        this.studentGroup = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }
}
