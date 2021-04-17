package com.github.arnecdn.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//String water = "H2O";
//parseMolecule.getAtoms(water); // return [H: 2, O: 1]
//K4[ON(SO3)2]2
//Mg(OH)2
//H2O
public class ParseMolecule {

    static Pattern enclosingNestedTags = Pattern.compile("\\{(.*?)\\}|\\[(.*?)\\]|\\((.*?)\\)");

    public static Map<String, Integer> getAtoms(String formula) {
        System.out.println(formula);
        validateMoleculePattern(formula);
        validateBracketPairs(formula);

        return parseNestedFormula(formula);
    }

    private static Map<String, Integer> parseNestedFormula(final String formula) {
        Matcher matcher = enclosingNestedTags.matcher(formula);
        if (matcher.find()) {
            int start = matcher.start() + 1;
            int end = matcher.end();

            String head = formula.substring(0, start - 1);
            String body = formula.substring(start, end - 1);

            String multiplicator = formula.substring(end, end + 1);
            String tail = (multiplicator.matches("\\d")) ? formula.substring(end + 1) : formula.substring(end);

            Map<String, Integer> headMap = parseNestedFormula(head);
            Map<String, Integer> tailMap = parseNestedFormula(tail);
            Map<String, Integer> bodyMap = parseNestedFormula(body);

            Map<String, Integer> bodyMultiplied = (multiplicator.matches("\\d")) ? multilpyBodyElemets(bodyMap, multiplicator) : bodyMap;

            Map<String, Integer> mergedMaps = mergeTokenMaps(headMap, bodyMultiplied);
            Map<String, Integer> mappedFormula = mergeTokenMaps(tailMap, mergedMaps);

            return mappedFormula;
        }

        return mapFlatFormula(formula);
    }

    private static void validateMoleculePattern(final String formula) {

        String strippedOfBrackets = formula.replaceAll("\\(|\\)|\\[|\\]|\\{|\\}", "");
        for (String s : strippedOfBrackets.split("(?=[A-Z])")) {
            if (s.startsWith(s.toLowerCase())) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateBracketPairs(final String formula) {
        String onlyBrackets = formula.replaceAll("[A-Za-z0-9]", "");

        while (onlyBrackets.contains("()") || onlyBrackets.contains("[]") || onlyBrackets.contains("{}")) {
            onlyBrackets = onlyBrackets.replaceAll("\\(\\)", "")
                .replaceAll("\\[\\]", "")
                .replaceAll("\\{\\}", "");
        }
        if (!onlyBrackets.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static Map<String, Integer> mergeTokenMaps(final Map<String, Integer> source, final Map<String, Integer> target) {
        Map<String, Integer> copy = new HashMap<>();
        copy.putAll(target);

        for (String key : source.keySet()) {
            if (target.containsKey(key)) {
                copy.put(key, copy.get(key) + source.get(key));
            } else {
                copy.put(key, source.get(key));
            }
        }

        return copy;
    }

    private static Map<String, Integer> mapFlatFormula(final String formula) {
        Map<String, Integer> result = new HashMap<>();

        for (String s : formula.split("(?=[A-Z])")) {
            if (!s.isEmpty() && s.startsWith(s.toLowerCase())) {
                throw new IllegalArgumentException();
            }

            String num = "";
            String key = "";
            for (Character c : s.toCharArray()) {
                num += (Character.isDigit(c)) ? c : "";
                key += (Character.isAlphabetic(c)) ? c : "";
            }
            if (!key.isEmpty()) {
                if (result.containsKey(key)) {
                    result.put(key, result.get(key).intValue() + (num.isEmpty() ? 1 : Integer.parseInt(num)));
                } else {
                    result.put(key, (num.isEmpty() ? 1 : Integer.parseInt(num)));
                }
            }
        }
        return result;
    }

    private static Map<String, Integer> multilpyBodyElemets(final Map<String, Integer> source, String multiplicator) {

        Map<String, Integer> target = new HashMap<>();

        for (String s : source.keySet()) {
            target.put(s, source.get(s) * Integer.parseInt(multiplicator));
        }
        return target;
    }
}
