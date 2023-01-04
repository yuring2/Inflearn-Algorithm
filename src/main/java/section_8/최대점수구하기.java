package section_8;

import java.util.Scanner;

public class 최대점수구하기 {
    static int n,m=0;
    static int sum = 0;
    static int[] scores;
    static int[] time;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int D, int sum, int t){
        if(t > m) return;
       if(D==n){  // 부분집합이 완성이 되면
           answer = Math.max(sum,answer);
       }else{
          DFS(D+1,sum+scores[D],t+time[D]);
          DFS(D+1,sum,t);
       }
    }



    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        최대점수구하기 T = new 최대점수구하기();
        n = kb.nextInt();  // 문제의 개수
        m = kb.nextInt();  // 제한시간
        scores = new int[n];  // n=5이면 인덱스 0~4로 방을 5개 잡음
        time = new int[n];
        for(int i=0; i<n; i++){
           scores[i] = kb.nextInt();
           time[i] = kb.nextInt();
        }
        T.DFS(0,0,0);
        System.out.println(answer);
    }  // end main
}
