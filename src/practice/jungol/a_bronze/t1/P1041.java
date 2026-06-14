package practice.jungol.a_bronze.t1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class P1041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowVal = sc.nextInt();
        int highVal = sc.nextInt();
        sc.close();

        System.out.print(String.join(" ",
                IntStream.rangeClosed(1, 100)
                        .map(n->n*n)
                        .filter(n->n>=lowVal && n<=highVal)
                        .mapToObj(x->""+x)
                        .toArray(String[]::new)
        ));
    }
}