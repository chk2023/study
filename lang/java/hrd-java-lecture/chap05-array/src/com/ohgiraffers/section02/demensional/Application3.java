package com.ohgiraffers.section02.demensional;

public class Application3 {
    public static void main(String[] args) {
        int[][] iarr = new int[3][];
        iarr[0] = new int[3];
        iarr[1] = new int[2];
        int[] arr = new int[5];
        iarr[2] = arr;
        /* 가변배열 역시 반복문을 이용해서 값을 대입하고 출력할 수 있다. */
        /* 반복문을 이용한 값 대입 */
        /* 배열 인덱스마다 저장할 값이 보관될 변수 선언 */
        int value = 0;
        /* 모든 배열에 순차적으로 접근하는 반복문 */
        for (int i = 0; i < iarr.length; i++) {
            /* 배열마다 인덱스에 차례로 접근하는 반복문 */
            for (int j = 0; j < iarr[i].length; j++) {
                iarr[i][j] = ++value;
            }
        }
        /* 반복문을 이용한 값 출력 */
        /* 모든 배열에 순차적으로 접근하는 반복문 */
        for (int i = 0; i < iarr.length; i++) {
            /* 배열마다 인덱스에 차례로 접근하는 반복문 */
            for (int j = 0; j < iarr[i].length; j++) {
                System.out.print(iarr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
