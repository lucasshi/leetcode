package com.tencent.lucasshi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P210_CourseScheduleII {
    public List<Integer> getLevel(int numCourses, HashMap<Integer, Integer> dependCount) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dependCount.containsKey(i) || dependCount.get(i) != 0)
                continue;
            result.add(i);
        }
        return result;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> dependencies = new HashMap<>();
        HashMap<Integer, Integer> dependCount = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            dependCount.put(i, 0);
            dependencies.put(i, new ArrayList<>());
        }
        // first
        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            //
            dependencies.get(second).add(first);
            dependCount.put(first, dependCount.get(first) + 1);
        }

        int taskCount = 0;
        ArrayList<List<Integer>> paths = new ArrayList<>();
        while (taskCount < numCourses) {
            List<Integer> targetTasks = getLevel(numCourses, dependCount);
            // do
            for (Integer targetTask : targetTasks) {
                List<Integer> depends = dependencies.get(targetTask);
                for (Integer depend : depends) {
                    dependCount.put(depend, dependCount.get(depend) - 1);
                }
                dependCount.remove(targetTask);
            }
            paths.add(targetTasks);
            taskCount += targetTasks.size();
        }



        System.out.println(paths);
        return null;
    }

    public static void main(String[] args) {
        P210_CourseScheduleII p = new P210_CourseScheduleII();
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        p.findOrder(4, prerequisites);
    }


}
