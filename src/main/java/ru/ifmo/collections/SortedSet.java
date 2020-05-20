package ru.ifmo.collections;

import java.util.*;
/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */

public  class SortedSet<T> extends AbstractSet<T> {
    private static final Object EXISTS = new Object();
    private final Map<T, Object> map;

    private SortedSet(TreeMap<T, Object> treeMap) {
        map = treeMap;
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    public List<T> getSorted() {
        return new ArrayList<>(map.keySet());
    }

    public List<T> getReversed() {
        List<T> reversedList = new ArrayList<>(map.keySet());
        Collections.reverse(reversedList);
        return reversedList;
    }

    @Override
    public boolean add(T t) {
        return map.put(t, EXISTS) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isAllAdded = false;
        for (T it : c) {
            isAllAdded |= add(it);
        }
        return isAllAdded;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o, EXISTS);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isAllRemoved = false;
        for (Object it : c) {
            isAllRemoved |= remove(it);
        }
        return isAllRemoved;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}