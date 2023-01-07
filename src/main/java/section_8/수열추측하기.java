package section_8;
// n=4이면 1~4
// 1~4 숫자를 1열로 나열하는 경우의 수(순열) 4P4
// D = 5가 되면 순열이 하나 완성. 이때 SUM이 원하는 값이 맞는지 확인

import java.util.Scanner;

public class 수열추측하기 {
    static int n,f=0;
    static int[] combi_arr,ch,p;  // 중복순열이 아니기 때문에 체크배열이 필요하다. P에는 순열을 저장
    boolean flag = false;
    int[][] dy = new int[35][35]; // 메모이제이션
    //조합의 답을 구하는 알고리즘
    public int combi(int n,int r){  // 조합의경우수
        if(dy[n][r] >0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1, r-1)+combi(n-1,r); // 메모이제이션
    } // end combi

    public void DFS(int D, int sum){
         if(flag == true) return;
         if(D==n){
            if(sum==f) {
                for(int x : p) System.out.print(x + " ");  // 답을 찾으면 다음 스택이 들어있는 재귀들은 다 stop
                flag = true;
            }
         }else{
             for(int i=1; i<=n;i++){   // 여기서 i는 인덱스가 아니라 순열을 만드는 숫자 자체임.
                 if(ch[i]==0){
                     ch[i] = 1;
                     p[D] = i;
                     DFS(D+1, sum+(p[D]*combi_arr[D]));
                     ch[i] = 0; // 체크배열 풀어주기
                 }
             }  // end for
         }  // end else
    } // end DFS()

    public static void main(String[] args) {
         수열추측하기 T = new 수열추측하기();
         Scanner kb = new Scanner(System.in);
         n = kb.nextInt();
         f = kb.nextInt();
         combi_arr = new int[n];
         p = new int[n]; // 순열
         ch = new int[n+1];

         // 조합 배열에 조합의 답을 구해서 숫자를 채움
         for(int i=0; i<n; i++){
             combi_arr[i] = T.combi(n-1,i);
         }

         T.DFS(0,0);
    } // end main
}
