package model;

import java.util.Date;

public class CustomerManagement {
    private int id_customer;
    private String name_customer;
    private Date date_of_birth_customer;
    private String phone;
    private String address_customer;
    private String email_customer;

    public CustomerManagement(int id_customer, String name_customer, Date date_of_birth_customer,
                              String phone, String address_customer, String email_customer) {
        this.id_customer = id_customer;
        this.name_customer = name_customer;
        this.date_of_birth_customer = date_of_birth_customer;
        this.phone = phone;
        this.address_customer = address_customer;
        this.email_customer = email_customer;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public Date getDate_of_birth_customer() {
        return date_of_birth_customer;
    }

    public void setDate_of_birth_customer(Date date_of_birth_customer) {
        this.date_of_birth_customer = date_of_birth_customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_customer() {
        return address_customer;
    }

    public void setAddress_customer(String address_customer) {
        this.address_customer = address_customer;
    }

    public String getEmail_customer() {
        return email_customer;
    }

    public void setEmail_customer(String email_customer) {
        this.email_customer = email_customer;
    }
}