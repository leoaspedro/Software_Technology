package main.assignment1.impl;

import main.assignment1.Couple;
import main.assignment1.MyAVL4Strings;
import main.assignment1.MyList;

public class MyAVL4StringsImpl implements MyAVL4Strings {

    private avlNode<String> root = null;

    public MyAVL4StringsImpl(){}

    @Override
    public void insert(String element) {
        root = insert(element, root);
    }

    private avlNode<String> insert(String x,avlNode<String> node ) {

        /*First, insert element like if it was an unbalanced BST */
        if (node == null) {
            return new avlNode<>(x, null, null);
        }
        int compareResult = x.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(x, node.left);

        } else if (compareResult > 0) {
            node.right = insert(x, node.right);

        } else {
            //If duplicate Do nothing
        }

        return balance(node);
    }
    public avlNode rotateWithLeftChild(avlNode node) {
        avlNode<String> t1 = node.left;
        node.left = t1.right;
        t1.right = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        t1.height = Math.max(height(t1.left),node.height)+1;
        return t1;
    }
    private avlNode<String> rotateWithRightChild(avlNode<String> node) {
        avlNode<String> t1 = node.right;
        node.right = t1.left;
        t1.left = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        t1.height = Math.max(height(t1.left),node.height)+1;
        return t1;
    }
    private avlNode<String> doubleWithLeftChild(avlNode<String> node){
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    private avlNode<String> doubleWithRightChild(avlNode<String> node){
        node.right = rotateWithLeftChild(node);
        return rotateWithRightChild(node);
    }


    private avlNode balance(avlNode<String> node) { //To change layout

        if(node ==null){
            return node;
        }
        if(height(node.left)-height(node.right)>1){
            if(height(node.left.left)>= height(node.left.right)){
                node = rotateWithLeftChild(node);
            }else{
                node = doubleWithLeftChild(node);
            }
        }else if(height(node.right)-height(node.left)>1){
            if(height(node.right.right)>= height(node.right.left)){
                node = rotateWithRightChild(node);
            }else{
                node = doubleWithRightChild(node);
            }
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;


    }

    private int height(avlNode<String> n) {
        return n == null ? -1 : n.height;
    }

    /* *************** Partial Search *******************/
    @Override
    public Couple<String> partialSearch(String beginning) {
        Couple<String> search = new CoupleImpl<>();
        avlNode<String> min = smallestString(root,null, beginning);
        if(min ==null){
            return search;
        }else{
            search.setFirst(min.element);
        }

        avlNode<String> max = biggestString(root,null,beginning);
        if(max ==null){
            search.setLast(min.element);
        }else{
            search.setLast(max.element);
        }

        return search;

    }

    private avlNode<String> smallestString(avlNode<String> root, avlNode<String> lastSame, String beginning){
        if(root==null){
            return lastSame;
        }
        if(root.element.startsWith(beginning)){
            lastSame = root;
        }
        if(root.element.compareTo(beginning)>0){
            return smallestString(root.left,lastSame,beginning);
        }else if(root.element.compareTo(beginning)<0){
            return smallestString(root.right,lastSame,beginning);
        }else
            return lastSame;
    }

    private avlNode<String> biggestString(avlNode<String> root, avlNode<String> lastSame,String beginning){
        if(root==null){
            return lastSame;
        }
        if(root.element.startsWith(beginning)){
            lastSame = root;
            return biggestString(root.right,lastSame,beginning);
        }
        else if(root.element.compareTo(beginning)>0){
            return biggestString(root.left,lastSame,beginning);
        }else if(root.element.compareTo(beginning)<0){
            return biggestString(root.right,lastSame,beginning);
        }else
            return lastSame;
    }


    /*--------------------------------Level By Level---------------------------------------*/
    @Override
    public MyList<MyList<String>> LevelByLevelLists() {
        MyListImpl list = new MyListImpl();

        for(int i=0;i<(root.height+1);i++)
            list.add(levelByLevel(root,i,new MyListImpl()));

	return list;
    }
    private MyList<String> levelByLevel(avlNode<String> node, int level, MyListImpl list){
        if(node == null)
            return list;
        if(level ==0){
            list.add(node.element);
        }
        else if (level > 0)
        {
            levelByLevel(node.left, level-1,list);
            levelByLevel(node.right, level-1,list);
        }
        return list;

    }
    public void printTree(MyList<MyList<String>> tree){
        for(int i=0;i<tree.size();i++){
            System.out.print("Index "+i+": ");
            for (int j=0;j<tree.get(i).size();j++){
                System.out.print(tree.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    /*------------------------------------End Of Level By Level--------------------------------*/

    private static class avlNode<String>{
        String element;
        avlNode<String> left;
        avlNode<String> right;
        int height;

        avlNode(String theElement ){
            this(theElement, null,null);
        }
        avlNode(String theElement, avlNode<String> leftRoot, avlNode<String> rightRoot){
            element = theElement;
            left = leftRoot;
            right = rightRoot;
            height = 0;
        }
    }
}

