package ru.ifmo.collections;

import java.util.TreeMap;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private final int k;

    public KthLargest(int k, int[] numbers) {
        for (var num : numbers) {
            treeMap.put(num, 1);
        }
        this.k = k;
    }

    public int add(int val) {
        treeMap.put(val, treeMap.containsKey(val) ? treeMap.get(val) + 1 : 1);

        var it = treeMap.descendingMap();
        int elementsPassed = 0;

        for (var entry : it.entrySet()) {
            elementsPassed += entry.getValue();
            if (elementsPassed >= k){
                return  entry.getKey();
            }
        }

        return -1;
    }
}