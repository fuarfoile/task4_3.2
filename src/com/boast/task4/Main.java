/*
 * Main.java 04/08/2017
 *
 * Created by Bondarenko Oleh
 */


package com.boast.task4;

import java.util.HashMap;
import java.lang.Character;

public class Main {

    public static void main(String[] args) {
        DictionaryEngRus dictionary = new DictionaryEngRus();

        dictionary.addWord("vehicle", "средство передвижения");
        dictionary.addWord("car", "автомобиль");
        dictionary.addWord("red", "красный");
        dictionary.addWord("blue", "синий");
        dictionary.addWord("small", "маленький");
        dictionary.addWord("white", "белый");
        dictionary.addWord("airplane", "самолет");
        dictionary.addWord("end", "конец");
        dictionary.addWord("place", "место");
        dictionary.addWord("for", "для");
        dictionary.addWord("advertisement", "реклама");
        dictionary.addWord("after", "после");
        dictionary.addWord("translate", "перевод");

        String engPhrase = "Vehicle - small red car, white airplane; Batmobile! End?...\nSmall blue airplane. End.\n--Place for advertisement--";

        System.out.println("Before translate:");
        System.out.println(engPhrase);
        System.out.println(dictionary.translate("\nAfter translate:"));
        System.out.println(dictionary.translate(engPhrase));
    }
}

class DictionaryEngRus {
    private HashMap<String,String> dictionary = new HashMap<>();

    public void addWord(String engWord, String rusWord) {
        dictionary.put(engWord, rusWord);
    }

    public String translate(String engPhrase) {
        String[] words = engPhrase.split("\\b");
        StringBuilder rusPhrase = new StringBuilder();

        for (String word: words) {
            boolean upperCaseTrigger = false;

            if (Character.toLowerCase(word.charAt(0)) != word.charAt(0)) {
                word = word.toLowerCase();
                upperCaseTrigger = true;
            }

            String rusWord = dictionary.get(word);
            if (rusWord != null) {
                if (upperCaseTrigger) {
                    rusPhrase.append(Character.toUpperCase(rusWord.charAt(0)));
                    rusPhrase.append(rusWord.substring(1));
                } else {
                    rusPhrase.append(rusWord);
                }
            } else {
                if (upperCaseTrigger) {
                    rusPhrase.append(Character.toUpperCase(word.charAt(0)));
                    rusPhrase.append(word.substring(1));
                } else {
                    rusPhrase.append(word);
                }
            }
        }

        return rusPhrase.toString();
    }
}