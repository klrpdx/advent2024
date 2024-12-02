package com.klr.advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationListsTest {


    @Test
    void getList1() {
        final int[] list1 = {1,2,3};
        final int[] list2 = {4,5,6};
        LocationLists lists = new LocationLists();
        for (int value : list1) {
            lists.addList1Val(value);
        }
        for (int value : list2) {
            lists.addList2Val(value);
        }

        int[] aList = lists.getList1();
        assertArrayEquals(list1, aList);
    }

    @Test
    void getList2() {
        final int[] list1 = {1,2,3};
        final int[] list2 = {4,5,6};
        LocationLists lists = new LocationLists();
        for (int value : list1) {
            lists.addList1Val(value);
        }
        for (int value : list2) {
            lists.addList2Val(value);
        }

        int[] aList = lists.getList2();
        assertArrayEquals(list2, aList);

    }

    @Test
    void checkLists() {
        final int[] list1 = {1,2,3};
        final int[] list2 = {4,5,6};
        LocationLists lists = new LocationLists();
        for (int value : list1) {
            lists.addList1Val(value);
        }
        for (int value : list2) {
            lists.addList2Val(value);
        }
        assertTrue(lists.valid());
    }

     @Test
    void checkListsInvalid() {
        final int[] list1 = {1,3};
        final int[] list2 = {4,5,6};
        LocationLists lists = new LocationLists();
        for (int value : list1) {
            lists.addList1Val(value);
        }
        for (int value : list2) {
            lists.addList2Val(value);
        }
        assertFalse(lists.valid());
    }


}