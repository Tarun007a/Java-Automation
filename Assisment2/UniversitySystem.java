package Assisment2;

import java.util.*;

class UniversitySystem{

    static class Student{
        int id;
        String course;
        int marks;

        Student(int id,String course,int marks){
            this.id = id;
            this.course = course;
            this.marks = marks;
        }
    }

    public static void main(String[] args){

        ArrayList<Student> students = new ArrayList<>();
        Vector<String> courseList = new Vector<>();
        Stack<Student> stack = new Stack<>();
        Set<String> uniqueCourses = new HashSet<>();
        HashMap<Integer,Student> map = new HashMap<>();

        try{
            Student s1 = new Student(1,"CS",85);
            Student s2 = new Student(2,"IT",90);
            Student s3 = new Student(3,"CS",70);

            students.add(s1);
            students.add(s2);
            students.add(s3);

            map.put(1,s1);
            map.put(2,s2);
            map.put(3,s3);

            for(Student s : students){
                uniqueCourses.add(s.course);
            }

            students.sort((a,b) -> b.marks - a.marks);

            TreeMap<Integer,Student> tm = new TreeMap<>(map);

            HashMap<String,Integer> courseCount = new HashMap<>();
            for(Student s : students){
                courseCount.put(s.course,courseCount.getOrDefault(s.course,0) + 1);
            }

            System.out.println("Sorted Students:");
            for(Student s : students){
                System.out.println(s.id + " " + s.course + " " + s.marks);
            }

            System.out.println("Unique Courses: " + uniqueCourses);
            System.out.println("Course Count: " + courseCount);
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
