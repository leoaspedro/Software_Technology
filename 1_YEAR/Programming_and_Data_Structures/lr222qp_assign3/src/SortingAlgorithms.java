import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithms {
    public static void main(String[] args){

        int[] arr ={4,3,5,1,2};
        String [] abc = {"d","c","b","a"};
        Comparator<String> ab = String::compareTo;

        for(int i =0;i<arr.length;i++){
            int[] a = insertionSort(arr);

            System.out.print(" "+a[i]);

        }
        String[] b = insertionSort(abc,ab);
        System.out.println(" "+ Arrays.toString(b));

    }

    //All methods return a new sorted array where all
    // elements are sorted in ascending order (lowest first) in the first two integer array methods,
    public static int[] insertionSort(int [] in){
        int[] newIn = in.clone();
        for(int i =0; i<newIn.length;i++){
            int j = i-1;//pos 0 ->4
            int currentN = newIn[i];//pos 1 ->3
            while(j>=0 && newIn[j]>currentN){
                newIn[j+1] = newIn[j]; // si 4>3 alors newIn[0] = 3
                j=j-1;
            }
            newIn[j+1] = currentN;
        }
        return newIn;
    }

    public static String[] insertionSort(String[] in, Comparator<String> c){

        if(in.length==0){
            System.err.println("The array is empty. Please put a String in the array.");
            return null;
        }else {
            String[] returnArray = new String[in.length];
            returnArray[0] = in[0];
            for (int i = 1; i < in.length; i++) {
                String help = in[i];
                for (int k = i - 1; k >= 0; k--) {
                    if (c.compare(help, returnArray[k]) > 0) {
                        returnArray[k + 1] = help;
                        break;
                    } else {
                        String temp = returnArray[k];
                        returnArray[k] = help;
                        returnArray[k + 1] = temp;
                    }
                }
            }
            return returnArray;
        }

    }

}

