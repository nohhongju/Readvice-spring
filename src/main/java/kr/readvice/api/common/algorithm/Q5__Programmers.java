package kr.readvice.api.common.algorithm;

import java.util.Scanner;

/**
 * packageName: kr.scalar.api.common.algorithm
 * fileName   : Q5__Programmers
 * author     : parkjungkwan
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-09   parkjungkwan  최초 생성
 */
public class Q5__Programmers {
    public static void main(String[] args) { // 03소수 quiz03prime()
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1.정렬 2.큐 3.스택 4.이진분류 5.동적프로그래밍 \n" +
                    "6.해시 7.깊이우선탐색 8.너비우선탐색 9.완전탐색 10.탐욕 \n" +
                    "11.그래프 12.힙");
            switch (scanner.next()){
                case "1": sort(); break;
                case "2": queue(); break;
                case "3": stack(); break;
                case "4": binarySearch(); break;
                case "5": dp(); break;
                case "6": hash(); break;
                case "7": dfs(); break;
                case "8": bfs(); break;
                case "9": bruteForce(); break;
                case "10": greedy(); break;
                case "11": graph(); break;
                case "12": heap(); break;
                default:return;
            }
        }
    } // main
    static void sort() {}
    static void stack() {}
    static void queue() {}
    static void binarySearch() {}
    static void dp() {}
    static void hash() {}
    static void dfs() {}
    static void bfs() {}
    static void bruteForce() {}
    static void greedy() {}
    static void graph() {}
    static void heap() {}
}
