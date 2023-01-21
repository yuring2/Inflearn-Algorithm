package main.java.section_1;

import java.util.Scanner;

// 문자 '0' 이 아스키번호로 48 ~ '9' 는 57
public class 숫자만추출 {
    static int solution(String str){
        int answer = 0;
        for(char c : str.toCharArray()){
            if(c >= 48 && c <= 57) answer = answer * 10 + (c-48); // c-48을 해주어야 실제 숫자가 된다.
        }
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    } // end main
}
