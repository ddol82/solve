package practice.baekjoon.c_gold.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 2638 : solved.ac CLASS 4++
 * Date: 2026-04-10 ~ 2026-04-10
 * Problem:
 *   - N(세로 격자 수) * M(가로 격자 수) 격자에 치즈를 놓음.
 *   - 4변 중 2변 이상이 밖이랑 접촉하면 한 시간 후 사라짐
 *   - 치즈 내부의 공기는 외부 공기가 아니지만, 노출되면 외부 공기가 됨.
 *   - 맨 가장자리에는 치즈가 놓이지 않음.
 * Condition:
 *   - 첫 줄: 5 <= N, M <= 100
 *   - 그 다음 N개 줄: 0은 공기, 1은 치즈
 * Return:
 *   - 치즈가 모두 녹아 없어지는데 걸리는 시간을 출력
 * Note:
 */
public class P2638 {
    static int width;
    static int height;
    static byte[][] field;
    static class Point {
        int x;
        int y;
        int weight;
        Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputInfo = br.readLine().split(" ");
        height = Integer.parseInt(inputInfo[0]);
        width = Integer.parseInt(inputInfo[1]);
        field = new byte[height][width];
        for (int i = 0; i < height; i++) {
            inputInfo = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                field[i][j] = Byte.parseByte(inputInfo[j]);
            }
        }
        br.close();
    }
    public static void main(String[] args) throws IOException {
        init();

        Queue<Point> currQueue = new LinkedList<>();
        Queue<Point> nextQueue = new LinkedList<>();
        nextQueue.offer(new Point(0, 0, 0));
        field[0][0] = -1;
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, -1, 0, 1};

        int depth;
        for (depth = 0; !nextQueue.isEmpty(); depth++) {
            while (!nextQueue.isEmpty()) {
                currQueue.offer(nextQueue.poll());
            }
            while (!currQueue.isEmpty()) {
                Point target = currQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int dx = target.x + dirX[i];
                    int dy = target.y + dirY[i];

                    if (dx < 0 || dx >= width || dy < 0 || dy >= height) continue;
                    if (field[dy][dx] == 0) {
                        field[dy][dx] = -1;
                        currQueue.offer(new Point(dx, dy, 0));
                    } else {
                        field[dy][dx] += 1;
                        nextQueue.offer(new Point(dx, dy, field[dy][dx]));
                    }
                }
            }
        }
    }
}






























