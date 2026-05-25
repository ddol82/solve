import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int answer = 0;
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int targetNum = grid[i][j];
                int[] nearNums = new int[4];
                for (int k = 0; k < 4; k++) {
                    int dx = i + dirX[k];
                    int dy = j + dirY[k];
                    if (dx < 0 || dx == n || dy < 0 || dy == m) {
                        nearNums[k] = 0;
                    } else {
                        nearNums[k] = grid[dx][dy];
                    }
                }
                Arrays.sort(nearNums); //asc
                targetNum += nearNums[2] + nearNums[3]; //max 2EA
                answer = Math.max(answer, targetNum);
            }
        }
        System.out.print(answer);
    }
}