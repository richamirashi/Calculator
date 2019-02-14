import java.util.HashMap;

public abstract class Operator {
    public int priority;
    private static HashMap<String, Operator> operatorMap;
        
    //abstract methods declaration
    public abstract int priority();
    public abstract Operand execute( Operand op1, Operand op2 );
    
    public static HashMap initializeOperatorMap(){
        operatorMap = new HashMap<String, Operator>();
        
        //put Sharp operator into the hashmap
        Operator sharpOperator = new SharpOperator();
        operatorMap.put("#", sharpOperator);

        //put Bang operator into the hashmap
        Operator bangOperator = new BangOperator();
        operatorMap.put("!", bangOperator);
        
        //put Addition operator into the hashmap
        Operator addOperator = new AdditionOperator();
        operatorMap.put("+", addOperator);
        
        //put Subtraction operator into the hashmap
        Operator subOperator = new SubtractionOperator();
        operatorMap.put("-", subOperator);
        
        //put Multiplication operator into the hashmap
        Operator multiplicationOperator = new MultiplicationOperator();
        operatorMap.put("*", multiplicationOperator);
        
        //put Division operator into the hashmap
        Operator divOperator = new DivOperator();
        operatorMap.put("/", divOperator);

        //put Power operator into the hashmap
        Operator powerOperator = new PowerOperator();
        operatorMap.put("^", powerOperator);
        
        //put LeftParenthesis operator into the hashmap
        Operator leftparenthesesOperator = new LeftParenthesesOperator();
        operatorMap.put("(", leftparenthesesOperator);
        
        //put RightParenthesis operator into the hashmap
        Operator rightparenthesesOperator = new RightParenthesesOperator();
        operatorMap.put(")", rightparenthesesOperator);
        
        return operatorMap;
    }
    
    public static boolean check( String token ) {
        if(token.matches("\\+||\\-||\\*||\\/||\\^||\\(||\\)")){
          return true;
        }
        return false;
   }
    
    public static Operator getOperatorMap(String token){
        //return operator
        return operatorMap.get(token);
    }
    
}