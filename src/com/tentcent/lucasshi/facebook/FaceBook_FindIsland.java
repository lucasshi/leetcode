package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/12.
 */
public class FaceBook_FindIsland {
  public int findIsland(int[][] lands) {
    boolean[][] visited = new boolean[lands.length][lands[0].length];
    int islandNumber = 0;

    for (int i = 0; i < lands.length; i++) {
      for (int j = 0; j < lands[0].length; j++) {
        if (lands[i][j] == 0 || visited[i][j]) {
          continue;
        }

        DFS(i, j, lands, visited);
        islandNumber++;
      }
    }
    return islandNumber;
  }

  public void DFS(int i, int j, int[][] lands, boolean[][] visted) {
    visted[i][j] = true;
    if (i - 1 > 0 && lands[i - 1][j] == 1 && !visted[i - 1][j]) {
      DFS(i - 1, j, lands, visted);
    }

    if (i + 1 < lands.length && lands[i + 1][j] == 1 && !visted[i + 1][j]) {
      DFS(i + 1, j, lands, visted);
    }

    if (j - 1 > 0 && lands[i][j - 1] == 1 && !visted[i][j - 1]) {
      DFS(i, j - 1, lands, visted);
    }

    if (j + 1 < lands[0].length && lands[i][j + 1] == 1 && !visted[i][j + 1]) {
      DFS(i, j + 1, lands, visted);
    }

    return;
  }
}