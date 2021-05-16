package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P853_carFleet {
    class CarFleet {
        private final int speed;
        private final int position;
        private final double time;

        CarFleet(int speed, int position, int target) {
            this.speed = speed;
            this.position = position;
            this.time = (target - position) / (double)(speed);
        }

        public double getTime() {
            return time;
        }

        public int getPosition() {
            return position;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Integer> unions = new ArrayList<>();
        List<CarFleet> carFleets = IntStream.range(0, position.length)
                .mapToObj(i -> new CarFleet(speed[i], position[i], target))
                .sorted(Comparator.comparingInt(CarFleet::getPosition).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < carFleets.size(); i++) {
            boolean findUnion = false;

            for (int j = 0; j < unions.size(); j++) {
                int cindex = unions.get(j);
                double ptime = carFleets.get(i).getTime();
                double ctime = carFleets.get(cindex).getTime();

                if (ptime <= ctime) {
                    findUnion = true;
                    break;
                }
            }

            if (findUnion == false) {
                unions.add(i);
            }
        }

        return unions.size();
    }

    public static void main(String[] args) {
        P853_carFleet p853_carFleet = new P853_carFleet();
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        p853_carFleet.carFleet(target, position, speed);
    }
}
