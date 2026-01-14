package Assisment3;

import java.util.Vector;

public class VectorMethodsAndConstructors {
    public static void main(String[] args){
        Vector<String> v1 = new Vector<>();
        Vector<String> v2 = new Vector<>(10);
        Vector<String> v3 = new Vector<>(10,5);
        Vector<String> v4 = new Vector<>(v1);

        v1.add("A");
        v1.addElement("B");
        v1.add(1,"C");

        v1.remove("B");
        v1.remove(0);

        System.out.println(v1.get(0));
        v1.set(0,"Z");

        System.out.println(v1.contains("Z"));
        System.out.println(v1.indexOf("Z"));

        System.out.println(v1.capacity());
        v1.ensureCapacity(20);
        v1.trimToSize();

        System.out.println(v1.size());
        System.out.println(v1.isEmpty());

        v1.clear();
        System.out.println(v1);
    }
}