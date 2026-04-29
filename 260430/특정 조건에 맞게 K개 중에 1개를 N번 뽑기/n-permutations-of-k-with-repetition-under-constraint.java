import java.util.Scanner;
public class Main {
    static int k;
    static int n;
    static StringBuilder sb;
    static void simulate(String str) {
        if (checkThree(str)) return; 
        if (str.length() == n) {
            if (sb.length() > 0) sb.append("\n");
            sb.append(String.join(" ", str.split("")));
            return;
        }

        for (int i = 1; i <= k; i++) {
            simulate(str + i);
        }
    }
    static boolean checkThree(String str) {
        for (int i = 1; i <= k; i++) {
            if (str.endsWith(String.valueOf(i * 111))) return true;
        }
        return false;
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        sc.close();
    }
    public static void main(String[] args) {
        init();
        sb = new StringBuilder();
        simulate("");
        System.out.print(sb);
    }
}