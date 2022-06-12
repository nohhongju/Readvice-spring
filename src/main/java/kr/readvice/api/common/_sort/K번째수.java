package kr.readvice.api.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName: kr.scalar.api.common._sort
 * fileName   : K번째수
 * author     : parkjungkwan
 * date       : 2022-05-24
 * desc          :  https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
 *      K 번째 수.
 *      배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *      예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 *      array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 *      1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 *      2에서 나온 배열의 3번째 숫자는 5입니다.
 *      배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 *      commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때
 *      나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 *      입출력 예
 *      array                   commands                           return
 *      [1, 5, 2, 6, 3, 7, 4]   [[2, 5, 3], [4, 4, 1], [1, 7, 3]]   [5, 6, 3]

 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-24   parkjungkwan  최초 생성
 */



public class K번째수 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution{
        private int[] array, aReturn;
        private int[][] commands;

        @Override
        public String toString(){
            return String.format("array : %s\n" +
                            "commands : %s\n" +
                            "실행 결과 : %s",
                    Arrays.toString(array), Arrays.deepToString(commands), Arrays.toString(aReturn));
        }
    }
    @FunctionalInterface private interface SolutionService<T, R>{
        R solution(T t);
    }
    static class Service{
        Solution test(Solution s){
            SolutionService<Solution, Solution> f = e -> {
                int[] answer = new int[e.getCommands().length];
                int index2 = 0;
                for (int[] command: e.getCommands()){
                    int a = command[0];
                    int b = command[1];
                    int c = command[2];
                    int[] array = new int[b-a+1];
                    int index = 0;
                    for (int i = a-1; i<b; i++){
                        array[index++] = e.getArray()[i];
                    }
                    Arrays.sort(array);
                    answer[index2++] = array[c-1];
                    System.out.println(Arrays.toString(array));
                }

                /**
                 * 1. command에 0번째 엘리먼트의 0번, 1번 값을 추출해서 어레이에 적용하고, 0,1번 만큼 슬라이싱
                 * 2. arrary.sort
                 * 3. 정렬된 배열에서 command 3번값에 해당하는 인덱스값 추출
                 * */

                return Solution.builder()
                        .array(e.getArray())
                        .commands(e.getCommands())
                        .aReturn(answer)
                        .build();
            };
            return f.solution(s);
        }
    }
    @Test
    void testSolution(){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution s = Solution.builder()
                .array(array)
                .commands(commands)
                .build();

        System.out.println(new Service().test(s));
    }
}