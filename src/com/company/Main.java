package com.company;

import java.util.Scanner;
import java.lang.Math.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static Scanner input = new Scanner(System.in);
    static void zad1(){
        System.out.println("Name:");
        String imie = input.nextLine();
        System.out.println("Hello " + imie);
    }

    static void zad2(){
        //W tym zadaniu iterujemy po pytaniach, odpowiedziach i "elementach wypowiedzi". Proste pętle.
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
        //Przypisanie kolejnych liczb do tablicy. Mogłem użyć pętli, nie chciało mi się.
        System.out.println("First number:");
        numbers[0] = input.nextInt();
        System.out.println("Second number:");
        numbers[1] = input.nextInt();
        System.out.println("Third number:");
        numbers[2] = input.nextInt();

        //Przechodzimy przez tablicę, zapamiętując największą liczbę.
        for (max = numbers[0]; i < 3; i++) {
            if (max < numbers[i]){
                max = numbers[i];
            }
        }

        System.out.println("The biggest number provided was " + max);

    }

    static void zad4(){

        int[] numbers = new int[5];
        //Tutaj powinienembył użyć pętli, nie użyłem.
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

        //Szybka implementacja insert sorta:
        for(int i = 0; i < 4; i++){
            int tmp;    //"cache" do zamiany liczb miejscami
            int j = i;  //Iterator, który będzie przechodził po kolejnych pozycjach tablicy
            while( j >= 0 && numbers[j+1] < numbers[j]){ //Jeżeli liczba w danym miejscu jest mniejsza od następnej...
                //...Zamieniamy je miejscami...
                tmp = numbers[j];
                numbers[j] = numbers[j+1];
                numbers[j+1] = tmp;
                //...I sprawdzamy znowu dla każdej ppoprzedniej pary liczb
                j--;
            }
        }

        for (int number : numbers){
            System.out.println(number);
        }
    }

    static void zad5(float R){
        //Wiele tłumaczyć nie trzeba :)
        System.out.println("Area: " + (4.0f * Math.PI * Math.pow(R, 2)));
        System.out.println("Volume: " + ((4.0f/3.0f) * Math.PI * Math.pow(R, 3)));
    }

    static void zad6(float price, int n){
        float installment = 0.0f;
        //Proste wyrażenia warunkowe do sprawdzenia zakresów, proste operacje na liczbach
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

    static void zad7(){
        Double a, b;
        Character operator;
        //Każdy element działania jest oddzielnym wejściem od użytkownika
        System.out.println("Please input equation. Separate numbers and operator by pressing enter.");
        a = input.nextDouble();
        operator = input.next().charAt(0);
        b = input.nextDouble();
        //Sprawdzam, czy operator istnieje, wykonuję działanie
        switch (operator){
            case '+':
                System.out.println(" = " + (double)(a + b));
                break;

            case '-':
                System.out.println(" = " + (double)(a - b));
                break;

            case '*':
                System.out.println(" = " + (double)(a * b));
                break;

            case '/':
                System.out.println(" = " + (double)(a / b));
                break;

            default:
                System.out.println("\n " + operator + " is not a recognized operator.");
        }
    }

    public static void zad8(int n){
        //Podejście iteracyjne dla zdecydowanie większej prędkości i wydajności w pamięci
        long a = 1, b = 1, cache;
        //Pierwsze dwie liczby zawsze takie same
        System.out.println(a);
        System.out.println(b);
        for(int i = 0; i < n; i++){
            //Cache tymczasowo przechowuje starą wartość
            cache = b;
            //Wypisujemy kolejną liczbę
            System.out.println(a+b);
            //Nowa wartość b
            b += a;
            //Stare b przypisujemy a
            a = cache;
        }
    }

    static class zad9{
        //Klasa stworzona dla większej czytelnośći.
        public static void insertSort(int[] numbers){
            //Informacja dla użytkownika
            System.out.print("\nInput: [");
            for(int number : numbers){
                System.out.print(" " + number);
            }
            System.out.print("].");

            //Ten sam insertion sort co poprzednio
            for(int i = 0; i < numbers.length - 1; i++){
                int tmp;
                int j = i;
                while( j >= 0 && numbers[j+1] < numbers[j]){
                    tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                    j--;
                }
            }

            //Znowu informacja dla użytkownika
            System.out.print("\nOutput sorted by insert sort: [");
            for(int number : numbers){
                System.out.print(" " + number);
            }
            System.out.print(" ].\n");
        }

        public static void bubbleSort(int[] numbers){
            //upperBound ogranicza długość wykonywania jednej z pętli
            int upperBound = numbers.length-1;
            int cache;
            //Informacje dla użytkownika
            System.out.print("\nInput: [");
            for(int number : numbers){
                System.out.print(" " + number);
            }
            System.out.print("].\n");
            //Dopóki nie posortujemy całej tablicy...
            while(upperBound > 0) {
                //...Porównujemy każdą liczbę z następną, zamieniamy jeżeli jest większa
                for (int i = 0; i < upperBound; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                        cache = numbers[i + 1];
                        numbers[i + 1] = numbers[i];
                        numbers[i] = cache;
                    }
                }
                //Po każdym przejściu kolejna liczba na końcu jest posortowana, zostanie zignorowana przy kolejnych
                upperBound--;
            }

            //Informacje dla użytkownika
            System.out.print("Output sorted by bubblesort: [");
            for(int number : numbers){
                System.out.print(" " + number);
            }
            System.out.print(" ].\n");
        }

        public static int[] mergeSort(int[] numbers){
            //Podejście rekurencyjne, tak dla rozmaitości
            if(numbers.length == 1){
                //Jeżeli pozostała jedna liczba, zwracamy - warunek STOP-u
                return numbers;
            } else {
                //Wywołujemy funkcję mergeSort ponownie dla podtablic będących lewą i prawą połówką głównej tablicy
                int[] left = mergeSort(Arrays.copyOfRange(numbers, 0, numbers.length/2));
                int[] right = mergeSort(Arrays.copyOfRange(numbers, numbers.length/2, numbers.length));
                //Zwracamy połączone tablice z tych wywołań
                return merge(left, right);
            }
        }

        public static int[] merge(int[] a, int[] b){
            //Tutaj nieco kodu ze stackoverflow (obiecuję, że tylko te dwie linie) - prymitywna tablica do listy Integer
            LinkedList<Integer> listA = new LinkedList<Integer>(IntStream.of(a).boxed().collect(Collectors.toList()));
            LinkedList<Integer> listB = new LinkedList<Integer>(IntStream.of(b).boxed().collect(Collectors.toList()));
            //Tablica do zwrócenia, jej długość jest równa długości podtablic
            int[] mergedArray = new int[a.length + b.length];
            int i = 0;
            //Iterujemy aż jedna z podlist nie będzie pusta
            while(listA.size() != 0 && listB.size() != 0){
                //Mniejszą z wartości "wkładamy" do tablicy do zwrócenia, usuwamy z listy, z której pochodzi
                if(listA.element() < listB.element()){
                    mergedArray[i] = listA.poll();
                } else {
                    mergedArray[i] = listB.poll();
                }
                //Iterujemy dalej po tablicy do zwrócenia
                i++;
            }
            //Kiedy jedna z podlist jest pusta, zawartość drugiej podlisty "wkładamy" do tablicy do zwrócenia
            if(listA.size() == 0){
                while(listB.size() != 0){
                    mergedArray[i] = listB.poll();
                    i++;
                }
            } else if (listB.size() == 0){
                while(listA.size() != 0){
                    mergedArray[i] = listA.poll();
                    i++;
                }
            }
            return mergedArray;
        }
    }
    public static void main(String[] args) {

//        zad1();
//        zad2();
//        zad3();
//        zad4();
//        zad5(2.34f);
//        zad6(2999.99f, 24);
//        zad7();
//        zad8(75);

        /*
        int[] numbers = {1, 5, 7, 3, 8, 4, 9, 0, 2, 6, 34, 72, 24, 63, 12,75, 22, 24,12};

        zad9.insertSort(numbers);
        zad9.bubbleSort(numbers);

        System.out.print("\nInput: [");
        for(int number : numbers){
            System.out.print(" " + number);
        }
        int[] sortedNumbers = zad9.mergeSort(numbers);
        System.out.print("\nOutput sorted by merge sort: [ ");
        for (int number : sortedNumbers){
            System.out.print(number + " ");
        }
        System.out.print("].");
        */
    }
}
