package ru.job4j.exercises.optional;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseThrow {

    public static class User {

        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public static class UserNotFoundException extends RuntimeException { }

    public static User orElseThrow(List<User> list, String login) {
        Optional<User> user = search(list, login);
        return  user.orElseThrow(UserNotFoundException::new);
    }

    private static Optional<User> search(List<User> list, String login) {
        Optional<User> user = Optional.empty();
        for (User u: list) {
        if (u.getLogin().equals(login)) {
                user = Optional.of(u);
                break;
            }

        }
        return user;
    }

    public static void main(String[] args) {
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        System.out.println(OptionalOrElseThrow.orElseThrow(List.of(u1, u2, u3), "u2"));

    }
}
