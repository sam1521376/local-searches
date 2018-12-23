package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a = new int[12];
        Scanner input = new Scanner(System.in);
        for (int i=0;i<12;i++){
            System.out.println("please enter next int");
            a[i]= input.nextInt();
        }
        for (int i=0;i<12;i++){
            System.out.println(a[i]);
        }
        System.out.println("enter number of algorithm: \n 1.hill-climbing \n 2.LBS \n 3.SA");
        int algn = input.nextInt();

        if (algn==1){
            hillClimbing(a);
        }
        else if (algn==2){
            LBS(a);

        }
        else if (algn==3){

        }



    }


    public static void hillClimbing (int[] a ){
        int min = a[0];
        int minIndex = 0;
        int goal;
        for (int i=0;i<12;i++){
            if (a[i]<=min){
                min = a[i];
                minIndex = i;
            }
            if (a[i]==0){
                min = 0;
                goal = i;
                System.out.println("Goal has been found in i = "+i);
                break;
            }
            if (a[i]>min){
                System.out.println("algorithm has been stoped in i = "+ i);
            break;
            }
        }
        if (min !=0 ){
            System.out.println("Goal can not be found with hill-climbing algorithm");
        }

    }


    public static void LBS (int[] a){
        int min = a[0];
        int minIndex = 0;
        int goal=-1;
        int i=0;
        for (int k=0;k<12;k++) {

            if ((i!=5)&&(i!=11)) {

                if (a[i] == 0) {
                    min = 0;
                    goal = i;
                    System.out.println("Goal has been found in i = " + i);
                    break;
                }
                if (a[i + 1] <= a[i]) {
                    min = a[i];
                    minIndex = i;
                }

                if (a[i + 1] > a[i]) {
                    System.out.println("algorithm has been stoped in i = " + i);
                    break;
                }
            }
                if (i < 6) {
                    i += 6;
                } else {
                    i = i - 5;
                }
            }

        if (goal == -1 ){
            System.out.println("Goal can not be found with LBS algorithm");
        }

    }

    public static void SA (int[] a){

    }

}
