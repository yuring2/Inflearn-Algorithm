package section_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//송아지 찾기(BFS)
class lec_08 {
    int[] dis = {1,-1,5};
    int[] ch; // 체크배열
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {  // level안에 있는 원소를 다 돌기 위한 반복문
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {   // dis를 위한 반복문
                    int nx = x + dis[j];
                    if (nx == e) return L + 1;  //큐에 넣기전에 확인
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }

            }
            L++;
        }

        return 0;
    }

    public static void main(String[] args) {
        lec_08 T = new lec_08();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();  //  현수의 위치
        int e = sc.nextInt();  // 송아지의 위치
        System.out.println(T.BFS(s,e));
    }
}
