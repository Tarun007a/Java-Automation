package MiniProject3;

import java.util.*;

class Student{

    private int eno;
    private String name;
    private String branch;
    private int sem;
    private double percentage;

    Student(int eno,String name,String branch,int sem,double percentage){
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    public int getEno(){
        return eno;
    }

    public String getBranch(){
        return branch;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }

    public String toString(){
        return eno + " " + name + " " + branch + " " + sem + " " + percentage;
    }
}

public class StudentManagementSystem {
    static boolean login(Scanner sc){
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if(u.equals("admin") && p.equals("admin123"))return true;
        System.out.println("Invalid Login");
        return false;
    }

    static boolean enoExists(List<Student> list,int eno){
        for(Student s : list){
            if(s.getEno() == eno) return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        if(!login(sc)) return;

        List<Student> list = new ArrayList<>();

        while(true){
            System.out.println("1.Add 2.Display 3.Search 4.Update 5.Delete 6.Sort 7.Exit");
            int ch = sc.nextInt();

            try{
                if(ch == 1){
                    System.out.print("Enter Eno Name Branch Sem Percentage: ");
                    int eno = sc.nextInt();
                    String name = sc.next();
                    String branch = sc.next();
                    int sem = sc.nextInt();
                    double per = sc.nextDouble();

                    if(enoExists(list,eno)) System.out.println("Eno Must Be Unique");
                    else if(per <= 0) System.out.println("Percentage Must Be Positive");
                    else if(branch.isEmpty() || sem <= 0) System.out.println("Sem and Branch Cannot Be Empty");
                    else{
                        list.add(new Student(eno,name,branch,sem,per));
                        System.out.println("Student Added");
                    }
                }

                else if(ch == 2){
                    if(list.isEmpty())System.out.println("No Records");
                    for(Student s : list){
                        System.out.println(s);
                    }
                }

                else if(ch == 3){
                    System.out.print("Enter Eno: ");
                    int eno = sc.nextInt();
                    boolean found = false;

                    for(Student s : list){
                        if(s.getEno() == eno){
                            System.out.println(s);
                            found = true;
                            break;
                        }
                    }

                    if(!found) System.out.println("Student Not Found");
                }

                else if(ch == 4){
                    System.out.print("Enter Eno and New Branch: ");
                    int eno = sc.nextInt();
                    String branch = sc.next();
                    boolean updated = false;

                    if(branch.isEmpty()) System.out.println("Branch Cannot Be Empty");
                    else{
                        for(Student s : list){
                            if(s.getEno() == eno){
                                s.setBranch(branch);
                                updated = true;
                                break;
                            }
                        }

                        if(updated) System.out.println("Branch Updated");
                        else System.out.println("Student Not Found");
                    }
                }

                else if(ch == 5){
                    System.out.print("Enter Eno: ");
                    int eno = sc.nextInt();

                    boolean removed = list.removeIf(s -> s.getEno() == eno);

                    if(removed) System.out.println("Student Deleted");
                    else System.out.println("Student Not Found");
                }

                else if(ch == 6){
                    list.sort((a,b) -> a.getEno() - b.getEno());
                    for(Student s : list){
                        System.out.println(s);
                    }
                }

                else if(ch == 7){
                    System.out.println("Exit");
                    break;
                }

                else System.out.println("Invalid Choice");
            }
            catch(Exception e){
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
        sc.close();
    }
}

