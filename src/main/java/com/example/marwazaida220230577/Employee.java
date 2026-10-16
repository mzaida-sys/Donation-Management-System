package com.example.marwazaida220230577;

public class Employee extends User {
    private String fullName;
    private String birthDate;
    private String gender;
    private String position;
    private String phone;

    public Employee(String username, String password, String fullName, String birthDate, String gender, String position, String phone) {
        super(username, password);
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.position = position;
        this.phone = phone;
    }

    @Override
    public String getRole() {
        return "Employee";
    }

    public String getFullName() { return fullName; }
    public String getBirthDate() { return birthDate; }
    public String getGender() { return gender; }
    public String getPosition() { return position; }
    public String getPhone() { return phone; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPosition(String position) { this.position = position; }
    public void setPhone(String phone) { this.phone = phone; }

    public void addFamily(Family family) {
        DataStorage.families.add(family);
    }

    public void viewFamilies() {
        for (Family family : DataStorage.families) {
            System.out.println(family.getName());
        }
    }

    public void editFamilies(Family family, String newAddress) {
        family.setAddress(newAddress);
    }
}