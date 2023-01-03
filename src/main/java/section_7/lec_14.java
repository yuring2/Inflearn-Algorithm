package section_7;

// 최단거리 문제는 bfs라고 생각하면 된다.
// 레벨로 거리를 측정

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class lec_14 {
    static int n,m=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v){ // 정점이 넘어온다.
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        q.offer(v);
        while(!q.isEmpty()){
            int currentV = q.poll();  // 큐에서 현재 정점을 하나 꺼낸다.
            for(int nextV : graph.get(currentV)){ // 정점에서 바로 갈 수 있는 노드 탐색
                if(ch[nextV] == 0){
                    ch[nextV] = 1;
                    q.offer(nextV);
                    dis[nextV] = dis[currentV] + 1;  // 중요!
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        lec_14 T = new lec_14();
        n = kb.nextInt();  //6
        m = kb.nextInt();  //9
        graph = new ArrayList<ArrayList<Integer>>();
        // 여기 반복문에서 왜 i=1로 해주면 안되는 거임?
        // 1. 1로 해주면 Arraylist안에 리스트가 6개가 생김 ! 근데
        for(int i=0; i<=n; i++){ // 율 : 그래프에 공간 잡을 때 <=n으로 해주어야 한다.
            graph.add(new ArrayList<Integer>());
        }


        // 인접리스트 만들기
        // 2. 여기서 인덱스로 접근을 할 때는 0부터 돌기 때문에 5번 ArrayList가 끝임.
        // 따라서 키보드에서 6 3 이런식으로 치면 에러가 발생
        // 따라서 정점이 6번까지 있으면 리스트는 +1 해서 7개를 생성해놓아야함(인덱스가 0부터 시작이니깐)
        for(int i=0; i<m; i++){  // 간선의 개수만큼 돌면서
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        ch = new int[n+1];
        dis = new int[n+1];

        T.BFS(1 );
        for(int i=2; i<=n; i++){
            System.out.println(i + " : " + dis[i]);
        }

    }
}
