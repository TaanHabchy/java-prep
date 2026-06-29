import java.util.ArrayList;

static class Heap {
    private ArrayList<Integer> arr;

    Heap(){
        arr = new ArrayList<>();
    }

    int parent(int i) {
        return arr.get(i / 2 - 1);
    }

    int leftChild(int i) {
        return i * 2 + 1;
    }

    int rightChild(int i) {
            return i * 2 + 2;
        }

    void add(int v) {
        if (arr.isEmpty()) {
            arr.add(v);
            return;
        }

        for (int i = 0; i < arr.size(); i++){
            if (v > arr.get(i)) {
                continue;
            }
            arr.add(i, v);
            return;
        }
        arr.add(v);
    }

    void remove(int v) {
        arr.remove(arr.indexOf(v));
    }

    void min(){
        System.out.println(arr.get(0));
    }

}

public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Heap myHeap = new Heap();
    Scanner scanner = new Scanner(System.in);
    int queries = scanner.nextInt();
    for (int i = 0; i < queries; i++) {
        int command = scanner.nextInt();

        if (command == 3) {
            myHeap.min();
            continue;
        }

        int param = scanner.nextInt();

        if (command == 1) {
            myHeap.add(param);
        }

        else {
            myHeap.remove(param);
        }

    }
}