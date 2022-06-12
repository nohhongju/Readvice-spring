package kr.readvice.api.common._sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common._sort
 * fileName   : 가장큰수
 * author     : parkjungkwan
 * date       : 2022-05-24
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-24   parkjungkwan  최초 생성
 */
public class 가장큰수 {
    @Data
    @AllArgsConstructor
    static class Solution{

        @Override public String toString(){


            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){

    }
}
