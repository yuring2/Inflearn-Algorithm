package section_8;

import java.util.Scanner;

// 중복불가
public class 순열구하기 {
    static int n,m=0;
    static int[] ch;
    static int[] arr;
    static int[] result_arr;
    public void DFS(int D){
        if(D==m){
            for(int x : result_arr) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(ch[i] == 0){
                    result_arr[D] = arr[i];
                    ch[i] = 1;
                    DFS(D+1); // 백하면
                    ch[i] = 0;  // 여기서 부터 실행. 이때 체크를 풀어주고 다음 for 갈래로 뻗는다.
                }
            }  // end for
        }  // end else
    } // end DFS()

    public static void main(String[] args) {
        순열구하기 T = new 순열구하기();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();  // n개의 자연수
        m = kb.nextInt();  // 몇 개
        arr = new int[n];
        ch = new int[n];
        result_arr = new int[m];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        T.DFS(0);
    } // end main
}
