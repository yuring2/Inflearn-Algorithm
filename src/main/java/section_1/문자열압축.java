package main.java.section_1;

import java.util.Scanner;

public class 문자열압축 {
    public static  String solution(String s){
        String answer = "";
        s=s+" ";
        int cnt = 1;
        for(int i=0; i<s.length()-1; i++){ // 빈 문자열이 있는 곳은 i가 가면 안되기 때문에 length()-1
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else{
                answer += s.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt); // int - > String
                cnt = 1;
            }
        } // end for
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    } // end main
}
