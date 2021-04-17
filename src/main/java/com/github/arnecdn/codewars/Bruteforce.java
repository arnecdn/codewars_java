package com.github.arnecdn.codewars;

public class Bruteforce {
    private char[] charset;

    private int min;
    private int max;

    public Bruteforce() {
        charset = "ab".toCharArray();
        min = 1;
        max = 3;
    }

    public void generate(String str, int pos, int length) {
        if (length == 0) {
            System.out.println(str);
        } else {

            if (pos != 0) {
                pos = 0;
            }

            for (int i = pos; i < charset.length; i++) {
                generate(str + charset[i], i, length - 1);
            }
        }
    }

    public static void main(String[] args) {
        Bruteforce bruteforce = new Bruteforce();

        for (int length = bruteforce.min; length < bruteforce.max; length++)
            bruteforce.generate("", 0, length);
    }
}
