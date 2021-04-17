package com.github.arnecdn.codewars;

import java.security.MessageDigest;
import java.util.Arrays;

public class Cracker {

    static String crackSha256(String hash, String chars) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = byteOf(hash);

            String combination = findCombination("", chars, hashBytes, md);
            return (combination.isEmpty()) ? null: combination;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String findCombination(String generated, String chars, byte[] hashBytes, MessageDigest md) {
        if (chars.length() == 0) {
            return generated;
        }

        for (int i = 0; i < chars.length(); i++) {
            String combination = findCombination(generated + chars.charAt(i), chars.substring(0, i) + chars.substring(i + 1), hashBytes, md);
            if (Arrays.equals(md.digest(combination.getBytes()), hashBytes)) {
                return combination;
            }
        }

        return generated;
    }

    private static byte[] byteOf(String hex) {
        byte[] val = new byte[hex.length() / 2];
        for (int i = 0; i < val.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(hex.substring(index, index + 2), 16);
            val[i] = (byte) j;
        }

        return val;
    }

}
