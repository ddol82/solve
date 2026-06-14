package practice.baekjoon.a_bronze.t5;

/**
 * BOJ 1271 : 랜덤 마라톤 97
 * Date: 2026-04-09 ~ 2026-04-09
 * Note:
 *   - 1. N은 10^1,000,000까지의 범위를 가지며, 단순 BigInteger.mod 는 시간 초과.
 */
public class P14928 {
    public static void main(String[] args) {
        System.out.print(
                java.util.Arrays.stream(
                        new java.util.Scanner(System.in)
                                .next()
                                .split(""))
                        .mapToInt(Integer::parseInt)
                        .reduce(0, (p,n)->(p*10+n)%20000303)
        );
    }
}

//short-coding
//interface Main{static void main(String[]a){System.out.print(java.util.Arrays.stream(new java.util.Scanner(System.in).next().split("")).mapToInt(Integer::parseInt).reduce(0,(p,n)->(p*10+n)%20000303));}}