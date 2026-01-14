package Assisment3;

import java.util.*;

public class HashTableMethodsAndConstructors {
    public static void main(String[] args){
        Hashtable<Integer,String> h1 = new Hashtable<>();
        Hashtable<Integer,String> h2 = new Hashtable<>(10);
        Hashtable<Integer,String> h3 = new Hashtable<>(10,0.75f);
        Hashtable<Integer,String> h4 = new Hashtable<>(h1);

        h1.put(1,"A");
        h1.put(2,"B");
        h1.put(3,"C");

        h1.putIfAbsent(4,"D");

        System.out.println(h1.get(2));
        System.out.println(h1.containsKey(3));
        System.out.println(h1.containsValue("A"));

        h1.remove(1);
        h1.replace(2,"BB");

        System.out.println(h1.size());
        System.out.println(h1.isEmpty());

        System.out.println(h1.keySet());
        System.out.println(h1.values());
        System.out.println(h1.entrySet());

        h1.clear();
        System.out.println(h1);
    }
}
