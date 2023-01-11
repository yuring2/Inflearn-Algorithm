package section_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    public int money;
    public int date;
    Lecture(int money, int date){
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
} // end class Lecture

public class 최대수입스케줄 {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr) {
        //PriorityQueue<Integer> pQ = new PriorityQueue<>(); -> 이렇게 선언하면 큐에 정수가 들어가고 poll()을 했을 때 가장 작은 값을 최우선순위로 꺼낸다.
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 이렇게 하면 큰 수부터 나옴
        int answer=0;
        Collections.sort(arr); // 날짜에 의한 내림차순 정렬
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).date < i) break; // j=1일 때 break가 걸리므로 j는 2가 되지 않는다. 아직 계속 1인 상태
                else pQ.offer(arr.get(j).money);
            }
            // i 날짜에 얼마짜리 강연을 할 지 선택
            if (!pQ.isEmpty()) answer += pQ.poll();
        } // end for
        return answer;
    } // end solution()
    public static void main(String[] args) {
        최대수입스케줄 T = new 최대수입스케줄();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m,d));
            if(d>max) max = d; // 가장 큰 date를 찾기 위해서
        } // end for
        System.out.println(T.solution(arr));
    } // end main
}
