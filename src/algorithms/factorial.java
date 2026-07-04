package algorithms;

import java.util.HashMap;

public class factorial {
    public record Combo(int i, int op) {}
    static HashMap<Integer, Integer> answers = new HashMap<>();
    static HashMap<Combo, Integer> clumsyAnswers = new HashMap<>();

    static int factorial(int i){
        int rv = 0;
        if (i == 1){
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (answers.containsKey(i)){
            return answers.get(i);
        } else {
            rv = i * factorial(i-1);

        }
        answers.put(i, rv);
        return rv;
    }

    static int clumyFactorial(int i, int op){
        int rv = 0;
        if (i == 1){
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (clumsyAnswers.containsKey(new Combo(i, op))){
            return clumsyAnswers.get(i);
        } else {
            switch (op) {
                case 0:
                    rv = i * clumyFactorial(i - 1, 1);
                case 1:
                    rv = i / clumyFactorial(i - 1, 2);
                case 2:
                    rv = i - clumyFactorial(i - 1, 3);
                case 3:
                    rv = i + clumyFactorial(i - 1, 0);

            }
        }
        clumsyAnswers.put(new Combo(i, op), rv);
        return rv;
    }
    static void main() {
        int poop = factorial(4);
        System.out.println(poop);
    }
}
