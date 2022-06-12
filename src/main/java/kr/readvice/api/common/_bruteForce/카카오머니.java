package kr.readvice.api.common._bruteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common._bruteForce
 * fileName   : 카카오머니
 * author     : parkjungkwan
 * date       : 2022-05-25
 * desc       : https://www.acmicpc.net/problem/15998
 *
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-25   parkjungkwan  최초 생성
 */
public class 카카오머니 {
    @Data
    @AllArgsConstructor
    static class Solution{

        private int num1;
        private String opcode;
        private int num2;
        @Override public String toString(){
            System.out.println("08 입출금");
            int select = 0;
            int total = 200000;//잔액
            int output = 0;//출금
            int input = 0;//입금
            int pw = 0;//비밀번호
            int m = 10000;
            int m5 = 50000;
            int m10 = 100000;
            int m20 = 200000;
            int m50 = 500000;

            System.out.print("사용하실 비밀번호를 입력하세요 : ");
            int password = 0;
            while (true) {
                System.out.println("사용하실 메뉴를 선택해주세요.\n" +
                        "0.잔액조회 1.현금인출 2.입금 3.종료\n메뉴 선택: ");
                select = 0;
                if (select == 3) break;
                else if (select >= 0 && select < 3) {
                    while (true) {
                        System.out.print("비밀번호를 입력하세요 : ");
                        pw = 0;
                        if (password == pw) {
                            switch (select) {
                                case 0:
                                    System.out.println(String.format("고객님의 잔액은 %d입니다.", total));
                                    break;
                                case 1:
                                    System.out.println("인출하실 금액을 선택하세요." +
                                            "0. 만원 1. 5만원 2. 10만원 3.20만원 4.50만원 5.직접입력");
                                    switch (2) {
                                        case 0:
                                            if (total >= m) {
                                                total = total - m;
                                                System.out.println(String.format("%d가 출금되었고 잔액은 %d입니다.", m, total));
                                            } else if (total < m) {
                                                System.out.println("잔액이 부족합니다.");
                                            }
                                            break;
                                        case 1:
                                            if (total >= m5) {
                                                total = total - m5;
                                                System.out.println(String.format("%d가 출금되었고 잔액은 %d입니다.", m5, total));
                                            } else if (total < m5) {
                                                System.out.println("잔액이 부족합니다.");
                                            }
                                            break;
                                        case 2:
                                            if (total >= m10) {
                                                total = total - m10;
                                                System.out.println(String.format("%d가 출금되었고 잔액은 %d입니다.", m10, total));
                                            } else if (total < m10) {
                                                System.out.println("잔액이 부족합니다.");
                                            }
                                            break;
                                        case 3:
                                            if (total >= m20) {
                                                total = total - m20;
                                                System.out.println(String.format("%d가 출금되었고 잔액은 %d입니다.", m20, total));
                                            } else if (total < m20) {
                                                System.out.println("잔액이 부족합니다. 다시입력해주세요.");
                                            }
                                            break;
                                        case 4:
                                            if (total >= m50) {
                                                total = total - m50;
                                                System.out.println(String.format("%d가 출금되었고 잔액은 %d입니다.", m50, total));
                                            } else if (total < m50) {
                                                System.out.println("잔액이 부족합니다. 다시입력해주세요.");
                                            }
                                            break;
                                        case 5:
                                            System.out.println("인출금액을 입력해주세요.");
                                            output = 0;
                                            if (total < output) {
                                                System.out.println("잔액이 부족합니다.");
                                            } else if (total >= output) {
                                                total = total - output;
                                                System.out.println(String.format("%d가 출금되었고 잔액은 %d입니다.", output, total));
                                            }
                                            break;
                                        default:
                                            System.out.println("올바른 번호를 입력해주세요.");
                                            break;
                                    }
                                case 2:
                                    System.out.println("입금하실 금액을 입력하세요.");
                                    input = 0;
                                    total=total+input;
                                    System.out.println(String.format("입금하신금액은 %d이며 잔액은 %d입니다.", input, total));
                                    break;



                            }
                            break;
                        }
                        else{
                            System.out.println("비밀번호를 잘못입력하였습니다.");
                        }
                    }
                }
            }
            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        카카오머니.Solution solution(카카오머니.Solution s);
    }
    @Test
    void testSolution(){

    }
}
