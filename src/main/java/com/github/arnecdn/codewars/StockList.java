package com.github.arnecdn.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StockList {

    public static String stockSummary(final String[] art, final String[] cd) {
        if ((cd.length == 0) || (art.length == 0)) {
            return "";
        }

        final List<Record> records = Arrays.stream(art).map(Record::new).collect(Collectors.toList());

        return Arrays.asList(cd).stream().map(s -> {
            final int sum = records.stream().filter(c -> c.category.equals(s)).mapToInt(k -> k.qantity).sum();
            return String.format("(%s : %d)", s, sum);
        }).collect(Collectors.joining(" - "));

    }

    static class Record {
        public String category;
        public String key;
        public int qantity;

        public Record(String stock) {
            final String[] split = stock.split(" ");
            this.category = split[0].substring(0, 1);
            this.key = split[0];
            this.qantity = Integer.valueOf(split[1]);
        }
    }
}
