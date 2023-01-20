package main.java.section_1;

import java.util.Scanner;
// indexof() : 해당 문자가 가장 처음으로 발견되는 인덱스번호를 return (여러 개 있어도 가장 앞)

public class 중복문자제거 {
    static String solution(String str){
        String answer = "";
        for(int i=0; i<str.length(); i++){
            if(i == str.indexOf(str.charAt(i))) answer += str.charAt(i);
        }
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    } // end main
}
