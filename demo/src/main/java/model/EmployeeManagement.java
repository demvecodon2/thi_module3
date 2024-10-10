package model;

import java.util.Date;

public class EmployeeManagement {
    private int emp_id;
    private String name;
    private Date date_of_birth;
    private String address;
    public EmployeeManagement() {}
    public EmployeeManagement(int emp_id, String name, Date date_of_birth, String address) {
        this.emp_id = emp_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.address = address;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
