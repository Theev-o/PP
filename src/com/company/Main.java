package com.company;

import java.util.Scanner;
import java.lang.Math.*;


public class Main {
    public static Scanner input = new Scanner(System.in);
    static void zad1(){
        System.out.println("Name:");
        String imie = input.nextLine();
        System.out.println("Hello " + imie);
    }

    static void zad2(){

        String[] questions = {"Name: ", "Age: ", "School: ", "Major: ", "Favorite subject: ", "Least favorite subject: "
                , "Favorite food: ", "Favorite drink: "};
        String[] answers = new String[questions.length];
        String[] story = {"My name is ", ", I'm ",  " years old. I go to " , ", where I study ",
                ". My favorite subject is " , " and my least favorite one is ", ". I like to eat ",  " and drink "};
        for (int i = 0; i< questions.length; i++){
            System.out.print(questions[i]);
            answers[i] = input.nextLine();
        }
        for (int i = 0; i < answers.length; i++){
            System.out.print(story[i] + answers[i]);
        }
    }

    static void zad3(){

        int[] numbers = new int[3];
        int i = 1;
        int max;

        System.out.println("First number:");
        numbers[0] = input.nextInt();
        System.out.println("Second number:");
        numbers[1] = input.nextInt();
        System.out.println("Third number:");
        numbers[2] = input.nextInt();

        for (max = numbers[0]; i < 3; i++) {
            if (max < numbers[i]){
                max = numbers[i];
            }
        }

        System.out.println("The biggest number provided was " + max);

    }

    static void zad4(){

        int[] numbers = new int[5];

        System.out.println("First number:");
        numbers[0] = input.nextInt();
        System.out.println("Second number:");
        numbers[1] = input.nextInt();
        System.out.println("Third number:");
        numbers[2] = input.nextInt();
        System.out.println("Fourth number:");
        numbers[3] = input.nextInt();
        System.out.println("Fifth number:");
        numbers[4] = input.nextInt();

        for(int i = 0; i < 4; i++){
            int tmp;
            int j = i;
            while( j >= 0 && numbers[j+1] < numbers[j]){
                tmp = numbers[j];
                numbers[j] = numbers[j+1];
                numbers[j+1] = tmp;
                j--;
            }
        }

        for (int number : numbers){
            System.out.println(number);
        }
    }

    static void zad5(float R){
        System.out.println("Area: " + (4.0f * Math.PI * Math.pow(R, 2)));
        System.out.println("Volume: " + ((4.0f/3.0f) * Math.PI * Math.pow(R, 3)));
    }

    static void zad6(float price, int n){
        float installment = 0.0f;

        if(n >= 1 && n <=12){
            System.out.println("3% interest");
            installment = (price / (float)n) * 1.03f;
        } else if (n >= 13 && n <= 24){
            System.out.println("6% interest");
            installment = (price / (float)n) * 1.06f;
        } else if (n >= 25 && n <= 48) {
            System.out.println("10% interest");
            installment = (price / (float)n) * 1.1f;
        }

        System.out.println("The monthly installment comes out to " + installment);
    }
    public static void main(String[] args) {

        zad2();

    }
}
