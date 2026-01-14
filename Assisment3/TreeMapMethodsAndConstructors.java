package Assisment3;

import java.util.*;

public class TreeMapMethodsAndConstructors {
    public static void main(String[] args){
        TreeMap<Integer,String> t1 = new TreeMap<>();
        TreeMap<Integer,String> t2 = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer,String> t3 = new TreeMap<>(t1);

        t1.put(1,"A");
        t1.put(2,"B");
        t1.put(3,"C");

        System.out.println(t1.firstKey());
        System.out.println(t1.lastKey());

        System.out.println(t1.get(2));
        System.out.println(t1.containsKey(3));
        System.out.println(t1.containsValue("A"));

        t1.remove(1);
        t1.replace(2,"BB");

        System.out.println(t1.ceilingKey(2));
        System.out.println(t1.floorKey(2));

        System.out.println(t1.headMap(3));
        System.out.println(t1.tailMap(2));

        System.out.println(t1.size());
        System.out.println(t1.entrySet());

        t1.clear();
        System.out.println(t1);
    }
}
