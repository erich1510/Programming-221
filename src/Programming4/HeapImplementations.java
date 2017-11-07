import java.io.*;
import java.util.Arrays;


public class HeapImplementations
{
    //private instance variables without instantiating an object
    private static int[] heap;
    private static int size;
    private static int leftNode;
    private static int rightNode;
    private static int largestNode;

    public static void main(String[] args){
        int [] a1={3,5,1,2,4};
        heapSort(a1);
        for (int i=0; i<a1.length; i++){
            System.out.print(a1[i] + " ");
        }
    }


//        public static void TestArray(int[] array){
//        System.out.println("Array: " + Arrays.toString(array));
//        long start = System.nanoTime();
//        buildHeap(array);
//        long end = System.nanoTime() - start;
//        System.out.println("Built Heap: " + Arrays.toString(array) + " Time : " + (end)) ;
//        heapSort(array);
//        System.out.println("" + Arrays.toString(array));
//    }



    // Bottom-up heap build
    public static void buildHeap(int[] input) {
        heap = input;
        size = heap.length - 1;

        for (int i = size / 2; i >= 0; i--) { //For each level in the heap input
            maxHeap(input, i); //Find biggest node
        }
    }

    public static void heapSort(int [] input) {
        buildHeap(input); //initialize the heap
        int i = size;
        while (i > 0){
            swapNodes(0, i);
            size--;
            maxHeap(heap, 0);
            i--;
    }

    }

    public int leftIndex(int index){
        return (index * 2 + 1);
    }

    public int rightIndex(int index){
        return (index * 2 + 2);
    }

    //Given an array heap and the heap level, finds largest Node
    public static void maxHeap(int [] input, int rootIndex) {
        leftNode = 2 * subHeap;
        rightNode = 2 * subHeap + 1;
        largestNode = subHeap; //initialize largestNode as subheap first

        if ((leftNode <= size))
            if((heap[leftNode] > heap[subHeap]))
              largestNode = leftNode;
        if ((rightNode <= size))
            if((heap[rightNode] > heap[largestNode]))
                largestNode = rightNode;

        if (largestNode != subHeap) {
            swapNodes(subHeap, largestNode);
            maxHeap(input, largestNode); //recursive
        }
    }

    public static void swapNodes (int a, int b){
        int temp = heap[a];
        heap[b] = heap[a];
        heap[a] = temp;
    }



}