package main.assignment1.impl;

import main.assignment1.Couple;
import main.assignment1.MyList;

public class AvlMain {
    public static void main(String[] args) {
        MyAVL4StringsImpl tree = new MyAVL4StringsImpl();
        tree.insert("Alice");
        tree.insert("Bob");
        tree.insert("Jon");
        tree.insert("Jonatan");
        tree.insert("Jonna");
        tree.insert("Jones");
        tree.insert("Jonny");
        tree.insert("Jonty");
        tree.insert("Xabier");

        System.out.println("*---------------- PartialSearch Test ----------------*");
        String prefix = "Jonn"; //To change the beginning word
        Couple<String> result = tree.partialSearch(prefix);

        System.out.println("Prefix: "+prefix+"\nFirst: "+result.getFirst()+" / Last: "+result.getLast());

        System.out.println("\n*---------------- Level By Level ----------------*");
        MyList<MyList<String>> listByLevel = tree.LevelByLevelLists();
        tree.printTree(listByLevel);
    }
}
