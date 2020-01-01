package com.fustack.base.dataStructure.array;

/**
 * sieve of Eratosthenes
 */
public class Eratosthenes {

    private static final int ARRAY_SIZE = 100000;

    public static void main(String[] args) {
        int i, j;
        int[] a = new int[ARRAY_SIZE];
        for (i = 2; i < ARRAY_SIZE; i++) {
            a[i] = 1;
        }

        try {
            for (i = 2; i < ARRAY_SIZE; i++) {
                if (a[i] == 1) {

                    // 如果熟练级太大，要考虑 i*j 变成负数的情况 会导致数组访问越界。
                    for (j = i; ((i * j) < ARRAY_SIZE) && (i*j > 0); j++) {
                        a[i * j] = 0;
                    }
                }
            }


            for (i = 2; i < ARRAY_SIZE; i++) {
                if (a[i] == 1)
                    System.out.print(i + "   ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            // System.out.println("m*n="+(m * n) + "m=" +m + ",n=" + n + ",Integer.MAX=" + Integer.MAX_VALUE);
        }
    }
}
