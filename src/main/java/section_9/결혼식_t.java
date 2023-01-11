package section_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int time;
    public char state;
    Time(int time, char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time o) {
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
} // end class Time
public class 결혼식_t {
    public int solution(ArrayList<Time> arr){
        int answer = Integer.MIN_VALUE;
        int cnt=0; // 현재 피로연에 존재하는 인원수
        Collections.sort(arr);
        for(Time tmp : arr){
            if(tmp.state == 's') cnt++;
            else cnt--;
            answer=Math.max(answer,cnt);
        } // end for
        return answer;
    } // end solution()

    public static void main(String[] args) {
        결혼식_t T = new 결혼식_t();
        Scanner kb = new Scanner(System.in);
        ArrayList<Time> arr = new ArrayList<>();
        int n = kb.nextInt();
        for(int i=0; i<n; i++){
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new Time(sT,'s'));
            arr.add(new Time(eT,'e'));
        } // end for
        System.out.println(T.solution(arr));
    } // end main
}
