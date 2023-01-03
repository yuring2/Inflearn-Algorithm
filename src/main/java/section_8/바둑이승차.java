package section_8;
// 바둑이 승차 : 부분집합 문제임
import java.util.Scanner;

public class 바둑이승차 {
    static int c,n=0;
    static int finalT = Integer.MIN_VALUE;
    static int[] arr; // 입력받은 바둑이의 무게를 저장하는 배열
    public void DFS (int i, int sum){
       if(sum > c) return;
       if(i==n){  // sum이 c보다 작거나 같은 부분집합 하나 완성
           if(sum > finalT) finalT = sum;
       }else{
           DFS(i+1,sum+arr[i]); // 여기에  sum+=arr[i] 이렇게 하면 답이 제대로 안나옴
           DFS(i+1,sum);
       }
    }
    public static void main(String[] args) {
        바둑이승차 T = new 바둑이승차();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        T.DFS(0,0);
        System.out.println(finalT);
    } // end main
}
