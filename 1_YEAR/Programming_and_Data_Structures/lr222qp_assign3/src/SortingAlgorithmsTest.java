
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsTest {

    @BeforeEach
    public void setsA() {
    }

    @Test
    public void insertionSortTest() {
        //One Element Array Testing
        int[] arr1 = {1};
        assertArrayEquals(arr1, SortingAlgorithms.insertionSort(arr1));

        // Few Element array Testing
        int[] arr = {4, -3, 2, 1};
        int[] arrSorted = {-3, 1, 2, 4};
        assertArrayEquals(arrSorted, SortingAlgorithms.insertionSort(arr));

        //Huge Array
        int[] arrHuge = new int[1000];
        Random rd = new Random();
        for (int i = 0; i < arrHuge.length; i++) {

            arrHuge[i] = rd.nextInt();
        }
        int[] arrHugeSorted = arrHuge.clone();
        Arrays.sort(arrHugeSorted);

        assertArrayEquals(arrHugeSorted, SortingAlgorithms.insertionSort(arrHuge));

    }

    @Test
    public void insertionSort1Test() {
        //Simple Test
        String[] str = {"A", "B", "C"};
        String[] str1 = {"C", "A", "B"};
        Comparator<String> ab = (s1, s2) -> s1.compareTo(s2);
        assertArrayEquals(str, SortingAlgorithms.insertionSort(str1, ab));

        //Few element test
        String[] text = {"hello", "good", "nice", "why", "char", "abc", "zebra", "casio"};
        String[] textSorted = {"abc", "casio", "char", "good", "hello", "nice", "why", "zebra"};
        assertArrayEquals(textSorted, SortingAlgorithms.insertionSort(text, ab));

        //One element test
        String[] tx = {"test"};
        assertArrayEquals(tx, SortingAlgorithms.insertionSort(tx, ab));

        //Huge element Test
        String[] hugeRandomLetter = new String[1000];
        String abc = "abcdefghijklmnopqrstuvwxyz";
        Random rd = new Random();
        for (int i = 0; i < hugeRandomLetter.length; i++) {
            char t = (char) ('a' + rd.nextInt(abc.length()));
            hugeRandomLetter[i] = t + "";
        }
        String[] hugeRandomLetterSorted = hugeRandomLetter.clone();
        Arrays.sort(hugeRandomLetterSorted);
        //System.out.println(" "+ Arrays.toString(hugeRandomLetter));
        //System.out.println(" "+ Arrays.toString(hugeRandomLetterSorted));
        assertArrayEquals(hugeRandomLetterSorted, SortingAlgorithms.insertionSort(hugeRandomLetter, ab));
    }
}