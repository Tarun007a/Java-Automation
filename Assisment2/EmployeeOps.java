package Assisment2;

import java.util.*;

interface EmployeeOps{
    void add(int id,String name);
    void display();
    void search(int id);
    void remove(int id);
}

class EmployeeManager implements EmployeeOps{

    HashMap<Integer,String> hm = new HashMap<>();
    Hashtable<Integer,String> ht = new Hashtable<>();
    TreeMap<Integer,String> tm = new TreeMap<>();

    public void add(int id,String name){
        hm.put(id,name);
        ht.put(id,name);
        tm.put(id,name);
    }

    public void display(){
        System.out.println("HashMap: " + hm);
        System.out.println("Hashtable: " + ht);
        System.out.println("TreeMap: " + tm);
    }

    public void search(int id){
        System.out.println(hm.get(id));
    }

    public void remove(int id){
        hm.remove(id);
        ht.remove(id);
        tm.remove(id);
    }

    public static void main(String[] args){

        EmployeeManager em = new EmployeeManager();

        try{
            em.add(1,"Tarun");
            em.add(2,"Rahul");

            em.hm.put(null,"Allowed");
            em.hm.put(3,null);

            em.display();
        }catch(Exception e){
            System.out.println("Hashtable does not allow null");
        }
    }
}
