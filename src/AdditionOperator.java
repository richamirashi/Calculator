public class AdditionOperator extends Operator{
   public int priority(){
        priority = 2;
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        double addition;
        addition = op1.getValue() + op2.getValue();
        Operand addResult = new Operand(addition);
        return addResult;
    }
    
}
