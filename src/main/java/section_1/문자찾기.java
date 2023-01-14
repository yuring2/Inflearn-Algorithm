package main.java.section_1;

import java.util.Scanner;
// string(문자열)을 아래와 같이 index로 접근할 수도 있지만 향상된 for문을 사용해도 된다.
/*for(char x : str.toCharArray()){
    if(x==c) answer++;
        }*/

public class 문자찾기 {
    public int solution(String str, char c){
        int answer = 0;
        //대소문자를 구분하지 않기 때문에 str,c를 다 대문자로 바꾼다.
        str = str.toUpperCase();
        c = Character.toUpperCase(c); // c는 문자이기 때문에 Character에 있는 메소드를 사용합니다.
        for(int i=0; i<str.length(); i++){ // string의 길이만큼 돌도록
            if(str.charAt(i) == c) answer++;
        }
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        문자찾기 T = new 문자찾기(); // solution()을 static으로 해주면 객체생성x
        String str = kb.next();
        char c = kb.next().charAt(0); // string을 index로 접근 : charAt(index)
        System.out.println(T.solution(str,c));
    } // end main
}
