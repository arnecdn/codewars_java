package com.github.arnecdn.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesmanTravel {

    public static String travel(String r, String zipcode) {
        Pattern addressPattern = Pattern.compile("(?<streetnumber>\\d{1,5})\\s(?<streetname>.*)(?<zip>" + zipcode + ")");
        String[] adresses = r.split(",");
        Map<String, String> adressCatalog = new HashMap<>();

        for (String adress : adresses) {
            Matcher matcher = addressPattern.matcher(adress);
            if (matcher.find()) {

                if (adressCatalog.containsKey(matcher.group("zip"))) {
                    String streetAdresses = adressCatalog.get(matcher.group("zip"));
                    String[] streetAdressesSplit = streetAdresses.split("/");
                    String newStreetName = streetAdressesSplit[0] + "," + matcher.group("streetname").trim();
                    String newStreetNumber = streetAdressesSplit[1] + "," + matcher.group("streetnumber").trim();
                    adressCatalog.put(matcher.group("zip"), newStreetName + "/" + newStreetNumber);
                } else {
                    adressCatalog.put(matcher.group("zip"), matcher.group("streetname").trim() + "/" + matcher.group("streetnumber").trim());
                }

            }
        }
        return (adressCatalog.containsKey(zipcode)) ? zipcode + ":" + adressCatalog.get(zipcode) : zipcode + ":/";
    }
}