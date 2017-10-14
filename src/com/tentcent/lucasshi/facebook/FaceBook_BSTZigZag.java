package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_BSTZigZag {
  private void zigZag(TreeNode root) {
    List<TreeNode> levelLists = new ArrayList<>();
    int levelId = 0;

    while (!levelLists.isEmpty()) {
      List<TreeNode> nextLevelLists = new ArrayList<>();
      for (TreeNode node : levelLists) {
        if (node.left != null) {
          nextLevelLists.add(node.left);
        } else {
          nextLevelLists.add(node.right);
        }
      }
      // print
      if (levelId % 2 == 0) {
        for (int i = 0; i < levelLists.size(); i++)
          System.out.print(levelLists.get(i).val + " ");
      } else {
        for (int i = levelLists.size() - 1; i >= 0; i--)
          System.out.print(levelLists.get(i).val + " ");
      }

      levelLists = nextLevelLists;
      levelId++;
    }
  }

  public static void main(String[] args) {

  }
}
