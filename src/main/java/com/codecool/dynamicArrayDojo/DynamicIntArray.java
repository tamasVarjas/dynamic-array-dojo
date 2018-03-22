package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    private int[] array;
    private int lastIndex;

    DynamicIntArray() {
        array = new int[10];
        lastIndex = -1;
    }

    DynamicIntArray(int elementCount) {
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

    private void expandArrayLengthIfNecessary() {
        if (lastIndex == array.length - 1) {
            int[] tempArray = array;
            array = new int[array.length * 2];
            System.arraycopy(tempArray, 0, array, 0, tempArray.length);
        }
    }

    private void shrinkUnnecessaryArrayLength() {
        if (lastIndex < array.length / 2 - 1) {
            int[] tempArray = array;
            array = new int[array.length / 2];
            System.arraycopy(tempArray, 0, array, 0, array.length);
        }
    }

    public void add(int valueToAdd) {
        expandArrayLengthIfNecessary();
        array[++lastIndex] = valueToAdd;
    }

    public void remove(int indexToRemove) {
        System.arraycopy(array, indexToRemove + 1, array, indexToRemove, lastIndex-- - indexToRemove);
        shrinkUnnecessaryArrayLength();
    }

    public void insert(int indexToInsert, int valueToInsert) {
        expandArrayLengthIfNecessary();
        if (indexToInsert > lastIndex) {
            array[++lastIndex] = valueToInsert;
        } else {
            System.arraycopy(array, indexToInsert, array, indexToInsert + 1, ++lastIndex - indexToInsert);
            array[indexToInsert] = valueToInsert;
        }
    }

}
