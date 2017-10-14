package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_MultipyPrime {
  public List<Integer> multiPrime(int[] primes, int end) {
    ArrayList<Integer> result = new ArrayList<>();
    if (end == 0) {
      result.add(primes[end]);
      return result;
    }

    List<Integer> subResult = multiPrime(primes, end - 1);
    int subSize = subResult.size();
    for (int i = 0; i < subSize; i++) {
      subResult.add(subResult.get(i) * primes[end]);
    }

    subResult.add(primes[end]);
    return subResult;
  }

  public static void main(String[] args) {
    int[] prims = {2, 3, 5};
    FaceBook_MultipyPrime p = new FaceBook_MultipyPrime();
    List<Integer> result = p.multiPrime(prims, prims.length - 1);
    System.out.println(result);
  }
}
