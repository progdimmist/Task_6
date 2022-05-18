package ru.vsu.cs.pavlenkodm;

import ru.vsu.cs.pavlenkodm.struct.SimpleBSTreeMap;

import java.util.HashMap;

public class Task {
    public static int[] sortMap(int[] arr){
        SimpleBSTreeMap<Integer, Integer> map = new SimpleBSTreeMap<>();
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else map.computeIfPresent(j, (k, v) -> v + 1);
        }
        int[] arr1 = new int[arr.length];
        int n = 0;
        for (SimpleBSTreeMap.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr1[n] = entry.getKey();
                n++;
            }
        }
        return arr1;
    }
}//Сложность алгоритма O(n^2)