package ru.job4j.exesJob.lamd.lamdEx;

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
        OptionalOrElseThrow.User user = null;
        for (OptionalOrElseThrow.User u:list) {
                if (u.getLogin().equals(login)) {
                    user = u;
                    break;
                }
        }
       search(list, login);
       return user;
    }

    private static Optional<User> search(List<User> list, String login) {
        Optional<User> user = Optional.empty();

        //
        return user;
    }

}
