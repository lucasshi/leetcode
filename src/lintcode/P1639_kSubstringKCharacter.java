package lintcode;

import java.util.HashMap;
import java.util.HashSet;

public class P1639_kSubstringKCharacter {
    public int KSubstring(String stringIn, int K) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashSet<String> resultHash = new HashSet<>();
        for (int i = 0; i < K; i++) {
            if (!count.containsKey(stringIn.charAt(i)))
                count.put(stringIn.charAt(i), 0);
            count.put(stringIn.charAt(i), count.get(stringIn.charAt(i)) + 1);
        }

        int result = 0;
        if (count.size() == K)
            resultHash.add(stringIn.substring(0, K + 1));

        for (int sindex = 0; sindex + K < stringIn.length(); sindex++) {
            char oldChar = stringIn.charAt(sindex);
            count.put(oldChar, count.get(oldChar) - 1);
            if (count.get(oldChar) == 0)
                count.remove(oldChar);

            Character newChar = stringIn.charAt(sindex + K);
            if (!count.containsKey(newChar))
                count.put(newChar, 0);
            count.put(newChar, count.get(newChar) + 1);
            if (count.size() == K)
                resultHash.add(stringIn.substring(sindex + 1, sindex + K + 1));
        }
        System.out.println(resultHash);
        return resultHash.size();
    }

    public static void main(String[] args) {
        P1639_kSubstringKCharacter p = new P1639_kSubstringKCharacter();
        System.out.println(p.KSubstring("abacabc", 3));
    }
}
