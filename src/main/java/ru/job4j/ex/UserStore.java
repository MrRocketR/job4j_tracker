package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User returnUser = null;
            for (User user : users) {
                if (login.equals(user.getUsername())) {
                    returnUser = user;
                } else {
                    throw new UserNotFoundException("User not found!");
            }
        }
            return returnUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        String l = new String(user.getUsername());
        if (!user.isValid())  {
            throw new UserInvalidException("User is Invalid");
        }
        if (l.length() < 3) {
            throw new UserInvalidException("User is Invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            boolean val = validate(users[0]);
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

    }
}
