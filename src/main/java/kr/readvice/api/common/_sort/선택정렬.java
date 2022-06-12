package kr.readvice.api.common._sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * packageName: kr.scalar.api.common._sort
 * fileName   : SelectionSort
 * author     : parkjungkwan
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-23   parkjungkwan  최초 생성
 */
public class 선택정렬 {
    @Data
    @AllArgsConstructor
    static class Solution{

        private int num1;
        private String opcode;
        private int num2;
        @Override public String toString(){
            Random random = new Random();
            int[] arr = new int[100];
            for(int i = 0; i < arr.length - 1; i++) {
                int min_index = i;

                // 최솟값을 갖고있는 인덱스 찾기
                for(int j = i + 1; j < arr.length; j++) {
                    if(arr[j] < arr[min_index]) {
                        min_index = j;
                    }
                }
                // i번째 값과 찾은 최솟값을 서로 교환
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
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
