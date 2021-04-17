package com.github.arnecdn.codewars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParseMoleculeTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {
            Arrays.asList("H", "O"),
            Arrays.asList(2, 1),
            "H2O",
            "water" },
            { Arrays.asList("Mg"),
                Arrays.asList(3),
                "Mg(Mg)2",
                "magnesium hydroxide" },
            { Arrays.asList("Mg", "H", "O"),
                Arrays.asList(1, 2, 2),
                "Mg(OH)2",
                "magnesium hydroxide" },

            { Arrays.asList("K", "O", "N", "S"),
                Arrays.asList(4, 14, 2, 4),
                "K4[ON(SO3)2]2",
                "Fremy's salt" },

            { Arrays.asList("C", "H", "O"),
                Arrays.asList(6, 12, 6),
                "C6H12O6",
                "Fremy's salt" },

            { Arrays.asList("As", "B", "Cu", "Be", "C", "Co", "O"),
                Arrays.asList(2, 8, 5,16, 44, 24, 48),
                "As2{Be4C5[BCo3(CO2)3]2}4Cu5",
                "Fremy's salt" },

            { Arrays.asList("C", "H", "O"),
                Arrays.asList(4, 4, 4),
                "C2H2(COOH)2",
                "Fremy's salt" },



            { Arrays.asList("C", "H", "Fe", "O"),
                Arrays.asList(8, 8, 1, 2),
                "(C5H5)Fe(CO)2CH3",
                " cyclopentadienyliron dicarbonyl dimer" },

        });
    }

    private Map<String, Integer> expected;
    private String formula, name;

    public ParseMoleculeTest(List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String, Integer> exp = new HashMap<String, Integer>();
        for (int i = 0; i < atoms.size(); i++)
            exp.put(atoms.get(i), nums.get(i));

        this.expected = exp;
        this.formula = formula;
        this.name = name;
    }

    @Test
    public void testMolecule() {
        System.out.println(expected);
        assertEquals(String.format("Should parse %s: %s", name, formula), expected, ParseMolecule.getAtoms(formula));
    }

}