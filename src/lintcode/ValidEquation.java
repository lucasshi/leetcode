package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ValidEquation {
    public void validStatements(char[][] equal, char[][] unequal) {
        HashMap<Character, HashSet<Character>> equals = new HashMap<>();
        for (int i = 0; i < equal.length;i++){
            char key = equal[i][0];
            char value = equal[i][1];
            if (!equals.containsKey(key)) {
                equals.put(key, new HashSet<>());
            }
            if (!equals.containsKey(value)) {
                equals.put(value, new HashSet<>());
            }

            equals.get(key).add(value);
            equals.get(value).add(value);
            for (Character ckey : equals.get(key)) {
                equals.get(ckey).add(value);
            }
            for (Character cvalue : equals.get(value)) {
                equals.get(cvalue).add(key);
            }
        }

    }
}
