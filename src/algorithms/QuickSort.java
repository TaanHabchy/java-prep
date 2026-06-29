package algorithms;

import java.util.ArrayList;
import java.util.stream.Stream;

public class QuickSort {

    static ArrayList concat(ArrayList<Integer> first, ArrayList<Integer> second){
        for (int i : second){
            first.add(i);
        }
        return first;
    }

    static ArrayList sort(ArrayList<Integer> arr) {
        int pivot = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        if (arr.size() <= 1) {
            return arr;
        }
        for (int element : arr) {
            if (element <= arr.get(pivot)) {
                left.add(element);
            } else {
                right.add(element);
            }
        }
        left = concat(sort(left), sort(right));
        return left;
    }
    static void main() {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(sort(list));
    }
}
