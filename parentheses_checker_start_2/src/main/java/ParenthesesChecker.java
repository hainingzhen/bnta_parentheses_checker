
import java.util.Map;
import java.util.Stack;

public class ParenthesesChecker {

    private static Stack<Character> stack;
    private static Map<Character, Character> map = Map.of(
                                                        ')', '(',
                                                        '}', '{',
                                                        ']', '[',
                                                        '>', '<'
                                                         );


    public static boolean checkParentheses(String testString) {

        stack = new Stack<>();

        for (int i = 0; i < testString.length(); i++) {

            Character testChar = testString.charAt(i);

            switch (testChar){
                case '(':
                case '{':
                case '[':
                case '<':
                    stack.push(testChar);
                    break;
                case ')':
                case '}':
                case ']':
                case '>':
                    if (stack.empty()) return false;
                    if (map.get(testChar) == stack.peek()) {
                        stack.pop();
                        break;
                    }
                    return false;
                default:
                    break;
            }
        }

        return stack.empty();
    }

}
