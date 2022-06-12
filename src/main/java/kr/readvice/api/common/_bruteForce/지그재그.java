package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common._bruteForce
 * fileName   : 지그재그2
 * author     : parkjungkwan
 * date       : 2022-05-25
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-25   parkjungkwan  최초 생성
 */
public class 지그재그 {
    @Data
    @AllArgsConstructor
    static class Solution{


        @Override public String toString(){
            String res = "";
            int count = (int)(Math.random() * 100);
            int [][]arr = new int[count][count];
            int temp = 1;
            System.out.println(count + " 로 지그재그 만들기");
            for(int i = 0; i < count; i ++){
                if(i % 2 == 0){
                    for(int j = 0; j < count; j++){
                        arr[i][j] = temp;
                        temp ++;
                    }
                }else
                    for(int j = count - 1; j >= 0 ; j--){
                        arr[i][j] = temp;
                        temp ++;
                    }
            }
            for(int i = 0 ; i < count; i ++){
                for(int j = 0; j < count; j++){
                    res += String.format("%3d" + " ",arr[i][j]);
                }
                res += String.format("\n");
            }

            System.out.println(res);

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
