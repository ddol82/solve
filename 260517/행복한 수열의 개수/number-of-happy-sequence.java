import java.util.Scanner;
  
public class Main {
    static final int VER_IDX = 0;
    static final int HOR_IDX = 1;
    static class NumItem {
        int tgNum;
        int tgCnt;
        int maxCnt;

        NumItem(int tgNum, int tgCnt) {
            this.tgNum = tgNum;
            this.tgCnt = tgCnt;
            this.maxCnt = 0;
        }

        void check(int num) {
            if (num == tgNum) {
                tgCnt++;
            } else {
                tgNum = num;
                tgCnt = 1;
            }
            maxCnt = Math.max(maxCnt, tgCnt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //init nums
        NumItem[][] nums = new NumItem[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][VER_IDX] = new NumItem(0, 0);
            nums[i][HOR_IDX] = new NumItem(0, 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmpNum = sc.nextInt();
                nums[i][VER_IDX].check(tmpNum);
                nums[j][HOR_IDX].check(tmpNum);
            }
        }
        sc.close();
        
        int prettyCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (nums[i][j].maxCnt >= m) prettyCnt++;
            }
        }
        System.out.print(prettyCnt);
    }
}