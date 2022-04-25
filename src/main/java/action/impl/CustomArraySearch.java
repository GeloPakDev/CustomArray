package action.impl;


import action.ArraySearch;

public class CustomArraySearch implements ArraySearch {
    public int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length;
        while (start < end) {
            int midPoint = (start + end) / 2;
            if (array[midPoint] == target) {
                return midPoint;
            } else if (array[midPoint] < target) {
                start = midPoint + 1;
            } else {
                end = midPoint;
            }
        }
        return -1;
    }
}