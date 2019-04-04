package com.tencent.lucasshi;

import java.util.*;

public class P332_FindItinerary {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, List<String>> allTickets = new HashMap<>();
        // do
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String dest = ticket[1];
            if (!allTickets.containsKey(from)) {
                allTickets.put(from, new ArrayList<>());
            }
            allTickets.get(from).add(dest);
        }

        for (String key : allTickets.keySet()) {
            allTickets.get(key).sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        // do
        List<String> paths = new ArrayList<>();
        paths.add("JFK");
        HashSet<String> usedRoutes = new HashSet<>();
        helper(allTickets, paths, "JFK", usedRoutes, tickets.length);
        return paths;
    }

    public boolean helper(HashMap<String, List<String>> allTickets,
            List<String> path, String from, HashSet<String> usedRoutes, int size) {
        List<String> dests = allTickets.get(from);
        if (usedRoutes.size() == size)
            return true;
        for (int i = 0; i < dests.size(); i++) {
            String routes = from + "#" + dests.get(i);
            if (usedRoutes.contains(routes)) {
                continue;
            }
            // do
            path.add(dests.get(i));
            usedRoutes.add(routes);
            if (helper(allTickets, path, dests.get(i), usedRoutes, size)) {
                System.out.println(path);
                return true;
            }
            // dfs all
            path.remove(path.get(path.size() - 1));
            usedRoutes.remove(routes);
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] iterney = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        P332_FindItinerary p = new P332_FindItinerary();
        List<String> path = p.findItinerary(iterney);
        System.out.println(path);
    }
}
