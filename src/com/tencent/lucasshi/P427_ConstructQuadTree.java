package com.tencent.lucasshi;

public class P427_ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        return helper(grid, 0, width - 1, 0, height - 1);
    }

    public Node helper(int[][] grid, int left, int right, int top, int bottom) {
        if (left == right && top == bottom) {
            boolean val = grid[top][left] == 1;
            return new Node(val, true, null, null, null, null);
        }

        Node topLeft = helper(grid, left, (left + right) / 2, top, (top + bottom) / 2);
        Node topRight = helper(grid, (left + right) / 2 + 1, right, top, (top + bottom) / 2);
        Node bottomLeft = helper(grid, left, (left + right) / 2, (top + bottom) / 2 + 1, bottom);
        Node bottomRight = helper(grid, (left + right) / 2 + 1, right, (top + bottom) / 2 + 1, bottom);

        if (topLeft.isLeaf == true &&
                topRight.isLeaf == true &&
                bottomLeft.isLeaf == true &&
                bottomRight.isLeaf == true) {
            // do
            if (topLeft.val == bottomRight.val &&
                    topLeft.val == bottomLeft.val &&
                    topLeft.val == topRight.val) {
                return new Node(topLeft.val, true, null, null, null, null);
            }
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 0},{1, 1, 0, 0}, {0, 1, 0, 1}, {1, 1, 0, 0}};
        P427_ConstructQuadTree p = new P427_ConstructQuadTree();
        p.construct(grid);
    }
}
