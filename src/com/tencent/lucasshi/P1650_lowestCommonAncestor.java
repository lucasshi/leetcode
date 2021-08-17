package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.HashSet;

public class P1650_lowestCommonAncestor {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int val) {
            this.val = val;
        }
    };

    public Node lowestCommonAncestorV2(Node p, Node q) {
        int pSize = 0;
        Node originP = p;
        while (p != null) {
            p = p.parent;
            pSize += 1;
        }

        int qSize = 0;
        Node originQ = q;
        while (q != null) {
            q = q.parent;
            qSize += 1;
        }

        if (pSize < qSize) {
            return helper(originP, originQ, qSize - pSize);
        }
        return helper(originQ, originP, pSize - qSize);
    }

    public Node helper(Node low, Node deep, int diff) {
        while (diff != 0) {
            System.out.println(diff);
            deep = deep.parent;
            diff--;
        }

        while (low != deep) {
            low = low.parent;
            deep = deep.parent;
        }

        return low;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> sets = new HashSet<>();
        if (p == q)
            return p;

        while (p != null || q != null) {
            if (p != null && sets.contains(p))
                return p;
            if (q != null && sets.contains(q))
                return q;
            if (p == q)
                return q;

            if (p != null) {
                sets.add(p);
                p = p.parent;
            }

            if (q != null) {
                sets.add(q);
                q = q.parent;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(4);
        n1.parent = new Node(2);
        n1.parent.parent = new Node(5);
        n1.parent.parent.parent = new Node(3);
        // Node n2 = new Node(1);
        // n2.parent = n1.parent;

        P1650_lowestCommonAncestor p1650_lowestCommonAncestor = new P1650_lowestCommonAncestor();
        Node res = p1650_lowestCommonAncestor.lowestCommonAncestorV2(n1, n1.parent.parent);
        System.out.println(res);

    }
}
