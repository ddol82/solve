import java.util.Scanner;

public class Main {
    static int numCnt;
    static int maxDepth;
    static void simulate(int depth, String nums) {
        if (depth == maxDepth) {
            System.out.println(String.join(" ", nums.split("")));
            return;
        }
        for (int i = 1; i <= numCnt; i++) {
            simulate(depth+1, nums+i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numCnt = sc.nextInt();
        maxDepth = sc.nextInt();
        
        simulate(0, "");
    }
}