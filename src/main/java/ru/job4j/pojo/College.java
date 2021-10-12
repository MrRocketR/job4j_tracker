package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Ivanov");
        ivan.setGroup(182);
        System.out.println(ivan.getFirstName() + " " + ivan.getLastName()
                + " from " + ivan.getGroup());
    }
}
