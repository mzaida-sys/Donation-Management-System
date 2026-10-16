package com.example.marwazaida220230577;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStorage {

    public static ObservableList<Family> families = FXCollections.observableArrayList();
    public static ObservableList<Donation> donations = FXCollections.observableArrayList();
    public static ObservableList<Employee> employees = FXCollections.observableArrayList();

    public static Donor loggedDonor;

    static {

        families.add(new Family("Salem Family", 6, "Rafah", "0599999999", "Widow", "No income"));
        families.add(new Family("Ali Family", 4, "Khan Younis", "0561234567", "Married", "Has a disabled child"));


        employees.add(new Employee("emp1", "123456", "Hamza Hani", "12/08/2015", "Male", "Field researcher", "0599999999"));


        loggedDonor = new Donor("donor1", "123456", "Marwa Zaida", "marwa@example.com", "0598765432");
    }
}