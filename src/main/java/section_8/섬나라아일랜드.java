package section_8;
// 이차원 배열을 탐색하면서 DFS를 섬 개수만큼 호출하는 방식으로 코딩

import java.util.Scanner;

public class 섬나라아일랜드 {
    static int n,answer=0;
    static int[][] board;
    // 시계방향
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public void DFS(int x, int y){
        for(int i=0; i<8; i++){  // 8번 돌아야 함
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                DFS(nx,ny);
            }
        } // end for

    } // end DFS()
    public void solution(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){  // 섬을 만나면
                    answer++;
                    board[i][j] = 0; // 출발점을 바다로 바꾸기 위함..!
                    DFS(i,j);
                }
            }
        }// end for
    } // end solution

    public static void main(String[] args) {
        섬나라아일랜드 T = new 섬나라아일랜드();
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
