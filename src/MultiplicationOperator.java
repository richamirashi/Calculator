public class MultiplicationOperator extends Operator{
    public int priority(){
        priority = 3;
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        double multiply;
        multiply = op1.getValue() * op2.getValue();
        Operand multiplyResult = new Operand(multiply);
        return multiplyResult;
    }
    
}
