package main.assignment1.impl;

import main.assignment1.MyList;

import java.util.Arrays;

public class MyListImpl implements MyList {
    private int size;
    private final int DEFAULT_CAP = 2;
    private Object[] words;

    public MyListImpl(){
        size =0;
        words = new Object[DEFAULT_CAP];
    }

    public void add(Object word){
        if(word!= null){
            if(size ==words.length){
                resize();
            }
            words[size++] = word;
        }
    }
    private void resize(){
        int newSize = words.length *2;
        words = Arrays.copyOf(words,newSize);
    }
    @Override
    public Object get(int index) {
        if(index<=size && index >=0){
            return words[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
