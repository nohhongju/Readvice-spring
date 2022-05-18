package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class Gugudan { // 그리디 , 그래프
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int[][] arr;
    }
        @FunctionalInterface private interface ISolution{
            void solution();
        }
        @Test
        void test(){
            ISolution is = () -> {

            };
            is.solution();
        }
}
