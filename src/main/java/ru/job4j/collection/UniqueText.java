package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String wordToHash: origin) {
            check.add(wordToHash);
        }
        for (String checkWords: text) {
            if (!check.contains(checkWords)) {
                rsl = false;
                break;
            }
        }

        return rsl;
    }
}
