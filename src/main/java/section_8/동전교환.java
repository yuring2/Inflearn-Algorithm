package section_8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {
    static int n=0; // 동전의 종류 개수
    static Integer[] arr;
    static int m=0; // 거슬러줄 금액
    static int answer = Integer.MAX_VALUE;
    public void DFS(int D, int sum){
        if(D >= answer) return; // 이미 answer라는 답을 구해놓았기 때문에 더 깊숙히 볼 필요가 없다.
        if(sum > m) return;
        if(sum==m){
            answer = Math.min(answer,D);
        }else{
            for(int i=0; i<n; i++){
                DFS(D+1, sum+arr[i]);
            }
        } // end else
    }  // end DFS

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        동전교환 T = new 동전교환();
        n = kb.nextInt(); // 동전의 종류 개수

        arr = new Integer[n];
        // 동전이 들어오면 내림차순으로 정렬
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        T.DFS(0,0);
        System.out.println(answer);
    }  // end main
}
