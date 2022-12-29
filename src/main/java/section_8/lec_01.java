package section_8;

import java.util.Scanner;

public class lec_01 {
    // static 붙인 것은 전역으로 사용하겠다는 의미
    // 강사님처럼 main안에다가 arr배열을 선언했으면 지역변수로 선언한 것이기 때문에
    // dfs에서 사용을 하려면 매개변수로 배열을 계속 넘겨주어야 한다.
    static int n,total = 0;
    static String answer = "no";
    boolean flag = false;
    static int[] arr;
    public void DFS(int L, int sum){
       if(flag == true) return;  // yes가 발견되면 스택에 자고있던 남아있는 재귀를 계속 return시켜버린다.(재귀가 바로 끝나버리도록)
       if(sum > total/2) return;  // 넘어가버리면 부분집합을 완성할 필요가 없다.
        if(L == n){ // 부분집합 하나를 만든상태
          if(sum == total/2){  // 1. 발견을 하면
              answer = "yes";
              flag = true;     // 2. flag를 true로 바꾼다.
          }
       }else{
           DFS(L+1, sum+arr[L]);
           DFS(L+1, sum);
       }
    }
    public static void main(String[] args) {
        lec_01 T = new lec_01();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
            total+=arr[i];
        }

        T.DFS(0,0);
        System.out.println(answer);
    }  // end main
}
