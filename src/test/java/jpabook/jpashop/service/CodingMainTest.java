package jpabook.jpashop.service;

import java.util.Arrays;

public class CodingMainTest {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 2, 5, 4};
        System.out.println("1 = " +Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("2 = " +Arrays.toString(arr));

        // 2. 배열을 자를 index
        int position = 3;

        // 3. 배열 자르기
        int[] arr1 = Arrays.copyOfRange(arr, 0, position);
        int[] arr2 = Arrays.copyOfRange(arr, position, arr.length);

        // 4. 자른 배열 출력
        System.out.println(Arrays.toString(arr1));  // [0, 1, 2]
        System.out.println(Arrays.toString(arr2));  // [3, 4, 5]








    }
}
