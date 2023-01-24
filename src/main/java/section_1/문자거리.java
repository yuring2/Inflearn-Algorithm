package main.java.section_1;

import java.util.Scanner;
// 오른쪽에 있는 e로부터의 거리
public class 문자거리 {
    public static int[] solution(String s, char target){
        int[] answer = new int[s.length()];
        int p = 1000;
        // 왼쪽에 있는 e로부터 떨어진 거리
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==target){
                p = 0;
                answer[i] = p;
            }
            else {
                p++;
                answer[i] = p;
            }
        } // end for
         p =1000;
         for(int i=s.length()-1; i>=0; i--){
             if(s.charAt(i)==target){
                 p = 0;
             }
             else{
                 p++;
                 answer[i] = Math.min(p,answer[i]);
             }
         } // end for
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char target = kb.next().charAt(0);
        for (int x: solution(str,target)) {
            System.out.print(x + " ");
        }
    } // end main
}
