package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {

        for (int i = 0; i < users.length; i++) {
            User user = users[i];
           if (!login.equals(user.getUsername())) {
               throw new UserNotFoundException("Invalid login");
           }

        }
        return null;
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
