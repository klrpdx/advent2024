package com.klr.advent;

import java.util.*;

public class LocationLists {

    private final List<Integer> list1 = new ArrayList<>();
    private final List<Integer> list2 = new ArrayList<>();
    private final  Map<Integer, Integer> map1 = new HashMap<>();
    private final  Map<Integer, Integer> map2 = new HashMap<>();

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

    public void sortAndHash() {
        list1.sort(Collections.reverseOrder());
        list2.sort(Collections.reverseOrder());
        for (int num : list1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            }
            else {
                map1.put(num, 1);
            }
        }
        for (int num : list2) {
            if (map2.containsKey(num)) {
                map2.put(num, map2.get(num) + 1);
            }
            else {
                map2.put(num, 1);
            }
        }
    }

    public int getOccurances1(Integer key) {
        return map1.getOrDefault(key, 0);
    }

    public int getOccurances2(Integer key) {
        return map2.getOrDefault(key, 0);
    }

    public List<Integer> getKeys() {
        return new ArrayList<>(map1.keySet());
    }
}
