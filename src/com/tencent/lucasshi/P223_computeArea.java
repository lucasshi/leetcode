package com.tencent.lucasshi;

public class P223_computeArea {
    class Rect {
        int left;
        int right;
        int top;
        int bottom;

        Rect(int l, int b, int r, int t) {
            this.left = l;
            this.right = r;
            this.top = t;
            this.bottom = b;
            System.out.println();
        }

        int getSize() {
            return (this.right - this.left) * (this.top - this.bottom);
        }
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Rect rect1 = new Rect(A, B, C, D);
        Rect rect2 = new Rect(E, F, G, H);

        if (isOverlap(rect1, rect2)) {
            Rect overlapRect = new Rect(Math.max(rect1.left, rect2.left), Math.max(rect1.bottom, rect2.bottom),
                    Math.min(rect1.right, rect2.right), Math.min(rect1.top, rect2.top));
            return rect1.getSize() + rect2.getSize() - overlapRect.getSize();
        }
        return rect1.getSize() + rect2.getSize();
    }

    public boolean isOverlap(Rect rect1, Rect rect2) {
        if (rect2.right < rect1.left || rect2.bottom > rect1.top || rect2.top < rect1.bottom || rect2.left > rect1.right)
            return false;
        return true;
    }

    public static void main(String[] args) {
        P223_computeArea p = new P223_computeArea();
        p.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
    }
}
