package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common.algorithm
 * fileName   : Frutes
 * author     : parkjungkwan
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-17   parkjungkwan  최초 생성
 */
public class 과일바구니 {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    static class Solution{
        private int total, apple, grape, orange;

        @Override
        public String toString() {
            return String.format("total: %d, apple: %d, grape: %d, orange: %d",
                    total, apple, grape, orange);
        }
    }
    @FunctionalInterface interface ISolution{
        Solution solution(Solution s);
    }
    @Test
    void test(){}
}