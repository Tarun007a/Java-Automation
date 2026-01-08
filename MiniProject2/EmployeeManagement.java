package MiniProject2;

import java.io.*;
import java.util.*;

class Employee{

    private int id;
    private String name;
    private double salary;
    private String dept;

    Employee(int id,String name,double salary,String dept){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public int getId(){
        return id;
    }

    public double getSalary(){
        return salary;
    }

    public String getDept(){
        return dept;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public String toFile(){
        return id + "," + name + "," + salary + "," + dept;
    }

    public String toString(){
        return id + " " + name + " " + salary + " " + dept;
    }
}

class EmployeeFile{

    static void save(List<Employee> list){
        try{
            FileWriter fw = new FileWriter("emp.txt");
            for(Employee e : list){
                fw.write(e.toFile() + "\n");
            }
            fw.close();
        }catch(Exception e){
            System.out.println("File Write Error");
        }
    }

    static List<Employee> load(){
        List<Employee> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("emp.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] d = line.split(",");
                list.add(new Employee(
                        Integer.parseInt(d[0]),
                        d[1],
                        Double.parseDouble(d[2]),
                        d[3]
                ));
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}

public class EmployeeManagement{
    static boolean login(Scanner sc){
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if(u.equals("admin") && p.equals("admin123")){
            return true;
        }
        System.out.println("Invalid Login");
        return false;
    }

    static boolean idExists(List<Employee> list,int id){
        for(Employee e : list){
            if(e.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        if(!login(sc)){
            return;
        }

        List<Employee> list = EmployeeFile.load();

        System.out.println("1.Add 2.Display 3.Search 4.Update 5.Delete 6.Sort 7.Departments 8.Exit");
        int ch = sc.nextInt();

        if(ch == 1){
            System.out.print("Enter ID Name Salary Dept: ");
            int id = sc.nextInt();
            String name = sc.next();
            double sal = sc.nextDouble();
            String dept = sc.next();

            if(idExists(list,id)){
                System.out.println("ID Already Exists");
            }
            else if(sal <= 0){
                System.out.println("Salary Must Be Positive");
            }
            else if(dept.isEmpty()){
                System.out.println("Department Cannot Be Empty");
            }
            else{
                list.add(new Employee(id,name,sal,dept));
                EmployeeFile.save(list);
                System.out.println("Employee Added");
            }
        }
        else if(ch == 2){
            for(Employee e : list){
                System.out.println(e);
            }
        }
        else if(ch == 3){
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            boolean found = false;

            for(Employee e : list){
                if(e.getId() == id){
                    System.out.println(e);
                    found = true;
                    break;
                }
            }

            if(!found){
                System.out.println("Employee Not Found");
            }
        }
        else if(ch == 4){
            System.out.print("Enter ID and New Salary: ");
            int id = sc.nextInt();
            double sal = sc.nextDouble();
            boolean done = false;

            if(sal <= 0){
                System.out.println("Salary Must Be Positive");
            }
            else{
                for(Employee e : list){
                    if(e.getId() == id){
                        e.setSalary(sal);
                        done = true;
                        break;
                    }
                }

                if(done){
                    EmployeeFile.save(list);
                    System.out.println("Updated");
                }
                else{
                    System.out.println("Employee Not Found");
                }
            }
        }
        else if(ch == 5){
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            boolean removed = list.removeIf(e -> e.getId() == id);

            if(removed){
                EmployeeFile.save(list);
                System.out.println("Deleted");
            }
            else{
                System.out.println("Employee Not Found");
            }
        }
        else if(ch == 6){
            list.sort((a,b) -> a.getId() - b.getId());
            for(Employee e : list){
                System.out.println(e);
            }
        }
        else if(ch == 7){
            Set<String> set = new HashSet<>();
            for(Employee e : list){
                set.add(e.getDept());
            }
            for(String d : set){
                System.out.println(d);
            }
        }
        else{
            System.out.println("Exit");
        }

        sc.close();
    }
}