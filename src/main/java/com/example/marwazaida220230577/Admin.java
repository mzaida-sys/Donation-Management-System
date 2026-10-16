package com.example.marwazaida220230577;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    public void addEmployee(Employee emp) {
        DataStorage.employees.add(emp);
    }

    public void viewReports() {
        System.out.println("Displaying reports...");
    }
}