package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person out : persons) {
            if (out.getName().contains(key) || out.getSurname().contains(key)
                    || out.getAddress().contains(key) || out.getPhone().contains(key)) {
                result.add(out);
            }
        }

        return result;
    }
}
