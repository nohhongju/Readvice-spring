package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common.algorithm
 * fileName   : CheckSameArray
 * author     : parkjungkwan
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-17   parkjungkwan  최초 생성
 */
public class 동일배열판별 {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Solution{
        private String result;

        @Override
        public String toString() {
            return String.format("A배열과 B배열은 %s 배열입니다",
                    result);
        }
    }
    @FunctionalInterface interface ISolution{
        Solution solution(Solution s);
    }
    @Test
    void test(){}
}
