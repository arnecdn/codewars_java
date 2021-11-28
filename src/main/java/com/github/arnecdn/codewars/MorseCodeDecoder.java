package com.github.arnecdn.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {
    static Map<String, String> MorseCode = new HashMap<>();

    static {
        MorseCode.put(".-", "A");
        MorseCode.put("-...", "B");
        MorseCode.put("-.-.", "C");
        MorseCode.put("-..", "D");
        MorseCode.put(".", "E");
        MorseCode.put("..-.", "F");
        MorseCode.put("--.", "G");
        MorseCode.put("....", "H");
        MorseCode.put("..", "I");
        MorseCode.put(".---", "J");
        MorseCode.put("-.-", "K");
        MorseCode.put(".-..", "L");
        MorseCode.put("--", "M");
        MorseCode.put("-.", "N");
        MorseCode.put("---", "O");
        MorseCode.put(".--.", "P");
        MorseCode.put("--.-", "Q");
        MorseCode.put(".-.", "R");
        MorseCode.put("...", "S");
        MorseCode.put("-", "T");
        MorseCode.put("..-", "U");
        MorseCode.put("...-", "V");
        MorseCode.put(".--", "W");
        MorseCode.put("-..-", "X");
        MorseCode.put("-.--", "Y");
        MorseCode.put("--..", "Z");
        MorseCode.put(".----", "1");
        MorseCode.put("..---", "2");
        MorseCode.put("...--", "3");
        MorseCode.put("....-", "4");
        MorseCode.put(".....", "5");
        MorseCode.put("-....", "6");
        MorseCode.put("--...", "7");
        MorseCode.put("---..", "8");
        MorseCode.put("----.", "9");
        MorseCode.put("-----", "0");
        MorseCode.put("|", " ");
    }

    final static String WORD_SPLIT = "   ";
    final static String CHAR_SPLIT = " ";

    public static String decode(String morseCode) {
        return decodeMorse(morseCode.trim().split(WORD_SPLIT), "").trim();
    }

    public static String decodeMorse(String[] morse, String message) {
        if (morse.length == 0) {
            return message;
        }

        String morseWord = morse[0];
        message = message + " " + decodeWord(morseWord.split(CHAR_SPLIT), "");

        return decodeMorse(Arrays.copyOfRange(morse, 1, morse.length), message);
    }

    private static String decodeWord(final String[] morseWord, String word) {
        if (morseWord.length == 0) {
            return word;
        }

        String morseChar = morseWord[0];
        word = word + MorseCode.get(morseChar.trim());
        return decodeWord(Arrays.copyOfRange(morseWord, 1, morseWord.length), word);
    }
}
