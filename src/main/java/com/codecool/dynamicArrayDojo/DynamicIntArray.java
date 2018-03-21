package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    private int[] array;
    private int lastIndex;

    public DynamicIntArray() {
        array = new int[10];
        lastIndex = -1;
    }

    public DynamicIntArray(int elementCount) {
        array = new int[elementCount];
        lastIndex = -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(array.length * 2);
        for (int i = 0; i <= lastIndex; i++ ) {
            sb.append(" ");
            sb.append(array[i]);
        }
        return sb.toString();
    }

    public void add(int num) {
        if (lastIndex == array.length - 1) {
            int[] tempArray = array;
            array = new int[array.length * 2];
            System.arraycopy(tempArray, 0, array, 0, tempArray.length);
        }
        array[++lastIndex] = num;
    }

    public void remove(int indexToRemove) {
        System.arraycopy(array, indexToRemove + 1, array, indexToRemove, lastIndex - indexToRemove);
        lastIndex--;
    }
}
