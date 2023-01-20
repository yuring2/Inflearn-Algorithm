package main.java.section_1;

import java.util.Scanner;
// repalce()는 정규식 사용 불가능
// repalceAll() 정규식 사용 가능
public class 팰린드롬 {
    static String solution(String str){
        String answer="NO";
        str=str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) return "YES";
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
    } // end main
}
