package ru.job4j.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void test() {
        List<Profile> resProfiles = Arrays.asList(
                new Profile(new Address("Moscow", "Testovya", 1, 2)),
                new Profile(new Address("Kaluga", "Kaluga Testovaja", 2, 3)),
                new Profile(new Address("Moscow", "Tverskaya", 15, 5))
        );
        List<Address> expected = Arrays.asList(
                new Address("Kaluga", "Kaluga Testovaja", 2, 3),
                new Address("Moscow", "Testovya", 1, 2),
                new Address("Moscow", "Tverskaya", 15, 5)
        );
        assertThat(Profiles.collect(resProfiles), is(expected));
    }

    @Test
    public void whenIdenticalAdress() {
        List<Profile> resProfiles = Arrays.asList(
                new Profile(new Address("Moscow", "Testovya", 1, 2)),
                new Profile(new Address("Kaluga", "Kaluga Testovaja", 2, 3)),
                new Profile(new Address("Kaluga", "Kaluga Testovaja", 2, 3))
        );
        List<Address> expected = Arrays.asList(
                new Address("Kaluga", "Kaluga Testovaja", 2, 3),
                new Address("Moscow", "Testovya", 1, 2)
        );

        assertThat(Profiles.collect(resProfiles), is(expected));
    }

}