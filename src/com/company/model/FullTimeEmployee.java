package com.company.model;

/*
*
*   HEADER
*
* */

import com.company.IAccounting;

public class FullTimeEmployee implements IAccounting {

    private String name;
    private int monthlySalary; // Solid salary for a month according to contract
    private int days;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, int monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "name='" + name + '\'' +
                ", monthlySalary=" + monthlySalary +
                '}';
    }

    @Override
    public int getSalary() {
        return this.getMonthlySalary();
    }
}
