public class Main {
    public static void main(String[] args) {
        User person1 = new User("Ivan", Gender.man, 33);
        person1.setLocation("Temple of Wisdom");
        person1.setNickname("The Fool");
        System.out.println(person1.getInfo());

        User person2 = new User("Mario Brother", Gender.man, 47);
        person2.setLocation("Sewer pipes");
        person2.setNickname("The Plumber");
        System.out.println(person2.getInfo());

        Developer person3 = new Developer("Jack Peterson", Gender.man, 35);
        person3.setLocation("Somewhere near the monitor");
        person3.setNickname("Hi Jack!");
        person3.setLanguages("C/C++");
        System.out.println(person3.getInfo());

        Developer person4 = new Developer("Senior Developer", Gender.man, 27);
        person4.setLocation("Area 51");
        person4.setLanguages("C/C++, Java, Assembler");
        person4.setAbilities("Refrigerators repairing");
        System.out.println(person4.getInfo());

        Manager person5 = new Manager("Scarlett", Gender.woman, 50);
        person5.setLocation("Accounting office");
        person5.setSkills("Looking after children");
        System.out.println(person5.getInfo());

        Manager person6 = new Manager("Vika", Gender.woman, 21);
        System.out.println(person6.getInfo());
    }
}

class ENV {
    static int ID = 0;
}

enum Role {
    user,
    developer,
    manager;
}

enum Gender {
    unknown,
    man,
    woman
}

class User {
    private int id;
    private String name;
    private String nickname;
    private Gender gender;
    private int age;
    private String location;
    private final Role role = Role.user;

    User() {
        this.id = ENV.ID++;
        this.name = "Unknown";
        this.gender = Gender.unknown;
        this.age = -1;
        this.nickname = "";
        this.location = "Unknown";
    }

    User(String name, Gender gender, int age) {
        this.id = ENV.ID++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.nickname = "";
        this.location = "Unknown";
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNickname(String nickname) {
        this.nickname = " '" + nickname + "'";
    }

    protected String getIdDesc() {
        return "[id " + this.id + "]";
    }

    protected String getBasicInfo() {
        return this.name + this.nickname + " (" + this.gender + ", " + this.age + ")";
    }

    protected String getLocation() {
        return "location: " + this.location;
    }

    String getInfo() {
        return this.getIdDesc() + " " + this.role + ": " + this.getBasicInfo() + "\n"
                + this.getLocation() + "\n...";
    }
}

class Developer extends User {
    private final Role role = Role.developer;
    private String languages = "";
    private String abilities = "";

    Developer (String name, Gender gender, int age) {
        super(name, gender, age);
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
                + super.getLocation() + "\n" + languages + abilities + "...";
    }
}

class Manager extends User {
    private final Role role = Role.manager;
    private String skills = "";

    Manager (String name, Gender gender, int age) {
        super(name, gender, age);
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    String getInfo() {
        String skills = "";

        if (this.skills.length() > 0)
            skills = "skills: " + this.skills + "\n";

        return super.getIdDesc() + " " + this.role + ": " + super.getBasicInfo() + "\n"
                + super.getLocation() + "\n" + skills + "...";
    }
}