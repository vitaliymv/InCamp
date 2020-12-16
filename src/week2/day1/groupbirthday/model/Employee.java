package week2.day1.groupbirthday.model;

import java.time.LocalDate;

public class Employee {

    private String fullName;
    private LocalDate birthday;

    public Employee() {
    }

    public Employee(String fullName, LocalDate birthday) {
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
