package Assisment1;

import java.util.Scanner;

class MatrixFunctions {

    static void add(int[][] a, int[][] b, int r, int c) {
        int[][] res = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        display(res, r, c);
    }

    static void subtract(int[][] a, int[][] b, int r, int c) {
        int[][] res = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        display(res, r, c);
    }

    static void multiply(int[][] a, int[][] b, int r1, int c1, int c2) {
        int[][] res = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    res[i][j] = res[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        display(res, r1, c2);
    }

    static void transpose(int[][] a, int r, int c) {
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void checkSquare(int r, int c) {
        if (r == c) {
            System.out.println("Matrix is Square");
        }
        else {
            System.out.println("Matrix is NOT Square");
        }
    }

    static void checkDiagonal(int[][] a, int r, int c) {
        if (r != c) {
            System.out.println("Not a Diagonal Matrix");
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i != j && a[i][j] != 0) {
                    System.out.println("Not a Diagonal Matrix");
                    return;
                }
            }
        }
        System.out.println("Diagonal Matrix");
    }

    static void checkIdentity(int[][] a, int r, int c) {
        if (r != c) {
            System.out.println("Not an Identity Matrix");
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0)) {
                    System.out.println("Not an Identity Matrix");
                    return;
                }
            }
        }
        System.out.println("Identity Matrix");
    }

    static void display(int[][] a, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] mat1 = new int[r][c];
        int[][] mat2 = new int[r][c];

        System.out.println("Enter Matrix mat1:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Matrix ma2:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }

        System.out.println("1.Add 2.Subtract 3.Multiply 4.Transpose 5.Square 6.Diagonal 7.Identity");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            add(mat1, mat2, r, c);
        }
        else if (choice == 2) {
            subtract(mat1, mat2, r, c);
        }
        else if (choice == 3) {
            multiply(mat1, mat2, r, c, c);
        }
        else if (choice == 4) {
            transpose(mat1, r, c);
        }
        else if (choice == 5) {
            checkSquare(r, c);
        }
        else if (choice == 6) {
            checkDiagonal(mat1, r, c);
        }
        else if (choice == 7) {
            checkIdentity(mat1, r, c);
        }
        else {
            System.out.println("Invalid choice");
        }
    }
}
