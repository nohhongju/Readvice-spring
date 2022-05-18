package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrimeNumber {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int start, end;
        List<Integer> primes;

        @Override
        public String toString() {
            return String.format("소수값: %d", primes);
        }
    }
    @FunctionalInterface private interface PrimeService{
        Solution solution(Solution solution);
    }
    @Test
    void testPrime(){

    }


}
