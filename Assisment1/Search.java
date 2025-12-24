package Assisment1;

import java.util.Scanner;

class ArrayFunctionsNoSwitch{
    static int insert(int[] arr, int idx, int value){
        arr[idx] = value;
        return value;
    }

    static void delete(int[] arr, int idx){
        arr[idx] = -1;
        System.out.println("Deleted");
    }

    static void linearSearch(int[] arr, int key){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == key){
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void binarySearch(int[] arr, int key){
        insertionSort(arr);
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == key){
                System.out.println("Element found at index " + mid);
                return;
            }
            else if(arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Element not found");
    }

    static void findMaximum(int[] arr) {
        int max = arr[0];
        for(int ele : arr) max = Math.max(max, ele);
        System.out.println("Maximum value = " + max);
    }

    static void countEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int ele : arr) {
            if (ele % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even = " + even);
        System.out.println("Odd = " + odd);
    }

    static void display(int[] arr){
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) arr[i] = sc.nextInt();
        System.out.println("1.Insert 2.Delete 3.Linear Search 4.Binary Search 5.Maximum 6.Even/Odd 7.Insertion Sort 8.Display 9.Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter index and element: ");
            insert(arr, sc.nextInt(), sc.nextInt());
        }
        else if (choice == 2) {
            System.out.print("Enter position: ");
            delete(arr, sc.nextInt());
        }
        else if (choice == 3) {
            System.out.print("Enter element: ");
            linearSearch(arr, sc.nextInt());
        }
        else if (choice == 4) {
            System.out.print("Enter element: ");
            binarySearch(arr, sc.nextInt());
        }
        else if (choice == 5) {
            findMaximum(arr);
        }
        else if (choice == 6) {
            countEvenOdd(arr);
        }
        else if (choice == 7) {
            insertionSort(arr);
            System.out.println("Array sorted");
        }
        else if (choice == 8) {
            display(arr);
        }
        else {
            System.out.println("Invalid choice");
        }
    }
}

