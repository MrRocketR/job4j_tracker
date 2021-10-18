package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameUp() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmpName = new JobDescByName();
        int expected = 3;
        int rsl = cmpName.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCompatorByPriorityUp() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int expected = 1;
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, is(expected));

    }
    @Test
    public void whenCompatorByPriorityDesc() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int expected = -1;
        int rsl = cmpPriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, is(expected));

    }

    @Test
    public void whenCompatorByNameAndProrityUp() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int expected = 3;
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, is(expected));
    }
}

