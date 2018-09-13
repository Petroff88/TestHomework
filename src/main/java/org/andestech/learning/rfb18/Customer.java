package org.andestech.learning.rfb18;

import java.util.UUID;

public class Customer {

    public String id = "";
    public String name = "";
    public String sname = "";
    public double salary;
    public int age;
    public int creditRating;


    public Customer(String name, String sname, double salary, int age, int creditRating) {
        this.name = name;
        this.sname = sname;
        this.salary = salary;
        this.age = age;
        this.creditRating = creditRating;
        this.id = id;
    }

    public void setId(String id) {
        int idCount = 0;
        idCount++;
        String s = String.format("%04d", idCount);
        this.id = id;
    }
}
