package CountWords;


import java.util.Iterator;
import java.util.Stack;

public class TreeWordSet implements WordSet {

    private BST root = null;
    private int sz =0;

    public TreeWordSet() {
    }

    @Override
    public void add(Word word) {
        if (root==null){
            root = new BST(word);
            sz++;
        } else {
            root.add(word);
        }
    }

    @Override
    public boolean contains(Word word) {
        return root.contains(word);//return true if it contains
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public Iterator<Word> iterator() {
        return new TreeIterator(root);
    }

    @Override
    public String toString() {
        String str="";
        Iterator it = iterator();
        while (it.hasNext()){
            str+=it.next().toString();
        }
        return str;

    }
    //Got help from the lecture
    private class BST{
        private Word w;
        private BST left =null;
        private BST right = null;

        public BST(Word w){
            this.w = w;
        }

        private String print(){
            String str = "";
            if(left!=null){
                left.print();
            }
            str += " "+w;
            if(right!=null){
                right.print();
            }
            return str;
            //System.out.println(" "+w);
        }

        private void add(Word word){
            if(word.compareTo(w)<0){
                if(left==null){
                    left = new BST(word);
                    sz++;
                } else {
                    left.add(word);
                }
            } else if(word.compareTo(w)>0){
                if(right==null){
                    right = new BST(word);
                    sz++;
                } else {
                    right.add(word);
                }
            }
        }

        private boolean contains(Word word){
            if(word.compareTo(w)<0){
                if(left==null){
                    return false;
                } else {
                    return left.contains(word);
                }
            } else if(word.compareTo(w)>0){
                if(right==null){
                    return false;
                } else {
                    return right.contains(word);
                }
            }
            return true;
        }


    }

    /* This part was inspired by this: http://stackoverflow.com/a/17959135*/
    private class TreeIterator implements Iterator
    {
        private Stack<BST> stackTree = new Stack<>();
        private BST current;

        private TreeIterator(BST root)
        {
            current = root;
        }

        @Override
        public boolean hasNext()
        {
            return (!stackTree.isEmpty() || current != null);
        }

        @Override
        public Word next()
        {
            while (current != null) {
                stackTree.push(current);
                current = current.left;
            }

            current = stackTree.pop();
            BST node = current;
            current = current.right;

            return node.w;
        }
    }
}

