package Assisment2;

import java.util.*;
import java.util.regex.Pattern;

import java.util.*;

interface StudentOps{
    void add(Student s);
    void display();
    void remove(int roll);
    void search(int roll);
}

class Student{
    int roll;
    String name;

    Student(int roll,String name){
        this.roll = roll;
        this.name = name;
    }
}

class StudentManager implements StudentOps{

    List<Student> list = new ArrayList<>();
    Vector<Student> vector = new Vector<>();

    public void add(Student s){
        list.add(s);
        vector.add(s);
    }

    public void display(){
        for(Student s : list){
            System.out.println(s.roll + " " + s.name);
        }
    }

    public void remove(int roll){
        list.removeIf(s -> s.roll == roll);
    }

    public void search(int roll){
        for(Student s : list){
            if(s.roll == roll){
                System.out.println("Found " + s.name);
                return;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args){

        try{
            StudentManager sm = new StudentManager();
            sm.add(new Student(1,"Tarun"));
            sm.add(new Student(2,"Rahul"));
            sm.display();
            sm.search(2);
            sm.remove(1);
            sm.display();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
