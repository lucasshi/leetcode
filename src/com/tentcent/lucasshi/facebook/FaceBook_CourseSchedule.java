package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> depends = new HashMap<>();
    int[] dependsCount = new int[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      for (int j = 0; j < prerequisites[0].length; j++) {
        if (prerequisites[i][j] == 1) {
          if (!depends.containsKey(j)) {
            depends.put(j, new ArrayList<>());
          }
          depends.get(j).add(i);
          dependsCount[i] += 1;
        }
      }
    }

    // findZero
    LinkedList<Integer> avails = new LinkedList<>();
    for (int i = 0; i < dependsCount.length; i++) {
      if (dependsCount[i] == 0) {
        avails.add(i);
      }
    }

    while (!avails.isEmpty()) {
      int courseId = avails.poll();
      for (Integer dependCourse : depends.get(courseId)) {
        dependsCount[dependCourse]--;
        if (dependsCount[dependCourse] == 0) {
          avails.add(dependCourse);
        }
      }
      depends.remove(courseId);
    }

    // 现在队列都已经空了
    for (int i = 0; i < dependsCount.length; i++) {
      if (dependsCount[i] != 0)
        return false;
    }

    return true;
  }
}
