package sortingalgorithms;

import java.util.*;

public class SortingAlgorithms {

    public static void main(String[] args) {

        Random randomizer = new Random();

        String[] names_StringArray = {"Aaron", "Abigail", "Alexander", "Alice", "Benjamin", "Brianna", "Caleb", "Charlotte", "Daniel",
            "Diana", "Elijah", "Emma", "Gabriel", "Grace", "Hannah", "Isaac", "Isabella", "Jacob", "Jasmine", "Joshua", "Katherine",
            "Kevin", "Leah", "Liam", "Lucas", "Madison", "Mathew", "Mia", "Nathan", "Noah", "Olivia", "Owen", "Patrick", "Penelope",
            "Quentin", "Rachel", "Samuel", "Sarah", "Sophia", "Steven", "Thomas", "Tristan", "Uriel", "Vanessa", "Victor", "Willian",
            "Xander", "Yasmine", "Zachary", "Zoe"};

        String[] randomizedNames_StringArray = new String[names_StringArray.length];

        // puts the names into a randomized array
        for (String name_String : names_StringArray) {

            while (true) {

                int chosenRandomIndex = randomizer.nextInt(names_StringArray.length);
                if (randomizedNames_StringArray[chosenRandomIndex] == null) {

                    randomizedNames_StringArray[chosenRandomIndex] = name_String;
                    break;

                }

            }

        }

        printOutArray(randomizedNames_StringArray, "Unasorted/ Randomized");
        
        // bubble sort
        bubbleSort(randomizedNames_StringArray);

        // selection sort
        selectionSort(randomizedNames_StringArray);

        // insertion sort
        insertionSort(randomizedNames_StringArray);

    }

    public static void bubbleSort(String[] stringArray) {

        for (int i = 0; i < stringArray.length - 1; i++) {

            for (int j = 0; j < stringArray.length - 1 - i; j++) {

                if (stringArray[j].compareTo(stringArray[j + 1]) > 0) {

//                    System.out.printf("%s > %s\n", stringArray[i], stringArray[j]);
                    String temp = stringArray[j];
                    stringArray[j] = stringArray[j + 1];
                    stringArray[j + 1] = temp;

                }
            }

        }

        printOutArray(stringArray, "Bubble");

    }

    public static void selectionSort(String[] stringArray) {

        for (int i = 0; i < stringArray.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < stringArray.length - 1; j++) {
                if (stringArray[j].compareTo(stringArray[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {

                String temp = stringArray[i];
                stringArray[i] = stringArray[minIndex];
                stringArray[minIndex] = temp;

            }

        }

        printOutArray(stringArray, "Selection");

    }

    public static void insertionSort(String[] stringArray) {

        for (int i = 0; i < stringArray.length - 1; i++) {

            String temp = stringArray[i];
            for (int j = i - 1; j >= 0 && temp.compareTo(stringArray[j]) < 0; j--) {

                stringArray[j] = stringArray[j + 1];
                stringArray[j + 1] = temp;

            }

        }

        printOutArray(stringArray, "Insertion");

    }

    private static void printOutArray(String[] stringArray, String sortingType) {

        System.out.println("Sorting type: " + sortingType);
        linebreak(0);

        int rowCount = 0;
        for (String stringArray1 : stringArray) {
            System.out.printf("%s, ", stringArray1);
            if (rowCount < 3) {
                rowCount++;
            } else {
                System.out.println();
                rowCount = 0;
            }
        }

        System.out.println();
        linebreak(2);
    }

    public static void linebreak(int type) {

        switch (type) {

            case 0 -> {
                System.out.println("------------------------------------------------------------");
                System.out.println();
            }

            case 1 -> {
                System.out.println("------------------------------");
                System.out.println();
            }

            case 2 -> {
                System.out.println("------------------------------------------------------------");
                System.out.println("------------------------------------------------------------");
                System.out.println();
            }

            case 3 -> {
                System.out.println("------------------------------");
                System.out.println("------------------------------");
                System.out.println("------------------------------");
                System.out.println();
            }

            case 4 ->
                System.out.println();

        }

    }

}
