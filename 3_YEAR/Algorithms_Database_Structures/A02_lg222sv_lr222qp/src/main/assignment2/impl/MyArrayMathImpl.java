package main.assignment2.impl;

import main.assignment2.ArrayMath;


public class MyArrayMathImpl implements ArrayMath {

    @Override
    public boolean isSameCollection(int[] array1, int[] array2) {
        if(array1.length != array2.length){
            return false;
        }else{
            heapsort(array1);
            heapsort(array2);

            for(int i=0;i<array1.length;i++){
                if(array1[i]!=array2[i]){
                    return false;
                }
            }

        }

        return true;
    }

    @Override
    public int minDifferences(int[] array1, int[] array2) {
        int difference = 0;
        if(array1.length != array2.length){
            throw new ArithmeticException("Array1 and Array2 dont have the same size.");
        }
        else{
            heapsort(array1);
            heapsort(array2);

            for (int i = 0; i < array1.length; i++) {
                difference += Math.pow(array1[i] - array2[i], 2);
            }

            return difference;
        }

    }

    private static int leftChild( int i ){
        return 2 * i + 1;
    }

    private static void percDown( int [ ] a, int i, int n ) {
        int child;
        int tmp;

        for( tmp = a[ i ]; leftChild( i ) < n; i = child ) {
            child = leftChild( i );
            if( child != n - 1 && a[ child ]>( a[ child + 1 ] ) )
                child++;
            if( tmp> a[ child ] )
                a[ i ] = a[ child ];
            else
                break;
        }
        a[ i ] = tmp;
    }
    public static void heapsort( int [ ] a ){
        for( int i = a.length / 2 - 1; i >= 0; i-- ) {/* buildHeap */
            percDown(a, i, a.length);
        }
        for( int i = a.length - 1; i > 0; i-- ) {
            swapReferences( a, 0, i ); /* deleteMax */
            percDown( a, 0, i );
        }
    }

    public static  void swapReferences(int [] a, int posMin, int posToSwiched ){
        int temp = a[posMin];
        a[posMin]=a[posToSwiched];
        a[posToSwiched] = temp;
    }

    @Override
    public int[] getPercentileRange(int[] arr, int lower, int upper) {
        if(lower > upper){
            //throw some random exception
        }else{
            heapsort(arr);
            int percentageElement = 100/arr.length;
            int sizeToReturn = (upper-lower) /percentageElement;

            int[] result  = new int[sizeToReturn];


            int pos =0;
            for(int i =(arr.length -1-lower/percentageElement);i > (upper /percentageElement)-1 ;i--){
                System.out.println(arr[i]);
                result[pos++] = arr[i];
            }
            return result;
        }
        return null;
    }

}