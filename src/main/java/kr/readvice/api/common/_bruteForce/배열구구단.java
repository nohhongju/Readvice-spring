package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * packageName: kr.scalar.api.common.algorithm
 * fileName   : Gugudan
 * author     : parkjungkwan
 * date       : 2022-05-17
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-17   parkjungkwan  최초 생성
 */
public class 배열구구단 {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    static class Solution{
        private int num ;
        private String result;
        @Override
        public String toString() {
            return result ;
        }
    }
    @FunctionalInterface interface ISolution{ Solution solution(Solution s);}
    @FunctionalInterface interface IMinseoGugudan{ void solution();}
    @FunctionalInterface interface IJinyoungGugudan{ Solution solution(Solution s);}
    @FunctionalInterface interface IHyungukGugudan{ void solution();}
    static class Service{
        static IMinseoGugudan iMinseo = ()-> {
            for (int dan = 2; dan < 10; dan += 4) { //구구단은 2단부터 시작.
                for (int i = 1; i <= 9; i++) { // 1 ~ 9 까지 곱이 나오도록 조건잡기
                    for (int j = dan; j < dan + 4; j++) {
                        System.out.print(j + "*" + i + "=" + (j * i) + "\t");
                    }
                    System.out.print("\n"); // 4개씩 출력 되어야 하므로 j*i 값 4개가 출력된 후 엔터
                }
                System.out.println("\n"); //4개의 단(2단~5단)이 모두 출력 된 후, 엔터
            }
        };
        static IJinyoungGugudan iJinyoung = e -> {
            String result = "";
            for(int k = 2; k <= e.getNum(); k+=4) {
                for (int i = 1; i <= e.getNum(); i++) {
                    for (int j = k; j < k+4; j++) {
                        result +=  j + "*" + i+ "=" +(j*i)+"\t";
                    }
                    result += '\n';
                }
                result += '\n';
            }
            return Solution.builder().result(result).build();
        };
        static ISolution iSolution = e ->{
            int[][] arr = new int[e.getNum()][e.getNum()];
            String result = "";
            for(int i=0; i< arr.length-1; i++){
                for(int j=0; j< arr[i].length; j++){
                    arr[i][j] = (i+2) * (j+1);
                    result += String.format("%d * %d = %d\n", i+2, j+1, arr[i][j]);
                }
                result += '\n';
            }
            return Solution.builder().result(result).build();
        };
        static IHyungukGugudan iHyunguk = () ->{
            IntStream.rangeClosed(2,9).forEach(i->{
                IntStream.rangeClosed(1,9).forEach(j->{
                    System.out.print(i + "*" + j + "=" + String.format("%2d",i * j));
                    System.out.print("   ");
                });
                System.out.println();
            });
        };
    }
    @Test
    void test(){
        // 기본형 구구단
        // Service.iMinseo.solution();
        // 이차원배열. 구구단 정렬 무시
        // System.out.println(Service.iSolution.solution(Solution.builder().num(19).build()));
        // 책받침 구구단 
        // System.out.println(Service.iJinyoung.solution(Solution.builder().num(19).build()));
        // 람다 구구단
        Service.iHyunguk.solution();
    }




}
