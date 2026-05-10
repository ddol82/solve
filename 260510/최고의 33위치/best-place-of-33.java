import java.util.Scanner;
public class Main {
    static int gridSize;
    static int[][] grid;
    static int[][] cnts;

    public static void init() {
        Scanner sc = new Scanner(System.in);
        gridSize = sc.nextInt();
        grid = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        cnts = new int[gridSize][gridSize];
    }
    public static void addCnt(int x, int y) {
        for (int i = y-2; i <= y; i++) {
            if (i < 0) continue;
            for (int j = x-2; j <= x; j++) {
                if (j < 0) continue;
                cnts[i][j]++;
            }
        }
    }

    public static void main(String[] args) {
        init();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 0) continue;
                addCnt(j, i);
            }
        }

        int maxCnt = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                maxCnt = Math.max(maxCnt, cnts[i][j]);
            }
        }
        System.out.print(maxCnt);
    }
}