package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/22.
 */
public class Airbnb_DiplayPages {
    public void DisplyaPages(List<String> input, int num) {

        List<String> output = new ArrayList<String>();
        //List<String> input = new ArrayList<String>();

        Iterator<String> iter = input.iterator();
        HashSet<String> visited = new HashSet<>();
        int pageCount = 0;
        boolean needDedup = true;

        // do iteration
        while (iter.hasNext()) {
            String line = iter.next();
            String hostId = line.split(",")[0];
            // visited
            if (needDedup && !visited.contains(hostId)) {
                visited.add(hostId);
                output.add(line);
                System.out.println(line);

                iter.remove();
                pageCount++;
            } else {

            }

            if (pageCount == num) {
                visited.clear();
                System.out.println();
                output.add("");
                pageCount = 0;
                iter = input.iterator();
            }

            if (!iter.hasNext()) {
                visited.clear();
                iter = input.iterator();
            }
        }

        String[] retResult = new String[output.size()];
        for (int i = 0; i < output.size(); i++) {
            retResult[i] = output.get(i);
        }

        // return retResult;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "1,28,300.1,Melbourne",
                "4,5,209.1,Melbourne",
                "5,7,208.1,Melbourne",
                "1,8,207.1,Melbourne",
                "1,10,206.1,Melbourne",
                "2,16,205.1,Melbourne",
                "1,29,204.1,Melbourne",
                "6,20,203.1,Melbourne",
                "1,21,202.1,Melbourne",
                "8,18,201.1,Melbourne",
                "8,30,200.1,Melbourne",
                "7,11,199.1,Melbourne"
        };
        List<String> input = new ArrayList<>(Arrays.asList(strs));
        Airbnb_DiplayPages p = new Airbnb_DiplayPages();
        p.DisplyaPages(input, 5);
    }

}
