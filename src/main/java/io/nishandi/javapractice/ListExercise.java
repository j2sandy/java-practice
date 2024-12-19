package io.nishandi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*
Create a Java program that allows a user to perform various operations on an ArrayList of integers.
The program should display a menu of options, and the user should be able to select one of the following operations:

1. Add an element to the list
2. Remove an element from the list
3. Find the minimum element in the list
4. Find the maximum element in the list
5. Print the contents of the list
6. Quit the program

The program should continue to display the menu and allow the user to perform operations until they choose to quit.
*/

public class ListExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int choice = scanner.nextInt();
        
        List<Integer> holdingList = new ArrayList<>();

        while (choice < 7) {
            switch (choice) {
                case 1:
                    Integer inputAdd = scanner.nextInt();
                    holdingList.add(inputAdd);
                    printMenu();
                    choice = scanner.nextInt();
                    break;
                case 2:
                    Integer inputRem = scanner.nextInt();
                    holdingList.remove(inputRem);
                    printMenu();
                    choice = scanner.nextInt();
                    break;
                case 3:
                    System.out.println(Collections.min(holdingList));
                    printMenu();
                    choice = scanner.nextInt();
                    break;
                case 4:
                    System.out.println(Collections.max(holdingList));
                    printMenu();
                    choice = scanner.nextInt();
                    break;
                case 5:
                    System.out.println(holdingList);
                    printMenu();
                    choice = scanner.nextInt();
                    break;
                case 6:
                    ListIterator<Integer> listIterator = holdingList.listIterator(holdingList.size());
                    while (listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous());
                    }
                    printMenu();
                    choice = scanner.nextInt();
                    break;    
                case 7:
                    scanner.close();
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Please select one of the following options");
        System.out.println("1. Add an element to the list");
        System.out.println("2. Remove an element from the list");
        System.out.println("3. Find the minimum element in the list");
        System.out.println("4. Find the maximum element in the list");
        System.out.println("5. Print the list elements in forward order");
        System.out.println("6. Print the list elements in reverse order");
        System.out.println("7. Quit the program");
    }
}
