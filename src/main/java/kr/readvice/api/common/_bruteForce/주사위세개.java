package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * packageName: kr.scalar.api.common._bruteForce
 * fileName   : Dice
 * author     : parkjungkwan
 * date       : 2022-05-23
 * desc       : 백준 알고리즘
 * 주사위 세개
 * - 문제
 * 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
 *
 * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
 * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
 * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
 * 예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
 *
 * 3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.
 *
 * - 입력
 * 첫째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.
 *
 * - 출력
 * 첫째 줄에 게임의 상금을 출력 한다.
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-23   parkjungkwan  최초 생성
 */
public class 주사위세개 {
    @Data
    @AllArgsConstructor
    static class Solution{

        private int num1;
        private String opcode;
        private int num2;
        @Override public String toString(){

            System.out.println("01 주사위");
            // 홀수나올때까지 주사위굴려 합하는 프로그래밍
            // Random random = new Random();
            Random random = new Random();
            int result = 0;
            while(true) {
                int r = random.nextInt(5)+1;
                System.out.println(" dice value : "+ r);
                if(r % 2 != 0) {
                    break;
                }
                result += r;
            }
            System.out.println(result);
            // 6면인 주사위를 5회 굴려서 나온 합계를 구하시오.
            // (int) (Math.random() * 최댓값) + 최솟값
            result = 0;
            for(int i=0; i<5; i++) {
                double d = Math.random();
                int temp = (int) (d * 6) +1;  // 랜덤으로 (1-6) 정수값
                System.out.println(temp);
                result += temp;
            }
            System.out.println("Sum : "+result);
            // 플레이어(Math 랜덤값)와 컴퓨터(Random 랜덤값) 주사위 굴리기를 해 이기면
            // "Win", 비기면 "Draw.", 지면 "Lose"를 출력하세요.
            int player=(int)(Math.random()*6)+1;
            //int p = random(1,6);
            System.out.println("플레이어 숫자"+player);
            int com= new Random().nextInt(5)+1;
            System.out.println("컴퓨터 숫자"+com);
            String s = "Draw";
            if(player!=com) s = (player>com) ? "Win" : "Lose";
            System.out.println(s);
            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        주사위세개.Solution solution(주사위세개.Solution s);
    }
    @Test
    void testSolution(){

    }
}
