package practice.baekjoon.a_bronze.t5;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * BOJ 1271 - https://www.acmicpc.net/problem/1271
 * Date: 2026-04-08
 */
public class P1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        sc.close();

        System.out.println(a.divide(b));
        System.out.println(a.mod(b));
    }
}
