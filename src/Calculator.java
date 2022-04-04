import java.util.Stack;

public class Calculator {
    public String converterForNotation(String string) {
        String notation = "";
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
                notation += ' ';
                while (rotation(stack.peek()) != 1) {
                    notation += stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            notation += stack.pop();
        }
        return notation;
    }

    public Double calc(String string){
        String notation = converterForNotation(string);
        String str = "";
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < notation.length(); i++) {
            if (notation.charAt(i) == ' ') {
                continue;
            }
            if (rotation(notation.charAt(i)) == 0) {
                while (rotation(notation.charAt(i)) == 0 && notation.charAt(i) != ' ') {
                    str += notation.charAt(i);
                    i++;
                    if (i == notation.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(str));
                str = "";
            }
            if (rotation(notation.charAt(i)) > 1) {
                Double a = stack.pop();
                Double b = stack.pop();
                switch (notation.charAt(i)) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
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
}
