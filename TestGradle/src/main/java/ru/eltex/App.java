package ru.eltex;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

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
public class App {
    public static void main(String[] args) throws IOException {
        User person1 = new User("Ivan", Gender.man, 33);
        person1.setLocation("Temple of Wisdom");
        person1.setNickname("The Fool");
        passThroughJson(person1);

        User person2 = new User("Mario Brother", Gender.man, 47);
        person2.setLocation("Sewer pipes");
        person2.setNickname("The Plumber");
        passThroughJson(person2);

        Developer person3 = new Developer("Jack Peterson", Gender.man, 35);
        person3.setLocation("Somewhere near the monitor");
        person3.setNickname("Hi Jack!");
        person3.setLanguages("C/C++");
        passThroughJson(person3);

        Developer person4 = new Developer("Senior Developer", Gender.man, 27);
        person4.setLocation("Area 51");
        person4.setLanguages("C/C++, Java, Assembler");
        person4.setAbilities("Refrigerators repairing");
        passThroughJson(person4);

        Manager person5 = new Manager("Scarlett", Gender.woman, 50);
        person5.setLocation("Accounting office");
        person5.setSkills("Looking after children");
        passThroughJson(person5);

        Manager person6 = new Manager("Vika", Gender.woman, 21);
        passThroughJson(person6);
    }

    //Function which write to json and read it back
    //throws IOException - we need it for json serialization
    public static void passThroughJson(User person) throws IOException {
        File tmpFile = new File("tmp.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.writeValue(tmpFile, person);

        User printPerson = mapper.readValue(tmpFile, User.class);
        System.out.println(printPerson.getInfo());

        tmpFile.delete();
        //Runtime.getRuntime().exec("rm -f tmp.json");  //We can also use the Linux's way, but another time
    }

    public static void passThroughJson(Developer person) throws IOException {
        File tmpFile = new File("tmp.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.writeValue(tmpFile, person);

        Developer printPerson = mapper.readValue(tmpFile, Developer.class);
        System.out.println(printPerson.getInfo());

        tmpFile.delete();
    }

    public static void passThroughJson(Manager person) throws IOException {
        File tmpFile = new File("tmp.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.writeValue(tmpFile, person);

        Manager printPerson = mapper.readValue(tmpFile, Manager.class);
        System.out.println(printPerson.getInfo());

        tmpFile.delete();
    }
}

