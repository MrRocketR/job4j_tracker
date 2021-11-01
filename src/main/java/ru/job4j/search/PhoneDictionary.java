package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = (p)  -> p.getName().contains(key);
        Predicate<Person> bySurname = (p)  -> p.getSurname().contains(key);
        Predicate<Person> byPhone = (p)  -> p.getPhone().contains(key);
        Predicate<Person> byAddress = (p)  -> p.getAddress().contains(key);
        Predicate<Person> combine = (p) -> {
            return byName.or(bySurname).or(byPhone).or(byAddress).test(p);
        };
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    public ArrayList<Person> findOld(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person out: persons) {
            if (out.getName().contains(key) || out.getSurname().contains(key)
                    || out.getAddress().contains(key) || out.getPhone().contains(key)) {
                result.add(out);
            }
        }

        return result;
    }
}