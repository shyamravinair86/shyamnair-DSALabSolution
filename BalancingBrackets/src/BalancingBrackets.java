import java.util.Stack;

public class BalancingBrackets {

    //to check for a given expression if it contains balanced brackets or not
    private static Boolean containsBalancedBrackets(String expr) {
        Stack<Character> stack = new Stack<Character>();

        //to check if the length of expression is divisible by 2. If the remainder is 1, then we return false
        if (expr.length() % 2 == 1) {
            return false;
        }
        else {
            //Traversing the expression
            for (int i = 0; i < expr.length(); i++) {
                char x = expr.charAt(i);
                if (x == '(' || x == '[' || x == '{') {
                    //push the element to the stack
                    stack.push(x);
                    continue;
                }

                //if the current character is not opening bracket, then it must be closing. Hence the stack cannot be empty at this point.
                if (stack.isEmpty()) {
                    return false;
                }

                char check;
                switch (x) {
                    case ')' :
                        check = stack.pop();
                        if (check == '{' || check == '[') {
                            return false;
                        }
                        break;

                    case '}':
                        check = stack.pop();
                        if (check == '(' || check == '[') {
                            return false;
                        }
                        break;

                    case ']':
                        check = stack.pop();
                        if (check == '{' || check == '(') {
                            return false;
                        }
                        break;
                }
            }

            //check for empty stack
            return stack.isEmpty();
        }
    }

    //driver
    public static void main(String[] args) {
        String expr = "([[{}]])";

        //call containsBalancedBrackets() function
        if (containsBalancedBrackets(expr)) {
            System.out.println("The entered String has Balanced Brackets");
        }
        else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}
