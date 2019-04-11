package com.tencent.lucasshi;

import java.util.*;

public class P399_EvaluateDivision {
    class Equation {
        public String to;
        public double value;

        // do
        public Equation(String _to, double _value) {
            this.to = _to;
            this.value = _value;
        }
    }

    public double dfs(String from, String dest, HashMap<String, List<Equation>> equationMap, HashSet<String> visited) {
        if (!equationMap.containsKey(from))
            return -1;
        if (from.equals(dest))
            return 1;
        // do
        List<Equation> equations = equationMap.get(from);
        for (Equation eq : equations) {
            if (visited.contains(eq.to))
                continue;
            // do
            visited.add(eq.to);
            double val = dfs(eq.to, dest, equationMap, visited);
            if (val != -1) {
                double result = val * eq.value;
                equationMap.get(from).add(new Equation(dest, result));
                return result;
            }
            visited.remove(eq.to);
        }
        return -1;
    }


    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<Equation>> equationMap = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String first = equations[i][0];
            String second = equations[i][1];

            if (!equationMap.containsKey(first))
                equationMap.put(first, new ArrayList<>());
            if (!equationMap.containsKey(second))
                equationMap.put(second, new ArrayList<>());
            equationMap.get(first).add(new Equation(second, values[i]));
            equationMap.get(second).add(new Equation(first, 1 / values[i]));
        }

        // dfs
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String from = queries[i][0];
            String to = queries[i][1];
            HashSet<String> visited = new HashSet<>();
            result[i] = dfs(from, to, equationMap, visited);
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        P399_EvaluateDivision p = new P399_EvaluateDivision();
        double[] results = p.calcEquation(equations, values, queries);
        for (int i = 0; i < results.length; i++)
            System.out.println(results[i]);
    }
}
