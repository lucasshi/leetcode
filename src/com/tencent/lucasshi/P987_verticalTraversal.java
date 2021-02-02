package com.tencent.lucasshi;

import java.util.*;

public class P987_verticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        HashMap<Integer, List<Pair>> hm = new HashMap<>();
        LinkedList<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0, root));
        int min = 0;
        int max = 0;

        while(!que.isEmpty()){
            Pair cur = que.poll();
            min = Math.min(min, cur.x);
            max = Math.max(max, cur.x);
            hm.putIfAbsent(cur.x, new ArrayList<>());
            hm.get(cur.x).add(cur);

            if(cur.node.left != null){
                que.add(new Pair(cur.x-1, cur.y-1, cur.node.left));
            }

            if(cur.node.right != null){
                que.add(new Pair(cur.x+1, cur.y-1, cur.node.right));
            }
        }

        for(int i = min; i<=max; i++){
            List<Pair> list = hm.get(i);
            Collections.sort(list, (a, b) -> a.y == b.y ? a.node.val-b.node.val : b.y-a.y);

            List<Integer> item = new ArrayList<>();
            for(Pair p : list){
                item.add(p.node.val);
            }

            res.add(item);
        }

        return res;
    }

    class Pair{
        int x;
        int y;
        TreeNode node;
        public Pair(int x, int y, TreeNode node){
            this.x = x;
            this.y = y;
            this.node = node;
        }

        public String toString(){
            return "" + this.x + "^" + this.y + "^" + this.node.val;
        }
    }

}

