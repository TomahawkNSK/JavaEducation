package ru.eltex.list;

public class User {
    private String name;
    private String phone;
    private final Role role = Role.user;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String getInfo() {
        return this.role + " phone: " + getPhone() + ". Nothing special." + "\n";
    }
}
