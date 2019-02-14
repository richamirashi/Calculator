public class RightParenthesesOperator extends Operator{
    public int priority(){
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        return new Operand(0);
    }
    
}
