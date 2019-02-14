public class SubtractionOperator extends Operator{
    public int priority(){
        priority = 2;
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        double sub;
        sub = op1.getValue() - op2.getValue();
        Operand subResult = new Operand(sub);
        return subResult;
    }
    
}
