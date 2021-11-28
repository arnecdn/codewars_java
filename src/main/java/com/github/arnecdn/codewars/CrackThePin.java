package com.github.arnecdn.codewars;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CrackThePin {
    public CrackThePin() {
    }

    static String digits = "0123456789";

    public String crack(String hash) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytesOfHash = byteOf(hash);
            for (int i = 1; i <= 5; i++) {
                String pin = tryPin("", digits, i, md, bytesOfHash);

                if(!pin.isEmpty()) {
                    return pin;
                }
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private String tryPin(final String generated, String digits, final int length, MessageDigest md, final byte[] bytesOfHash) {
        if(length == 0){
            return generated;
        }

        for(int i = 0; i < digits.length(); i++){
            String pin = tryPin(generated  + digits.charAt(i) , digits.substring(0, i) + digits.substring(i),  length-1, md, bytesOfHash);

            byte[] bytesOfPin = md.digest(pin.getBytes());

            if (Arrays.equals(bytesOfHash,bytesOfPin)) {
                return pin;
            }
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

    public String crack2(String hash) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            for (int i = 0; i <= 99999; i++) {
                String possiblePin = String.format("%05d", i);
                md.update(possiblePin.getBytes());
                byte[] digest = md.digest();
                String hex = hexOf(digest);

                if (hex.equals(hash)) {
                    return possiblePin;
                }
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }


    private static String hexOf(final byte[] digest) {
        StringBuilder sb = new StringBuilder(digest.length);
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
