package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] a = new int[8];
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            a[i] = random.nextInt(8) + 1;
            System.out.println(a[i]);
        }


        Scanner input = new Scanner(System.in);

       /* for (int i=0;i<8;i++){
            System.out.println("enter "+i+" number");
            a[i]=input.nextInt();
        }*/

        System.out.println("choose alghorithm 1.hillClimbing  2.LBS");
        int algorithm = input.nextInt();

        if (algorithm == 1) {


            int resultA = tadakhol(a);


            if (resultA == 0) {
                System.out.println("Goal is find !");
            }

            print(a);

            while (true) {
                boolean findGoal = false;
                boolean findBetter = false;

                for (int i = 0; i < 8; i++) {
                    int[] b = copy(a);
                    int resultB = 0;
                    if ((b[i] > 1) && (b[i] < 8)) {
                        b[i]++;
                        resultB = tadakhol(b);
                        if (resultB == 0) {
                            a = b;
                            resultA = resultB;
                            System.out.println("Goal is find!");
                            print(a);
                            findGoal = true;
                            findBetter = true;
                            break;
                        } else if (resultB < resultA) {
                            a = b;
                            resultA = resultB;
                            print(a);
                            findBetter = true;
                            break;
                        }


                        b = copy(a);
                        b[i]--;
                        resultB = tadakhol(b);

                        if (resultB == 0) {
                            a = b;
                            resultA = resultB;
                            System.out.println("Goal is find!");
                            print(a);
                            findGoal = true;
                            findBetter = true;
                            break;

                        } else if (resultB < resultA) {
                            a = b;
                            resultA = resultB;
                            print(a);
                            findBetter = true;
                            break;
                        }
                    } else if (b[i] == 1) {
                        b[i]++;
                        resultB = tadakhol(b);
                        if (resultB == 0) {
                            a = b;
                            resultA = resultB;
                            System.out.println("Goal is find!");
                            print(a);
                            findGoal = true;
                            findBetter = true;
                            break;
                        } else if (resultB < resultA) {
                            a = b;
                            resultA = resultB;
                            print(a);
                            findBetter = true;
                            break;
                        }

                    } else if (b[i] == 8) {
                        b[i]--;
                        resultB = tadakhol(b);

                        if (resultB == 0) {
                            a = b;
                            resultA = resultB;
                            System.out.println("Goal is find!");
                            print(a);
                            findGoal = true;
                            findBetter = true;
                            break;

                        } else if (resultB < resultA) {
                            a = b;
                            resultA = resultB;
                            print(a);
                            findBetter = true;
                            break;
                        }
                    }
                }

                if (findGoal == true) {
                    break;
                }
                if (findBetter == false) {
                    System.out.println("not find Goal!");
                    break;
                }
            }


        }
        else if (algorithm==2){
            int [] a1 = new int[4];
            int [] a2 = new int[4];
            for (int i=0;i<4;i++){
                a1[i]=a[i];
            }
            for (int i=0;i<4;i++){
                a2[i]=a[i+4];
            }


            int resultA1 = tadakhol2(a1);
            int resultA2 = tadakhol2(a2);


            if (resultA1 == 0) {
                System.out.println("Goal is find for part1 !");
            }


            if (resultA2 == 0) {
                System.out.println("Goal is find for part2 !");
            }




            boolean findGoal1 = false;
            boolean findGoal2 = false;

            while (true) {

                boolean findBetter1 = false;


                boolean findBetter2 = false;

                int[] a3 = new int[8];
                for (int i=0;i<8;i++){
                    if (i/4==0){
                        a3[i]=a1[i];
                    }
                    else {
                        a3[i]=a2[i-4];
                    }
                }

                print(a3);
                for (int i = 0; i < 4; i++) {
                    int[] b1 = copy(a1);
                    int resultB1 = 0;
                    int[] b2 = copy(a2);
                    int resultB2 = 0;

                    if (findGoal1!=true){
                    if ((b1[i] > 1) && (b1[i] < 8)) {
                        b1[i]++;
                        resultB1 = tadakhol2(b1);
                        if (resultB1 == 0) {
                            a1 = copy(b1);
                            resultA1 = resultB1;
                            System.out.println("Goal for part1 is find!");
                            findGoal1 = true;
                            findBetter1 = true;

                        } else if (resultB1 < resultA1) {
                            a1 = b1;
                            resultA1 = resultB1;
                            findBetter1 = true;
                        }


                        b1 = copy(a1);
                        b1[i]--;
                        resultB1 = tadakhol2(b1);

                        if (resultB1 == 0) {
                            a1 = b1;
                            resultA1 = resultB1;
                            System.out.println("Goal for part1 is find!");
                            findGoal1 = true;
                            findBetter1 = true;


                        } else if (resultB1 < resultA1) {
                            a1 = b1;
                            resultA1 = resultB1;
                            findBetter1 = true;

                        }
                    } else if (b1[i] == 1) {
                        b1[i]++;
                        resultB1 = tadakhol2(b1);
                        if (resultB1 == 0) {
                            a1 = b1;
                            resultA1 = resultB1;
                            System.out.println("Goal for part1 is find!");
                            findGoal1 = true;
                            findBetter1 = true;

                        } else if (resultB1 < resultA1) {
                            a1 = b1;
                            resultA1 = resultB1;
                            findBetter1 = true;

                        }

                    } else if (b1[i] == 8) {
                        b1[i]--;
                        resultB1 = tadakhol2(b1);

                        if (resultB1 == 0) {
                            a1 = copy(b1);
                            resultA1 = resultB1;
                            System.out.println("Goal for part1 is find!");
                            findGoal1 = true;
                            findBetter1 = true;


                        } else if (resultB1 < resultA1) {
                            a1 = b1;
                            resultA1 = resultB1;
                            findBetter1 = true;

                        }
                    }
                }

                    if (findGoal2 != true) {


                        if ((b2[i] > 1) && (b2[i] < 8)) {
                            b2[i]++;
                            resultB2 = tadakhol2(b2);
                            if (resultB2 == 0) {
                                a2 = copy(b2);
                                resultA2 = resultB2;
                                System.out.println("Goal for part2 is find!");
                                findGoal2 = true;
                                findBetter2 = true;

                            } else if (resultB2 < resultA2) {
                                a2 = b2;
                                resultA2 = resultB2;
                                findBetter2 = true;

                            }


                            b2 = copy(a2);
                            b2[i]--;
                            resultB2 = tadakhol2(b2);

                            if (resultB2 == 0) {
                                a2 = b2;
                                resultA2 = resultB2;
                                System.out.println("Goal for part2 is find!");
                                findGoal2 = true;
                                findBetter2 = true;


                            } else if (resultB2 < resultA2) {
                                a2 = b2;
                                resultA2 = resultB2;
                                findBetter2 = true;

                            }
                        } else if (b2[i] == 1) {
                            b2[i]++;
                            resultB2 = tadakhol2(b2);
                            if (resultB2 == 0) {
                                a2 = b2;
                                resultA2 = resultB2;
                                System.out.println("Goal for part2 is find!");
                                findGoal2 = true;
                                findBetter2 = true;

                            } else if (resultB2 < resultA2) {
                                a2 = b2;
                                resultA2 = resultB2;
                                findBetter2 = true;

                            }

                        } else if (b2[i] == 8) {
                            b2[i]--;
                            resultB2 = tadakhol2(b2);

                            if (resultB2 == 0) {
                                a2 = copy(b2);
                                resultA2 = resultB2;
                                System.out.println("Goal for part2 is find!");
                                findGoal2 = true;
                                findBetter2 = true;


                            } else if (resultB2 < resultA2) {
                                a2 = b2;
                                resultA2 = resultB2;
                                findBetter2 = true;
                            }
                        }
                    }
                }

                if ((findGoal1 == true)&&(findGoal2 == true)) {
                    print(a);
                    break;
                }
                if ((findBetter1 == false)&&(findBetter2 == false)) {
                    System.out.println("not find Goal!");
                    break;
                }
            }


        }
    }

    public static int tadakhol (int[] a){
        int result = 0;



        for (int i=0;i<8;i++){
            for (int j=i+1;j<8;j++){
                if (a[i]==a[j]){
                    result++;
                }
                if (Math.abs(a[i]-a[j])==j-i){
                    result++;
                }
            }
        }
        return result;
    }


    public static int tadakhol2 (int[] a){
        int result = 0;

        for (int i=0;i<4;i++){
            for (int j=i+1;j<4;j++){
                if (a[i]==a[j]){
                    result++;
                }
                if (Math.abs(a[i]-a[j])==j-i){
                    result++;
                }
            }
        }
        return result;
    }

    public static void print (int [] a){
        System.out.print("{");
        for (int i=0;i<a.length;i++){
            if (i<a.length-1) {
                System.out.print(a[i] + ",");
            }
            else {
                System.out.print(a[i]);

            }

        }
        System.out.print("}     "+tadakhol(a)+"\n");
    }


    public static int[] copy(int[] a){
        int [] b = new int[a.length];
        for (int i=0;i<a.length;i++){
            b[i]=a[i];
        }
        return b;
    }

}


