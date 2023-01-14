package main.java.section_1;

import java.util.Scanner;
// 방법 1 : split()사용

public class 문장속단어 {
    public String solution(String str){
        String answer = " ";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){ // 배열이므로 향상된 for문 가능
            int len = x.length();
            if(len > m){
                m = len;
                answer = x;
            }
        } // end for
        return answer;
    } // end solution()
    public static void main(String[] args) {
        문장속단어 T = new 문장속단어();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); // 문장을 입력받아야 하기 때문에 nextLine() 사용
        System.out.println(T.solution(str));
    } // end main
}
