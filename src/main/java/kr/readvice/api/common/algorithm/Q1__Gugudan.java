package kr.readvice.api.common.algorithm;

import java.util.Random;
import java.util.Scanner;

/**
 * packageName: kr.scalar.api.common.step1
 * fileName   : MaxMin
 * author     : parkjungkwan
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-09   parkjungkwan  최초 생성
 */
public class Q1__Gugudan {
    public static void main(String[] args) { // 03소수 quiz03prime()
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1계산기 2Bmi 3주사위 4가위바위보 5윤년 \n" +
                    "6숫자추론 7로또 8예약 9입출금 10구구단 \n" +
                    "11큰숫자게임 12야구");
            switch (scanner.next()){
                case "1": calc(); break;
                case "2": bmi(); break;
                case "3": dice(); break;
                case "4": rps(); break;
                case "5": leap(); break;
                case "6": guess(); break;
                case "7": lotto(); break;
                case "8": booking(scanner); break;
                case "9": bank(scanner); break;
                case "10": gugudan(); break;
                case "11": playNumberGameWithComputer(); break;
                case "12": baseball(scanner); break;
                default:return;
            }
        }
    } // main
    static void calc(){

    }

    static void bmi(){

    }
    static void dice(){
        System.out.println("01 주사위");
        // 홀수나올때까지 주사위굴려 합하는 프로그래밍
        // Random random = new Random();
        Random random = new Random();
        int result = 0;
        while(true) {
            int r = random.nextInt(5)+1;
            System.out.println(" dice value : "+ r);
            if(r % 2 != 0) {
                break;
            }
            result += r;
        }
        System.out.println(result);
        // 6면인 주사위를 5회 굴려서 나온 합계를 구하시오.
        // (int) (Math.random() * 최댓값) + 최솟값
        result = 0;
        for(int i=0; i<5; i++) {
            double d = Math.random();
            int temp = (int) (d * 6) +1;  // 랜덤으로 (1-6) 정수값
            System.out.println(temp);
            result += temp;
        }
        System.out.println("Sum : "+result);
        // 플레이어(Math 랜덤값)와 컴퓨터(Random 랜덤값) 주사위 굴리기를 해 이기면
        // "Win", 비기면 "Draw.", 지면 "Lose"를 출력하세요.
        int player=(int)(Math.random()*6)+1;
        System.out.println("플레이어 숫자"+player);
        int com= new Random().nextInt(5)+1;
        System.out.println("컴퓨터 숫자"+com);
        String s = "Draw";
        if(player!=com) s = (player>com) ? "Win" : "Lose";
        System.out.println(s);
    }
    static void rps(){
        System.out.println("02 가위바위보");
        System.out.println(" ----------- 1 -------------");
        int a = (int)(Math.random()*3)+1;
        int b = (int)(Math.random()*3)+1;
        System.out.println((a == b) ? "Draw" : (b > (a+1)%3) ? "Win":"lose");
        System.out.println(" ----------- 2 -------------");
        a = (int)(Math.random()*3)+1;
        b = (int)(Math.random()*3)+1;
        System.out.println(a);
        System.out.println(b);
        String s = "";
        if (a == b) s= "Draw";
		/*
		 2%3 2 3
		 3%3 0 1
		 1%3 1 2
		 * */
        else s = (b > (a+1)%3) ? "Win":"lose";
        System.out.println(s);
        System.out.println(" ----------- 3 -------------");
        String[] arr = {"가위", "바위", "보", "Draw", "Win", "Lose"};
        int[] arr2 = new int[2];
        for(int i =0 ; i<arr2.length; i++) arr2[i] = (int)(Math.random()*3)+1;
        int p = arr2[0], c = arr2[1];
        System.out.printf("Player : %s %d\n",arr[p-1], p);
        System.out.printf("Computer : %s %d\n",arr[c-1], c);
        int i = 3;
        switch(Math.abs(p - c)) {
            case 1: i = (p > c) ? 5 : 4;
            case 2: i = (p > c) ? 4 : 5;
            default: break;
        }
        System.out.printf("Player: %s", arr[i]);
    }
    static void leap(){
        System.out.println("04 윤년");
        //윤년은 해당년도가 4로 나눈 나머지값이 0인것이다. (i%4==0)
        //그리고(and==>&&) 100으로 나눈 나머지값이 0인것은 윤년에서 제외되며(부정[default값 반대=!](i%100!=0)
        //또는(or==>||)400으로 나눈값은 윤년(i%400==0)
        Scanner scanner = new Scanner(System.in);
        System.out.println("연도를 입력해주세요!");
        int i = scanner.nextInt();
        String s;
        if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            s = "윤년";
        } else
            s = "평년";
        System.out.println(String.format("%d는 %s입니다.", i, s));
    }
    static void guess(){
        System.out.println("05 숫자추론");
        Scanner scanner = new Scanner(System.in);
        int rand = (int)(Math.random()*100) + 1;
        String res = "";
        System.out.println("임의로 입력받은 숫자 맞추기");
        while (true) {
            System.out.print("예상 숫자를 입력하세요 : ");
            int num = scanner.nextInt();
            if (rand == num) {
                res = "정답입니다";
                System.out.println(String.format(res));
            } else if (rand < num) {
                System.out.println("임의의 숫자가 더 작습니다.");
            } else{
                System.out.println("임의의 숫자가 더 큽니다.");
            }
        }
    }
    static void lotto(){
        System.out.println("06 로또");
        Random rand = new Random();
        String res = "";
        int[] lotto = new int[6];
        for (int i = 0; i < 6; i++) {
            lotto[i] = (int)(Math.random()*45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j])
                    i--;
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            res += String.format(lotto[i] + " ");
        }
        System.out.println(res);
    }
    static void booking(Scanner scanner){
        System.out.println("07 예약");
        // 1. 배열을 이용하여 간단한 극장 예약시스템 작성
        // 2. 아주 작은 극장이라 좌석이 10개만  됨.
        // 3. 먼저 좌석 배치표를 보여주고 예약이 끝나면 1로
        // 4. 예약이 안된 좌석은 0으로 나타내라.

        int seat[] = new int[10];
        int rserved;

        while (true) {
            System.out.println("좌석을 예약하시겠습니까? (1또는 0)");
            int q = scanner.nextInt();

            if (q == 0) break;
            System.out.println("현재의 예약상태는 다음과 같습니다.");
            System.out.println("===");
            for (int i = 0; i < 10; i++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
            for (int i : seat)
                System.out.print(i + " ");
            System.out.println();
            System.out.println("몇 번째 좌석을 에약하시겠습니까?");
            rserved = scanner.nextInt();
            seat[rserved - 1] = 1;
            System.out.println("예약되었습니다.");
        }
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
    static void bank(Scanner scanner){
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
        int password = scanner.nextInt();
        while (true) {
            System.out.println("사용하실 메뉴를 선택해주세요.\n" +
                    "0.잔액조회 1.현금인출 2.입금 3.종료\n메뉴 선택: ");
            select = scanner.nextInt();
            if (select == 3) break;
            else if (select >= 0 && select < 3) {
                while (true) {
                    System.out.print("비밀번호를 입력하세요 : ");
                    pw = scanner.nextInt();
                    if (password == pw) {
                        switch (select) {
                            case 0:
                                System.out.println(String.format("고객님의 잔액은 %d입니다.", total));
                                break;
                            case 1:
                                System.out.println("인출하실 금액을 선택하세요." +
                                        "0. 만원 1. 5만원 2. 10만원 3.20만원 4.50만원 5.직접입력");
                                switch (scanner.nextInt()) {
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
                                        output = scanner.nextInt();
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
                                input = scanner.nextInt();
                                total=total+input;
                                System.out.println(String.format("입금하신금액은 %d이며 잔액은 %d입니다.", input, total));
                                break;

                            case 3:
                                System.out.println("EXIT");
                                return;

                        }
                        break;
                    }
                    else{
                        System.out.println("비밀번호를 잘못입력하였습니다.");
                    }
                }
            }
        }

    }
    static void gugudan(){
        System.out.println("09 구구단");
        System.out.println(" --------- 1 --------------");
        for(int k = 2; k < 10; k+=4) {
            for (int i = 1; i < 10; i++) {
                for (int j = k; j < k+4; j++) {
                    System.out.print(j + "*" + i+ "=" +(j*i)+"\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(" --------- 2 --------------");
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 6; j++) {
                System.out.print(j + "*" + i+ "=" +(j*i)+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 2; i < 10; i++) {
            for (int j = 6; j < 10; j++) {
                System.out.print(j + "*" + i+ "=" +(j*i)+"\t");
            }
            System.out.println();
        }
        System.out.println(" --------- 3 --------------");
        /*
        for(i 1 10 1)
        for(j 2 6 1)
        j * i = j * i
        for(i 1 10 1)
        for(j 6 10 1)
        j * i = j * i
        에서 같은 구문이 반복되므로, 다시 for 를 사용한다.
        for(k 2, 10, 4)
        for(i 1, 10, 1)
        for(j k, k+4, 1)
        j * i = (j * i)
         * */
        for (int dan = 2; dan < 10; dan += 4) { //구구단은 2단부터 시작.
            for (int i = 1; i <= 9; i++) { // 1 ~ 9 까지 곱이 나오도록 조건잡기
                for (int j = dan; j < dan + 4; j++) {
                    System.out.print(j + "*" + i + "=" + (j * i) + "\t");
                }
                System.out.print("\n"); // 4개씩 출력 되어야 하므로 j*i 값 4개가 출력된 후 엔터
            }
            System.out.println("\n"); //4개의 단(2단~5단)이 모두 출력 된 후, 엔터
        }
    }
    static void playNumberGameWithComputer() {
        Random random = new Random();
        double d = Math.random();
        int player = (int) (d * 6) + 1;
        System.out.println("플레이어 숫자 : " + player);
        int com = random.nextInt(5) + 1;
        System.out.println("컴퓨터 숫자 : " + com);
        String s = "Draw";
        if (player != com) s = (player > com) ? "Win." : "Lose.";
        System.out.println(s);

    }
    static void baseball(Scanner scanner) {
        int com1 = (int)(Math.random()*9)+1;
        int com2 = (int)(Math.random()*9)+1;
        while(com1==com2) {
            com2 = (int)(Math.random()*9)+1;
        }
        int com3 = (int)(Math.random()*9)+1;
        while(com1==com3||com2==com3) {
            com3 = (int)(Math.random()*9)+1;
        }
        System.out.println(com1 + " " + com2 + " " + com3);

        Scanner sc = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        int strike = 0;
        int ball = 0;
        int out = 0;

        while(strike != 3) {
            System.out.println("user> 숫자 세 개를 입력하세요.");

            strike = 0;      //돌려줄 때마다 매번 초기화 필요
            ball = 0;
            out = 0;

            num1 = sc.nextInt();
            num2 = sc.nextInt();
            num3 = sc.nextInt();
            if(com1 == num1) {
                strike += 1;
            }else if(com1 == num2 || com1 == num3){
                ball += 1;
            }
            else {
                out+=1;
            }
            if(com2 == num2) {
                strike += 1;
            }else if(com2 == num1 || com2 == num3) {
                ball += 1;
            }
            else {
                out+=1;
            }
            if(com3 == num3) {
                strike += 1;
            }else if(com3 == num1 || com3 == num2) {
                ball += 1;
            }
            else {
                out+=1;
            }

            System.out.println("Strike : " + strike + ", Ball : " + ball + ", Out : " + out);

        }

    }

}