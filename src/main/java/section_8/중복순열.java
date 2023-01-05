package section_8;

import java.util.Scanner;

// 이전 문제까지는 두가닥으로 뻗음( 예를들어 포함한다, 포함하지 않는다)
// 이번 문제는 여러가닥으로 뻗는다. 
public class 중복순열 {
    static int n,m=0;
    static int[] arr;
    
    public void DFS(int D) {
        if (D == m) {
            for(int x : arr) System.out.print(x + " ");
            System.out.println(); // 줄바꿈
        } else {
            for (int i = 1; i <= n; i++) {
                arr[D] = i;
                DFS(D + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        중복순열 T = new 중복순열();
        
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[m];
        
        T.DFS(0);
    } // end main
}
