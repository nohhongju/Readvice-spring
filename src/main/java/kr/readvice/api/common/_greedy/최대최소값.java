package kr.readvice.api.common._greedy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common.algorithm
 * fileName   : MaxMin
 * author     : parkjungkwan
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-17   parkjungkwan  최초 생성
 */
public class 최대최소값 {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        private int[] arr;
        private int max, min;
        @Override
        public String toString() {
            return String.format("최소값: %d, 최대값: %d", min, max);
        }
    }
    @FunctionalInterface
    public interface SolutionService {
        Solution solution(Solution s);
    }
    class Service {
        Solution test(Solution s){
            SolutionService f = e ->{
                int min = 10;
                for(int i : e.getArr()){
                    if(i < min) min = i;
                }
                return Solution.builder().min(min).build();
            };
            return f.solution(s);
        }
    }
    @Test
    void testSolution(){
        int[] arr = {3, 1, 9, 5, 10};
        Solution s = Solution.builder().arr(arr).build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }
}
