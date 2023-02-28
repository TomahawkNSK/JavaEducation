package ru.eltex;

class User {
    private int id;
    private String name;
    private String nickname;
    private Gender gender;
    private int age;
    private String location;
    private final Role role = Role.user;

    public User() {
        this.id = ENV.ID;
        this.name = "Unknown";
        this.gender = Gender.unknown;
        this.age = -1;
        this.nickname = "";
        this.location = "Unknown";
    }

    public User(String name, Gender gender, int age) {
        this.id = ENV.ID++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.nickname = "";
        this.location = "Unknown";
    }

    //we need all getters/setters for json serialization, so...
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    protected String getIdDesc() {
        return "[id " + this.id + "]";
    }

    protected String getBasicInfo() {
        if (nickname.length() > 0)
            return this.name + " '" + this.nickname + "' (" + this.gender + ", " + this.age + ")";
        else
            return this.name + " (" + this.gender + ", " + this.age + ")";
    }

    protected String getLocationStr() {
        return "location: " + this.location;
    }

    String getInfo() {
        return this.getIdDesc() + " " + this.role + ": " + this.getBasicInfo() + "\n"
                + this.getLocationStr() + "\n";
    }
}
