package com.tencent.lucasshi;

import java.util.*;

public class SnapshotArray {
    // dense
    List<int[]> denseVersion;
    int[] denseArray;

    // sparse
    List<Map<Integer, Integer>> sparseVersion;
    Map<Integer, Integer> sparse;
    int length;

    public SnapshotArray(int length) {
        this.length = length;
        if (length < 128) {
            denseArray = new int[length];
            denseVersion = new ArrayList<>();
        } else {
            sparse = new HashMap<>();
            sparseVersion = new ArrayList<>();
        }
    }

    public void set(int index, int val) {
        if (this.length < 128) {
            denseArray[index] = val;
        } else {
            sparse.put(index, val);
        }
    }

    public int snap() {
        if (this.length < 128) {
            denseVersion.add(Arrays.copyOf(this.denseArray, this.denseArray.length));
            return denseVersion.size() - 1;
        } else {
            sparseVersion.add(new HashMap<>(this.sparse));
            return sparseVersion.size() - 1;
        }
    }

    public int get(int index, int snap_id) {
        if (this.length < 128) {
            return denseVersion.get(snap_id)[index];
        } else {
            return sparseVersion.get(snap_id).getOrDefault(index, 0);
        }
    }
}
