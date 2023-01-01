package section_7;  // 경로탐색(인접리스트)

// 정점이 10000 개 이런식으로 들어오는 경우에 인접행렬은 너무 비효율적이다.
// 이차원 배열을 만다는데만 10000x10000 이렇게 엄청만 메모리를 잡아먹음

import java.util.ArrayList;
import java.util.Scanner;

public class lec_13 {

    static int n,m,answer=0;
    // 그래프는 arraylist객체를 저장한다.
    static ArrayList<ArrayList<Integer>> graph;  // 선언만 했지 그래프 객체가 생성된 것은 아직 아니다.
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
           for(int nextV : graph.get(v)){  // get(v)하면 v번째 arraylist에 접근
               if(ch[nextV] == 0){
                   ch[nextV] = 1;
                   DFS(nextV);
                   ch[nextV] =0;
               }
           }
        }
    }


    public static void main(String[] args) {
       lec_13 T = new lec_13();
       Scanner kb = new Scanner(System.in);
       n = kb.nextInt();
       m = kb.nextInt();
       ch = new int[n+1];
       graph = new ArrayList<ArrayList<Integer>>();
       for(int i=0; i<=n; i++){  // n개    ,,, 이부분 중요!
           graph.add(new ArrayList<Integer>());
       }

       for(int i=0; i<m; i++){
           int a = kb.nextInt();
           int b = kb.nextInt();
           graph.get(a).add(b);
       }

       ch[1] = 1;
       T.DFS(1);
        System.out.println(answer);


    }
}
