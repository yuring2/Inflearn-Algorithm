package section_8;

import java.util.Scanner;

public class 미로탐색 {
    // 12시 3시 6시 9시
    static int[] dx = {-1,0,1,0};  // 행
    static int[] dy = {0,1,0,-1};  // 열
    static int[][] board = new int[8][8]; // 0이 아닌 1번 인덱스부터 사용하기 위해서 8행 8열로 잡음
    static int answer = 0;
    public void DFS(int x, int y){
        if(x==7 && y==7) answer++;
        else{
            for(int i=0; i<4; i++){  // 동 서 남 북 4방향으로 뻗어야 하니까 반복문이 4번 돌아야한다.
                int nextX = x + dx[i]; // 현재지점 x에 더해준것임..  행 움직임
                int nextY = y + dy[i];
                if(nextX >= 1 && nextX <= 7 && nextY >=1 && nextY <= 7 && board[nextX][nextY]==0) {  // 경계선 안쪽에 있고 통로가 맞는지 확인
                    board[nextX][nextY] = 1;
                    DFS(nextX, nextY);
                    board[nextX][nextY] = 0;
                }
            } // end for
        } // end else
    } // end DFS()
    public static void main(String[] args) {
        미로탐색 T = new 미로탐색();
        Scanner kb = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = kb.nextInt();
            }
        }  // end for
        board[1][1] = 1; // 출발점은 체크를 걸어놓고 시작
        T.DFS(1,1);
        System.out.println(answer);
    }// end main
}
