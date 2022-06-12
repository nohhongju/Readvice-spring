package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * packageName: kr.scalar.api.common.step1
 * fileName   : MaxMin
 * author     : parkjungkwan
 * date       : 2022-05-09
 * desc       : 백준 10157번 자리배정 https://dlee0129.tistory.com/171
 * 대기 순서가 K인 관객에게 배정될 좌석 번호(x,y)를 찾는 문제이다.
 * 문제 설명에서 주어졌듯이 배열을 달팽이 모형으로 순회하며 K번째가 될때 위치를 출력해주면 된다.
 * 배열을 달팽이 모형으로 순회할줄만 알면 어렵지 않은 문제이다.
 *
 * 초기 위치를 x = R - 1, y = 0으로 방향은 위, 오른쪽, 아래, 왼쪽 순으로 초기화 하였다.
 * while문에서 k번째가 될때까지 횟수 cnt를 증가 시키며 k가 될때에 종료된다.
 * 다음으로 배정될 좌석을 찾고 지도 밖으로 벗어나거나 이미 배정된 자리인 경우 방향을 돌려 배정하도록 하였다.
 * - 처음 한바퀴를 돌 때에는 0보다 작거나 R, C보다 크면 지도 밖을 벗어난다.
 * - 그다음 바퀴부터는 이미 배정된 좌석인지 확인하며 방향을 돌리면 된다.
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-09   parkjungkwan  최초 생성
 */

public class 자리배정 {
    @Data
    @AllArgsConstructor
    static class Solution {

        private int num1;
        private String opcode;
        private int num2;

        @Override
        public String toString() {
            System.out.println("07 예약");
            // 1. 배열을 이용하여 간단한 극장 예약시스템 작성
            // 2. 아주 작은 극장이라 좌석이 10개만  됨.
            // 3. 먼저 좌석 배치표를 보여주고 예약이 끝나면 1로
            // 4. 예약이 안된 좌석은 0으로 나타내라.

            int seat[] = new int[10];
            int rserved;

            while (true) {
                System.out.println("좌석을 예약하시겠습니까? (1또는 0)");
                int q = 0;

                if (q == 0) break;
                System.out.println("현재의 예약상태는 다음과 같습니다.");
                System.out.println("===");
                for (int i = 0; i < 10; i++) {
                    System.out.print(i + 1 + " ");
                }
                System.out.println();
                for (int i : seat)
                    System.out.print(i + " ");
                System.out.println();
                System.out.println("몇 번째 좌석을 에약하시겠습니까?");
                rserved = 0;
                seat[rserved - 1] = 1;
                System.out.println("예약되었습니다.");
            }
            System.out.println("프로그램을 종료합니다.");
            return "";
    }
    @FunctionalInterface
    interface SolutionService {
        계산기.Solution solution(계산기.Solution s);
    }

    @Test
    void testSolution() {

    }

}
    static void bank(Scanner scanner){


    }


}
