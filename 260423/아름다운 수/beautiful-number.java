import java.util.Scanner;

public class Main {
    static int maxLength;
    static String[] elems;

    static int simulate(String numStr) {
        if (numStr.length() > maxLength) return 0;
        if (numStr.length() == maxLength) return 1;

        int tmpCnt = 0;
        for (String item : elems) {
            tmpCnt += simulate(numStr + item);
        }
        return tmpCnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxLength = sc.nextInt();
        sc.close();
        
        elems = new String[] {"1", "22", "333", "4444"};
        System.out.print(simulate(""));
    }
}