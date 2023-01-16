package main.java.section_1;

import java.util.Scanner;

public class 특정문자뒤집기 {
    public String solution(String s){
        String answer="";
        char[] c = s.toCharArray();
        int lt = 0;
        int rt = s.length()-1; // 마지막 인덱스
        while(lt<rt){
            if(!Character.isAlphabetic(c[lt])) lt++;
            else if(!Character.isAlphabetic(c[rt])) rt--;
            else{
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
        } // end while
        answer = String.valueOf(c);
        return answer;
    } // end solution()
    public static void main(String[] args) {
        특정문자뒤집기 T = new 특정문자뒤집기();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.solution(s));
    } // end main
}
