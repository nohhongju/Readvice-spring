package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class MaxMin { // 그리디
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    private static class Solution{
        private int[] arr;
        private int max, min;

        @Override
        public String toString() {
            return String.format("최소값: %d, 최대값: %d", min, max);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){
        int[] arr = {3, 1, 9, 5, 10};
        /**
         SolutionService f = e -> {
            int max = 0;
            int min = 10;
            for(int i : e.getArr()){
                if(i>max)max = i;
                if(i<min)min = i;
         }
         */
        SolutionService f = e -> {
            int max = 0;
            for(int i : e.getArr()){
                if(i>max)max = i;}
            int min = max;
            for(int i : e.getArr()){
                if(i<min)min = i;
            }
            return Solution.builder().min(min).max(max).build();
        };
        Solution s = Solution.builder().arr(arr).build();
        System.out.println(f.solution(s));
    }
}
