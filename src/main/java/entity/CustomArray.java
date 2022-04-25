package entity;

import exception.CustomArrayException;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray {
    private int[] array;

    public CustomArray() {
    }

    public CustomArray(int[] array) {
        this.array = array;
    }

    public CustomArray(int capacity) throws CustomArrayException {
        if (capacity < 0) {
            throw new CustomArrayException("Capacity of the array can not be negative!");
        }
        array = new int[capacity];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .toString();
    }
}