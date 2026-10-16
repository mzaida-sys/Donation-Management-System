package com.example.marwazaida220230577;

public class Family {
    private String name;
    private int membersCount;
    private String address;
    private String phone;
    private String status;
    private String notes;

    public Family(String name, int membersCount, String address, String phone, String status, String notes) {
        this.name = name;
        this.membersCount = membersCount;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public void setName(String name) { this.name = name; }
    public void setMembersCount(int membersCount) { this.membersCount = membersCount; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setStatus(String status) { this.status = status; }
    public void setNotes(String notes) { this.notes = notes; }
}