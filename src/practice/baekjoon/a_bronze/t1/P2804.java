package practice.baekjoon.a_bronze.t1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wordH = sc.next();
        String wordV = sc.next();
        sc.close();
        char[][] field = new char[wordV.length()][wordH.length()];
        for (int i = 0; i < wordV.length(); i++) {
            Arrays.fill(field[i], '.');
        }
    }
}
