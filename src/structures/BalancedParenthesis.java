package structures;

import java.util.Stack;

public class BalancedParenthesis {
    static void main() {
        String test = "((((()(())))))";

        Stack<String> total = new Stack<>();
        int betterTotal = 0;

        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == '('){
//                total.add("(");
                betterTotal += 1;
                continue;
            }
            if (test.charAt(i) == ')'){
                betterTotal -= 1;

            }
        }
        System.out.println(betterTotal);
    }
}
