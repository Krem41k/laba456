package laba456.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Practice {
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "([а-яА-Я]+)", message = "Поле должно содержать строку написанную русскими буквами")
    private String nameOfOrganization;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "([а-яА-Я]+)", message = "Поле должно содержать строку написанную русскими буквами")
    private String positionHeld;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "([а-яА-Я]+)", message = "Поле должно содержать строку написанную русскими буквами")
    private String city;

    @DateTimeFormat(pattern = "dd.MM.YYYY")
    private String dateOfReceipt;

    @Min(value = 7000, message = "Поле должно содержать число больше чем 6999")
    @Max(value = 1000000, message = "Поле должно содержать число меньше чем 1000001")
    private int salary;

    public Practice() {
    }

    public Practice(int id, String nameOfOrganization, String city, String positionHeld, String dateOfReceipt, int salary) {
        this.id = id;
        this.nameOfOrganization = nameOfOrganization;
        this.city = city;
        this.positionHeld = positionHeld;
        this.dateOfReceipt = dateOfReceipt;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }

    public String getPositionHeld() {
        return positionHeld;
    }

    public void setPositionHeld(String positionHeld) {
        this.positionHeld = positionHeld;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(String dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
