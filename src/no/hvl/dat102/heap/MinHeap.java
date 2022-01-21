package no.hvl.dat102.heap;

import java.util.Arrays;

public class MinHeap {

    public static void main(String[] args) {
        int[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        convert(data);

    }


    private static int LEFT(int i) {
        return (2*i + 1);
    }


    private static int RIGHT(int i) {
        return (2*i + 2);
    }

    private static void heapify(int[] data, int i, int size) {
        int left = LEFT(i);
        int right = RIGHT(i);
        int smallest = i;

       if (left < size && data[left] < data[i]) {
            smallest = left;
        }

        if (right < size && data[right] < data[smallest]) {
            smallest = right;
        }


        if (smallest != i) {
            swap(data, i, smallest);
            System.out.println(Arrays.toString(data));
            heapify(data, smallest, size);
        }
    }


    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void convert(int[] data) {

        int i = (data.length - 2)/2;
        while (i >= 0) {
            heapify(data,i--,data.length);
        }
    }
}
