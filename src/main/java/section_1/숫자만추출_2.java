package main.java.section_1;

import java.util.Scanner;
// Character.isDigit(c)사용
public class 숫자만추출_2 {
    static int solution(String str){
        String answer = "";
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)) answer+=c;
        }
        return Integer.parseInt(answer); // 그대로 String으로 return하면 0208이 반환됨. 따라서 parseInt를 해주어야함.
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    } // end main
}
