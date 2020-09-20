package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class yourapp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String text;

        if ( args.length == 0 ) {

            System.out.println("Error. No variable values entered");

            System.out.println("");
            System.out.println("Enter text");

            text = scanner.nextLine();

            if (text.equals("")) {
                System.out.println("Error. No variable values entered");
            } else {

                String[] array = text.split(" "); // Помещение слов в массив

                System.out.println("");
                System.out.println("Start");
                System.out.println("");
                System.out.println("Level 1");
                System.out.println("");
                for (int i = 0; i < array.length; i++)
                    System.out.println(array[i]);

                Level2(array); // сортировка по алфавиту

                System.out.println("");
                System.out.println("Level 2");
                System.out.println("");
                for (int i = 0; i < array.length; i++) { // вывод сортировки по алфовиту
                    System.out.println(array[i]);
                }

                String[] arrayCopy = Level3(array); // Оставляем уникальные слова
                int[] count = Level4(array, arrayCopy); // Считаем количество повторений

                System.out.println("");
                System.out.println("Level 4");
                System.out.println("");

                for (int i = 0; i < arrayCopy.length; i++) {
                    System.out.println(arrayCopy[i] + " " + count[i]);
                }

                Level5(arrayCopy, count);

                System.out.println("");
                System.out.println("Finish");
                System.out.println("");

            }

        } else {

            System.out.println("Start");
            System.out.println("");
            System.out.println("Level 1");
            System.out.println("");
            for (int i = 0; i < args.length; i++)
                System.out.println(args[i]);

            Level2(args); // сортировка по алфавиту

            System.out.println("");
            System.out.println("Level 2");
            System.out.println("");
            for (int i = 0; i < args.length; i++) { // вывод сортировки по алфовиту
                System.out.println(args[i]);
            }

            String[] arrayCopy = Level3(args); // Оставляем уникальные слова
            int[] count = Level4(args, arrayCopy); // Считаем количество повторений

            System.out.println("");
            System.out.println("Level 4");
            System.out.println("");

            for (int i = 0; i < arrayCopy.length; i++) {
                System.out.println(arrayCopy[i] + " " + count[i]);
            }

            Level5(arrayCopy, count);

            System.out.println("");
            System.out.println("Finish");
            System.out.println("");

        }
    }


    private static String[] Level2 (String [] args ) { // сортировка по алфавиту

        Arrays.sort(args);
        return(args);

    }

    private static String[] Level3 (String [] args ) { // Оставляем уникальные слова

        int count = 0; // создаем счетчик
        int countCopy = 0;
        int counterCopy = 0;

        String [] arrayNew = new String[args.length];

        System.out.println("");
        System.out.println("Level 3");
        System.out.println("");

        for ( int i = 0; i < args.length; i ++ ) {

            count = 0; // обнуляем счетчик в начале цикла

            for ( int j = 0; j < arrayNew.length; j++ ) {

                if (!args[i].equals(arrayNew[j])) {
                    count++;
                }

                if ( count == args.length) {
                    arrayNew [counterCopy] = args [i];
                    countCopy++;
                    System.out.println( arrayNew [ counterCopy ] );
                    counterCopy++;

                }
            }
        }

        String [] arrayCopy = new String[countCopy++];

        for ( int i = 0; i < arrayCopy.length; i++) {
            arrayCopy [i] = arrayNew [i];
        }


        return(arrayCopy);

    }


    private static int[] Level4 (String [] args, String [] arrayCopy ) { // подсчет повторений

        int[] count = new int[arrayCopy.length];

        for (int i = 0; i < arrayCopy.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if (arrayCopy[i].equals(args[j])) {
                    count[i]++;
                }
            }
        }

        return (count);

    }


    private static void Level5 ( String [] arrayCopy,  int [] count ) { // сортировка по количеству повторений

        System.out.println("");
        System.out.println("Level 5");
        System.out.println("");

        for ( int i = count.length - 1; i > 0; i -- ) {
            for ( int j = 0; j < i; j ++ ) {
                if ( count [ j ] < count [ j + 1 ] ) {
                    int tmpCount  = count [ j  ];
                    count [ j ] = count [ j + 1];
                    count [ j + 1 ] = tmpCount;
                    String tmpArroy = arrayCopy [ j ];
                    arrayCopy [ j ] = arrayCopy [ j + 1 ];
                    arrayCopy [ j + 1 ] = tmpArroy;
                }
            }
        }

        for ( int i = 0; i < count.length; i ++ ) {
            System.out.println( arrayCopy [ i ] + " " + count [ i ] );
        }

    }

    private static void Level6 ( String [] args ) { // there is no release
    }

}
