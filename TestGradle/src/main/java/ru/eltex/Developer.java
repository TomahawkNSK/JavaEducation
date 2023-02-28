package ru.eltex;

public class Developer extends User {
    private final Role role = Role.developer;
    private String languages = "";
    private String abilities = "";

    public Developer () {
        super();
    }
    public Developer (String name, Gender gender, int age) {
        super(name, gender, age);
    }

    //we need all getters/setters for json serialization, so...
    public String getLanguages() {
        return languages;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    String getInfo() {
        String abilities = "";
        String languages = "";

        if (this.abilities.length() > 0)
            abilities = "abilities: " + this.abilities + "\n";
        if (this.languages.length() > 0)
            languages = "languages: " + this.languages + "\n";

        return super.getIdDesc() + " " + this.role + ": " + super.getBasicInfo() + "\n"
                + super.getLocationStr() + "\n" + languages + abilities;
    }
}
