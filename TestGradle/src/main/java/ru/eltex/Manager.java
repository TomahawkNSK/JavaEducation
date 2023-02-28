package ru.eltex;

public class Manager extends User {
    private final Role role = Role.manager;
    private String skills = "";

    public Manager () {
        super();
    }

    public Manager (String name, Gender gender, int age) {
        super(name, gender, age);
    }

    //we need all getters/setters for json serialization, so...
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    String getInfo() {
        String skills = "";

        if (this.skills.length() > 0)
            skills = "skills: " + this.skills + "\n";

        return super.getIdDesc() + " " + this.role + ": " + super.getBasicInfo() + "\n"
                + super.getLocationStr() + "\n" + skills;
    }
}
