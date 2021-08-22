package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;
    public Error() {

    }
    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo(){
        System.out.println("Active  = " + active);
        System.out.println("Status = " + status);
        System.out.println("Message = " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.printInfo();
        Error error2 = new Error(false,404,"Not found");
        error2.printInfo();
        Error error3 = new Error(false,505,"HTTP Version not supported");
        Error error4 = new Error(true,1,"Not found");


    }
}
