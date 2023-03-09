package ru.eltex.list;

public class Manager extends User {
    private final Role role = Role.manager;
    public Manager(String name, String phone) {
        super(name, phone);
    }

    String getInfo() {
        return this.role + " phone: " + getPhone() + ". She is busy." + "\n";
    }
}
