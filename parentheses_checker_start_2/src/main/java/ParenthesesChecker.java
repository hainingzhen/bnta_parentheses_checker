import com.sun.security.jgss.GSSUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesesChecker {

    private static Stack<Character> stack;

    public static boolean checkParentheses(String testString) {

        stack = new Stack<>();

        for (int i = 0; i < testString.length(); i++) {

            char testChar = testString.charAt(i);

            switch (testChar){
                case '(':
                case '{':
                case '[':
                case '<':
                    stack.push(testChar);
                    break;
                case ')':
                    if (check('(')) {
                        stack.pop();
                        continue;
                    }
                    return false;
                case '}':
                    if (check('{')) {
                        stack.pop();
                        continue;
                    }
                    return false;
                case ']':
                    if (check('[')) {
                        stack.pop();
                        continue;
                    }
                    return false;
                case '>':
                    if (check('<')) {
                        stack.pop();
                        continue;
                    }
                    return false;
                default:
                    break;
            }
        }

        return stack.empty();
    }

    private static boolean check(char bracket) {
        if (stack.empty()) return false;
        return stack.peek() == bracket;
    }
}
