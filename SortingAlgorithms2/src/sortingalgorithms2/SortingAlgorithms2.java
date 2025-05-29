
package sortingalgorithms2;

import java.util.*;

public class SortingAlgorithms2 {

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

        // merge sort
        mergeSort(randomizedNames_StringArray);

        // quick sort
        quickSort(randomizedNames_StringArray);
    }

    // <editor-fold desc="Merge Sort stuff">
    public static void mergeSort(String[] array) {

        if (array == null || array.length <= 1) {
            return;
        }
        mergeSortHelper(array, 0, array.length - 1);

        printOutArray(array, "Merge");

    }

    private static void mergeSortHelper(String[] array, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(array, left, mid);
            mergeSortHelper(array, mid + 1, right);
            merge(array, left, mid, right);
        }

    }

    private static void merge(String[] array, int left, int mid, int right) {

        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        String[] leftArray = new String[leftSize];
        String[] rightArray = new String[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Merge the temp arrays
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }

    }
    // </editor-fold>

    // <editor-fold desc="Merge Sort stuff">
    public static void quickSort(String[] array) {

        if (array == null || array.length <= 1) {
            return;
        }
        quickSortHelper(array, 0, array.length - 1);

        printOutArray(array, "Quick");

    }

    private static void quickSortHelper(String[] array, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }

    }

    private static int partition(String[] array, int low, int high) {

        String pivot = array[high];
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high); // move pivot to correct position
        return i + 1;

    }

    private static void swap(String[] array, int i, int j) {

        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
    // </editor-fold>

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
