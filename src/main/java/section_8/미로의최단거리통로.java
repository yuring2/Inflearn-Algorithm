package section_8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
} // end class Point

public class 미로의최단거리통로 {
    static int[][] board = new int[8][8];
    static int[][] dis = new int[8][8];
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0};  // 행
    static int[] dy = {0,1,0,-1};  // 열
    public void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y)); // 객체가 큐에 들어간다. 객체는 좌표
        board[x][y] = 1;
        while(!Q.isEmpty()){
            Point tmp = Q.poll(); // 여기서 좌표가 하나 나오겠죠?
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 1 && nx <=7 && ny >=1 && ny <=7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;   // while문이 끝나면 dis는 꽉 채워져 있겠지?
                } // end if
            } // end for
        } // end while
    }// end BFS()

    public static void main(String[] args) {
       미로의최단거리통로 T = new 미로의최단거리통로();
        Scanner kb = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = kb.nextInt();
            }
        } // end for
        T.BFS(1,1);  // 1,1이 출발점
        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    } // end main
}
