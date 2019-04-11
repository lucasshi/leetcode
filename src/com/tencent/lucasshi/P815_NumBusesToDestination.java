package com.tencent.lucasshi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class P815_NumBusesToDestination {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, List<Integer>> stationToLines = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int station = routes[i][j];
                if (!stationToLines.containsKey(station)) {
                    stationToLines.put(station, new ArrayList<>());
                }
                stationToLines.get(station).add(i);
            }
        }

        // bfs
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(S);

        HashSet<Integer> levelStation = new HashSet<>();
        levelStation.add(S);
        while (visited.contains(T)) {
            HashSet<Integer> nextLevel = new HashSet<>();
            for (Integer station : levelStation) {
                // get the route
                List<Integer> lineIds = stationToLines.get(station);
                for (Integer lineId : lineIds) {
                    // get next station
                    for (int i = 0; i < routes[lineId].length; i++) {
                        if (!visited.contains(routes[lineId][i]))
                            nextLevel.add(routes[lineId][i]);
                    }
                }
            }
            levelStation = nextLevel;
            visited.addAll(nextLevel);
            count += 1;
        }
        return count;
    }
}
