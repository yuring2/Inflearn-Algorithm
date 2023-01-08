package section_8;

import java.util.Scanner;

public class 조합구하기 {
    static int[] combi_arr;
    static int n,m=0;
    public void DFS(int D, int s){
        if(D==m){
            for(int x : combi_arr) System.out.print(x + " ");
            System.out.println();

        }else{  // 조합은 여기 for문을 그냥 외우는 것이 좋다.
            for(int i=s; i<=n; i++){
                combi_arr[D] = i;
                DFS(D+1, i+1);
            }
        }
    } // end DFS()

    public static void main(String[] args) {
        조합구하기 T = new 조합구하기();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi_arr = new int[m];
        T.DFS(0,1);
    }
}
