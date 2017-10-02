package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/23.
 */
public class Airbnb_FlightTicket {
    class Flight {
        private String start;
        private String end;

        public Flight(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public int hashcode() {
            return start.hashCode() * 17 + end.hashCode();
        }
    }

    public int minCostFlight(ArrayList<String> flights,
                             String start, String end, int k) {

        HashMap<String, HashSet<String>> graph = new HashMap<>();
        HashMap<Flight, Integer> costInfo = new HashMap<>();

        for (String flight : flights) {
            int cost = Integer.parseInt(flight.split(",")[1]);
            String flightStr = flight.split(",")[0];
            String fstart = flightStr.split("->")[0];
            String fend = flightStr.split("->")[1];

            if (!graph.containsKey(fstart)) {
                graph.put(fstart, new HashSet<>());
            }
            graph.get(fstart).add(fend);

            costInfo.put(new Flight(fstart, fend), cost);
        }

        // do BFS
        ArrayList<String> currFlights = new ArrayList<>();
        currFlights.add(start);
        HashMap<String, Integer> destCost = new HashMap<>();
        destCost.put(start, 0);
        int travelTimes = 0;

        // do
        while (travelTimes < k) {
            for (String curr : currFlights) {
                for (String dest : graph.get(curr)) {
                    // do
                    int pathCost = costInfo.get(new Flight(curr, dest));
                    if (!destCost.containsKey(dest)) {
                        destCost.put(dest, destCost.get(curr) + pathCost);
                        continue;
                    }

                    int MinCost = Math.min(
                            destCost.get(curr) + pathCost, destCost.get(dest));
                    destCost.put(dest, MinCost);
                }
            }

            travelTimes++;
        }

        if (!destCost.containsKey(end))
            return -1;
        return destCost.get(end);
    }

    public static void main(String[] args) {
        return;
    }
}
