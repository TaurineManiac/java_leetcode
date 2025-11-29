//You have a RecentCounter class which counts the number of recent requests within a certain time frame.
//Implement the RecentCounter class:
//RecentCounter() Initializes the counter with zero recent requests.
//int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
// and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
// Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
//It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

import java.util.*;

public class RecentCounter {

    Queue<Integer> q;
    int counter;
    public RecentCounter() {
        q = new LinkedList<>();
        counter = 0;
    }

    public int ping(int t) {
        q.offer(t);
        counter++;
        while(q.peek() < t - 3000){
            q.poll();
            counter--;
        }
        return counter;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

class SolutionForRecentCounter {
    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(200));
//        System.out.println(r.ping(3000));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));

    }
}
