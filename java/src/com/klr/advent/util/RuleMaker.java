package com.klr.advent.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleMaker {

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

    public List<Integer> getRule(int key) {
        return rules.get(key);
    }
}
