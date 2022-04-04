import java.util.Stack;

public class Calculator extends Preparation {

    public Double result(String string){
        String notation = notation(string);
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

    public Double result2(String string){
        String notation = notation(string);
        String[] str = notation.split(" ");
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (rotationString(str[i]) == 0) {
                stack.push(Double.parseDouble(str[i]));
            }
            if (rotationString(str[i]) > 1) {
                Double a = stack.pop();
                Double b = stack.pop();
                switch (str[i]) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
}
