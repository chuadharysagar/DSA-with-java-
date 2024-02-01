import java.util.Stack;
public class PostfixEvaluation {
     static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];

            if (str.matches("-?\\d+")) {
                int item = Integer.parseInt(str);
                st.push(item);
            } else {
                int op2 = st.pop();
                int op1 = st.pop();
                int result = 0;
                switch (str) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                        result = op1 / op2;
                        break;
                    default:
                        break;
                }
                st.push(result);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int sum = evalRPN(tokens);
        System.out.println(sum);
    }
}
