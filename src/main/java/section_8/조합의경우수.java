package section_8;

import java.util.Scanner;

// 메모이제이션
// nCr : n개중에서 r개를 뽑는다.
public class 조합의경우수 {
    int[][] dy = new int[35][35];
    public int DFS(int n, int r){
        if(dy[n][r] >0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = DFS(n-1, r-1)+DFS(n-1,r); // 메모이제이션
    }

    public static void main(String[] args) {
        조합의경우수 T = new 조합의경우수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(T.DFS(n,r));

    }
}
