package kr.readvice.api.common.algorithm;

import java.util.Random;
import java.util.Scanner;
/**
 * packageName: kr.scalar.api.common.algo01
 * fileName   : Quiz10
 * author     : parkjungkwan
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-09   parkjungkwan  최초 생성
 */
public class Q2__Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1버블 2삽입 3선택 4퀵 5병합 6매직 7지그재그 8직각별 9정삼각별");
            switch (scanner.next()){
                case "1": bubbleSort(); break;
                case "2": insertionSort(); break;
                case "3": selectionSort(); break;
                case "4": quickSort(null,0,10); break;
                case "5": mergeSort(scanner); break;
                case "6": magicSquare (); break;
                case "7": zigzag(); break;
                case "8": rectangleStarPrint(); break;
                case "9": triangleStarPrint (); break;
            }
        }
    } // main
    static void bubbleSort(){
        Random random = new Random();
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++) {

            for(int j = 0 ; j < arr.length - i - 1 ; j++) {

                if(arr[j] > arr[j+1]) {

                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        print(arr);
    }
    static void insertionSort(){
// 랜덤 정수 ( 1 ~ 100) 사이의 10 개 정수 정렬
        Random random = new Random();
        int[] arr = new int[100];
        for(int i = 1; i < arr.length; i++) {
            // 타겟 넘버
            int target = arr[i];

            int j = i - 1;

            // 타겟이 이전 원소보다 크기 전 까지 반복
            while(j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];   // 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }

            /*
             * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
             * 타겟 원소는 j번째 원소 뒤에 와야한다.
             * 그러므로 타겟은 j + 1 에 위치하게 된다.
             */
            arr[j + 1] = target;
        }
        print(arr);
    }
    static void selectionSort(){
// 랜덤 정수 ( 1 ~ 100) 사이의 10 개 정수 정렬
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
        print(arr);
    }
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
    static void mergeSort(Scanner scanner){
        {//5번
            // 랜덤 정수 ( 1 ~ 100) 사이의 10 개 정수 정렬
            //int[] arr = creatArr();
            int[] arr = creatArr(); // 인트 배열을 CreateArr 메소드를 통해 생성한다.
            // public int[] creatArr(){int[] arr = new int[10];
            // for ( int i = 0; i < arr.length; i++) { arr [i] = (int) (Math.random()*100 + 1);
            // 을 계속 반복하는 대신에 int[] arr = creatArr(); 로 간결하게 코딩한다.
            merge(arr, 0, arr.length - 1);
            print(arr);
        }
    }
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
    static void magicSquare (){
//        * 홀수 마방진 구하기
//        * 1. 시작은 첫 행, 한 가운데 열에 1을 둔다.
//         * 2. 행을 감소, 열을 증가하면서 순차적으로 수를 넣어간다.
//         * 3. 행은 감소하므로 첫 행보다 작아지는 경우에는 마지막 행으로 넘어간다.
//                * 4. 열은 증가하므로 마지막 열보다 커지는 경우에는 첫 열로 넘어간다.
//                * 5. 넣은 수가 n의 배수이면 행만 증가한다. 열은 변화가 없다.
        //행은 밑으로 0,1,2,3으로 진행 위로올라가라면 -
        Random random = new Random();
        int m;

        while (true) {
            m = random.nextInt(100);
            if (m % 2 == 1 && m != 1) {
                break;
            }
        }//랜덤으로 홀수만 뽑아낸다.
        int x = 0;
        int y = m / 2;// 마방진은 1행 가운데 열에서부터 시작
        int array[][] = new int[m][m];

        for (int i = 1; i < m * m; i++) {
            array[x][y] = i;
            if (i % m == 0) {
                x++;
                if (x == m) {
                    x = 0;
                }
            } else {
                x--;
                y++;
                if (x == -1) {
                    x = m - 1;
                }
                if (y == m) {
                    y = 0;
                }

            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
    static void zigzag (){
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
    }
    static void rectangleStarPrint (){
        Random random = new Random();
        String res = "";
        int rand = random.nextInt(50);
        System.out.println("좌측90도 직각삼각형 별찍기");
        System.out.println("삼각형의 길이 랜덤으로 생성한 값 : " + rand);
        for (int i = 0; i < rand; i++) {
            for (int j = 0; j <= i; j++) {
                res += String.format("*");
            }
            res += String.format("\n");
        }
    }

    static void triangleStarPrint(){
        Random random = new Random();
        String res = "";
        int rand = random.nextInt(50);
        System.out.println("정삼각형 별찍기");
        System.out.println("정삼각형의 길이 랜덤으로 생성한 값 : " + rand);
        for (int i = 0; i < rand; i++) {
            for (int j = rand - i; j >= 0; j--) {
                res += String.format(" ");
            }
            for (int k = 1; k < i * 2; k++) {
                res += String.format("*");
            }
            res += String.format("\n");
        }
        System.out.print(res);
    }
    static void print( int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}