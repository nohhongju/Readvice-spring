package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common._bruteForce
 * fileName   : Lotto
 * author     : parkjungkwan
 * date       : 2022-05-23
 * desc       : [백준] 6603 - 로또 (java)
 * 문제
 * 독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
 * 로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중
 * k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
 * 예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
 * ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
 * 집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 * 각 테스트 케이스는 한 줄로 이루어져 있다. 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
 * S의 원소는 오름차순으로 주어진다.
 *
 * 입력의 마지막 줄에는 0이 하나 주어진다.
 *
 * 출력
 * 각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다.
 *
 * 각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
 *
 * 예제 입력
 * 7 1 2 3 4 5 6 7
 * 8 1 2 3 5 8 13 21 34
 * 0
 * 예제 출력
 * 1 2 3 4 5 6
 * 1 2 3 4 5 7
 * 1 2 3 4 6 7
 * 1 2 3 5 6 7
 * 1 2 4 5 6 7
 * 1 3 4 5 6 7
 * 2 3 4 5 6 7
 *
 * 1 2 3 5 8 13
 * 1 2 3 5 8 21
 * 1 2 3 5 8 34
 * 1 2 3 5 13 21
 * 1 2 3 5 13 34
 * 1 2 3 5 21 34
 * 1 2 3 8 13 21
 * 1 2 3 8 13 34
 * 1 2 3 8 21 34
 * 1 2 3 13 21 34
 * 1 2 5 8 13 21
 * 1 2 5 8 13 34
 * 1 2 5 8 21 34
 * 1 2 5 13 21 34
 * 1 2 8 13 21 34
 * 1 3 5 8 13 21
 * 1 3 5 8 13 34
 * 1 3 5 8 21 34
 * 1 3 5 13 21 34
 * 1 3 8 13 21 34
 * 1 5 8 13 21 34
 * 2 3 5 8 13 21
 * 2 3 5 8 13 34
 * 2 3 5 8 21 34
 * 2 3 5 13 21 34
 * 2 3 8 13 21 34
 * 2 5 8 13 21 34
 * 3 5 8 13 21 34
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-23   parkjungkwan  최초 생성
 */
public class 로또 {
    @Data
    @AllArgsConstructor
    static class Solution{

        private int num1;
        private String opcode;
        private int num2;
        @Override public String toString(){

            System.out.println("06 로또");
            String res = "";
            int[] lotto = new int[6];
            for (int i = 0; i < 6; i++) {
                lotto[i] = (int)(Math.random()*45) + 1;
                for (int j = 0; j < i; j++) {
                    if (lotto[i] == lotto[j])
                        i--;
                    break;
                }
            }
            for (int i = 0; i < 6; i++) {
                res += String.format(lotto[i] + " ");
            }
            System.out.println(res);
            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        로또.Solution solution(로또.Solution s);
    }
    @Test
    void testSolution(){

    }
}
