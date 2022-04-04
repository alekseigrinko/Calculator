import java.util.Stack;

public class Preparation {
    public String notation(String string) {
        String notation = "";
        string = string.replaceAll(" ", "");
        Stack<Character> stack = new Stack<>();
        int grade;
        for (int i = 0; i < string.length(); i++) {
            grade = rotation(string.charAt(i));
            if (grade == 0) {
                notation += string.charAt(i);
            } else if (grade == 1) {
                stack.push(string.charAt(i));
            } else if (grade > 1) {
                notation += ' ';
                while (!stack.empty()) {
                    if (grade < rotation(stack.peek())) {
                        notation += stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(string.charAt(i));
            } else if (grade == -1) {
                while (rotation(stack.peek()) != 1) {
                    notation += ' ';
                    notation += stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            notation += ' ';
            notation += stack.pop();
        }
        return notation;
    }

    public int rotation(char example) {
        if (example == '*' || example == '/') {
            return 3;
        } else if (example == '+' || example == '-') {
            return 2;
        } else if (example == '(') {
            return 1;
        } else if (example == ')') {
            return -1;
        } else {
            return 0;
        }
    }

    public int rotationString(String example) {
        if (example.equals("*") || example.equals("/")) {
            return 3;
        } else if (example.equals("+") || example.equals("-")) {
            return 2;
        } else if (example.equals("(")) {
            return 1;
        } else if (example.equals(")")) {
            return -1;
        } else {
            return 0;
        }
    }
}
