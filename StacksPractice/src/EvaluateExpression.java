import java.util.Stack;

/*
    Evaluates (fully parenthesized) arithmetic expressions
    ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 *  101.0
 *
 */
public class EvaluateExpression {
    private  static Stack<String> operator;
    private  static Stack<Double> operand;

    public static void main(String[] args) {

         operator = new Stack<>();
         operand = new Stack<>();
         Double result;

        String test1="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String test2 = "((2+8)*((6/2)+9))";
        result = evalExpression(test2);

        System.out.println(result);

    }
    public static Double evalExpression(String expression){
        int i =0;String ch;
        while (i <expression.length()){
            ch = String.valueOf(expression.charAt(i));

            if(ch.equals("(")||ch.equals(" ")){
                //do nothing
            }else if(ch.equals("+")||ch.equals("-")||ch.equals("/")||ch.equals("*")){
                operator.push(ch);
            }else if(ch.equals(")")){

                Double val = operand.pop();
                String op = operator.pop();
                if(op.equals("+"))
                    val = operand.pop() + val;
                if(op.equals("-"))
                    val= operand.pop() - val;
                if(op.equals("*"))
                    val = operand.pop()*val;
                if(op.equals("/"))
                    val = operand.pop()/val;
                operand.push(val);
            }else {
                operand.push(Double.valueOf(ch));
            }
            i++;
        }
        return operand.pop();
    }
}
