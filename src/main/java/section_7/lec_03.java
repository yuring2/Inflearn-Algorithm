package section_7;

// 팩토리얼

class lec_03 {

    public int DFS(int n){
        if(n==0) return 1;
        else{
            return n*DFS(n-1);
        }
    }

    public static void main(String[] args) {
        lec_03 T = new lec_03();
        System.out.println(T.DFS(5));
    }
}
