package main.assignment2.impl;

import main.assignment2.ArrayWithPublishedSize;
import main.assignment2.MyMap;


public class MyHashTableImpl<K, V> implements MyMap<K, V>, ArrayWithPublishedSize {

    private MapEntryImpl<K, V>[] array;

    private static final int DEFAULT_TABLE_SIZE = 11;


    private int currentSize;

    private double MAXIMUM_ALLOWED_LOAD_FACTOR;

    // This is the load factor that the table can never exceed. However, it
    // may happen that an insertion fails before reaching this load factor.
    // the internal rehash() function should be called when either the load
    // factor is higher than a limit passed as an argument in the
    // constructor of MyHashTable or when an insertion fails (this is, when
    // an insertion does not find an empty cell

    public MyHashTableImpl(double MAX_LOAD_FACTOR) {

        // Here you need to create the array. It is not possible to create a new array
        // of generic type in Java. You can use any of the methods to simulate the
        // generic-like array; this assignment does not restrict the method to use for that.


        this.MAXIMUM_ALLOWED_LOAD_FACTOR = MAX_LOAD_FACTOR;
        array = new MapEntryImpl[DEFAULT_TABLE_SIZE];

    }


    private void allocateArray(int arraySize) {
        array = new MapEntryImpl[nextPrime( arraySize )];

    }

    private int nextPrime(int arraySize) {
         arraySize++;
         for (int i = 2; i < arraySize; i++) {
             if(arraySize%i == 0) {
                 arraySize++;
                 i=2;
             }
             else {
                    continue;
                }
            }
            return arraySize;
        }

    private int findPos( K key ) {
        int offset = 1;
        int currentPos = myhash( key );

        while( array[ currentPos ] != null && !array[ currentPos ].getKey().equals( key ) ){
            currentPos += offset; // Compute ith probe
            offset += 2;
            if( currentPos >= array.length )
                 currentPos -= array.length;
        }

        return currentPos;
        }

    private int myhash( K key ) {
        int hashVal = key.hashCode( );
        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;
        return hashVal;
    }
    private boolean isActive( int currentPos ) {
        return array[ currentPos ] != null && array[ currentPos ].isActive;

    }

    @Override
    public int getLengthOfArray() {
        return array.length;
    }

    private void rehash() {
        MapEntryImpl<K,V> [ ] oldArray = array;

        // Create a new double-sized, empty table
        allocateArray( nextPrime( 2 * oldArray.length ) );
        currentSize = 0;

        // Copy table over
        for( int i = 0; i < oldArray.length; i++ )
            if( oldArray[ i ] != null && oldArray[ i ].isActive )
                insert( oldArray[ i ].getKey(), oldArray[i].getValue() );
    }
    @Override
    public void insert(K key, V value) {
        // TODO Auto-generated method stub
        // Insert x as active
        int currentPos = findPos(key);
        if (isActive(currentPos)){
            if(array[currentPos].getKey() == key){
                array[currentPos].setValue(value);
            }
            return;
        }



        array[currentPos] = new MapEntryImpl<>(key, value);
        array[currentPos].isActive = true;

        if (++currentSize > array.length / 2)
            rehash();

    }

    @Override
    public void delete(K key) {
        int currentPos = findPos( key );
        if( isActive( currentPos ) )
            array[ currentPos ].isActive = false;
    }

    @Override
    public V contains(K key) {
        // TODO Auto-generated method stub
        int currentPos = findPos( key );
        if(array[currentPos].isActive){
            return array[currentPos].getValue();
        }
          else{
              return null;
        }

        }

    }


