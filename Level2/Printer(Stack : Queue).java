import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Pair> q = new LinkedList<Pair>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ComparatorDescending());

        for (int i = 0; i < priorities.length; i++) {
            Pair p = new Pair(i, priorities[i]);

            q.add(p);
            pq.add(priorities[i]);
        }

        while (!q.isEmpty()) {
            int curIndex = q.peek().index;
            int curImportance = q.peek().importance;
            q.poll();

            if (pq.peek() == curImportance) {
                pq.poll();
                answer++;

                if (curIndex == location) {
                    return answer;
                }
            } else {
                Pair p = new Pair(curIndex, curImportance);
                q.add(p);
            }
        }
        return 0;
    }
}

class Pair {
    int index, importance;

    Pair(int index, int importance) {
        this.index = index;
        this.importance = importance;
    }
}

class ComparatorDescending implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) return 1;
        return -1;
    }
}