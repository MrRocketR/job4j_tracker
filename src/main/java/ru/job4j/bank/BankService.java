package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User us = findByPassport(passport);
        if (us != null && !users.get(us).contains(account)) {
            users.get(us).add(account);
        }
    }

    /**
     * Поиск пользователя по паспорту:
     * @param passport номер паспорта в виде String
     * @return вовзращает пользователя User
     * @see User
     */
    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Поиск пользователя по реквизитам и паспорту
     * @param passport номер паспорта в виде String
     * @param requisite номер реквизитов в виде String
     * @return возвращает все счета данного пользователя
     * @see User
     * @see Account
     */
    public Account findByRequisite(String passport, String requisite) {
        User us = findByPassport(passport);
        if (us != null) {
            for (Account a: users.get(us)) {
                if (a.getRequisite().equals(requisite)) {
                    return a;
                }
            }
        }
        return null;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.getBalance() >= amount) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }

}
