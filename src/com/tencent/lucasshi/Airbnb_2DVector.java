package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/23.
 */
class Vector2D implements Iterator<Integer> {
    private List<ArrayList<Integer>> vec2d;
    private int i = 0;
    private int j = 0;
    // private Iterator<Integer> rowIter = null;
    // private Iterator<List<Integer>> colIter = null;

    public Vector2D(List<ArrayList<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.i = 0;
        this.j = 0;
    }

    @Override
    public boolean hasNext() {
        while (i < vec2d.size() && j >= vec2d.get(i).size()) {
            i++;
            j = 0;
        }
        return i < vec2d.size() && j < vec2d.get(i).size();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int val = vec2d.get(i).get(j);
            j++;
            return val;
        }

        return -1;
    }

    public void remove() {
        if (hasNext()) {
            vec2d.get(i).remove(j);
        }
    }

    /*
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.colIter = vec2d.iterator();
        this.rowIter = colIter.next().iterator();
    }


    public boolean hasNext() {
        while (!rowIter.hasNext() && colIter.hasNext()) {
            rowIter = colIter.next().iterator();
        }

        return rowIter.hasNext();
    }

    public Integer next() {
        if (hasNext()) {
            return rowIter.next();
        }

        return -1;
    }

    public void remove() {
        rowIter.remove();
        if (hasNext()) {
            return;
        }

        return;
    }
    */

}

public class Airbnb_2DVector {
    public static void main(String[] args) {
        List<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        lists.add(new ArrayList<Integer>(Arrays.asList(3)));
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));

        Vector2D vector2D = new Vector2D(lists);
        while (vector2D.hasNext()) {
            //vector2D.next();
            System.out.println(vector2D.next());
            vector2D.remove();
            System.out.flush();
        }
    }
}
