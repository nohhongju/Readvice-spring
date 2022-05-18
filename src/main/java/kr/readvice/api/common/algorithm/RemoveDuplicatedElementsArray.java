package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RemoveDuplicatedElementsArray {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int[] arr;
        private int[] result;

        @Override
        public String toString() {
            return String.format("");
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution solution);
    }
    @Test
    void testSolution(){}
}
