package main.java.section_10;

import java.util.Scanner;

public class 계단오르기 {
    static int[] dy;
    public int solution(int n){
       dy[1] = 1; // 직관적으로 초기화 가능
       dy[2] = 2; // 직관적으로 초기화 가능
       for(int i=3; i<=n; i++){
           dy[i] = dy[i - 2] + dy[i - 1];

       } // end for
        return dy[n];
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        계단오르기 T = new 계단오르기();
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(T.solution(n));
    } // end main
}
