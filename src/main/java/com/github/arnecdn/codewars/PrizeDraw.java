package com.github.arnecdn.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PrizeDraw {

    public static String nthRank(String st, Integer[] we, int n) {
        if (st.isEmpty()) {
            return "No participants";
        }

        String[] names = st.split(",");

        if (n > names.length) {
            return "Not enough participants";
        }

        List<Player> players = new ArrayList<>(st.length());

        for (int i = 0; i < names.length; i++) {
            Player p = new Player(names[i], we[i]);
            p.calculateWinningNumber();
            players.add(p);
        }

        Comparator<Player> winningNumberComp = Comparator.comparingInt(s -> s.winningNumber);
        Comparator<Player> nameCmp = Comparator.comparing(s -> s.name);

        players.sort(winningNumberComp.reversed().thenComparing(nameCmp));

        return players.get(n - 1).name;
    }

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    static class Player {
        String name;
        int weight;
        int winningNumber;

        public Player(final String name, final int weight) {
            this.name = name;
            this.weight = weight;
        }

        void calculateWinningNumber() {
            int sum = 0;

            for (char c : name.toLowerCase().toCharArray()) {
                sum += alphabet.indexOf(c) + 1;
            }

            winningNumber = weight * (name.length() + sum);
        }
    }
}
