package ru.eltex.list;

public class Developer extends User {
    private final Role role = Role.developer;
    public Developer(String name, String phone) {
        super(name, phone);
    }

    String getInfo() {
        return this.role + " phone: " + getPhone() + ". Don't call him." + "\n";
    }
}
