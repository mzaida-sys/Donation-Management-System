package com.example.marwazaida220230577;

public class Donor extends User {
    private String email;
    private String name;
    private String phone;

    public Donor(String username, String password, String name, String email, String phone) {
        super(username, password);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String getRole() {
        return "Donor";
    }

    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    public void setEmail(String email) { this.email = email; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }

    public void viewDonations() {
        for (Donation d : DataStorage.donations) {
            System.out.println(d.getDetails());
        }
    }

    public void donate(Donation donation) {
        DataStorage.donations.add(donation);
    }

    public void viewFamilies() {
        for (Family f : DataStorage.families) {
            System.out.println(f.getName());
        }
    }
}