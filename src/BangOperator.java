public class BangOperator extends Operator{
    public int priority(){
        priority = 1;
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        return new Operand(0);
    }
    
}