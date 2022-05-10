package kr.readvice.api.common.algorithm;

import java.util.Scanner;

/**
 * packageName: kr.scalar.api.common.algorithm
 * fileName   : Q4__Math
 * author     : parkjungkwan
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-09   parkjungkwan  최초 생성
 */
public class Q4__Math {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1.소수 ");
            switch (scanner.next()){
                case "1": primeNumber(scanner); break;

            }
        }
    } // main
    static void primeNumber(Scanner scanner) {
        Scanner scanner1 = new Scanner(System.in);
        int a;
        System.out.print("수 입력 : ");
        a = scanner1.nextInt();
        int count = 0;

        for (int i = 2; i <= a; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.print(i + " ");
            }
            count = 0;
        }
    }
}
