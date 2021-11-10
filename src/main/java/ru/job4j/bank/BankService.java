package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает простые банковские операции
 * Состоит из 5 разных методов
 * @author Nikita Kuptsov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового пользователя
     * @see User
     * @param user имя нового пользователя
     * Перед добавлением нового пользователя происходит проверка на его наличии в коллекции
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление нового счета:
     * @param account имя нового счета
     * по паспорту:
     * @param passport номер паспорта в виде String
     * Вызывается метод проверка наличия данного пользователя по паспорту
     * В случае успешной проверки новый счет добавляется к user
     * @see User
     * @see Account
     */

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> currentAccount = users.get(user.get());
            if (!currentAccount.contains(account)) {
                currentAccount.add(account);
            } else {
                System.out.println("This account already exists!");
            }
        }
    }

    /**
     * Поиск пользователя по паспорту:
     * @param passport номер паспорта в виде String
     * @return вовзращает пользователя User
     * @see User
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск пользователя по реквизитам и паспорту
     * @param passport номер паспорта в виде String
     * @param requisite номер реквизитов в виде String
     * @return возвращает все счета данного пользователя
     * @see User
     * @see Account
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод переводит средства с одного счета на другой
     * В качестве параметров небходим паспорт и реквизита исходного пользователя
     * @param srcPassport номер паспорта отправителя в виде String
     * @param srcRequisite номер реквизитов отправителя в виде String
     * И конечного пользователя
     * @param destPassport номер паспорта получателя в виде String
     * @param destRequisite номер реквизитов получателя в виде String
     * А также сумму
     * @param amount
     * В ходе работы метода происходит поиск счетов по реквизитам и паспорту
     * И проверка баланса
     * @return изменения состояния обоих счетов и возвращение true
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            if (srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }

}
