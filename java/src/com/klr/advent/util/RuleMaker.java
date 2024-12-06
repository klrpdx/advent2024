package com.klr.advent.util;

import java.util.*;

public class RuleMaker implements Comparator<Integer> {

    private final Map<Integer, List<Integer>> rules = new HashMap<Integer, List<Integer>>();

    public void addRule(String s) {
        String[] tokens = s.split("\\|");
        Integer key = Integer.valueOf(tokens[0]);
        Integer value = Integer.valueOf(tokens[1]);
        List<Integer> list = rules.get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(value);
        rules.put(key,list);
    }


        @Override
        public int compare(Integer o1, Integer o2) {
            List<Integer> lessThanList = rules.get(o1);
            if (lessThanList !=null &&  lessThanList.contains(o2)) {
                return -1;
            }
            return 1;
        }



    public List<Integer> getRule(int key) {
        return rules.get(key);
    }

    public List<Integer> fixList(List<Integer> disorderedList) {
        List<Integer> fixedList = new ArrayList<>(disorderedList);
        fixedList.sort(this);
        return fixedList;
    }

}
