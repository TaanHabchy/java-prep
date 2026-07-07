
import java.util.ArrayList;
import java.util.HashMap;

public static class SumArray {
    static void FindParts(ArrayList<Integer> arr, int sum){
        HashMap<Integer, Integer> needed = new HashMap<>();
        for (Integer element : arr) {
            int dif = sum - element;
            if (needed.containsKey(element)) {
                System.out.println(needed.get(element) + " + " + element + " = " + sum);
                return;
            }
            needed.put(dif, element);
        }
        System.out.println("no sum");
    }
}

static void main() {
    ArrayList<Integer> array = new ArrayList<>();
    for (int i = 0; i < 100; i++){
        array.add(i);
    }
    SumArray.FindParts(array, 197);
}
