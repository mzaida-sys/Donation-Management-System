package com.example.marwazaida220230577;

import java.time.LocalDate;

public class Donation {
    private String family;
    private String type;
    private double amount;
    private LocalDate date;

    public Donation(String family, String type, double amount, String date) {
        this.family = family;
        this.type = type;
        this.amount = amount;
        this.date = LocalDate.parse(date);
    }

    public Donation(String family, String type, double amount, LocalDate date) {
        this.family = family;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getFamily() {
        return family;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date.toString();
    }

    public String getDetails() {
        return "Family: " + family + ", Type: " + type + ", Amount: " + amount + ", Date: " + date;
    }
}