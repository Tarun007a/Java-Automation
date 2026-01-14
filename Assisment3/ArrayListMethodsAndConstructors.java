package Assisment3;

import java.util.*;

public class ArrayListMethodsAndConstructors {
    public static void main(String[] args){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>(10);
        ArrayList<Integer> a3 = new ArrayList<>(a1);

        a1.add(10);
        a1.add(20);
        a1.add(30);
        a1.add(1,15);

        a1.addAll(Arrays.asList(40,50));
        a1.remove(2);
        a1.remove(Integer.valueOf(50));

        System.out.println(a1.get(1));
        a1.set(1,99);

        System.out.println(a1.contains(99));
        System.out.println(a1.indexOf(99));
        System.out.println(a1.isEmpty());
        System.out.println(a1.size());

        a1.ensureCapacity(20);
        a1.trimToSize();

        Object[] arr = a1.toArray();

        a1.clear();
        System.out.println(a1);
    }
}
