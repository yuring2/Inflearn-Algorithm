package section_8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2{
    public int x,y;
    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
}  // end class point2

public class 섬나라아일랜드_BFS {
    static int n,answer=0;
    static int[][] board;
    // 시계방향
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public void BFS(int x, int y){
        Queue<Point2> Q = new LinkedList<>();
        Q.add(new Point2(x,y));
        while(!Q.isEmpty()){
            Point2 temp = Q.poll();
            for(int i=0; i<n; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >=0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    Q.add(new Point2(nx,ny));
                }
            } // end for
        } // end while
    } // end BFS()
    public void solution(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j] = 0; // 출발점을 바다로 바꾸기 위함..!
                    BFS(i,j);
                }
            }
        } // end for
    }  // end solution()

    public static void main(String[] args) {
        섬나라아일랜드_BFS T = new 섬나라아일랜드_BFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = kb.nextInt();
            }
        } // end for

        T.solution();
        System.out.println(answer);
    } // end main
}
