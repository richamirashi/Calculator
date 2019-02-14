public class SharpOperator extends Operator{
    public int priority(){
        priority = 0;
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        return new Operand(0);
    }
    
}
