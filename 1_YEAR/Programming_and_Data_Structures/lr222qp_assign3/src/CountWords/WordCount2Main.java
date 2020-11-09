package CountWords;

import java.util.Iterator;

public class WordCount2Main {

    public static void main (String[] args){

        HashWordSet hash1 = new HashWordSet();
        TreeWordSet tree1 = new TreeWordSet();

        Word word1 = new Word("A");
        Word word2 = new Word("B");
        Word word3 = new Word("C");
        Word word4 = new Word("D");
        Word word5 = new Word("E");
        Word word6 = new Word("F");
        Word word7 = new Word("G");
        Word word8 = new Word("H");
        Word word9 = new Word("I");

        word1.hashCode();
        word2.hashCode();
        word3.hashCode();
        word4.hashCode();
        word5.hashCode();
        word6.hashCode();
        word7.hashCode();
        word8.hashCode();
        word9.hashCode();

        System.out.println("***********HashWordSet Test*************");
        hash1.add(word1);
        hash1.add(word2);
        hash1.add(word3);
        hash1.add(word4);
        hash1.add(word5);
        hash1.add(word6);
        hash1.add(word7);
        hash1.add(word8);
        //hash1.add(word9);
        //hash1.size();
        System.out.println("Contains : "+hash1.contains(word9));
        //System.out.println("Iterator : "+hash1.iterator());
        System.out.println("Size hash1 : "+hash1.size()); // Size
        /*Iterator iterator1 = hash1.iterator();
        System.out.println("Iterator : ");
        while (iterator1.hasNext()){
            System.out.println(iterator1.next() + " ");
        }*/
        System.out.println(hash1.toString());//Iterator

        System.out.println("***********TreeWordSet Test*************");
        tree1.add(word2);
        tree1.add(word1);
        tree1.add(word3);
        System.out.println("Contains : "+tree1.contains(word2));
        System.out.println("Size : "+tree1.size());
        System.out.println(tree1.toString()); //Iterator toString
        Iterator iterator = tree1.iterator();
        System.out.println("TreeSet Iterator : ");
        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }










    }
}
