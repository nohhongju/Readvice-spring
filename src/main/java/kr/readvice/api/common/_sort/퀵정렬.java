package kr.readvice.api.common._sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common._sort
 * fileName   : QuickSort
 * author     : parkjungkwan
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-23   parkjungkwan  최초 생성
 */
public class 퀵정렬 {
    @Data
    @AllArgsConstructor
    static class Solution{

        static void quickSort(int[] arr,int start,int end){
            int part = partition(arr,start,end);
            if(start <part-1) quickSort(arr,start,part-1);
            if(end > part) quickSort(arr,start,part-1);

        }
        static int partition(int[] arr,int start,int end) {
            int pivot=arr[(start+end)/2];
            while(start<=end) {
                while(arr[start]<pivot) start++;
                while(arr[end]>pivot) end--;
                if(start<=end) {
                    swap(arr,start,end);
                    start++;
                    end--;
                }
            }
            return start;
        }
        static void swap(int[] arr,int start,int end) {
            int tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            return;
        }

        @Override public String toString(){
            quickSort(null,0,10);
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
