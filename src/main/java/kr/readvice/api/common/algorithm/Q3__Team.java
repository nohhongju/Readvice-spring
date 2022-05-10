package kr.readvice.api.common.algorithm;

import java.util.Scanner;
/**
 * packageName: kr.scalar.api.common.algo01
 * fileName   : Quiz20
 * author     : parkjungkwan
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-09   parkjungkwan  최초 생성
 */
public class Q3__Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1.팀별 과제 2.팀장이 맡은 과제 3.큐를 담당한 사람 4.팀원별 과제 수");
            String[] arr = {"권혜민","조현국","김진영","김한슬","서성민",
                    "정렬","해시","힙","완전탐색","DP",
                    "스택","깊이우선탐색","그래프","탐욕법","이중탐색",
                    "큐","너비우선탐색"};
            switch (scanner.next()){
                case "1": teamSubject(arr); break;
                case "2": teamLeaderSubject(arr); break;
                case "3": queueManager(arr); break;
                case "4": subjectCountPerPerson(arr); break;
            }
        }
    } // main

    static void teamSubject(String[] arr) {

        System.out.println("1.팀별 과제");
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 1) {
                s += "\n";
            }
            s += i + ":" + arr[i] + "\t";
        }
        System.out.println(s);
    }
    static void teamLeaderSubject (String[] arr){
        System.out.println("2.팀장이 맡은 과제만 출력하세요. 예) 김진영, 힙, 그래프 ");
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("김진영")) {
                for (int j = 0; j < 3; j++) {
                    s += arr[i + j * 5] + ",";
                }
                if (i == 17) {
                    break;
                }
            }
        }
        System.out.println(s);
    }
    static void queueManager (String[] arr) {
        System.out.println("3.큐를 담당한 사람을 출력하세요. 예) 큐를 담당한 사람: 권혜민 ");
        String s = "";
        /**
         * Q3. 입력한 과목의 인덱스를 추출하세요
         * 5, 10, 15 -> 0
         * 6, 11, 16 -> 1
         * 7, 12, 17 -> 2
         */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("힙")) {
                // System.out.println("큐의 인덱스 : "+i);
                s = arr[i] + "의 담당자는 " + arr[i % 5];
            }

        }
        System.out.println(s);
    }
    static void subjectCountPerPerson (String[] arr){
        System.out.println("4.팀원별 과제 수를 출력하세요 "
                +"예) 권혜민(3개), 조현국(3개), 김진영(2개), 김한슬(2개), 서성민(2개) ");


        /**
         *  String[] arr = {"권혜민",   "조현국",     "김진영",  "김한슬",  "서성민",
         *                 "정렬",     "해시",        "힙",   "완전탐색", "DP",
         *                 "스택",  "깊이우선탐색 ",  "그래프", "탐욕법", "이중탐색",
         *                 "큐",    "너비우선탐색"                        };
         *   4 * 5
         * */

        String s = "";
        int[] intArr = new int[5];
        int[] resArr = new int[5];
        for(int i = 5; i< arr.length; i++){
            int a = i % 5;
            for(int j = 0; j<5; j++){
                if(a == j){
                    intArr[j]++;
                }
                resArr = intArr;
            }
        }
        for(int i = 0; i< 5; i++){
            System.out.println(arr[i]+"("+resArr[i]+"), ");
        }
    }

}