package com.klr.advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocationLists {

    private final List<Integer> list1 = new ArrayList<>();
    private final List<Integer> list2 = new ArrayList<>();

    public void addList1Val(int value) {
        list1.add(value);
    }

    public void addList2Val(int value) {
        list2.add(value);
    }

    public Integer getList1Smallest() {
        if (list1.isEmpty()) {
            return null;
        }
        return list1.removeLast();
    }

    public Integer getList2Smallest() {
        if (list2.isEmpty()) {
            return null;
        }
        return list2.removeLast();
    }


    public int[] getList1() {
        return list1.stream().mapToInt(i -> i).toArray();
    }

    public int[] getList2() {
        return list2.stream().mapToInt(i -> i).toArray();
    }

    public boolean valid() {
        return list1.size() == list2.size();
    }

    public void sort() {
        list1.sort(Collections.reverseOrder());
        list2.sort(Collections.reverseOrder());
    }
}
