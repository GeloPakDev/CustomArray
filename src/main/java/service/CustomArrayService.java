package service;

import action.impl.CustomArraySorting;
import exception.CustomArrayException;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayService {
    public static int findMaxElement(int[] array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array can not be null");
        }
        int length = array.length - 1;
        CustomArraySorting arraySorting = new CustomArraySorting();
        arraySorting.mergeSort(array, 0, length);
        return array[length];
    }

    public int findMinElement(int[] array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array can not be null");
        }
        int length = array.length - 1;
        CustomArraySorting arraySorting = new CustomArraySorting();
        arraySorting.quickSort(array, 0, length);
        return array[0];
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public List<Integer> findPrimaryNumbers(int[] array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array can not be null");
        }
        List<Integer> list = new ArrayList<>();
        for (int j : array) {
            if (isPrime(j)) {
                list.add(j);
            }
        }
        return list;
    }

    private static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    private static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) ||
                isPerfectSquare(5 * n * n - 4);
    }

    public List<Integer> findFibonacciNumbers(int[] array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array can not be null");
        }
        List<Integer> list = new ArrayList<>();
        for (int j : array) {
            if (isFibonacci(j)) {
                list.add(j);
            }
        }
        return list;
    }
}