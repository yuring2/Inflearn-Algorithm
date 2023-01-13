package main.java.section_1;

import java.util.Scanner;

// 아스키넘버 : 대문자는 65~90
// 소문자는97~122
// 둘 차이는 32 즉 소문자에서 32를 빼면 대문자가 된다.
// if(x>=97&&x<=122) answer+=char(x-32)
// else answer+=char(x+32)
public class 대소문자변환 {
    public String solution(String str){
        String answer = ""; // answer에 대소문자 변환된 것 저장해서 return
        for(char x : str.toCharArray()){ // string을 문자배열로 변환
            if(Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
            else answer+=Character.toLowerCase(x);
        }

        return answer;
    } // end solution()
    public static void main(String[] args) {
        대소문자변환 T = new 대소문자변환();
        Scanner kb = new Scanner(System.in);
        String str = kb.next(); // next(): 공백(space)전까지 입력받은 문자열을 반환
        System.out.println(T.solution(str));
    } // end main
}
