import java.util.*;

public class Evaluator {

    private static final String DELIMITERS = "()+-*/^#! ";

    //constructor of the Evaluator class
    public Evaluator() {
        Operator.initializeOperatorMap();
    }

    public int eval(String expression) {

        Stack<Operand> operandStack = new Stack<Operand>();
        Stack<Operator> operatorStack = new Stack<Operator>();

        // Check for empty string
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Invalid/Empty input expression");
        }

        String token;
        StringTokenizer tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        //push sharp operator on the operator stack
        operatorStack.push(Operator.getOperatorMap("#"));

        //push every token on operator or operand stack and evaluate the expression
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();

            // filter out spaces
            if (token.equals(" ")) {
                continue;
            }

            // check if the token is an operand
            if (Operand.check(token)) {
                operandStack.push(new Operand(token));
                continue;
            }

            // At this point the token has to be an operator
            if (!Operator.check(token)) {
                throw new IllegalArgumentException("*****invalid token******");
            }

            // Check if the token is closing parentheses and if it's
            //occurence is before opening parentheses
            if (token.equals(")")) {
                throw new IllegalArgumentException("Invalid occurence of ) parentheses");
            }

            //Check if the token is open parentheses and if it is, then process
            //the expression between open and closing parentheses
            if (token.equals("(")) {
                //process the subexpression
                Operand operand = processSubExpression(tokenizer);
                operandStack.push(operand);
                continue;
            }

            Operator newOperator = Operator.getOperatorMap(token);

            while (operatorStack.peek().priority() >= newOperator.priority()) {
                //call evaluate method to evaluate operand and operator stacks
                evaluateStack(operandStack, operatorStack);
            }

            operatorStack.push(newOperator);
        } //end of a while loop

        //push bang operator on the operator stack
        operatorStack.push(Operator.getOperatorMap("!"));

        //call processStack method to evaluate rest of the operators and operands on both the stacks
        return processStack(Operator.getOperatorMap("#"), operandStack, operatorStack);
        
    }

    public int processStack(Operator sharpOperator, 
            Stack<Operand> operandStack,
            Stack<Operator> operatorStack) {
        
        //pop bang operator first from the operator stack
        operatorStack.pop();

        //continue to evaluate all the values on the stacks till we get
        //the sharp operator, that is, when all the operators are evaluated
        while (operatorStack.peek().priority != sharpOperator.priority) {
            //call evaluate method to evaluate an expression
            evaluateStack(operandStack, operatorStack);
        }

        //return the evaluated value of the argument from the operand stack
        Operand operand = operandStack.pop();
        System.out.println(operand.getValue());
        return (int) operand.getValue();
    }

    public void evaluateStack(Stack<Operand> operandStack, Stack<Operator> operatorStack) {
        
        //pop the top operator of the operator stack
        Operator opr = operatorStack.pop();

        //if there is only one operand in the operand stack
        if (operandStack.size() < 2) {
            throw new IllegalArgumentException("Given input expression is invalid");
        }

        Operand op2 = operandStack.pop();
        Operand op1 = operandStack.pop();
        operandStack.push(opr.execute(op1, op2));
    }

    public Operand processSubExpression(StringTokenizer tokenizer) {
        int braceCounter = 1;
        String subExpression = "";
        String token = null;
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if(token.equals("(")) braceCounter++;
            if(token.equals(")")) braceCounter--;
            if(braceCounter == 0) break;
            subExpression += token;
        }
        if(braceCounter != 0) {
            throw new IllegalArgumentException("The number of opening and closing braces does not match");
        }
        return new Operand(eval(subExpression));
    }

}
