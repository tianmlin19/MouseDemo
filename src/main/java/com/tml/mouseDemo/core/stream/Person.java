package com.tml.mouseDemo.core.stream;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public static void sleep(int hour){
        System.out.println("person sleep "+hour+" every day!");
    }

    public String study(String course){
        return name + " is study " + course;
    }

    public String play(){
        return "playing";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
