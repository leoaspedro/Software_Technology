package binheap;

public class BinaryIntHeap {
    private static final int CAPACITY = 100;
    private int [] element;
    private int ElementCount;

    public BinaryIntHeap()  {
        ElementCount = 0;
        element = new int[CAPACITY];
    }

    public void insert(int n) {

        if(ElementCount == element.length/2)
            expand();

        element[ElementCount++] = n;

        int childPos = ElementCount-1;
        int parentPos = (childPos-1)/2;

        while(element[parentPos] < element[childPos]) {
            swapping(parentPos,childPos);

            childPos = parentPos;
            parentPos = (childPos-1)/2;
        }

    }

    public int pullHighOne() {

        int highest = element[0];

        swapping(0,ElementCount-1);

        element[ElementCount-1] = 0;

        int parentPos = 0;
        int leftChild = 1;
        int rightChild = 2;

        while(element[leftChild] > element[parentPos] || element[rightChild] > element[parentPos]) {

            if(element[leftChild] > element[rightChild]) {
                swapping(parentPos,leftChild);
                parentPos = leftChild;

            }else {
                swapping(parentPos, rightChild);
                parentPos = rightChild;
            }

            leftChild = 2*parentPos+1;
            rightChild = 2*parentPos+2;

            if(leftChild > element.length || rightChild > element.length)
                break;
        }
        ElementCount--;
        return highest;
    }

    public int size() {
        return ElementCount;
    }
    public boolean isEmpty() {
        return ElementCount == 0;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ElementCount; i++) {
            sb.append(element[i] + " ");
        }
        return sb.toString();
    }

    private void swapping(int i, int j) {

        int help = element[i];
        element[i] = element[j];
        element[j] = help;
    }

    private void expand() {
        int [] help = new int[2*ElementCount];
        System.arraycopy(element, 0, help, 0, element.length);
        element = help;
    }
}