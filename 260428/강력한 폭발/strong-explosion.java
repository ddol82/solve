import java.util.*;

public class Main {
    static int gridSize;
    static List<Bomb> bombs;
    static class Bomb {
        int x;
        int y;

        Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void init() {
        bombs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        gridSize = sc.nextInt();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                 if (sc.nextInt() == 0) continue;
                 bombs.add(new Bomb(j, i));
            }
        }
        sc.close();
    }
    static int calc(String typeStr) {
        if (typeStr.length() == bombs.size()) return simulate(typeStr);
        int maxCnt = 0;
        for (int i = 1; i <= 3; i++) {
            maxCnt = Math.max(maxCnt, calc(typeStr + i));
        }
        return maxCnt;
    }
    static int simulate(String typeStr) {
        int[] destroyBit = new int[gridSize];
        int[] dx, dy;

        for (int i = 0; i < bombs.size(); i++) {
            int x = bombs.get(i).x;
            int y = bombs.get(i).y;

            switch (typeStr.charAt(i)) {
                case '1':
                    dx = new int[] {x, x, x, x, x};
                    dy = new int[] {y, y-2, y-1, y+1, y+2};
                    break;
                case '2':
                    dx = new int[] {x, x-1, x, x+1, x};
                    dy = new int[] {y, y, y-1, y, y+1};
                    break;
                case '3':
                    dx = new int[] {x, x-1, x+1, x+1, x-1};
                    dy = new int[] {y, y-1, y-1, y+1, y+1};
                    break;
                default:
                    dx = new int[] {};
                    dy = new int[] {};
            }

            for (int j = 0; j < 5; j++) {
                setBit(destroyBit, dx[j], dy[j]);
            }
        }

        int tmpCnt = 0;
        for (int bitItem : destroyBit) {
            tmpCnt += Integer.bitCount(bitItem);
        }
        return tmpCnt;
    }
    static void setBit(int[] targetBit, int x, int y) {
        if (x < 0 || x >= gridSize || y < 0 || y >= gridSize) return;
        targetBit[y] |= 1<<x;
    }
    public static void main(String[] args) {
        init();
        System.out.print(calc(""));
    }
}