package com.github.arnecdn.codewars;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class RealPasswordCracker {
    static String chars = " abcdefghijklmnopqrstuvwxyz";

    public static String passwordCracker(String hash) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = byteOf(hash);

            for (int i = 0; i < chars.length(); i++) {
                for (int j = 0; j < chars.length(); j++) {
                    for (int k = 0; k < chars.length(); k++) {
                        for (int l = 0; l < chars.length(); l++) {
                            for (int m = 0; m < chars.length(); m++) {
                                String pwd =("" + chars.charAt(i) + chars.charAt(j) +  chars.charAt(k) + chars.charAt(l)+ chars.charAt(m)).trim();
                                if (Arrays.equals(md.digest(pwd.getBytes()), hashBytes)) {
                                    return pwd;
                                }
                            }
                        }
                    }
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
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

