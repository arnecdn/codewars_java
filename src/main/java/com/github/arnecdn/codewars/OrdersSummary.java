package com.github.arnecdn.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrdersSummary {
    public static String balanceStatements(final String orderList) {
        double salgSum = 0, kjoepSum = 0;
        Pattern fieldValidator = Pattern.compile("\\w+\\.?\\w*\\s\\d+\\s\\d*\\.\\d+\\s\\w");

        final String[] orders = orderList.split(",");
        List<String> feilmelding = new ArrayList();

        for (int i = 0; i < orders.length; i++) {
            String order = orders[i].trim();
            if (order.isEmpty()) {
                break;
            }

            final Matcher matcher = fieldValidator.matcher(order);

            if (!matcher.matches()) {
                feilmelding.add(order);
                continue;
            }

            try {
                String[] fields = order.trim().split(" ");
                int quantity = Integer.valueOf(fields[1]);
                Double price = Double.valueOf(fields[2]);
                String status = fields[3];

                switch (status) {
                case "B":
                    kjoepSum += quantity * price;
                    break;
                case "S":
                    salgSum += quantity * price;
                }
            } catch (Exception e) {
                feilmelding.add(order);
            }
        }

        String msg = feilmelding.size() > 0 ? String.format("; Badly formed %d: %s ;", feilmelding.size(), String.join(" ;", feilmelding)) : "";
        return String.format("Buy: %d Sell: %d%s", Math.round(kjoepSum), Math.round(salgSum), msg);
    }
}
