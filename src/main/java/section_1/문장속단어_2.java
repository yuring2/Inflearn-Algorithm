package main.java.section_1;

import java.util.Scanner;

public class 문장속단어_2 {
    public String solution(String str){
        String answer = " ";
        int m = Integer.MIN_VALUE,pos;
        while((pos=str.indexOf(' '))!=-1){ // 띄어쓰기를 발견하면 index번호를 return 발견하지 못하면 -1을 return
            String tmp = str.substring(0,pos); // 0번 index부터 pos전까지
            int len = tmp.length();
            if(len>m){
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1); // str을 새로 변경
        } // end while() ,, 띄어쓰기 없이 다 쪼개면 종료
        if(str.length() > m) answer = str;  // 마지막 단어 처리를 꼭 해주어야 함. 아니면 time이 출력
        return answer;
    } // end solution()
    public static void main(String[] args) {
        문장속단어_2 T = new 문장속단어_2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); // 문장을 입력받아야 하기 때문에 nextLine() 사용
        System.out.println(T.solution(str));
    } // end main
}
