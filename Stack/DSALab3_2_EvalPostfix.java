import java.util.*;

public class DSALab3_2_EvalPostfix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the expression: ");
        String exp;
        exp = input.next();

        input.close();

        exp = exp.replace(" ", "");
        System.out.println(exp);
        if (parenthesisMatching(exp)) {
            String p = infixToPostfix(exp);
            System.out.println("Postfix form of the expression:" + p);
            int r = evalPostfix(p);
            System.out.println("The result is " + r);

        } else {
            System.out.println("Parenthesis do not match.");
        }

    }

    public static boolean parenthesisMatching(String exp) {
        Stack stack = new ArrayStack();

        try {
            for (int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);

                if (c == '(' || c == '[' || c == '{')
                    stack.push(c);
                else if (c == ')') {
                    char obj = (char) stack.pop();
                    if (obj != '(')
                        return false;
                } else if (c == ']') {
                    char obj = (char) stack.pop();
                    if (obj != '[')
                        return false;
                } else if (c == '}') {
                    char obj = (char) stack.pop();
                    if (obj != '{')
                        return false;
                }
            }
        }
        catch (Exception e) {
            return false;
        }
        return stack.isEmpty();
    }

    public static String infixToPostfix(String exp) {

        Stack s = new ArrayStack();
        String r = "";
        char elm, op;

        for (int i = 0; i < exp.length(); i++) {
            elm = exp.charAt(i);

            if (elm >= '0' && elm <= '9')
                r += elm;
            else if (elm == '(')
                s.push(elm);
            else if (elm == ')') {
                do {
                    op = (char) s.pop();
                    if (op != '(')
                        r += op;
                } while (op != '(');
            } else {  //c is operator + - * / 
                while (!s.isEmpty()) {
                    op = (char) s.pop();
                    int opp = precedenceLvl(op);
                    int elmp = precedenceLvl(elm);

                    // IF op has higher or equal precedence than elm THEN  print op
                    // else ELSE S.push (op)
                    if (opp >= elmp)
                        r += op;
                    else {
                        s.push(op);
                        break;
                    }
                }
                s.push(elm);
            }

        }

        //print all stack
        while (!s.isEmpty()) {
            r += s.pop();
        }
        return r;
    }

    public static int precedenceLvl(char c) {
        if (c == '+' && c == '-')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        if (c == '(' || c == ')')
            return -1;  //  "(" is NOT having higher precedence than any operator
        else
            return 0;
    }

    public static int evalPostfix(String postfix) {
        Stack s = new ArrayStack(); // stack of Integer objects
        int opd1, opd2; // operand1 and operand2
        int res = 0;
        for (int i = 0; i < postfix.length(); i++) {

            // get char from postfix string
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                s.push((int) c - 48);
            } else if (c >= 'A' && c <= 'F') {
                s.push((int) c - 65 + 10);
            } else if (c == '+') {
                opd1 = (int) s.pop();
                opd2 = (int) s.pop();
                s.push(opd2 + opd1);
            } else if (c == '-') {
                opd1 = (int) s.pop();
                opd2 = (int) s.pop();
                s.push(opd2 - opd1);
            } else if (c == '*') {
                opd1 = (int) s.pop();
                opd2 = (int) s.pop();
                s.push(opd2 * opd1);
            } else if (c == '/') {
                opd1 = (int) s.pop();
                opd2 = (int) s.pop();
                s.push(opd2 / opd1);
            }

        }
        res = (int) s.pop();
        return res;
    }

    public static char digit(int n) {
        return (char) (n + 48);
    }

}
