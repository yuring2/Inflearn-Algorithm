package section_7;

import java.util.Scanner;

public class lec_12 {

    static int n,m,answer=0;
    static int[][] graph;  // 인접행렬
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;   // n을 전역으로 잡았기 때문에 여기 dfs에서 접근이 가능하다.
        else {

            for (int i = 1; i <= n; i++) {
                // 현재 지점은 v이다. v에서 i로 갈 수 있는지 확인이 필요하다.
                if(graph[v][i]==1 && ch[i]==0){
                    ch[i]=1; // 체크배열 체크하고 호출
                    DFS(i);  // 정점이 v -> i로 이동  ,,, 백하면 이 라인으로 다시 들어오잖아?
                    ch[i] = 0;   // 백하면 체크를 다시 풀어주어야 한다.
                }
            }
        } // end else

    }


    public static void main(String[] args) {
        lec_12 T = new lec_12(); // DFS에 접근하기 위해서
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();  // 정점의 수
        m = kb.nextInt();  // 간선의 개수
        graph = new int[n+1][n+1];  // 행과 열의 인덱스 번호가 정점을 뜻하기 때문에 정점을 나타내기 위해서는 n+1로 잡아주어야 한다.
        ch = new int[n+1];

        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1; // 경로표시
        }

        ch[1] = 1;
        T.DFS(1);   // 출발점이 1

        System.out.println(answer);
    }
}
