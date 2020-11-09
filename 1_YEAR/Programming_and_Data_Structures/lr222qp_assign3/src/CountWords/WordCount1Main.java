package CountWords;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordCount1Main {

    public static void main(String[] args){
        ArrayList<Word> wordss = new ArrayList<>();
        Set<Word> hashSet = new HashSet<>(); //Create an empty set with no duplicate
        Set<Word> treeSet = new TreeSet<>();

        try {
            Scanner sc = new Scanner(new File("C:\\Users\\LeonardoPedro\\IdeaProjects\\lr222qp_assign3\\src\\words"));
            while (sc.hasNext()){
                String tempString = sc.next();
                wordss.add(new Word(tempString));
            }

            for(Word w : wordss){
                hashSet.add(w);
                treeSet.add(w);
            }
            sc.close();

        } catch (IOException ioe){
            ioe.getCause();
        }

        System.out.println("***************HashSet Test******************\n");
        System.out.println("HashSet size : "+ hashSet.size());
        //Iterator of HashSet
        Iterator iterator1 = hashSet.iterator();
        System.out.println("HashSet iterator : ");
        while(iterator1.hasNext()){
            System.out.println(iterator1.next()+" ");
        }
        System.out.println("HashSet contains : "+hashSet.contains(1)+"\n");

        System.out.println("***************TreeSet Test******************\n");
        System.out.println("TreeSet size : "+treeSet.size());

        //Iteration of a TreeSet
        Iterator iterator;
        iterator = treeSet.iterator();
        System.out.println("TreeSet iterator : ");
        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }

    }
}
