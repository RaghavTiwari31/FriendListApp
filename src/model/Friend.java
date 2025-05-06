package model;

public class Friend {
    private String name;
    private String contactNumber;
    private String address;
    private String dob;

    public Friend(String name, String contactNumber, String address, String dob) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return name + "," + contactNumber + "," + address + "," + dob;
    }

    public String getName() {
        return name;
    }
}