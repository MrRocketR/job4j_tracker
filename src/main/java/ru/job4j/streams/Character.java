package ru.job4j.streams;

public class Character {
    private String name;
    private int strength;
    private int intelligence;
    private int charisma;
    private String alignment;

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", charisma=" + charisma +
                ", alignment='" + alignment + '\'' +
                '}';
    }

    static class Creator {

        private String name;
        private int strength;
        private int intelligence;
        private int charisma;
        private String alignment;

        Creator setName(String name) {
            this.name = name;
            return this;
        }

        Creator addStrength(int s) {
            this.strength = s;
            return this;
        }

        Creator addIntelligence(int i) {
            this.intelligence = i;
            return this;
        }

        Creator addCharisma(int c) {
            this.charisma = c;
            return this;
        }

        Creator setAlignment(String alignment) {
            this.alignment = alignment;
            return this;
        }

        Character build() {
            Character character = new Character();
            character.name = name;
            character.strength = strength;
            character.intelligence = intelligence;
            character.charisma = charisma;
            character.alignment = alignment;
            return character;

        }

        public static void main(String[] args) {
            Character barbarian = new Creator().setName("CrazyKiller2000")
                    .addStrength(30)
                    .addIntelligence(5)
                    .addCharisma(27)
                    .setAlignment("Chaotic good")
                    .build();
            System.out.println(barbarian);
        }

    }
}
