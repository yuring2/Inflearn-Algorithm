package main.java.section_1;

import java.util.Scanner;

public class 회문문자열 {
    static String solution(String str){
        String answer = "YES";
        str = str.toUpperCase();
        for(int i=0; i<str.length()/2; i++){
         if(str.charAt(i) != str.charAt(str.length()-i-1)) return "NO";
        } // end for
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    } // end main
}
