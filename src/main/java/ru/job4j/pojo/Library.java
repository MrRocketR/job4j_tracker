package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book moby = new Book("Moby Dick", 300);
        Book warP = new Book("War and Peace", 1200);
        Book hp = new Book("Harry Potter", 220);
        Book cc = new Book("Clean Code", 800);
        Book[] bookArray = new Book[4];
        bookArray[0] = moby;
        bookArray[1] = warP;
        bookArray[2] = hp;
        bookArray[3] = cc;
        for (int index = 0; index < bookArray.length; index++) {
            Book out = bookArray[index];
            System.out.println(out.getName() + " " + out.getPages());

        }
        System.out.println("_____________________");
        Book temp = bookArray[0];
        bookArray[0] = bookArray[3];
        bookArray[3] = temp;
        for (int index = 0; index < bookArray.length; index++) {
            Book out = bookArray[index];
            System.out.println(out.getName() + " " + out.getPages());

        }
        System.out.println("_____________________");
        for (int index = 0; index < bookArray.length; index++) {
            Book out = bookArray[index];
            if (out.getName().equals("Clean Code")) {
                System.out.println(out.getName() + " " + out.getPages());
                break;
            }
        }
    }
}