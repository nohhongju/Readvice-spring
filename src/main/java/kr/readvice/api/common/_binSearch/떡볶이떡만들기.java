package kr.readvice.api.common._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName: kr.scalar.api.common._binSearch
 * fileName   : 떡볶이떡만들기
 * author     : parkjungkwan
 * date       : 2022-05-24
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-24   parkjungkwan  최초 생성
 */
public class 떡볶이떡만들기{
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private int[] NM, dduckHeight;
        private int answer;
        @Override
        public String toString() {
            return String.format("떡의 갯수 : %d\n" +
                    "요청한 떡의 길이 : %d\n" +
                    "떡의 개별 높이 : %s\n" +
                    "기대값 : %d", NM[0], NM[1], Arrays.toString(dduckHeight), answer);
        }
    }

    @FunctionalInterface
    private interface SolutionService<T, R> {
        R solution(T t);
    }
    static class Service{
        SolutionService<Solution, Solution> f = e -> {
            e.answer = 0;
            for(int i: e.dduckHeight){
                if (i<e.answer)e.answer=i;
            }
            return Solution.builder()
                    .NM(e.getNM())
                    .dduckHeight(e.getDduckHeight())
                    .answer(e.getAnswer())
                    .build();
        };
    }

    @Test
    void testSolution() {
        int[] NM = {4, 6};
        int[] dduckHeight = {19, 15, 10, 17};

        Solution s = Solution.builder()
                .NM(NM)
                .dduckHeight(dduckHeight)
                .build();
        System.out.println(new Service().f.solution(s));
    }

}

