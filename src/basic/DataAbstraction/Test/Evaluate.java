package basic.DataAbstraction.Test;

import basic.DataAbstraction.ImplementByArray.Stack;
import edu.princeton.cs.algs4.*;

//有问题
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) { // Read token, push if operator.
            String s = StdIn.readString();
//            if(s.equals("("));
//            else if (s.equals("+")) ops.push(s);
//            else if (s.equals("-")) ops.push(s);
//            else if (s.equals("*")) ops.push(s);
//            else if (s.equals("/")) ops.push(s);
//            else if (s.equals("sqrt")) ops.push(s);
//            else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
//
//                String op = ops.pop();
//                double v = vals.pop();
//                if(op.equals("+")) v = vals.pop() + v;
//                else if (op.equals("-"))v = vals.pop() - v;
//                else if (op.equals("*"))v = vals.pop() * v;
//                else if (op.equals("/"))v = vals.pop() / v;
//                else if (op.equals("sqrt")) v = Math.sqrt(v);
//                vals.push(v);
//            } // Token not operator or paren: push double value. else vals.push(Double.parseDouble(s));

            switch(s){
                case "(":break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":ops.push(s);break;
                case ")":{

                    String op=ops.pop();
                    double v=vals.pop();
                    switch(op){
                        case "+":v = vals.pop() + v;break;
                        case "-":v = vals.pop() - v;break;
                        case "*":v = vals.pop() * v;break;
                        case "/":v = vals.pop() / v;break;
                        case "sqrt":v = Math.sqrt(v);break;
                    }
                    vals.push(v);
                }
            }
        }
        StdOut.println(vals.pop());
    }
}