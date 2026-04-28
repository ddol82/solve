import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static class Line {
        int start;
        int end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(lines, (o1, o2)->o1.start == o2.start ? (o1.end - o2.end) : (o2.start - o1.start));
        sc.close();

        int cursor = Integer.MAX_VALUE;
        int cnt = 0;
        for (Line line : lines) {
            if (cursor <= line.end) continue;
            cursor = line.end;
            cnt++;
        }
        System.out.print(cnt);
    }
}