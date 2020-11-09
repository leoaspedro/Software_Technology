package CountWords;


import java.util.Arrays;
import java.util.Iterator;

public class HashWordSet implements WordSet {

    private int sz;
    private Node[] buckets = new Node[8];

    public HashWordSet() {
    }
    //Got help from the lecture
    //Add word if not already added
    @Override
    public void add(Word word) {
        int pos = getBucketNumber(word);
        Node node  = buckets[pos];//

        //search in the list
        while(node!=null){
            if(node.equals(word)){
                return; //return nothing if the element is found
            } else {
                node = node.next; // Goes to the next node in the list
            }
        }

        //Add the word as a new node
        node = new Node(word);
        node.next =buckets[pos];
        buckets[pos]=node;
        sz++;//increase size when added

        if(sz==buckets.length){
            rehash();
        }

    }

    //Return true if word contained
    @Override
    public boolean contains(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];

        //Search for the element
        while(node!=null){
            if(node.value.equals(word)){
                return true; // return true if the element is found
            } else {
                node = node.next; // otherwise it goes to the next one (it keeps searching)
            }
        }
        return false; // Not found
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public Iterator<Word> iterator() {
        return new IteratorHashSet();
    }

    @Override
    public String toString() {
        String mess = "HashSet: { ";
        for(int i=0;i<buckets.length;i++){
            Node node1 = buckets[i];
            while(node1!=null){
                mess+= node1.value + " ";
                node1 = node1.next;
            }
        }
        mess+="}";
        return mess;
    }


    private void rehash(){
        Node[] tempo = buckets;//Copy old bucket
        buckets = new Node[2*tempo.length];//Creates a new one with a double size
        sz = 0; //reset size to 0
        //We insert old value in the new bucket
        for(Node n : tempo){
            if(n==null){
                continue; //empty
            }
            while (n!=null){
                add(n.value); //we add element
                n=n.next;
            }
        }
    }

    //Private method that helps to implement the set. It takes the number at certain pos
    private int getBucketNumber(Word w){
        int hc = w.hashCode();//Take HashCode from Word class
        if(hc<0){
            hc=Math.abs(-hc); //Make sure it's non negative
        }
        return hc%buckets.length; //simple hash function
    }

    //Private class
    private class Node{
        Word value;
        Node next = null;
        public Node(Word w){value = w;}
        public String toString(){return value.toString();}
    }

    private class IteratorHashSet implements Iterator<Word>{
        private int pos;
        private Node current;

        public IteratorHashSet(){
            pos = -1;
            current=null;
        }

        @Override
        public boolean hasNext() {
            if (current!=null && current.next !=null)
                return true;

            for(int i =pos+1;i<buckets.length;i++){
                if(buckets[i]!=null)
                    return true;
            }
            return false;
        }

        @Override
        public Word next() {
            if(current == null || current.next==null){
                if(current!= null)
                    pos++;

                if (pos <buckets.length)
                    current = buckets[pos];
                else
                    throw new IndexOutOfBoundsException();
            }else{
                current = current.next;
            }


            return current.value;
        }
    }

}

