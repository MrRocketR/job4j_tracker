package ru.job4j.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = new ArrayList<>();
        return profiles.stream().map(p -> p.getAddress()).collect(Collectors.toList());
    }

}
