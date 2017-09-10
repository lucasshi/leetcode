package com.tencent.lucasshi;

import java.util.*;
import java.util.Queue;


/**
 * Created by fzy on 17/9/4.
 */
public class Amazon_MovieNetwork_done {
    static class Movie {
        private int id;
        private double rate;
        public List<Movie> similarMovies;

        public Movie(int id, double rate) {
            this.id = id;
            this.rate = rate;
            this.similarMovies = new ArrayList<>();
        }

        public double getRate() {
            return rate;
        }

        public int getId() {
            return id;
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }


    public Set<Movie> getMovieRecommendations(Movie movie, int N) {
        PriorityQueue<Movie> priorityQueue = new PriorityQueue<>(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if (o1.getRate() == o2.getRate())
                    return 0;
                if (o1.getRate() > o2.getRate())
                    return 1;
                return -1;
            }
        });

        Queue<Movie> queue = new LinkedList<>();
        HashSet<Movie> visited = new HashSet<>();
        queue.add(movie);
        visited.add(movie);

        while (!queue.isEmpty()) {
            Movie p = queue.poll();
            for (Movie similarMovie : p.getSimilarMovies()) {
                if (!visited.contains(similarMovie)) {
                    visited.add(similarMovie);
                    queue.add(similarMovie);
                    priorityQueue.offer(similarMovie);

                    //System.out.println(similarMovie.getId());
                    // do
                    if (priorityQueue.size() > N) {
                        priorityQueue.poll();
                    }
                }
            }
        }

        HashSet<Movie> result = new HashSet<>();
        result.addAll(priorityQueue);
        return result;
    }

    public static void main(String[] args) {
        Movie m1 = new Movie(1, 2.0);
        Movie m2 = new Movie(2, 3.0);
        Movie m3 = new Movie(3, 4.0);
        Movie m5 = new Movie(5, 5.0);
        Movie m0 = new Movie(0, 100);

        m0.similarMovies.add(m1);
        m0.similarMovies.add(m2);

        m1.similarMovies.add(m3);
        m2.similarMovies.add(m5);

        m3.similarMovies.add(m2);

        Amazon_MovieNetwork_done amazon_movieNetwork = new Amazon_MovieNetwork_done();
        Set<Movie> result = amazon_movieNetwork.getMovieRecommendations(m0, 10);

        for (Movie movie : result) {
            System.out.println(movie.getId());
        }
    }


}
