import action.impl.CustomArraySearch;
import action.impl.CustomArraySorting;
import entity.CustomArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArraySearchTest {
    CustomArraySearch search;
    CustomArray customArray;
    CustomArraySorting sorting;

    @BeforeEach
    void setUp() {
        search = new CustomArraySearch();
        sorting = new CustomArraySorting();
    }

    @Test
    void simpleBinarySearch() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        customArray = new CustomArray(numbers);
        int result = search.binarySearch(customArray.getArray(), 9);
        assertEquals(8, result);
    }

    @Test
    void middleNegativeNumberBinarySearch() {
        int[] numbers = {1, 2, 3, 4, -8794582, 6, 7, 8, 9};
        customArray = new CustomArray(numbers);
        int result = search.binarySearch(customArray.getArray(), 9);
        assertEquals(8, result);
    }

    @Test
    void middleLargeNumberBinarySearch() {
        int[] numbers = {1, 2, 3, 4, 8794582, 6, 7, 8, 9};
        customArray = new CustomArray(numbers);
        int result = search.binarySearch(customArray.getArray(), 9);
        assertEquals(-1, result);
    }

    @Test
    void sortedAscendingNegativeArrayBinarySearch() {
        int[] numbers = {-1, -2, -3, -4, -5, -6, -7, -8, -9};
        customArray = new CustomArray(numbers);
        int result = search.binarySearch(customArray.getArray(), -9);
        assertEquals(-1, result);
    }

    @Test
    void sortedDescendingNegativeArrayBinarySearch() {
        int[] numbers = {-9, -8, -7, -6, -5, -4, -3, -2, -1};
        customArray = new CustomArray(numbers);
        int result = search.binarySearch(customArray.getArray(), -1);
        assertEquals(8, result);
    }

    @Test
    void nonSortedBinarySearch() {
        int[] numbers = {395, 815, 25, -28, 968, -857, 23, 94, -945};
        customArray = new CustomArray(numbers);
        int result = search.binarySearch(customArray.getArray(), 94);
        assertEquals(-1, result);
    }

    @Test
    void sortedBinarySearch() {
        int[] numbers = {395, 815, 25, -28, 968, -857, 23, 94, -945};
        customArray = new CustomArray(numbers);
        sorting.quickSort(customArray.getArray(), 0, numbers.length);
        int result = search.binarySearch(customArray.getArray(), 94);
        assertEquals(5, result);
    }

    @Test
    void sortedNegativeBinarySearch() {
        int[] numbers = {-395, -815, -25, -28, -968, -857, -23, -94, -945};
        customArray = new CustomArray(numbers);
        sorting.quickSort(customArray.getArray(), 0, numbers.length);
        int result = search.binarySearch(customArray.getArray(), -25);
        assertEquals(7, result);
    }

    @Test
    void sortedPositiveBinarySearch() {
        int[] numbers = {395, 815, 25, 28, 968, 857, 23, 94, 945};
        customArray = new CustomArray(numbers);
        sorting.quickSort(customArray.getArray(), 0, numbers.length);
        int result = search.binarySearch(customArray.getArray(), 94);
        assertEquals(3, result);
    }

    @Test
    void duplicateBinarySearch() {
        int[] numbers = {983, 4, 532, 2, 832, 59, 532, 45, 976};
        customArray = new CustomArray(numbers);
        int result = search.binarySearch(customArray.getArray(), 532);
        assertEquals(2, result);
    }

    @Test
    void duplicateSortedBinarySearch() {
        int[] numbers = {983, 4, 532, 2, 832, 59, 532, 45, 976};
        customArray = new CustomArray(numbers);
        sorting.quickSort(customArray.getArray(), 0, numbers.length);
        int result = search.binarySearch(customArray.getArray(), 532);
        assertEquals(4, result);
    }
}