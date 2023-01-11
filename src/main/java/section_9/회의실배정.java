package section_9;
// 최대한 많은 회의를 할 수 있게끔 빨리 끝나는 회의를 먼저 진행한다. (그리디 기법)
// 반대로 빠른 시작시간 순으로 회의를 선택하여 푼다면? 최악의 경우 가장 일찍 시작된 회의가 가장 늦게 끝난다면 1개의 회의밖에 진행하지 못한다.
// 끝나는 시간이 같다면 시작 시간에 의한 오름차순으로 정렬

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class meeting implements Comparable<meeting>{
    public int start,end;
    meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(meeting o) {
        if(this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
} //end class meeting

public class 회의실배정 {
    static int n = 0;
    static ArrayList<meeting> arr = new ArrayList<>();
    public int solution(){
        int count = 0;
        int endTime = 0;
        Collections.sort(arr);
        for(meeting tmp : arr){
              if(tmp.start >= endTime){
                  count++;
                  endTime = tmp.end;
              }
        } // end for
        return count;
    } // end solution()
    public static void main(String[] args) {
        회의실배정 T = new 회의실배정();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        for(int i=0; i<n; i++){
            int s = kb.nextInt();
            int e = kb.nextInt();
            arr.add(new meeting(s,e));
        } // end for
        System.out.println(T.solution());

    } // end main
}
