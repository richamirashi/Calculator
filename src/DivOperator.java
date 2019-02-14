public class DivOperator extends Operator{
    public int priority(){
        priority = 3;
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        double div;
        div = op1.getValue() / op2.getValue();
        Operand divResult = new Operand(div);
        return divResult;
    }
    
}
