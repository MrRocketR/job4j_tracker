package ru.job4j.inheritance;

public class Patient {
    private boolean leftHand;
    private boolean rightHand;
    private boolean leftLeg;
    private boolean rightLeg;
    private boolean isDead;
    private int teeth;

    public Patient(boolean leftHand, boolean rightHand, boolean leftLeg,
                   boolean rightLeg, boolean isDead, int teeth) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
        this.isDead = isDead;
        this.teeth = teeth;
    }
}
