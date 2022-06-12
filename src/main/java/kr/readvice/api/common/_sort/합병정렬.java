package kr.readvice.api.common._sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common._sort
 * fileName   : MergeSort
 * author     : parkjungkwan
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-23   parkjungkwan  최초 생성
 */
public class 합병정렬 {
    @Data
    @AllArgsConstructor
    static class Solution{

        static void merge ( int[] arr, int left, int right){
            int[] tmp = new int[arr.length]; // 배열의 값을 잠시 복사해둘 공간에 새로운 인덱스값의 길이를 생성한다.

            if (left < right) { // 왼쪽이 오른쪽보다 작을 때
                int mid = (left + right) / 2; // 중앙을 기준으로 2개의 그룹으로 분할
                merge(arr, left, mid);
                merge(arr, mid + 1, right); // 재귀
                int leftIndex = left; // 왼쪽 그룹의 시작 인덱스
                int midIndex = mid + 1; // 오른쪽 그룹의 시작 인덱스
                int idx = leftIndex; // 인덱스값은 leftIndex,
                while (leftIndex <= mid || midIndex <= right) { // 왼쪽 인덱스값이 중앙보다 작을때 or
                    // 중앙 인덱스값이 오르쪽보다 작을 때 ( 정렬 & 합병 )
                    if (midIndex > right || (leftIndex <= mid && arr[leftIndex] < arr[midIndex])) {
                        // 중앙 인덱스값이 오른쪽보다 클 때 or (왼쪽인덱스값이 중앙보다 작을 때 and leftIndex 배열값이 midIndex 배열값보다
                        //작을 때 )
                        tmp[idx++] = arr[leftIndex++];//  idx = y   leftIndex = x
                        //   tmp[y] = arr[x]
                        // idx =y+ 1   leftIndex x+1
                        // 참고로 i++ 과 ++i 의 차이점 이해하면 조금 더 낫다.
                    } else {
                        tmp[idx++] = arr[midIndex++];
                    }
                } // 왼쪽 그룹의 원소가 남는 경우 처리
                // 오른쪽 그룹의 원소가 남는 경우는 따로 처라하지 않아도 됨.
                for (int i = left; i <= right; i++) {
                    arr[i] = tmp[i];
                }
            }
        }
        static int[] creatArr(){
            int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 + 1);
            }//생성
            return arr;
        }
        @Override public String toString(){
            //5번
            // 랜덤 정수 ( 1 ~ 100) 사이의 10 개 정수 정렬
            //int[] arr = creatArr();
            int[] arr = creatArr(); // 인트 배열을 CreateArr 메소드를 통해 생성한다.
            // public int[] creatArr(){int[] arr = new int[10];
            // for ( int i = 0; i < arr.length; i++) { arr [i] = (int) (Math.random()*100 + 1);
            // 을 계속 반복하는 대신에 int[] arr = creatArr(); 로 간결하게 코딩한다.
            merge(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(" ");
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
