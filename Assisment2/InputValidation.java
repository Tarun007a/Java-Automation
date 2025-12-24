package Assisment2;

import java.util.Scanner;
import java.util.regex.Pattern;

class InputValidation{

    static boolean validate(String input,String regex){
        return Pattern.matches(regex,input);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("1.Mobile 2.Email 3.Username 4.Password 5.Exit");
        int choice = sc.nextInt();
        sc.nextLine();

        try{
            if(choice == 1){
                String mob = sc.nextLine();
                if(validate(mob,"[6-9][0-9]{9}")) System.out.println("Welcome User");
                else System.out.println("Invalid Mobile");
            }
            else if(choice == 2){
                String email = sc.nextLine();
                if(validate(email,"[a-zA-Z0-9._]+@[a-z]+\\.[a-z]+")) System.out.println("Welcome User");
                else System.out.println("Invalid Email");

            }
            else if(choice == 3){
                String user = sc.nextLine();
                if(validate(user,"[a-zA-Z0-9]{5,}")) System.out.println("Welcome User");
                else System.out.println("Invalid Username");
            }
            else if(choice == 4){
                String pass = sc.nextLine();
                if(validate(pass,"(?=.*[0-9])(?=.*[A-Z]).{6,}")) System.out.println("Welcome User");
                else System.out.println("Invalid Password");

            }
            else System.out.println("Exit");
        }
        catch(Exception e){
            System.out.println("Error");
        }

        sc.close();
    }
}

