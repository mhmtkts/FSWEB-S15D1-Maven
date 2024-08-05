package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List groceryList = new ArrayList();

    public Scanner startGrocery() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lütfen 0 ile 2 arasında bir sayı girin: ");
        int girdi = sc.nextInt();
        if (girdi == 0) {
            sc.close();
        } else if (girdi == 1) {
            System.out.print("Eklenmesini istediğiniz elemanları giriniz.");
            String input = sc.nextLine();
            addItems(input);
        }else if (girdi == 2) {
            System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
            String input = sc.nextLine();
            removeItems(input);
        }

        return sc;
    }

    public  static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            if (checkItemIsInList(item)){
                System.out.println("Girilen item listede var: " + item);
            }else {
                groceryList.add(item);
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            if (checkItemIsInList(item)){
                groceryList.remove(item);
            }else {
                System.out.println("Girilen item listede yok: " + item);
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }

    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }


}
