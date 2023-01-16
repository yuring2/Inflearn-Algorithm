package main.java.section_1;

import java.util.ArrayList;
import java.util.Scanner;
// 문자열을 다루는 클래스에는 String도 있지만
// StringBuilder도 있다

// reverse()를 사용하면 단순히 문자열을 뒤집어준다. 따라서 단어안에서 특정 문자만 뒤집으라는 경우에는 reverse()를 사용하지 못한다.

public class 단어뒤집기 {
    public ArrayList<String> solution(int n, String[] arr){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : arr){
            String tmp = new StringBuilder(x).reverse().toString(); // good이라는 단어로 StringBuilder객체가 만들어 진것이다. (이것도 문자열 객체)
            // 객체를 다시 문자열로 변환을 해주기 위해서 toString()을 해준다.
            answer.add(tmp);
        }
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        단어뒤집기 T = new 단어뒤집기();
        int n = kb.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.next();
        } // end for
        for(String x : T.solution(n,arr)){
            System.out.println(x);
        } // end for
    } // end main
}
