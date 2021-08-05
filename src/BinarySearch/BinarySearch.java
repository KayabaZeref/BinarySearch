/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BinarySearch {

    public static void main(String[] args) {
        int length, search, found;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of array: ");
        length = sc.nextInt();
        sc.nextLine();

        System.out.println("Input search value: ");
        search = sc.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        BinarySearch searcher = new BinarySearch();
        searcher.bubbleSort(array);

        System.out.println("Sorted array: ");
        searcher.displayArray(array);

        found = searcher.binarySearch(array, search, 0, length - 1);
        if (found == -1) {
            System.out.println("Not found !");
        } else {
            System.out.println("\n Found" + search + " at index: " + found);
        }

    }

    public void bubbleSort(int[] arr) {
        boolean swap = true;
        int j = 0;
        int tmp;
        while (swap) {
            swap = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swap = true;
                }

            }
        }
    }

    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }
}
