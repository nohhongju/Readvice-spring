package kr.readvice.api.common.algorithm;

import kr.readvice.api.common.streams.PersonStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Fruits {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int total, apple, grape, orange;

        @Override
        public String toString() {
            return String.format("총합: %d, 사과평균: %d, 포도평균: %d, 오렌지평균: %d", total);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){
        int[][] arr = {{10000, 20000, 12000},
                        {8000, 3000, 15000},
                        {20000, 15000, 38000},
                        {13000, 20000, 30000},
                        {30000, 12000, 20000},
                        {35000, 30000, 25000},
                        {50000, 23000, 10000}
        };
//        SolutionService f = e -> {};
        Solution solution = Solution.builder().build();
//        f.solution(solution);
    }
}
