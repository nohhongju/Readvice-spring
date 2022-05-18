package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CheckSameArray {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int[] result;

        @Override
        public String toString() {
            return String.format("", result);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution solution);
    }
    @Test
    void test(){
        int[] arr1={1, 3, 2};
        int[] arr2={2, 3, 1};
    }

}
