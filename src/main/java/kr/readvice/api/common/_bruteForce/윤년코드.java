package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * packageName: kr.scalar.api.common._bruteForce
 * fileName   : LeapYear
 * author     : parkjungkwan
 * date       : 2022-05-23
 * desc       : 자바 윤년 계산 알고리즘 (백준 2753번 윤년 코드)
 * * 윤년이란?
 *
 * 지구가 태양을 한 번 공전하는 데 걸리는 시간을 일 년으로 두었는데, 사실은 그 시간이 365일이 아닌 365일 5시간 49분 가량이다.
 * 일 년에 5시간 49분씩 4 년이 지나면 약 하루가 되는데, 이를 맞추기 위해 4 년마다 한 번씩 2월을 하루 늘리고 이를 윤년이라 한다.
 * 단, 이렇게 계산하게 되면 매년 11분 가량이 초과되어 계산된다.
 * 는 131년이 지나면 하루(대략 400년에 3일)가 되기 때문에 대부분의 국가에서 반영하는 그레고리력에서는
 * 400년에 3일을 제외시키기 위해 100년마다 한 번 윤년을 없애고 400년 마다 다시 하루를 추가해 윤년을 둔다.
 * 정리하면 다음과 같은 방법으로 윤년을 계산할 수 있다.
 * ☞ 연도가 4로 나누어 떨어지면 윤년이다. ex) 2020년, 2024년, 2028년, ...
 * ☞ 연도가 100으로 나누어 떨어지면 윤년이 아니다. ex) 2100년, 2200년, 2300년, ...
 * ☞ 연도가 400으로 나누어 떨어지면 윤년이다. ex) 2000년, 2400년, 2800년, ...
 * 예를 들면 2000년은 100의 배수이지만 400으로 나누어 떨어지기 때문에 윤년이다.
 * 이를 알면 조건문을 활용하여 코드화하는 것은 쉽다. 두 가지 알고리즘을 생각해보았다.
 * 알고리즘 1) 4로 나누어 떨어지면 우선 윤년으로 판단하고, 그 중 400이 아닌 100으로만 나누어 떨어지는 경우를 평년으로 판단한다.
 * 알고리즘 2) 주어진 연도가 400으로 나누어 떨어지면 윤년으로 판단하고 종료한다.
 * 아닐 경우 100으로 나누어 떨어지면 평년으로 판단하고 종료한다.
 * 그것도 아닐 경우 4로 나누어 떨어지면 윤년으로 판단하고 종료한다.
 * 이 외의 모든 케이스는 평년이다.
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-23   parkjungkwan  최초 생성
 */
public class 윤년코드 {
    @Data
    @AllArgsConstructor
    static class Solution{

        @Override public String toString(){

            System.out.println("04 윤년");
            //윤년은 해당년도가 4로 나눈 나머지값이 0인것이다. (i%4==0)
            //그리고(and==>&&) 100으로 나눈 나머지값이 0인것은 윤년에서 제외되며(부정[default값 반대=!](i%100!=0)
            //또는(or==>||)400으로 나눈값은 윤년(i%400==0)
            Scanner scanner = new Scanner(System.in);
            System.out.println("연도를 입력해주세요!");
            int i = scanner.nextInt();
            String s;
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                s = "윤년";
            } else
                s = "평년";
            System.out.println(String.format("%d는 %s입니다.", i, s));
            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        윤년코드.Solution solution(윤년코드.Solution s);
    }
    @Test
    void testSolution(){

    }
}
