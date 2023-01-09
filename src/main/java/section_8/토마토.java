package section_8;
// 동시다발적으로 출발점이 여러개일 때에는 bfs에 돌기전에 0레벨을 다 큐에 넣어주어야 한다. (중요)
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point1{
    public int x,y;
    Point1(int x, int y){
        this.x = x;
        this.y = y;
    }
} // end class Point1

public class 토마토 {
    static int m,n=0; // m: 가로(열)
    static int[][] board,dis_arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point1> Q = new LinkedList<Point1>(); // main에서도 큐에 접근해야하므로 큐를 전역으로 잡음
    public void BFS(){
        while(!Q.isEmpty()){
            Point1 tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx<n && ny >=0 && ny < m && board[nx][ny]==0){
                    board[nx][ny] =1;
                    Q.offer(new Point1(nx,ny));
                    dis_arr[nx][ny] = dis_arr[tmp.x][tmp.y] +1;
                }
            } // end for
        }  // end while

    } // end BFS()

    public static void main(String[] args) {
        토마토 T = new 토마토();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt(); // 6
        n = kb.nextInt();  // 4
        board = new int[n][m];
        dis_arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                board[i][j] = kb.nextInt();
                if(board[i][j]==1) Q.offer(new Point1(i,j));
            }
        } // end for
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){  // BFS()가 끝나고 났는데도 익지않은 토마토가 있는경우,,
            for(int j=0; j<m; j++){
                if(board[i][j] == 0) flag = false;
            }
        } // end for

        if(flag){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer = Math.max(answer,dis_arr[i][j]);
                }
            }
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    } // end main
}
