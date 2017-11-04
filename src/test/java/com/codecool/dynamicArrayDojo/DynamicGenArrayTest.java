package com.codecool.dynamicArrayDojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicGenArrayTest {

    @Test
    void dynamicGenArrayTest() {
        new DynamicGenArray<Integer>();
        new DynamicGenArray<String>();
    }

    @Test
    void dynamicGenArrayTest_WithInitialSize()
    {
        new DynamicGenArray<Integer>(15);
        new DynamicGenArray<String>(15);
    }

    @Test
    void addTest_Int()
    {
        DynamicGenArray<Integer> array = createArrayInt(11);
        array.add(32);
        array.add(42);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 32 42";
        assertEquals(result, array.toString());
    }

    @Test
    void addTest_String()
    {
        DynamicGenArray<String> array = createArrayString(11);
        array.add("32");
        array.add("42");
        String result = " 0 1 2 3 4 5 6 7 8 9 10 32 42";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_Int()
    {
        DynamicGenArray<Integer> array = createArrayInt(11);
        array.remove(5);
        array.remove(0);
        String result = " 1 2 3 4 6 7 8 9 10";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_String()
    {
        DynamicGenArray<String> array = createArrayString(11);
        array.remove(5);
        array.remove(0);
        String result = " 1 2 3 4 6 7 8 9 10";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_LastItem_Int()
    {
        DynamicGenArray<Integer> array = createArrayInt(10);
        array.remove(9);
        String result = " 0 1 2 3 4 5 6 7 8";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_LastItem_String()
    {
        DynamicGenArray<String> array = createArrayString(10);
        array.remove(9);
        String result = " 0 1 2 3 4 5 6 7 8";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_InvalidItem_Int()
    {
        DynamicGenArray<Integer> array = createArrayInt(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(-1));
    }

    @Test
    void RemoveTest_InvalidItem_String()
    {
        DynamicGenArray<String> array = createArrayString(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(-1));
    }

    @Test
    void insertTest_Int()
    {
        DynamicGenArray<Integer> array = createArrayInt(11);
        array.insert(8, 223);
        array.insert(100, 654);

        String result = " 0 1 2 3 4 5 6 7 223 8 9 10 654";
        assertEquals(result, array.toString());
    }

    @Test
    void insertTest_String()
    {
        DynamicGenArray<String> array = createArrayString(11);
        array.insert(8, "223");
        array.insert(100, "654");

        String result = " 0 1 2 3 4 5 6 7 223 8 9 10 654";
        assertEquals(result, array.toString());
    }

    private DynamicGenArray<Integer> createArrayInt(int numOfElements)
    {
        DynamicGenArray<Integer> array = new DynamicGenArray<>();
        for (int i = 0; i < numOfElements; ++i)
        {
            array.add(i);
        }
        return array;
    }

    private DynamicGenArray<String> createArrayString(int numOfElements)
    {
        DynamicGenArray<String> array = new DynamicGenArray<>();
        for (int i = 0; i < numOfElements; ++i)
        {
            array.add(String.valueOf(i));
        }
        return array;
    }
}