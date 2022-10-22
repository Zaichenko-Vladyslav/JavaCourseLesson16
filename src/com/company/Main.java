package com.company;

import com.company.model.FullTimeEmployee;
import com.company.model.PartTimeEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee("Full time employee 1", 7000);
        FullTimeEmployee fullTimeEmployee2 = new FullTimeEmployee("Full time employee 2", 6000);
        FullTimeEmployee fullTimeEmployee3 = new FullTimeEmployee("Full time employee 3", 4000);
        FullTimeEmployee fullTimeEmployee4 = new FullTimeEmployee("Full time employee 4", 5500);
        FullTimeEmployee fullTimeEmployee5 = new FullTimeEmployee("Full time employee 5", 4800);

        PartTimeEmployee designer = new PartTimeEmployee("designer",25,150);
        PartTimeEmployee tester = new PartTimeEmployee("tester",35,176);
        PartTimeEmployee backend = new PartTimeEmployee("backend",50,200);
        PartTimeEmployee gui = new PartTimeEmployee("gui",38,200);
        PartTimeEmployee devops = new PartTimeEmployee("admin",40,176);

        List<IAccounting> employees = new ArrayList<>();

        employees.add(fullTimeEmployee1);
        employees.add(fullTimeEmployee2);
        employees.add(fullTimeEmployee3);
        employees.add(fullTimeEmployee4);
        employees.add(fullTimeEmployee5);

        employees.add(designer);
        employees.add(tester);
        employees.add(backend);
        employees.add(gui);
        employees.add(devops);

        int salary = employees.stream().mapToInt(IAccounting::getSalary).sum();

        IAccounting highestSalaryMan = employees.stream()
                .max(Comparator.comparingInt(IAccounting::getSalary))
                .orElse(null);

        IAccounting lowestSalaryMan = employees.stream()
                .min(Comparator.comparingInt(IAccounting::getSalary))
                .orElse(null);

        double averageSalary = employees.stream().mapToInt(IAccounting::getSalary)
                .average().orElse(0);

        int partTimeSalary = employees.stream().filter(el -> el instanceof PartTimeEmployee)
                .mapToInt(IAccounting::getSalary).sum();

        int fullTimeSalary = employees.stream().filter(el -> el instanceof FullTimeEmployee)
                .mapToInt(IAccounting::getSalary).sum();

        if (partTimeSalary > fullTimeSalary) {
            System.out.println("Part time workers get greater salary than full time workers");
        } else {
            System.out.println("Full time employees are the best");
        }

        System.out.println("Company has " + employees.size() + " employees"
                + System.lineSeparator()
                + "Total salary is " + salary + " USD");
    }
}
