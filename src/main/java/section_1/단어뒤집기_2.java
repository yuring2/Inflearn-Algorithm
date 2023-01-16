package main.java.section_1;

import java.util.ArrayList;
import java.util.Scanner;

// 여기서는 단어를 하나하나 직접 뒤집는 코드를 구현해보겠음.

public class 단어뒤집기_2 {
    public ArrayList<String> solution(int n, String[] arr){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : arr){
            char[] c = x.toCharArray(); // 문자들을 하나하나 교환하려면.. 스트링은 움직일수가 없으니까 문자열을 문자배열로 만들어준다.
            int lt = 0;
            int rt = x.length()-1;
            while(lt<rt){
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            } // end while
            answer.add(String.valueOf(c)); // String.vlaueOf() : 문자배열을 String화 시켜준다. valueOf는 static으로 선언된 메소드여서 클래스명으로 접근가능
        }// end for
        return answer;
    } // end solution()
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        단어뒤집기_2 T = new 단어뒤집기_2();
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
