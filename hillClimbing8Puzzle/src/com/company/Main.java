package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] a = new int[9];
        int[][] aPrin = new int[3][3];
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int k = 9;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int tempIndex = random.nextInt(k);
            a[i] = temp[tempIndex];
            for (int j = tempIndex + 1; j < 9; j++) {
                temp[j - 1] = temp[j];
            }
            k--;
        }

        /*a= new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8};*/
        for (int i = 0; i < 9; i++) {
            int m = i % 3;
            int n = i / 3;
            aPrin[n][m] = a[i];
        }


        print(aPrin);
        System.out.println("choose alghorithm 1.hillClimbing  2.LBS");
        int algorithm = input.nextInt();

        if (algorithm == 1) {
            int resultA = huristic(aPrin);


            int m = 0;
            int n = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (aPrin[i][j] == 0) {
                        m = i;
                        n = j;
                        break;
                    }
                }
            }

            if (resultA == 0) {
                System.out.println("Goal is find!");
                System.exit(0);
            }


            int mPrin = m;
            int nPrin = n;

            while (true) {


                mPrin++;
                if (mPrin < 3) {
                    int[][] b = copy(aPrin);
                    b[m][n] = b[mPrin][nPrin];
                    b[mPrin][nPrin] = 0;
                    if (huristic(b) == 0) {
                        System.out.println("find result");
                        print(b);
                        System.out.println("huristic:" + huristic(b));
                        break;
                    }
                    if (huristic(b) < resultA) {

                        aPrin = b;
                        print(aPrin);
                        System.out.println("huristic:" + huristic(aPrin));
                        resultA = huristic(aPrin);
                        m = mPrin;
                        n = nPrin;
                        continue;
                    }
                }

                mPrin = m;
                nPrin = n;

                mPrin--;
                if (mPrin > -1) {
                    int[][] b = copy(aPrin);
                    b[m][n] = b[mPrin][nPrin];
                    b[mPrin][nPrin] = 0;
                    if (huristic(b) == 0) {
                        System.out.println("find result");
                        print(b);
                        System.out.println("huristic:" + huristic(b));
                        break;
                    }
                    if (huristic(b) < resultA) {
                        aPrin = b;
                        print(aPrin);
                        System.out.println("huristic:" + huristic(aPrin));
                        resultA = huristic(aPrin);
                        m = mPrin;
                        n = nPrin;
                        continue;
                    }
                }

                mPrin = m;
                nPrin = n;


                nPrin++;
                if (nPrin < 3) {
                    int[][] b = copy(aPrin);
                    b[m][n] = b[mPrin][nPrin];
                    b[mPrin][nPrin] = 0;
                    if (huristic(b) == 0) {
                        System.out.println("find result");
                        print(b);
                        System.out.println("huristic:" + huristic(b));
                        break;
                    }
                    if (huristic(b) < resultA) {
                        aPrin = b;
                        print(aPrin);
                        System.out.println("huristic:" + huristic(aPrin));
                        resultA = huristic(aPrin);
                        m = mPrin;
                        n = nPrin;
                        continue;
                    }
                }

                mPrin = m;
                nPrin = n;


                nPrin--;
                if (nPrin > -1) {
                    int[][] b = copy(aPrin);
                    b[m][n] = b[mPrin][nPrin];
                    b[mPrin][nPrin] = 0;
                    if (huristic(b) == 0) {
                        System.out.println("find result");
                        print(b);
                        System.out.println("huristic:" + huristic(b));
                        break;
                    }
                    if (huristic(b) < resultA) {
                        aPrin = b;
                        print(aPrin);
                        System.out.println("huristic:" + huristic(aPrin));
                        resultA = huristic(aPrin);
                        m = mPrin;
                        n = nPrin;
                        continue;
                    }
                }


                System.out.println("Goal not find!");
                break;


            }
        }
        else if (algorithm==2){

        }
    }

    public static int huristic (int[][] a){
    int result = 0;
    /*for (int i=0;i<3;i++){
        for (int j=0;j<3;j++){
            result += Math.abs(i-(a[i][j]/3));
            result += Math.abs(j-(a[i][j]%3));
        }
    }
*/
    int [][] b = {{0,1,2},{3,4,5},{6,7,8}};
    for (int i=0;i<3;i++){
        for (int j=0;j<3;j++){
            if (a[i][j]!=b[i][j]){
                result++;
            }
        }
    }

    return result;
    }




    public static void print (int[][] a){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] copy(int[][] a){
        int [][] b= new int[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                b[i][j]=a[i][j];
            }
        }


        return b;
    }
}
