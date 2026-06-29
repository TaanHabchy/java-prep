package algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    static ArrayList concat(ArrayList<Integer> first, ArrayList<Integer> second){
        for (int i : second){
            first.add(i);
        }
        return first;
    }

    static boolean binarySearch(List<Integer> arr, int target){

        if (arr.size() <= 1) {
            if (arr.get(0) == target) {
                return true;
            }
            return false;
        }

        int middle = arr.get(arr.size() / 2);

        if (middle < target) {
            return binarySearch(arr.subList(arr.size() / 2, arr.size()), target);
        } else if (middle > target) {
            return binarySearch(arr.subList(0, arr.size() / 2), target);
        }

        return true;
    }

    static ArrayList quicksort(ArrayList<Integer> arr) {
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
        left = concat(quicksort(left), quicksort(right));
        return left;
    }
    static void main() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            list.add(i);
        }
        System.out.println(binarySearch(list, 0));
    }
}
