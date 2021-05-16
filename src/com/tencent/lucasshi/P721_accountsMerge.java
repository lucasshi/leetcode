package com.tencent.lucasshi;

import java.util.*;

public class P721_accountsMerge {
    public List<List<String>> merges(final List<List<String>> accountsList) {
        final Set<Integer> visited = new HashSet<>();
        final Set<String> cursor = new HashSet<>();
        final List<List<String>> result = new ArrayList<>();

        while (visited.size() < accountsList.size()) {
            for (int i = 0; i < accountsList.size(); i++) {
                if (visited.contains(i))
                    continue;
                if (cursor.size() == 0) {
                    cursor.addAll(accountsList.get(i));
                    visited.add(i);
                } else if (isOverlap(accountsList.get(i), cursor)) {
                    cursor.addAll(accountsList.get(i));
                    visited.add(i);
                }
            }

            result.add(new ArrayList<>(cursor));
            cursor.clear();
        }

        return result;
    }

    public boolean isOverlap(List<String> s1, Set<String> s2) {
        for (final String s: s1) {
            if (s2.contains(s))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<String>> accountsList = new ArrayList<List<String>>() {{
            add(Arrays.asList("johnsmith@mail.com", "john00@mail.com"));
            add(Arrays.asList("johnnybravo@mail.com"));
            add(Arrays.asList("johnsmith@mail.com", "john_newyork@mail.com"));
            add(Arrays.asList("mary@mail.com"));
        }};

        P721_accountsMerge p721_accountsMerge = new P721_accountsMerge();
        System.out.println(p721_accountsMerge.merges(accountsList));
    }
}
