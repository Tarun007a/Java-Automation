import java.util.Scanner;

class StringOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println("length: " + s.length());

        System.out.println("isEmpty: " + s.isEmpty());

        System.out.println("charAt(1): " + s.charAt(1));

        System.out.println("toString: " + s.toString());

        System.out.println("equals(Hello): " + s.equals("Hello"));

        System.out.println("compareTo(Hello): " + s.compareTo("Hello"));

        System.out.println("contains(Hello): " + s.contains("Java"));

        System.out.println("indexOf(H): " + s.indexOf('o'));

        System.out.println("lastIndexOf(l): " + s.lastIndexOf('o'));

        System.out.println("startsWith(He): " + s.startsWith("  He"));

        System.out.println("endsWith(lo): " + s.endsWith("  "));

        System.out.println("matches(hello): " + s.matches(".*Java.*"));

        System.out.println("substring: " + s.substring(1, s.length()));

        System.out.println("toLowerCase: " + s.toLowerCase());

        System.out.println("trim: " + s.trim());

        System.out.println("replace(hello, world): " + s.replace("hello", "world"));

        String[] arr = s.trim().split(" ");

        for (String ele : arr) {
            System.out.println(ele);
        }

        System.out.println("join(): " + String.join("-", arr));

        System.out.println("valueOf(100): " + String.valueOf(100));
    }
}
